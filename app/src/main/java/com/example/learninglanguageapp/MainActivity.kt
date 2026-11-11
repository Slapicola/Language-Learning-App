package com.example.learninglanguageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        LanguageLearningAppScreens()
                    }

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

@Composable
fun BackButton(onBackClick: () -> Unit) {
    FilledTonalButton(onClick = { onBackClick()}) {
        Text("Back")
    }
}

@Composable
fun LanguageLearningAppScreens() {
    var currentScreen by remember {
        mutableStateOf("home")
    }

    when (currentScreen) {
        "home" -> HomeScreen(
            onQuizClick = {
                currentScreen = "quiz"
            },
            onPronunciationClick = {
                currentScreen = "pronunciation"
            }
        )

        "quiz" -> QuizScreen(onBackClick = {
            currentScreen = "home"
        })
        "pronunciation" -> PronunciationScreen(onBackClick = {
            currentScreen = "home"
        })
    }
}

@Composable
fun HomeScreen(
    onQuizClick: () -> Unit,
    onPronunciationClick: () -> Unit) {


    Column {
        Greeting()
        VocabQuizButton {onQuizClick()}
        PronunciationButton {onPronunciationClick()}
    }
}

@Composable
fun QuizScreen(onBackClick: () -> Unit) {
    Column {
        Text("Vocabulary Quiz")
        BackButton { onBackClick() }
        Text("Question 1: What does 'Hola' mean?")
        Choice1Button { }
        Choice2Button { }
        Choice3Button { }
        Choice4Button { }

    }

}

@Composable
fun Choice1Button(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text("Hello")
    }
}
@Composable
fun Choice2Button(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text("Goodbye")
    }
}
@Composable
fun Choice3Button(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text("Please")
    }
}
@Composable
fun Choice4Button(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text("Thank You")
    }
}

@Composable
fun PronunciationScreen(onBackClick: () -> Unit) {
    Column {
        Text("Pronunciation Guide")
        BackButton { onBackClick() }
        Text("Word: Hola")
        Text("Pronunciation: OH-lah")
        Text("English Translation: Hello")

        Text("Word: Gracias")
        Text("Pronunciation: GRAH-see-ahs")
        Text("English Translation: Thank you")

        Text("Word: Por favor")
        Text("Pronunciation: POUR fa-vore")
        Text("English Translation: Please")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningLanguageAppTheme {
        Column {
            Greeting()
            VocabQuizButton {}
            PronunciationButton {println("Pronunciation button Clicked")}
        }

    }
}