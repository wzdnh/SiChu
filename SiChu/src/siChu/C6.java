package siChu;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class C6 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setStyle("-fx-background-image:url('/苏菜制作.jpg')");
        btn.setPrefSize(560, 790);
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 560, 792);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
