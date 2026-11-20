package com.example.learninglanguageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        text = "Welcome to the Language Learner App!",
        modifier = modifier,
        color = Color.Black,
        fontSize = 22.sp
    )
}

//--------------Buttons------------------------
@Composable
fun SpanishButton(onClick: () -> Unit) {
    FilledTonalButton(onClick =  { onClick() }, modifier = Modifier.size(width = 500.dp, height = 150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
            contentColor = Color.White)) {
        Text("Spanish", fontSize = 30.sp)
    }
}
@Composable
fun FrenchButton(onClick: () -> Unit) {
    FilledTonalButton(onClick =  { onClick() }, modifier = Modifier.size(width = 500.dp, height = 150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
            contentColor = Color.White)) {
        Text("French", fontSize = 30.sp)
    }
}

@Composable
fun ChineseButton(onClick: () -> Unit) {
    FilledTonalButton(onClick =  { onClick() }, modifier = Modifier.size(width = 500.dp, height = 150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
            contentColor = Color.White)) {
        Text("Chinese", fontSize = 30.sp)
    }
}

@Composable
fun VocabQuizButton(onClick: () -> Unit) {
    FilledTonalButton(onClick =  { onClick() }, modifier = Modifier.size(width = 500.dp, height = 150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
            contentColor = Color.White)) {
        Text("Vocabulary Quiz", fontSize = 30.sp)
    }
}

@Composable
fun PronunciationButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}, modifier = Modifier.size(width = 500.dp, height = 150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
            contentColor = Color.White)) {

        Text("Pronunciation Guide", fontSize = 30.sp)
    }
}

@Composable
fun BackButton(onBackClick: () -> Unit) {
    FilledTonalButton(onClick = { onBackClick()}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
        Text("Back", color = Color.White)
    }
}

@Composable
fun LanguageLearningAppScreens() {
    var currentScreen by remember {
        mutableStateOf("home")
    }

    when (currentScreen) {
        "home" -> HomeScreen(
            onSpanishClick = {currentScreen = "spanishMenu"},
            onFrenchClick = {currentScreen = "frenchMenu"},
            onChineseClick = {currentScreen = "chineseMenu"}

//            onQuizClick = {
//                currentScreen = "quiz"
//            },
//            onPronunciationClick = {
//                currentScreen = "pronunciation"
//            }
        )
        "spanishMenu" -> LanguageMenuScreen(languageName = "Spanish",
            onQuizClick = {currentScreen = "spanishQuiz"},
            onPronunciationClick = {currentScreen = "spanishGuide"},
            onBackClick = {currentScreen = "home"})

        "spanishQuiz" -> SpanishQuizScreen(onBackClick = {
            currentScreen = "home"
        })
        "spanishGuide" -> SpanishPronunciationScreen(onBackClick = {
            currentScreen = "home"
        })


        "frenchMenu" -> LanguageMenuScreen(languageName = "French",
            onQuizClick = {currentScreen = "frenchQuiz"},
            onPronunciationClick = {currentScreen = "frenchGuide"},
            onBackClick = {currentScreen = "home"})

        "frenchQuiz" -> FrenchQuizScreen(onBackClick = {
            currentScreen = "home"
        })
//        "frenchGuide" -> FrenchPronunciationScreen(onBackClick = {
//            currentScreen = "home"
//        })


        "chineseMenu" -> LanguageMenuScreen(languageName = "Chinese",
            onQuizClick = {currentScreen = "chineseQuiz"},
            onPronunciationClick = {currentScreen = "chineseGuide"},
            onBackClick = {currentScreen = "home"})

//        "chineseQuiz" -> ChineseQuizScreen(onBackClick = {
//            currentScreen = "home"
//        })
//        "chineseGuide" -> ChinesePronunciationScreen(onBackClick = {
//            currentScreen = "home"
//        })
    }
}

@Composable
fun HomeScreen(onSpanishClick: () -> Unit,
               onFrenchClick: () -> Unit,
               onChineseClick: () -> Unit) {
    Column (modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally){
        Greeting()
        SpanishButton {onSpanishClick()}
        FrenchButton {onFrenchClick() }
        ChineseButton { onChineseClick() }
    }
}

@Composable
fun LanguageMenuScreen(languageName: String,
                       onQuizClick: () -> Unit,
                       onPronunciationClick: () -> Unit,
                       onBackClick: () -> Unit) {
    Column {
        Text(languageName)
        BackButton { onBackClick() }
        VocabQuizButton { onQuizClick() }
        PronunciationButton { onPronunciationClick() }
    }


}

