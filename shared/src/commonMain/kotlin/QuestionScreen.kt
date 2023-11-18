import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import network.data.Answer
import network.data.Question
import network.data.Quiz

//Déroulé du Quizz
val listOfReponses1 = listOf<Answer>(Answer(1,"1"),Answer(2,"2"),Answer(3,"3"))
val listOfReponses2 = listOf<Answer>(Answer(4,"Oui"),Answer(5,"Non"),Answer(6,"De temps en temps"))
val listOfReponses3 = listOf<Answer>(Answer(7,"Pourquoi pas ?"),Answer(8,"Parceque"),Answer(9,"feur"))
val listOfQuestions = listOf<Question>(Question(1,"1 + 1 = ?",2,listOfReponses1),Question(2,"Jules est intelligent ?",4,listOfReponses2),Question(3,"Pourquoi ?",9,listOfReponses3))
val unQuizz = Quiz(listOfQuestions)

var nb = 0


@Composable
fun QuestionScreen() {
    MaterialTheme{

        val (selectedOption, onOptionSelected) = remember { mutableStateOf(listOfReponses1[1] ) }

        var buttonText = "   Next !   "
        var questionProgress by remember { mutableStateOf(0) }
        var score by remember { mutableStateOf(0) }
        val nbquestion = 3

        Column (modifier = Modifier.fillMaxHeight().background(color = Color.White)){
            Row(modifier = Modifier.padding(20.dp).border(3.dp, color = Color.Black, shape = RoundedCornerShape(10)).fillMaxWidth()){

                //box avec la question
                Box(modifier=Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Card(modifier = Modifier.padding(0.dp).fillMaxWidth()) {
                        Column(modifier = Modifier.padding(0.dp).background(color = Color.LightGray), verticalArrangement = Arrangement.Center){
                            Text(unQuizz.lesQuestions[questionProgress].label, color = Color.DarkGray, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                            Text("Votre score est de : " + score , color = Color.DarkGray, fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                        }

                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){

                //Contenu des Réponses
                Column(modifier = Modifier.background(color = Color.White).padding(0.dp).border(3.dp, color = Color.Black, shape = RoundedCornerShape(10))) {
                    unQuizz.lesQuestions[questionProgress].answers.forEach { text -> Row ( modifier = Modifier

                        //.selectable(
                        //selected = text == selectedOption,
                        //  onClick = {}
                        //)
                        .padding(0.dp)
                    )
                    {
                        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                modifier = Modifier.padding(10.dp),
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }

                            )
                            Text(
                                text.label,
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.body1.merge(),
                            )
                        }
                    }
                    }
                }
            }

            //Bouton Next !
            Row (modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.Center){
                Button(modifier = Modifier, onClick = {

                    //Réponse correct
                    if (questionProgress < nbquestion-1){
                        if (selectedOption.id==unQuizz.lesQuestions[questionProgress].correctAnswerId){
                            score++
                        }
                        nb++
                        questionProgress++
                    }else if(nb == 2 ){

                        if (selectedOption.id==unQuizz.lesQuestions[questionProgress].correctAnswerId){
                            score++
                        }
                        buttonText = "   Done !   "
                        nb++

                    }

                })

                {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "Next question")
                    Text(buttonText, fontSize = 22.sp)
                }
            }

            //Bottom bar de l'avancement du Quizz
            Scaffold(
                bottomBar = {
                    BottomAppBar(modifier = Modifier.height(10.dp).fillMaxWidth(), backgroundColor = Color.Transparent) { /* Bottom app bar content */
                        LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(10.dp),progress = ((questionProgress+1).toFloat()/unQuizz.lesQuestions.size), color = Color.Red)
                    }
                }
            ){}
        }
    }
}