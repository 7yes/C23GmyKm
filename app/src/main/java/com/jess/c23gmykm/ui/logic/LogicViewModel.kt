package com.jess.c23gmykm.ui.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.launch

class LogicViewModel : ViewModel() {
    val countDownFlow = flow<Int> {
        val startingValue = 10
        emit(startingValue)
        var currentValue = startingValue
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        // collectFlowCollect()
        //collectFlowCollectLastest()
        //collectFlowCollectOperators()
        //collectTerminalReduce()
        //collectTerminalCount()
        //collectTerminalFold()
        //collectFlowx()
        //collectStateFlow()
    }

    private var _stateFlow = MutableStateFlow(0)
        val stateFlow: StateFlow<Int> = _stateFlow
    private fun collectStateFlow() {
       // _stateFlow.value = +1
    }

    fun incrementCounter() {
         _stateFlow.value += 1
        var a:Int? =5
        a=7

    }

    private fun collectFlowx() {
        val flow1 = flow {
            delay(250)
            emit("Appetizer")
            delay(1000)
            emit("Main Dish")
            delay(150)
            emit("Dessert")
        }
        viewModelScope.launch {
            flow1.onEach {
                println("flow: $it is delivered")
            }
                // Modificadores de la forma de collectear
                //.buffer()
                //.conflate()
                //.sample(300)
                //.debounce(300)
                .collectLatest() {
                    println("flow: Now eating $it")
                    delay(1500)
                    println("flow: Finished eating $it")
                }
        }
    }

    private fun collectTerminalFold() {
        viewModelScope.launch {
            val answer = countDownFlow
                .fold(100) { accumulator, value ->
                    accumulator + value
                }
            println("the count is $answer")
        }
    }

    private fun collectTerminalReduce() {
        viewModelScope.launch {
            val answer = countDownFlow
                .reduce { accumulator, value ->
                    value
                }
            println("the count is $answer")
        }
    }

    private fun collectTerminalCount() {
        viewModelScope.launch {
            val answer = countDownFlow
                .filter { it % 2 == 0 }
                .map { it * it }
                .onEach { println("h $it") }
                .count { it % 2 == 0 }
            println("the count is $answer")
        }
    }

    private fun collectFlowCollectOperators() {
        viewModelScope.launch {
            countDownFlow
                .filter { it % 2 == 0 }
                .map { it * it }
                .onEach { println("h $it") }
                .collect {
                    println("time collect operator $it")
                }
        }
    }

    private fun collectFlowCollect() {
        viewModelScope.launch {
            countDownFlow.collect {
                println("time collect $it")
            }
        }
    }

    private fun collectFlowCollectLastest() {
        viewModelScope.launch {
            countDownFlow.collectLatest {
                delay(500)
                println("time collectLastest $it")
            }
        }
    }
}