package siChu;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class C7 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setStyle("-fx-background-image:url('/闽菜制作上.jpg')");
        btn.setPrefSize(560, 790);
        
        Button btnNextA = new Button("->");
        btnNextA.setOnAction((ActionEvent event) -> {
            C7B open = new C7B();
            open.start(new Stage());
            primaryStage.hide(); //点开新的界面后，是否关闭此界面
        });
        
        
        btnNextA.setLayoutX(510);
        btnNextA.setLayoutY(805);
        Pane root = new Pane();
        root.getChildren().addAll(btn,btnNextA);

        Scene scene = new Scene(root, 560, 850);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
