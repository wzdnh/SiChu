package siChu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Center1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setStyle("-fx-background-image:url('/淮山炖鸡汤.jpg')");
        btn.setPrefSize(664, 804);
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 664, 806);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
