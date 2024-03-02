package eu.example.decisionmaker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.example.decisionmaker.data.entities.CriterionBlueprint
import eu.example.decisionmaker.data.entities.CriterionData
import eu.example.decisionmaker.data.entities.DecisionOption
import eu.example.decisionmaker.data.entities.DecisionProblem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProblemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProblem(decisionProblem: DecisionProblem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: DecisionOption)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCriterionBlueprint(criterion: CriterionBlueprint)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCriterionData(criterionData: CriterionData)

    @Delete
    suspend fun deleteProblem(problem: DecisionProblem)

    @Delete
    suspend fun deleteOption(option: DecisionOption)

    @Delete
    suspend fun deleteCriterionBlueprint(criterion: CriterionBlueprint)

    @Delete
    suspend fun deleteCriterionData(criterionData: CriterionData)

    @Query("SELECT * FROM problems")
    fun getAllDecisionProblems(): Flow<List<DecisionProblem>>

    @Query("SELECT * FROM decision_options WHERE decisionProblemId = :problemId")
    fun getAllOptionsByProblemId(problemId: Int): Flow<List<DecisionOption>>

    @Query("SELECT * FROM criteria_blueprints WHERE decisionProblemId = :problemId")
    fun getAllCriteriaBlueprintsByProblemId(problemId: Int): Flow<List<CriterionBlueprint>>

    @Query("SELECT * FROM criterion_data WHERE optionId = :optionId")
    fun getAllCriteriaDataByOptionId(optionId: Int): Flow<List<CriterionData>>

}