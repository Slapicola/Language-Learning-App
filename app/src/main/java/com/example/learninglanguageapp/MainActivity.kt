package com.example.learninglanguageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

        Column {
            Text("Question 1: What does 'Hola' mean?")
            AnswerButton(text = "Goodbye") { }
            AnswerButton(text = "Hello") { }
            AnswerButton(text = "Please") { }
            AnswerButton(text = "Thank You") { }
        }
        Column {
            Text("Question 2: What does 'Por favor' mean?")
            AnswerButton(text = "Hello") { }
            AnswerButton(text = "Goodbye") { }
            AnswerButton(text = "Thank You") { }
            AnswerButton(text = "Please") { }
        }
        Column {
            Text("Question 3: What does 'Gracias' mean?")
            AnswerButton(text = "Please") { }
            AnswerButton(text = "Thank You") { }
            AnswerButton(text = "Hello") { }
            AnswerButton(text = "Goodbye") { }
        }
        Column {
            Text("Question 4: What does 'Adios' mean?")
            AnswerButton(text = "Thank You") { }
            AnswerButton(text = "Please") { }
            AnswerButton(text = "Goodbye") { }
            AnswerButton(text = "Hello") { }
        }
    }

}

@Composable
fun AnswerButton(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}) {
        Text(text)
    }
}


@Composable
fun PronunciationScreen(onBackClick: () -> Unit) {
    Row {
        Text("Pronunciation Guide")
        BackButton { onBackClick() }
    }
    Column {
        Text("Word: Hola")
        Text("Pronunciation: OH-lah")
        Text("English Translation: Hello")

        Text("Word: Gracias")
        Text("Pronunciation: GRAH-see-ahs")
        Text("English Translation: Thank you")

        Text("Word: Por favor")
        Text("Pronunciation: POUR fa-vore")
        Text("English Translation: Please")

        Text("Word: De nada")
        Text("Pronunciation: de naw-daw")
        Text("English Translation: You're Welcome")

        Text("Word: Madre")
        Text("Pronunciation: ma-dreh")
        Text("English Translation: mother")

        Text("Word: Padre")
        Text("Pronunciation: paw-dreh")
        Text("English Translation: father")

        Text("Word: Hermano")
        Text("Pronunciation: her-mah-no")
        Text("English Translation: brother")

        Text("Word: Hermana")
        Text("Pronunciation: her-mah-nah")
        Text("English Translation: sister")
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