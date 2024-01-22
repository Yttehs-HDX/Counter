package org.yttehs.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}
