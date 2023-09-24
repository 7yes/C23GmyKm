package com.jess.c23gmykm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jess.c23gmykm.ui.logic.LogicViewModel
import com.jess.c23gmykm.ui.logic.MyLogic
import com.jess.c23gmykm.ui.theme.C23GmyKmTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<LogicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            C23GmyKmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //  Greeting()
                    //MyLogic(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    C23GmyKmTheme {
        Greeting()
    }
}

fun <T> ComponentActivity.collectLastestLifeCycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(collect)
        }
    }
}
