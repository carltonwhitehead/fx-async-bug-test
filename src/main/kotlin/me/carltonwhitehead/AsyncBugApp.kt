package me.carltonwhitehead

import javafx.application.Application
import tornadofx.*

class AsyncBugApp : App(MainView::class)

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
    Application.launch(AsyncBugApp::class.java, *args)
}

class MainView : View("Async Bug App") {
    val controller: MainController by inject()
    override val root = pane {
        button("Robot-click to repeat bug") {
            id = "bug"
            action {
                runAsync {
                    controller.onAction("button clicked")
                }
            }
        }
    }
}

class MainController : Controller() {
    fun onAction(message: String) {
        println(message)
    }
}