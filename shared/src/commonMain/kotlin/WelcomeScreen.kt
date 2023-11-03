import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Color.DarkGray), contentAlignment = Alignment.Center){

            Card(modifier = Modifier.padding(50.dp).width(350.dp).height(300.dp)) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center){
                    Text("Quizz", color = Color.Blue, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                    Text("")
                    Text("Un petit texte tout simple et tout mignon.", modifier = Modifier.align(Alignment.CenterHorizontally))
                    Text("")
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = { onClick() }) {
                        Text("Let's started !", fontSize = 22.sp)
                    }
                }
            }

        }
    }
}

fun onClick() {
    TODO("Not yet implemented")
}
