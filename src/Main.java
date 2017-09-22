import gui.GameField;
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
        GameField gameField = new GameField(controller);

        gameField.setStage(primaryStage);
        primaryStage.setScene(gameField.getScene());
        primaryStage.show();
    }
}
