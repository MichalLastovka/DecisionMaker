package eu.example.decisionmaker.data

import eu.example.decisionmaker.data.entities.CriterionBlueprint
import eu.example.decisionmaker.data.entities.CriterionData
import eu.example.decisionmaker.data.entities.DecisionOption
import eu.example.decisionmaker.data.entities.DecisionProblem
import kotlinx.coroutines.flow.Flow

class DecisionProblemRepositoryImpl(
    private val dao: ProblemsDao
) : DecisionProblemRepository {
    override suspend fun insertProblem(decisionProblem: DecisionProblem) {
        dao.insertProblem(decisionProblem)
    }

    override suspend fun insertOption(option: DecisionOption) {
        dao.insertOption(option)
    }

    override suspend fun insertCriterionBlueprint(criterion: CriterionBlueprint) {
        dao.insertCriterionBlueprint(criterion)
    }

    override suspend fun insertCriterionData(criterionData: CriterionData) {
        dao.insertCriterionData(criterionData)
    }

    override suspend fun deleteProblem(problem: DecisionProblem) {
        dao.deleteProblem(problem)
    }

    override suspend fun deleteOption(option: DecisionOption) {
        dao.deleteOption(option)
    }

    override suspend fun deleteCriterionBlueprint(criterion: CriterionBlueprint) {
        dao.deleteCriterionBlueprint(criterion)
    }

    override suspend fun deleteCriterionData(criterionData: CriterionData) {
        dao.deleteCriterionData(criterionData)
    }

    override fun getAllDecisionProblems(): Flow<List<DecisionProblem>> {
        return dao.getAllDecisionProblems()
    }

    override suspend fun getAllOptionsByProblemId(problemId: Int): Flow<List<DecisionOption>> {
        return dao.getAllOptionsByProblemId(problemId)
    }

    override suspend fun getAllCriteriaBlueprintsByProblemId(problemId: Int): Flow<List<CriterionBlueprint>> {
        return dao.getAllCriteriaBlueprintsByProblemId(problemId)
    }

    override suspend fun getAllCriteriaDataByOptionId(optionId: Int): Flow<List<CriterionData>> {
        return dao.getAllCriteriaDataByOptionId(optionId)
    }
}