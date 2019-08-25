package siChu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Forum extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane forumPane = new BorderPane();
        forumPane.setStyle("-fx-background-image:url('/C.jpg')");
        
        Button btExit = new Button();
        btExit.setText("退出");
        btExit.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        Label labelTitle = new Label("私厨论坛");
        labelTitle.setTextFill(Color.web("#0076a3"));
        labelTitle.setFont(Font.font("Cambria", 45));
        
        HBox hBoxA = new HBox();
        hBoxA.setPadding(new Insets(50, 100, 50, 300));//shang  you  xia  zuo 
        hBoxA.setSpacing(500);
        hBoxA.getChildren().addAll(btExit, labelTitle);
        forumPane.setTop(hBoxA);
        //forumPane.setCenter();
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(30, 80, 10, 80));//shang  you  xia  zuo 
        
        Label laA1 = new Label("鲁煦：");
        Label laA2 = new Label("啊，酸菜鱼真好吃呀！！！！！！我下次还要吃这个");
        Label laA3 = new Label("2018/09/20     3.30");
        laA3.setStyle("-fx-font-weight: bold");
        laA3.setTextFill(Color.BLUE);
        laA3.setFont(Font.font("Cambria", 10));
        
        HBox hBoxA4 = new HBox();
        hBoxA4.setPadding(new Insets(0, 30, 0, 50));//shang  you  xia  zuo 
        hBoxA4.setSpacing(30);
        hBoxA4.getChildren().addAll(laA1, laA2, laA3);
        
        Label laB1 = new Label("蔺超：");
        Label laB2 = new Label("鲜肉灌汤包加咸味的豆腐脑，真的是太棒了，我很喜欢的一种搭配");
        Label laB3 = new Label("2018/12/10  3.30");
        laB3.setTextFill(Color.BLUE);
        laB3.setFont(Font.font("Cambria", 10));

        HBox hBoxB4 = new HBox();
        hBoxB4.setPadding(new Insets(0, 30, 0, 50));//shang  you  xia  zuo 
        hBoxB4.setSpacing(30);
        hBoxB4.getChildren().addAll(laB1, laB2, laB3);
        
        Label laC1 = new Label("我是英雄：");
        Label laC2 = new Label("4444444444444444444444444444444444444444444444");
        Label laC3 = new Label("2018/09/20     3.30");
        laC3.setTextFill(Color.BLUE);
        laC3.setFont(Font.font("Cambria", 10));
        
        HBox hBoxC4 = new HBox();
        hBoxC4.setPadding(new Insets(0, 30, 0, 50));//shang  you  xia  zuo 
        hBoxC4.setSpacing(30);
        hBoxC4.getChildren().addAll(laC1, laC2, laC3);
        
        Label laD1 = new Label("我是英雄：");
        Label laD2 = new Label("4444444444444444444444444444444444444444444444");
        Label laD3 = new Label("2018/09/20     3.30");
        laD3.setTextFill(Color.BLUE);
        laD3.setFont(Font.font("Cambria", 10));
        
        HBox hBoxD4 = new HBox();
        hBoxD4.setPadding(new Insets(0, 30, 0, 50));//shang  you  xia  zuo 
        hBoxD4.setSpacing(30);
        hBoxD4.getChildren().addAll(laC1, laC2, laC3);
        
        
        Label laE1 = new Label("我是英雄：");
        Label laE2 = new Label("4444444444444444444444444444444444444444444444");
        Label laE3 = new Label("2018/09/20     3.30");
        laE3.setTextFill(Color.BLUE);
        laE3.setFont(Font.font("Cambria", 10));
        
        HBox hBoxE4 = new HBox();
        hBoxE4.setPadding(new Insets(0, 30, 0, 50));//shang  you  xia  zuo 
        hBoxE4.setSpacing(30);
        hBoxE4.getChildren().addAll(laC1, laC2, laC3);
        
        vBox.getChildren().addAll(hBoxA4, hBoxB4, hBoxC4, hBoxD4, hBoxE4);
        forumPane.setCenter(vBox);
        
        VBox vBoxA = new VBox();
        TextField textField = new TextField("评论框");
        Button ButtonB = new Button("发送");
        ButtonB.setOnAction((ActionEvent event) -> {
            Tips open = new Tips();
            open.start(new Stage());
            //stage.hide(); //点开新的界面后，是否关闭此界面
        });
                
        vBoxA.getChildren().addAll(textField, ButtonB);
        vBoxA.setPadding(new Insets(20, 150, 50, 150));
        vBoxA.setSpacing(30);
        vBoxA.setAlignment(Pos.BASELINE_RIGHT);
        forumPane.setBottom(vBoxA);
        
        VBox vBoxTestL = new VBox();
        VBox vBoxTestR = new VBox();
        vBoxTestL.setMinWidth(200);
        vBoxTestR.setMinWidth(200);
        forumPane.setLeft(vBoxTestL);
        forumPane.setRight(vBoxTestR);
        
        Scene scene = new Scene(forumPane);
        primaryStage.setTitle("欢迎来到私厨论坛!");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true); // 设置全屏
        primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
