import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow

actual fun getPlatformName(): String = "Desktop"

//@Composable fun MainView() = ScoreScreen("20/20")
//@Composable fun MainView() = WelcomeScreen()
@Composable fun MainView() = App()


fun main() = application { // kotlin application
    PreComposeWindow(onCloseRequest = ::exitApplication, title = "QuizzApp") {
        App()
    }
}

        @Preview
@Composable
fun AppPreview() {
    App()
}