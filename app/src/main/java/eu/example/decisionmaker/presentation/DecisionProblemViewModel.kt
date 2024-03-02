package eu.example.decisionmaker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.example.decisionmaker.data.DecisionProblemRepository
import eu.example.decisionmaker.data.entities.DecisionProblem
import eu.example.decisionmaker.util.DecisionProblemEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DecisionProblemViewModel @Inject constructor(
    private val repository: DecisionProblemRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DecisionState())
    val state: StateFlow<DecisionState>
        get() = _state.asStateFlow()

    private val _decisionEvent = Channel<DecisionProblemEvent>()
    val decisionEvent = _decisionEvent.receiveAsFlow()

    fun onEvent(event: DecisionProblemEvent){
        when (event){
            is DecisionProblemEvent.DeleteProblem -> {

            }
            is DecisionProblemEvent.EditProblem -> {

            }
            is DecisionProblemEvent.InsertProblem -> {
                viewModelScope.launch {
                    repository.insertProblem(
                        event.problem
                    )
                }
                _state.update {
                    it.copy(problemName = "", problemNote = "")
                }
                switchAddProblemDialog()
            }
            is DecisionProblemEvent.EditExistingProblem -> {

            }
            is DecisionProblemEvent.Navigate -> {

            }
            is DecisionProblemEvent.SwitchAddProblemDialog -> {

            }
            is DecisionProblemEvent.SwitchEditProblemDialog -> {

            }
        }
    }

    fun getProblems(){
        viewModelScope.launch {
            repository.getAllDecisionProblems().collect {response ->
                _state.update {
                    it.copy(decisionList = response)
                }
            }
        }
    }

    fun insertProblem(problem: DecisionProblem){
        viewModelScope.launch {
            repository.insertProblem(problem)
        }
        _state.update {
            it.copy(problemName = "", problemNote = "")
        }
        switchAddProblemDialog()
    }

    fun deleteProblem(problem: DecisionProblem){
        viewModelScope.launch {
            repository.deleteProblem(problem)
        }
    }

    fun switchAddProblemDialog(){
        _state.update {
            it.copy(showAddProblemDialog = !it.showAddProblemDialog)
        }
    }


    fun addProblemDialogUpdateNameField(text: String){
        _state.update {
            it.copy(problemName = text)
        }
    }

    fun addProblemDialogUpdateNoteField(text: String){
        _state.update {
            it.copy(problemNote = text)
        }
    }

    fun fillWithDummy(){
        _state.update {
            it.copy(decisionList = dummyList)
        }
    }

}

val dummyList = listOf(DecisionProblem(1, "Mobil", "Výběr nového mobilního telefonu"), DecisionProblem(2, "Auto pro mamku", "Nový automobil"), DecisionProblem(3, "Laptop", "Nový pracovní laptop pro ségru"))