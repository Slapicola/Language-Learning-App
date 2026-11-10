package com.example.learninglanguageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learninglanguageapp.ui.theme.LearningLanguageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningLanguageAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to the Language Learning App!",
        modifier = modifier
    )
}

@Composable
fun VocabQuizButton(onClick: () -> Unit) {
    FilledTonalButton(onClick =  { onClick() }) {
        Text("Vocabulary Quiz")
    }
}

@Composable
fun PronunciationButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text("Pronunciation Guide")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningLanguageAppTheme {
        Column {
            Greeting()
            VocabQuizButton {}
            PronunciationButton {}
        }

    }
}