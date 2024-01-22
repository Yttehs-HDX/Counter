package org.yttehs.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.yttehs.counter.number.data.model.NumberEntity
import org.yttehs.counter.number.data.repository.NumbersRepository

class CounterViewModel(private val numbersRepository: NumbersRepository) : ViewModel() {
    private val _numberUiState = MutableStateFlow(NumberUiState(0L))
    val numberUiState: StateFlow<NumberUiState>
        get() = _numberUiState

    init {
        viewModelScope.launch {
            numbersRepository.getNumberStream().collect { numberEntity ->
                numberEntity?.also {
                    _numberUiState.value = it.toNumberUiState()
                }
            }
        }
    }

    fun increaseNumber() = modifyNumber {
        ++it.number
    }

    private inline fun modifyNumber(block: (NumberUiState) -> Unit) {
        val oldValue = numberUiState.value.copy()
        block(oldValue)
        _numberUiState.value = oldValue
        saveNumberEntity()
    }

    private fun saveNumberEntity() = viewModelScope.launch {
        numbersRepository.insertOrUpdateNumber(numberUiState.value.toNumberEntity())
    }
}

data class NumberUiState(
    val id: Long,
    var number: Long = 0L
)

fun NumberEntity.toNumberUiState(): NumberUiState = NumberUiState(id = id, number = number)

fun NumberUiState.toNumberEntity(): NumberEntity = NumberEntity(id = id, number = number)