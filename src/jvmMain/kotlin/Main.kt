import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.awt.awtEventOrNull
import androidx.compose.ui.input.key.KeyEventType.Companion.KeyDown
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlinx.coroutines.flow.MutableStateFlow
import view.game.GameView
import view.game.GameViewModel
import domain.GameMode
import view.menu.MenuView
import view.menu.MenuViewModel

/**
 * App Composable that switchs between the screens and triggers navigation events in the view models
 */
@Composable
@Preview
fun App(navigation: MutableStateFlow<NavigationParcel>, menuViewModel: MenuViewModel, gameViewMode: GameViewModel) {
    val navState = navigation.collectAsState()
    with(navState.value){
        when(this){
            is NavigationParcel.Game -> {
                gameViewMode.loadGame(this.value)
                GameView(gameViewMode)
            }
            is NavigationParcel.Menu -> {
                menuViewModel.updateXP(this.value)
                MenuView(menuViewModel)
            }
        }
    }
}

/**
 * Main functions that generates the viewModels for the two screens and is owner of
 * the navigation flow to allow navigation and communication between the views.
 * Additionaly keeps track of user inout
 */
fun main(){
    val navigation: MutableStateFlow<NavigationParcel> = MutableStateFlow(NavigationParcel.Menu())
    val menuViewModel = MenuViewModel(navigation)
    val gameViewModel = GameViewModel(navigation)
    application {
        Window(onCloseRequest = ::exitApplication,
            onKeyEvent = {
                if(it.type == KeyDown){
                    it.awtEventOrNull?.let { key ->
                        gameViewModel.keyEvent(key.keyCode)
                    }
                }
                true
            },
            title = "Sudoku",
            icon = painterResource("drawable/icon.ico"),
            state = WindowState(position = WindowPosition(Alignment.Center), height = 768.dp, width = 1280.dp)
        ){
            App(navigation, menuViewModel, gameViewModel)
        }
    }
}

open class NavigationParcel {
    data class Game(val value: GameMode) : NavigationParcel()
    data class Menu(val value: Int = 0) : NavigationParcel()
}
