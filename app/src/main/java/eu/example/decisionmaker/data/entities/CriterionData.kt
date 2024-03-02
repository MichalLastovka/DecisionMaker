package eu.example.decisionmaker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "criterion_data")
class CriterionData (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val criterionValue: Float,
    val criterionWeight: Float,
    val optionId: Int
)