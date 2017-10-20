import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.GameLogic;
import present.activities.impl.GameField;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameLogic gameLogic = new GameLogic();
        Controller controller = new Controller(gameLogic);
        GameField gameField = new GameField(controller);
        primaryStage.setScene(gameField.getScene());
        primaryStage.show();
    }
}
