package siChu;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class C7C extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setStyle("-fx-background-image:url('/闽菜制作下.jpg')");
        btn.setPrefSize(560, 790);
       
        Button btnNext = new Button("<-");
        btnNext.setOnAction((ActionEvent event) -> {
            C7B open = new C7B();
            open.start(new Stage());
            primaryStage.hide(); //点开新的界面后，是否关闭此界面
        });
        
        btnNext.setLayoutX(20);
        btnNext.setLayoutY(805);
        Pane root = new Pane();
        root.getChildren().addAll(btn, btnNext);

        Scene scene = new Scene(root, 560, 850);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
