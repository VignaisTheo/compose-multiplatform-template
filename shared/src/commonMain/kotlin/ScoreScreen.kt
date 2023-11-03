import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreScreen(score : String){
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Color.DarkGray),
            contentAlignment = Alignment.Center

        ) {
            Card(modifier = Modifier.padding(50.dp).width(350.dp).height(300.dp)) {
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center){
                    Text("Score", color = Color.DarkGray, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
                    Text(score, fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp).align(Alignment.CenterHorizontally))
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = { onClick() }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Localized description")
                        Text("Retake the quizz !", fontSize = 22.sp)
                    }
                }
            }
        }
    }
}