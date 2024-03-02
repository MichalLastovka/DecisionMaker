package eu.example.decisionmaker.presentation.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import eu.example.decisionmaker.data.entities.DecisionProblem

@Composable
fun AddProblemDialog(
    problemName: String,
    problemNote: String,
    onNameFilled: (String) -> Unit,
    onNoteFilled: (String) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: (DecisionProblem) -> Unit
) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            modifier = Modifier.padding(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(modifier = Modifier.padding(vertical = 10.dp),
                    value = problemName,
                    onValueChange = {onNameFilled(it)},
                    placeholder = {
                        Text(text = "Název rozhodovacího problému")
                    })
                OutlinedTextField(modifier = Modifier.padding(vertical = 10.dp),
                    value = problemNote,
                    onValueChange = {onNoteFilled(it)},
                    placeholder = {
                        Text(text = "Poznámka")
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Zrušit")

                }
                Button(onClick = { onConfirm(DecisionProblem(id = 0, name = problemName, note = problemNote)) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text(text = "Vložit")
                }
            }
        }
    }
}
