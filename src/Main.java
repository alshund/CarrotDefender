import gui.GameFrame;
import javafx.application.Application;
import controller.Controller;
import javafx.stage.Stage;
import model.GameLogic;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameLogic gameLogic = new GameLogic();
        Controller controller = new Controller(gameLogic);
        GameFrame gameFrame = new GameFrame(controller);

        gameFrame.setStage(primaryStage);
        primaryStage.setScene(gameFrame.getScene());
        primaryStage.show();
    }
}
