package org.yttehs.counter

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            MainViewModel(
                mainApplication().container.numbersRepository
            )
        }
    }
}

fun CreationExtras.mainApplication(): CounterApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as CounterApplication)