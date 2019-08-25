package siChu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tips extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        Label label = new Label("敬请期待，我们会尽快完善功能");
        label.setStyle("-fx-font-weight: bold");
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(Font.font("Cambria", 30));    

        
        StackPane root = new StackPane();
        root.getChildren().add(label);
        
        Scene scene = new Scene(root, 500, 250);
        
        primaryStage.setTitle("私厨");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
