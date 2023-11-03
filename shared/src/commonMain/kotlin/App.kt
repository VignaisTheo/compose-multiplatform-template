import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.BlendMode.Companion.Lighten
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class Exp(val title: String, val exp1: String, val exp2: String,val exp3 : String)
data class Skill(val name:String)
data class Hobbie(val name:String)

val listOfExp = listOf<Exp>(Exp("Mes Études","2023 : J'ai fais du kotlin","2022 : J'ai battu Mathieu au UNO","2021 : Plein plein de cours"),
    Exp("Expériences","2023 : J'ai fais du kotlin","2022 : J'ai battu Jules au UNO","2021 : Plein plein de cours"))

val listOfSkill = listOf<Skill>(Skill("C#"),Skill("Kotlin"),Skill("Java"),Skill("SQL"),Skill("C"),Skill("Python"))
val listOfHobbies = listOf<Hobbie>(Hobbie("Jeux Vidéos"),Hobbie("Sports"),Hobbie("Paris sportifs"))

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {

        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }


        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    contentDescription = "Compose Multiplatform icon"
                )
            }
        }
    }
}

@Composable
fun Cv(){
    MaterialTheme{
        Row (modifier = Modifier
            //.verticalScroll(rememberScrollState())
        ){
            Column(modifier = Modifier.weight(4f).background(color = androidx.compose.ui.graphics.Color.LightGray).fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally) {

                Column1()

            }
            Column (modifier = Modifier.weight(10f).fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally){

                Column (modifier = Modifier.height(220.dp).padding(10.dp),verticalArrangement = Arrangement.Center){
                    Text("Vignais Théo", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 10.dp))
                    Text("Theo@gmail.com")
                    Text("06 14 57 48 65")
                    Text("58 rue des chèvres, 59000, Lille")
                }

                Divider(Modifier.width(200.dp))

                listOfExp.forEach { Exp -> Column2(Exp) }
            }
        }

    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Column1() {

    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .height(220.dp)
        //.background(androidx.compose.ui.graphics.Color.Red)
    ){
        Image(
            painterResource("photo_theo.jpg"),
            contentDescription = "Photo de la personne",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
        )
    }

    Divider(Modifier.width(150.dp).padding(15.dp))

    Text("Skills",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp, modifier = Modifier.padding(15.dp))

    listOfSkill.forEach { Skill -> Column1_Skill(Skill) }

    Divider(Modifier.width(150.dp).padding(15.dp))

    Text("Hobbies",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp, modifier = Modifier.padding(15.dp))

    listOfHobbies.forEach { Hobbie -> Column1_Hobbie(Hobbie) }

}

@Composable
fun Column1_Skill(skill : Skill){
    Row(){
        Text(skill.name)
    }
}
@Composable
fun Column1_Hobbie(hobbie: Hobbie){
    Row(){
        Text(hobbie.name)
    }
}


@Composable
fun Column2(exp : Exp){

    Column (modifier = Modifier.padding(20.dp),verticalArrangement = Arrangement.Center){
        Text(exp.title,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp)
        Text("")
        Text(exp.exp1)
        Text(exp.exp2)
        Text(exp.exp3)
    }
}

expect fun getPlatformName(): String