@Composable
fun SpanishQuizScreen(onBackClick: () -> Unit) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState()).background(color = Color.White).fillMaxWidth()) {
        var score by remember { mutableIntStateOf(0) }
        Row (modifier = Modifier.padding(16.dp)){
            Text("Vocabulary Quiz", style = MaterialTheme.typography.titleLarge, color = Color.Black)
            Spacer(modifier = Modifier.width(25.dp))
            BackButton { onBackClick() }
        }
        Text(text = "Score: $score/8", color = Color.Black)

        var question1Result by remember { mutableStateOf("") }
        var question2Result by remember { mutableStateOf("") }
        var question3Result by remember { mutableStateOf("") }
        var question4Result by remember { mutableStateOf("") }
        var question5Result by remember { mutableStateOf("") }
        var question6Result by remember { mutableStateOf("") }
        var question7Result by remember { mutableStateOf("") }
        var question8Result by remember { mutableStateOf("") }

        var question1Scored by remember { mutableStateOf(false) }
        var question2Scored by remember { mutableStateOf(false) }
        var question3Scored by remember { mutableStateOf(false) }
        var question4Scored by remember { mutableStateOf(false) }
        var question5Scored by remember { mutableStateOf(false) }
        var question6Scored by remember { mutableStateOf(false) }
        var question7Scored by remember { mutableStateOf(false) }
        var question8Scored by remember { mutableStateOf(false) }

        Row {
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 1: What does 'Hola' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
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

                Text(question1Result, color = Color.Black)
                Text("-------------------------------------------")
            }

            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 2: What does 'Por favor' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Hello") { question2Result = "Incorrect!"}
                AnswerButton(text = "Goodbye") { question2Result = "Incorrect!"}
                AnswerButton(text = "Thank You") { question2Result = "Incorrect!"}
                AnswerButton(text = "Please") { question2Result = "Correct!"
                    if (!question2Scored) {
                        score++
                        question2Scored = true
                    }

                }

                Text(question2Result, color = Color.Black)
                Text("-------------------------------------------")
            }

            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 3: What does 'Gracias' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Please") { question3Result = "Incorrect!"}
                AnswerButton(text = "Thank You") {question3Result = "Correct!"
                    if (!question3Scored) {
                        score++
                        question3Scored = true
                    }
                }
                AnswerButton(text = "Hello") { question3Result = "Incorrect!"}
                AnswerButton(text = "Goodbye") { question3Result = "Incorrect!"}

                Text(question3Result, color = Color.Black)
                Text("-------------------------------------------")
            }
        }

        Row {
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 4: What does 'Adios' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Thank You") { question4Result = "Incorrect!"}
                AnswerButton(text = "Please") { question4Result = "Incorrect!"}
                AnswerButton(text = "Goodbye") { question4Result = "Correct!"
                    if (!question4Scored) {
                        score++
                        question4Scored = true
                    }
                }
                AnswerButton(text = "Hello") { question4Result = "Incorrect!"}

                Text(question4Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 5: What does 'Hermano' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Dad") { question5Result = "Incorrect!" }
                AnswerButton(text = "Brother") { question5Result = "Correct!"
                    if (!question5Scored) {
                        score++
                        question5Scored = true
                    }}
                AnswerButton(text = "Sister") {
                    question5Result = "Incorrect!"
                }
                AnswerButton(text = "Mom") { question5Result = "Incorrect!" }

                Text(question5Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 6: What does 'Hermana' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Sister") { question6Result = "Correct!"
                    if (!question6Scored) {
                        score++
                        question6Scored = true
                    }}
                AnswerButton(text = "Dad") { question6Result = "Incorrect!" }
                AnswerButton(text = "Mom") { question6Result = "Incorrect!" }
                AnswerButton(text = "Brother") { question6Result = "Incorrect!" }

                Text(question6Result, color = Color.Black)
                Text("-------------------------------------------")
            }

        }

        Row{
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 7: What does 'Madre' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Brother") { question7Result = "Incorrect!" }
                AnswerButton(text = "Sister") { question7Result = "Incorrect!" }
                AnswerButton(text = "Mom") {
                    question7Result = "Correct!"
                    if (!question7Scored) {
                        score++
                        question7Scored = true
                    }
                }
                AnswerButton(text = "Dad") { question7Result = "Incorrect!" }

                Text(question7Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 8: What does 'Padre' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Mom") { question8Result = "Incorrect!" }
                AnswerButton(text = "Brother") { question8Result = "Incorrect!" }
                AnswerButton(text = "Sister") { question8Result = "Incorrect!" }
                AnswerButton(text = "Dad") { question8Result = "Correct!"
                    if (!question8Scored) {
                        score++
                        question8Scored = true
                    }}

                Text(question8Result, color = Color.Black)
                Text("-------------------------------------------")
            }
        }


        if(question1Result != ""
            && question2Result != ""
            && question3Result != ""
            && question4Result != ""
            && question5Result != ""
            && question6Result != ""
            && question7Result != ""
            && question8Result != "") {
            Text("Quiz Complete!" + " " +
                    "Final Score: $score/8", color = Color.Black, fontSize = 35.sp)

        }
    }

}


