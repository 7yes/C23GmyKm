package com.jess.c23gmykm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MButtons(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ } ) { Text(text = "Simple Button") }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add to cart")
            Text(text = "+   Elevated Button") }
        Spacer(modifier = Modifier.width(8.dp))
        FilledTonalButton(onClick = { /*TODO*/ }) { Text(text = "Filled Tonal Button") }
        OutlinedButton(onClick = { /*TODO*/ }) { Text(text = "OutlinedButton") }
        TextButton(onClick = { /*TODO*/ }) { Text(text = "Text Button") }
    }
}