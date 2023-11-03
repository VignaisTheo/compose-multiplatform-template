import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

//@Composable fun MainView() = ScoreScreen("20/20")
//@Composable fun MainView() = WelcomeScreen()
@Composable fun MainView() = QuestionScreen()
@Preview
@Composable
fun AppPreview() {
    Cv()
}