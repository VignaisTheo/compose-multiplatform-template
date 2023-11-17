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

data class Reponses(val id : Int,val label :String)
data class Questions(val label:String,val correctIdInt :Int,val lesReponses:List<Reponses>)
data class Quizz(val lesQuestions : List<Questions>)


//Déroulé du Quizz
val listOfReponses1 = listOf<Reponses>(Reponses(1,"1"),Reponses(2,"2"),Reponses(3,"3"))
val listOfReponses2 = listOf<Reponses>(Reponses(4,"Oui"),Reponses(5,"Non"),Reponses(6,"De temps en temps"))
val listOfReponses3 = listOf<Reponses>(Reponses(7,"Pourquoi pas ?"),Reponses(8,"Parceque"),Reponses(9,"feur"))
val listOfQuestions = listOf<Questions>(Questions("1 + 1 = ?",2,listOfReponses1),Questions("Jules est intelligent ?",4,listOfReponses2),Questions("Pourquoi ?",9,listOfReponses3))
val unQuizz = Quizz(listOfQuestions)

var nb = 0


@Composable
fun QuestionScreen() {
    MaterialTheme{
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(listOfReponses1[1] ) }

        var buttonText = "   Next !   "
        var questionProgress by remember { mutableStateOf(0) }
        var score by remember { mutableStateOf(0) }
        val nbquestion = 3


        Column (modifier = Modifier.background(color = Color.LightGray).fillMaxHeight()){
            Row(modifier = Modifier.fillMaxWidth()){

                //box avec la question
                Box(modifier=Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Card(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center){
                            Text(unQuizz.lesQuestions[questionProgress].label, color = Color.DarkGray, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                            Text("Votre score est de : " + score , color = Color.DarkGray, fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                        }
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){

                //Contenu des Réponses
                Column(modifier = Modifier.background(color = Color.White).padding(30.dp).border(3.dp, color = Color.Black, shape = RoundedCornerShape(10))) {
                    unQuizz.lesQuestions[questionProgress].lesReponses.forEach { text -> Row ( modifier = Modifier

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
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(modifier = Modifier, onClick = {

                    //Réponse correct
                    if (questionProgress < nbquestion-1){
                        if (selectedOption.id==unQuizz.lesQuestions[questionProgress].correctIdInt){
                            score++
                        }
                        nb++
                        questionProgress++
                    }else if(nb === 2 ){

                        if (selectedOption.id==unQuizz.lesQuestions[questionProgress].correctIdInt){
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
                        LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(10.dp),progress = ((questionProgress+1).toFloat()/nbquestion), color = Color.Red)
                    }
                }
            ){}
        }
    }
}