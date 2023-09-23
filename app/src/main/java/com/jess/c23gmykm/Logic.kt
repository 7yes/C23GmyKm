package com.jess.c23gmykm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyLogic(viewModel: LogicViewModel) {
    val dato = viewModel.stateFlow.collectAsState(initial = 10)
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(fontSize = 30.sp, text = "${dato.value}")
        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Counter: ${dato.value}")
        }
    }
}