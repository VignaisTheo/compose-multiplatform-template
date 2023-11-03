import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Reponses(val label :String)
data class Questions(val label:String,val correctIdInt :Int,val lesReponses:List<Reponses>)
data class Quizz(val lesQuestions : List<Questions>)

val listOfReponses = listOf<Reponses>(Reponses("Réponse 1"),Reponses("Réponse 2"),Reponses("Réponse 3"))
val listOfQuestions = listOf<Questions>(Questions("Question numéro 1",2,listOfReponses),Questions("La question 2",3,listOfReponses))
val unQuizz = Quizz(listOfQuestions)

@Composable
fun QuestionScreen() {
    MaterialTheme{
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(listOfReponses[1] ) }

        //box avec la question
        Box(modifier=Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Card(modifier = Modifier.padding(50.dp).fillMaxWidth().height(100.dp)) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center){
                    Text(unQuizz.lesQuestions[0].label, color = Color.DarkGray, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                }
            }
        }

        Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(50.dp)) {
            listOfReponses.forEach { text -> Row ( modifier = Modifier

                .selectable(
                    selected = text == selectedOption,
                    onClick = {}
                ).padding(20.dp)
            )
            {
                Row(modifier = Modifier.padding(20.dp)) {
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
}