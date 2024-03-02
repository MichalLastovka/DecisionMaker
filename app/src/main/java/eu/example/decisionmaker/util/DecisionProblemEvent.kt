package eu.example.decisionmaker.util

import eu.example.decisionmaker.data.entities.DecisionProblem

sealed class DecisionProblemEvent {
    data class DeleteProblem(val problem: DecisionProblem): DecisionProblemEvent()
    data class EditProblem(val problem: DecisionProblem): DecisionProblemEvent()
    object SwitchAddProblemDialog: DecisionProblemEvent()
    object SwitchEditProblemDialog: DecisionProblemEvent()
    data class EditExistingProblem(val problem: DecisionProblem): DecisionProblemEvent()
    data class InsertProblem(val problem: DecisionProblem): DecisionProblemEvent()
    data class Navigate(val route: String): DecisionProblemEvent()
}