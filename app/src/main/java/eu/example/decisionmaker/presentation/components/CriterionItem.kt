package eu.example.decisionmaker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.decisionmaker.data.entities.CriterionBlueprint

@Composable
fun CriterionItem(
    criterion: CriterionBlueprint
) {
    Card(
        modifier = Modifier.padding(5.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = criterion.name, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column {

                Text(text = "")
            }
            Column {
                Text(text = criterion.criterionWeight.toString())
                Text(text = criterion.max.toString())
            }

        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PrevCriterionItem(

) {
    CriterionItem(criterion = CriterionBlueprint(1, "váha(Kg)", "Celé číslo", "0.5", 3, true, 1 ))
}