package eu.example.decisionmaker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.example.decisionmaker.data.entities.CriterionBlueprint
import eu.example.decisionmaker.data.entities.CriterionData
import eu.example.decisionmaker.data.entities.DecisionOption
import eu.example.decisionmaker.data.entities.DecisionProblem

@Database(
    entities = [DecisionProblem::class, DecisionOption::class, CriterionBlueprint::class, CriterionData::class],
    version = 1,
    exportSchema = false
)
abstract class ProblemDatabase : RoomDatabase() {
    abstract val dao: ProblemsDao
}