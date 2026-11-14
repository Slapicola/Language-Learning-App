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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
        modifier = modifier, style = MaterialTheme.typography.titleLarge
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
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        var score by remember { mutableIntStateOf(0) }
        Row {
            Text("Vocabulary Quiz", style = MaterialTheme.typography.titleLarge)
            BackButton { onBackClick() }
        }
        Text(text = "Score: $score/4")

        var question1Result by remember { mutableStateOf("") }
        var question2Result by remember { mutableStateOf("") }
        var question3Result by remember { mutableStateOf("") }
        var question4Result by remember { mutableStateOf("") }

        var question1Scored by remember { mutableStateOf(false) }
        var question2Scored by remember { mutableStateOf(false) }
        var question3Scored by remember { mutableStateOf(false) }
        var question4Scored by remember { mutableStateOf(false) }

        Column {
            Text("Question 1: What does 'Hola' mean?")
            AnswerButton(text = "Goodbye") { question1Result = "Incorrect!"}
            AnswerButton(text = "Hello") {
                question1Result = "Correct!"
                if (!question1Scored) {
                    score++
                    question1Scored = true
                }
            }
            AnswerButton(text = "Please") { question1Result = "Incorrect!"}
            AnswerButton(text = "Thank You") { question1Result = "Incorrect!"}

            Text(question1Result)
            Text("-------------------------------------------")
        }
        Column {
            Text("Question 2: What does 'Por favor' mean?")
            AnswerButton(text = "Hello") { question2Result = "Incorrect!"}
            AnswerButton(text = "Goodbye") { question2Result = "Incorrect!"}
            AnswerButton(text = "Thank You") { question2Result = "Incorrect!"}
            AnswerButton(text = "Please") { question2Result = "Correct!"
                if (!question2Scored) {
                    score++
                    question2Scored = true
                }

            }

            Text(question2Result)
            Text("-------------------------------------------")
        }
        Column {
            Text("Question 3: What does 'Gracias' mean?")
            AnswerButton(text = "Please") { question3Result = "Incorrect!"}
            AnswerButton(text = "Thank You") {question3Result = "Correct!"
                if (!question3Scored) {
                    score++
                    question3Scored = true
                }
            }
            AnswerButton(text = "Hello") { question3Result = "Incorrect!"}
            AnswerButton(text = "Goodbye") { question3Result = "Incorrect!"}

            Text(question3Result)
            Text("-------------------------------------------")
        }
        Column {
            Text("Question 4: What does 'Adios' mean?")
            AnswerButton(text = "Thank You") { question4Result = "Incorrect!"}
            AnswerButton(text = "Please") { question4Result = "Incorrect!"}
            AnswerButton(text = "Goodbye") { question4Result = "Correct!"
                if (!question4Scored) {
                    score++
                    question4Scored = true
                }
            }
            AnswerButton(text = "Hello") { question4Result = "Incorrect!"}

            Text(question4Result)
            Text("-------------------------------------------")
        }
        if(question1Result != "" && question2Result != "" && question3Result != "" && question4Result != "") {
            Text("Quiz Complete!\n" +
                    "Final Score: $score/4")

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
    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        Row {
            Text("Pronunciation Guide", style = MaterialTheme.typography.titleLarge)
            BackButton { onBackClick() }
        }

        Column {
            Text("Word: Hola")
            Text("Pronunciation: OH-lah")
            Text("English Translation: Hello")

            Text("")

            Text("Word: Gracias")
            Text("Pronunciation: GRAH-see-ahs")
            Text("English Translation: Thank you")

            Text("")

            Text("Word: Por favor")
            Text("Pronunciation: POUR fa-vore")
            Text("English Translation: Please")

            Text("")

            Text("Word: De nada")
            Text("Pronunciation: de naw-daw")
            Text("English Translation: You're Welcome")

            Text("")

            Text("Word: Madre")
            Text("Pronunciation: ma-dreh")
            Text("English Translation: mother")

            Text("")

            Text("Word: Padre")
            Text("Pronunciation: paw-dreh")
            Text("English Translation: father")

            Text("")

            Text("Word: Hermano")
            Text("Pronunciation: her-mah-no")
            Text("English Translation: brother")

            Text("")

            Text("Word: Hermana")
            Text("Pronunciation: her-mah-nah")
            Text("English Translation: sister")
        }
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