package eu.example.decisionmaker.data.entities

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decision_options")
data class DecisionOption(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val color: String = listOf(Color.Red, Color.Blue, Color.Green).random().toString(),
    val decisionProblemId: Int
)