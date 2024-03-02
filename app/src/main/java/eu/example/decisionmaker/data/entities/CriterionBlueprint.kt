package eu.example.decisionmaker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "criteria_blueprints")
data class CriterionBlueprint(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val type: String,
    val criterionUnit: String,
    val criterionWeight: Int?, //if not present, then no weight (must be applied to all remaining criteria)
    val max: Boolean, //if false, then min...
    val decisionProblemId: Int
)