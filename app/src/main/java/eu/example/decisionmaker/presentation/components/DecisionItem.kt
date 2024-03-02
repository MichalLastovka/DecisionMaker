package eu.example.decisionmaker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.decisionmaker.R
import eu.example.decisionmaker.data.entities.DecisionProblem

@Composable
fun DecisionItem(
    problem: DecisionProblem, onEdit: (DecisionProblem) -> Unit, onDelete: (DecisionProblem) -> Unit

) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(.15f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.width(50.dp),
                painter = painterResource(id = R.drawable.analytic_graph),
                contentDescription = "Graph_icon"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = problem.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row {
                Text(text = problem.note, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .clickable {
                        onEdit(problem)
                    },
                imageVector = Icons.Rounded.Edit,
                contentDescription = "Edit",
                tint = Color.Green
            )
            Icon(
                modifier = Modifier.clickable {
                onDelete(problem)
            },
                imageVector = Icons.Rounded.Delete,
                contentDescription = "Delete",
                tint = Color.Red)
        }
    }
    Divider(modifier = Modifier.padding(horizontal = 10.dp), thickness = 1.dp, color = Color.Black)
}