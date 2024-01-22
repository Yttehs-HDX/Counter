package org.yttehs.counter

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import org.yttehs.counter.number.ui.NumberViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            NumberViewModel(
                mainApplication().numbersContainer.numbersRepository
            )
        }
    }
}

fun CreationExtras.mainApplication(): CounterApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as CounterApplication)