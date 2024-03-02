package eu.example.decisionmaker.data

import androidx.room.Delete
import eu.example.decisionmaker.data.entities.CriterionBlueprint
import eu.example.decisionmaker.data.entities.CriterionData
import eu.example.decisionmaker.data.entities.DecisionOption
import eu.example.decisionmaker.data.entities.DecisionProblem
import kotlinx.coroutines.flow.Flow

interface DecisionProblemRepository {

    suspend fun insertProblem(decisionProblem: DecisionProblem)

    suspend fun insertOption(option: DecisionOption)

    suspend fun insertCriterionBlueprint(criterion: CriterionBlueprint)

    suspend fun insertCriterionData(criterionData: CriterionData)

    suspend fun deleteProblem(problem: DecisionProblem)

    suspend fun deleteOption(option: DecisionOption)

    suspend fun deleteCriterionBlueprint(criterion: CriterionBlueprint)

    suspend fun deleteCriterionData(criterionData: CriterionData)

    fun getAllDecisionProblems(): Flow<List<DecisionProblem>>

    suspend fun getAllOptionsByProblemId(problemId: Int): Flow<List<DecisionOption>>

    suspend fun getAllCriteriaBlueprintsByProblemId(problemId: Int): Flow<List<CriterionBlueprint>>

    suspend fun getAllCriteriaDataByOptionId(optionId: Int): Flow<List<CriterionData>>
}