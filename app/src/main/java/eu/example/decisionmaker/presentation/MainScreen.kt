package eu.example.decisionmaker.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import eu.example.decisionmaker.R
import eu.example.decisionmaker.data.entities.DecisionProblem
import eu.example.decisionmaker.presentation.components.DecisionItem
import eu.example.decisionmaker.presentation.dialogs.AddProblemDialog
import eu.example.decisionmaker.util.DecisionProblemEvent
import kotlinx.coroutines.flow.collect

@Composable
fun MainScreen(
    onEvent: (DecisionProblemEvent) -> Unit
) {
    val viewModel: DecisionProblemViewModel = hiltViewModel()
    viewModel.getProblems()
    val state = viewModel.state.collectAsState().value
    val emptyCheck = state.decisionList.isEmpty()
    LaunchedEffect(key1 = true){
        viewModel.decisionEvent.collect{event ->

        }
    }

    Scaffold(topBar = {
        Column(
            Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(60.dp)
                        .padding(end = 10.dp),
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "logo"
                )
                Text(
                    text = "DecisionMaker", fontSize = 25.sp, fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {

            }
        }
    }, bottomBar = {
        BottomAppBar(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.developer_signature), fontSize = 12.sp)
                Text(text = stringResource(R.string.developer_email_contact), fontSize = 10.sp)
            }
        }
    }, floatingActionButton = {
        if (!emptyCheck) {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { viewModel.switchAddProblemDialog() }) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add button")
            }
        }

    }) { innerPadding ->
        if (state.showAddProblemDialog) {
            AddProblemDialog(
                problemName = state.problemName,
                problemNote = state.problemNote,
                onNameFilled = { viewModel.addProblemDialogUpdateNameField(it) },
                onNoteFilled = { viewModel.addProblemDialogUpdateNoteField(it) },
                onConfirm = { onEvent(DecisionProblemEvent.InsertProblem(it)) },
                onDismiss = { viewModel.switchAddProblemDialog() }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = if (emptyCheck) Alignment.Center else Alignment.TopCenter
        ) {
            if (!emptyCheck) {
                LazyColumn {
                    items(state.decisionList) { problem ->
                        DecisionItem(
                            problem = problem,
                            onEdit = { viewModel.switchAddProblemDialog() },
                            onDelete = { viewModel.deleteProblem(it) })
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Žádné rozhodovací problémy k zobrazení",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "Začnětě přidáním rozhodovacího problému"
                    )
                    Icon(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .size(50.dp)
                            .clickable {
                                viewModel.switchAddProblemDialog()
                            },
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Add decision problem"
                    )
                }
            }
        }
    }
}