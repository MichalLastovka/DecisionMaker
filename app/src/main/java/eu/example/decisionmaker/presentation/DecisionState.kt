package eu.example.decisionmaker.presentation

import eu.example.decisionmaker.data.entities.DecisionProblem

data class DecisionState(
    val decisionList: List<DecisionProblem> = emptyList(),
    val showAddProblemDialog: Boolean = false,
    val problemName: String = "",
    val problemNote: String = "",
)