@Composable
fun FrenchQuizScreen(onBackClick: () -> Unit) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState()).background(color = Color.White).fillMaxWidth()) {
        var score by remember { mutableIntStateOf(0) }
        Row (modifier = Modifier.padding(16.dp)){
            Text("Vocabulary Quiz", style = MaterialTheme.typography.titleLarge, color = Color.Black)
            Spacer(modifier = Modifier.width(25.dp))
            BackButton { onBackClick() }
        }
        Text(text = "Score: $score/8", color = Color.Black)

        var question1Result by remember { mutableStateOf("") }
        var question2Result by remember { mutableStateOf("") }
        var question3Result by remember { mutableStateOf("") }
        var question4Result by remember { mutableStateOf("") }
        var question5Result by remember { mutableStateOf("") }
        var question6Result by remember { mutableStateOf("") }
        var question7Result by remember { mutableStateOf("") }
        var question8Result by remember { mutableStateOf("") }

        var question1Scored by remember { mutableStateOf(false) }
        var question2Scored by remember { mutableStateOf(false) }
        var question3Scored by remember { mutableStateOf(false) }
        var question4Scored by remember { mutableStateOf(false) }
        var question5Scored by remember { mutableStateOf(false) }
        var question6Scored by remember { mutableStateOf(false) }
        var question7Scored by remember { mutableStateOf(false) }
        var question8Scored by remember { mutableStateOf(false) }

        Row {
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 1: What does 'Bonjour' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
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

                Text(question1Result, color = Color.Black)
                Text("-------------------------------------------")
            }

            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 2: What is the French word for 'Thank you'?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Merci") {
                    question2Result = "Correct!"
                    if (!question2Scored) {
                        score++
                        question2Scored = true
                    }
                }
                AnswerButton(text = "Pardon") { question2Result = "Incorrect!"}
                AnswerButton(text = "Bonsoir") { question2Result = "Incorrect!"}
                AnswerButton(text = "Salut") { question2Result = "Incorrect!"
                }

                Text(question2Result, color = Color.Black)
                Text("-------------------------------------------")
            }

            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 3: What does 'Au revoir' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Good Morning") { question3Result = "Incorrect!"}
                AnswerButton(text = "Please") {question3Result = "Incorrect!" }
                AnswerButton(text = "Goodbye") { question3Result = "Correct!"
                    if (!question3Scored) {
                        score++
                        question3Scored = true
                    }
                }
                AnswerButton(text = "You're Welcome") { question3Result = "Incorrect!"}

                Text(question3Result, color = Color.Black)
                Text("-------------------------------------------")
            }
        }

        Row {
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 4: What is the French word for 'Yes'?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Non") { question4Result = "Incorrect!"}
                AnswerButton(text = "Oui") { question4Result = "Correct!"
                    if (!question4Scored) {
                        score++
                        question4Scored = true
                    }
                }
                AnswerButton(text = "Merci") { question4Result = "Incorrect!" }
                AnswerButton(text = "Salut") { question4Result = "Incorrect!"}

                Text(question4Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 5: What does 'Non' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "No") { question5Result = "Correct!"
                    if (!question5Scored) {
                        score++
                        question5Scored = true
                    }
                }
                AnswerButton(text = "Good night") { question5Result = "Incorrect!"}
                AnswerButton(text = "Hello") {
                    question5Result = "Incorrect!"
                }
                AnswerButton(text = "Please") { question5Result = "Incorrect!" }

                Text(question5Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 6: What is the french word for 'Please'?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Merci") { question6Result = "Incorrect!"}
                AnswerButton(text = "S'il vous plait") { question6Result = "Correct!"
                    if (!question6Scored) {
                        score++
                        question6Scored = true
                    }}
                AnswerButton(text = "Bonsoir") { question6Result = "Incorrect!" }
                AnswerButton(text = "Pardon") { question6Result = "Incorrect!" }

                Text(question6Result, color = Color.Black)
                Text("-------------------------------------------")
            }

        }

        Row{
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 7: What does 'Bonsoir' mean?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Good Evening") { question7Result = "Correct!"
                    if (!question7Scored) {
                        score++
                        question7Scored = true
                    }}
                AnswerButton(text = "Good Morning") { question7Result = "Incorrect!" }
                AnswerButton(text = "See you later") { question7Result = "Incorrect!" }
                AnswerButton(text = "Excuse me") { question7Result = "Incorrect!" }

                Text(question7Result, color = Color.Black)
                Text("-------------------------------------------")
            }
            Column (modifier = Modifier.padding(16.dp)){
                Text("Question 8: What is the French word for 'Excuse me'?", fontWeight = FontWeight.Bold, color = Color.Black)
                AnswerButton(text = "Salut") { question8Result = "Incorrect!" }
                AnswerButton(text = "Pardon") { question8Result = "Correct!"
                    if (!question8Scored) {
                        score++
                        question8Scored = true
                    }}
                AnswerButton(text = "Oui") { question8Result = "Incorrect!" }
                AnswerButton(text = "Merci") { question8Result = "Incorrect!" }

                Text(question8Result, color = Color.Black)
                Text("-------------------------------------------")
            }
        }


        if(question1Result != ""
            && question2Result != ""
            && question3Result != ""
            && question4Result != ""
            && question5Result != ""
            && question6Result != ""
            && question7Result != ""
            && question8Result != "") {
            Text("Quiz Complete!" + " " +
                    "Final Score: $score/8", color = Color.Black, fontSize = 35.sp)

        }
    }

}

