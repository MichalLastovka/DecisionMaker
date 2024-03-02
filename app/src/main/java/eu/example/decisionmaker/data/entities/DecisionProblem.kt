package eu.example.decisionmaker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "problems")
data class DecisionProblem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val note: String = "",
)