@Composable
fun AnswerButton(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick()}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
        Text(text, color = Color.White)
    }
}


@Composable
fun SpanishPronunciationScreen(onBackClick: () -> Unit) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState()).background(color = Color.White).fillMaxWidth()){
        Row {
            Text("Pronunciation Guide", style = MaterialTheme.typography.titleLarge, color = Color.Black)
            Spacer(modifier = Modifier.width(25.dp))
            BackButton { onBackClick() }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text("Word", modifier = Modifier.weight(0.25F), color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            Text("Pronunciation", modifier = Modifier.weight(0.25F), color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            Text("English Translation", modifier = Modifier.weight(0.25F), color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        }
        CompositionLocalProvider(LocalContentColor provides Color.Black) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    "Greetings and Manners",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )

                Word("Hola", "OH-lah", "Hello")
                Word("Gracias", "GRAH-see-ahs", "Thank you")
                Word("Por favor", "POUR fa-vore", "Please")
                Word("De nada", "de naw-daw", "You're welcome")

                Text(
                    "People",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )

                Word("Familia", "fah-MEE-lee-ah", "family")
                Word("Madre", "ma-dreh", "mother")
                Word("Padre", "paw-dreh", "father")
                Word("Hermano", "her-mah-no", "brother")
                Word("Hermana", "her-mah-nah", "sister")
                Word("Amigo", "ah-MEE-goh", "friend")

                Text(
                    "Food and Drink",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )

                Word("Agua", "AH-gwah", "water")
                Word("Comida", "koh-MEE-dah", "food")
                Word("Pollo", "poy-oh", "chicken")
                Word("Arroz", "ah-rose", "rice")
                Word("Refresco", "re-FRES-co", "soda")

                Text(
                    "Places",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )

                Word("Casa", "KAH-sah", "house")
                Word("Escuela", "es-KWEH-lah", "school")
                Word("Trabajo", "trah-BAH-ho", "work")
                Word("Biblioteca", "bib-lee-oh-tech-ah", "library")

                Text(
                    "Things",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
                Word("Libro", "LEE-broh", "book")
                Word("Coche", "KOH-cheh", "car")
                Word("lapiz", "lah-peas", "pencil")
                Word("papel", "pah-pel", "paper")

                Text(
                    "Time",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )

                Word("Tiempo", "TEE-em-poh", "time")
                Word("mañana", "mahn-yah-nah", "morning")
                Word("Día", "DEE-ah", "day")
                Word("Noche", "NO-cheh", "night")
            }
        }

    }


}
@Composable
fun Word(word: String, pronunciation: String, translation: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)){
        Text(text = word, modifier = Modifier.weight(0.25F))
        Text(text = pronunciation, modifier = Modifier.weight(0.25F))
        Text(text = translation, modifier = Modifier.weight(0.25F))
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