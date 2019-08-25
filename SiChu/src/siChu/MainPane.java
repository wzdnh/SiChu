package siChu;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainPane extends Application {
    public String text = "";
    ArrayList listUrl = new ArrayList(); 
    
    @Override
    public void start(Stage primaryStage) {      
        /*
        对盒子的操作
        */
        HBox hBox = new HBox();//Top
        VBox vBoxL = new VBox();//left
        HBox hBoxNew  = new HBox();//最新增加来放标签的
        VBox vBoxR = new VBox();//right
        VBox vBoxC = new VBox();//center
        //cente的三个水平盒子
        HBox hBoxA = new HBox();
        HBox hBoxB = new HBox();
        HBox hBoxC = new HBox();
        
        /*
        
        对上面部分的操作
        */
        Label label = new Label("私  厨");
        label.setStyle("-fx-font-weight: bold");
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(Font.font("Cambria", 60));

        //增加动态
        label.setOnMouseEntered((MouseEvent e) -> {
            label.setScaleX(1.1);
            label.setScaleY(1.1);
        });
        label.setOnMouseExited((MouseEvent e) -> {
            label.setScaleX(1);
            label.setScaleY(1);
        });
        hBox.setPadding(new Insets(30, 50, 20, 930));//shang  you  xia  zuo 
        hBox.setSpacing(730);
        hBox.getChildren().addAll(label);
        
        /*
        
        对左边部分的操作
        */
        Label label2 = new Label("热门视频！");
        label2.setTextFill(Color.web("#FF6100"));
        label2.setFont(Font.font("Cambria", 30));
        //增加动态
        label2.setOnMouseEntered((MouseEvent e) -> {
            label2.setScaleX(1.05);
            label2.setScaleY(1.05);
        });
        label2.setOnMouseExited((MouseEvent e) -> {
            label2.setScaleX(1);
            label2.setScaleY(1);
        });
        hBoxNew.setPadding(new Insets(0, 0, 0, 30));//shang  you  xia  zuo 
        hBoxNew.getChildren().addAll(label2);
        
        Button buttonLA = new Button("");
        buttonLA.setStyle("-fx-background-image:url('/回锅肉.jpg')");
        buttonLA.setPrefSize(180, 250);//width,height
        buttonLA.setOnMouseEntered((MouseEvent e) -> {
            buttonLA.setScaleX(1.1);
            buttonLA.setScaleY(1.1);
        });
        buttonLA.setOnMouseExited((MouseEvent e) -> {
            buttonLA.setScaleX(1);
            buttonLA.setScaleY(1);
        });
        
        Button buttonLB = new Button("");
        buttonLB.setStyle("-fx-background-image:url('/大杂烩.jpg')");
        //buttonLB.setStyle("-fx-font: 2 arial; -fx-base: #0096BF;");
        buttonLB.setPrefSize(180, 250);
        buttonLB.setOnMouseEntered((MouseEvent e) -> {
            buttonLB.setScaleX(1.1);
            buttonLB.setScaleY(1.1);
        });
        buttonLB.setOnMouseExited((MouseEvent e) -> {
            buttonLB.setScaleX(1);
            buttonLB.setScaleY(1);
        });
        
        Button buttonLC = new Button("");
        buttonLC.setStyle("-fx-background-image:url('/麻婆豆腐.jpg')");
        buttonLC.setPrefSize(180, 250);
        buttonLC.setOnMouseEntered((MouseEvent e) -> {
            buttonLC.setScaleX(1.1);
            buttonLC.setScaleY(1.1);
        });
        buttonLC.setOnMouseExited((MouseEvent e) -> {
            buttonLC.setScaleX(1);
            buttonLC.setScaleY(1);
        });
        
        vBoxL.setSpacing(35);//节点间的垂直距离
        vBoxL.setPadding(new Insets(0, 40, 10, 90));//所有节点与格子的外边距 shang  you  xia  zuo 
        vBoxL.getChildren().addAll(hBoxNew, buttonLA, buttonLB, buttonLC);
        
        /*
        
        对中间轮播图的操作
        */
        Button buttonTest = new Button("");
        buttonTest.setPrefSize(1300, 510);
        //用线程实现轮播图
        new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    
                    if (buttonTest.getText().trim().length() == 0){
                        text = ".";
                        buttonTest.setStyle("-fx-background-image:url('/centerA.jpg')");
                        
                        buttonTest.setOnAction((ActionEvent event) -> { 
                            Center1 open = new Center1();
                            open.start(new Stage());
                        
                        });   
                       
                    }
                    else if(buttonTest.getText().trim().length() == 1){
                        text = "..";
                        buttonTest.setStyle("-fx-background-image:url('/centerB.jpg')");
                        
                        buttonTest.setOnAction((ActionEvent event) -> { 
                            Center2 open = new Center2();
                            open.start(new Stage());
                        });    
         
                    }
                    else{
                        text = "";
                        buttonTest.setStyle("-fx-background-image:url('/centerC.jpg')");
                        
                        buttonTest.setOnAction((ActionEvent event) -> { 
                            Center3 open = new Center3();
                            open.start(new Stage());
                        });   
                          
                    }
                    
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run(){
                            buttonTest.setText(text);             
                        }
                    });
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }).start();
        
        hBoxA.getChildren().addAll(buttonTest);
        
        /*
        
        中下八个按钮的操作
        */
        Button buttonC1 = new Button("");
        buttonC1.setStyle("-fx-background-image:url('/川菜.jpg')");
        buttonC1.setPrefSize(270, 140);
        
        Button buttonC2 = new Button("");
        buttonC2.setStyle("-fx-background-image:url('/徽菜.jpg')");
        buttonC2.setPrefSize(270, 140);
        buttonC2.setOnMouseEntered((MouseEvent e) -> {
            buttonC2.setScaleX(1.1);
            buttonC2.setScaleY(1.1);
        });
        buttonC2.setOnMouseExited((MouseEvent e) -> {
            buttonC2.setScaleX(1);
            buttonC2.setScaleY(1);
        });
        
        Button buttonC3 = new Button("");
        buttonC3.setStyle("-fx-background-image:url('/浙菜.jpg')");
        buttonC3.setPrefSize(270, 140);
        buttonC3.setOnMouseEntered((MouseEvent e) -> {
            buttonC3.setScaleX(1.1);
            buttonC3.setScaleY(1.1);
        });
        buttonC3.setOnMouseExited((MouseEvent e) -> {
            buttonC3.setScaleX(1);
            buttonC3.setScaleY(1);
        });
        
        Button buttonC4 = new Button("");
        buttonC4.setStyle("-fx-background-image:url('/湘菜.jpg')");
        buttonC4.setPrefSize(270, 140);
        buttonC4.setOnMouseEntered((MouseEvent e) -> {
            buttonC4.setScaleX(1.1);
            buttonC4.setScaleY(1.1);
        });
        buttonC4.setOnMouseExited((MouseEvent e) -> {
            buttonC4.setScaleX(1);
            buttonC4.setScaleY(1);
        });
        
        Button buttonC5 = new Button("");
        buttonC5.setStyle("-fx-background-image:url('/粤菜.jpg')");
        buttonC5.setPrefSize(270, 140);
        buttonC5.setOnMouseEntered((MouseEvent e) -> {
            buttonC5.setScaleX(1.1);
            buttonC5.setScaleY(1.1);
        });
        buttonC5.setOnMouseExited((MouseEvent e) -> {
            buttonC5.setScaleX(1);
            buttonC5.setScaleY(1);
        });
        
        Button buttonC6 = new Button("");
        buttonC6.setStyle("-fx-background-image:url('/苏菜.jpg')");
        buttonC6.setPrefSize(270, 140);
        buttonC6.setOnMouseEntered((MouseEvent e) -> {
            buttonC6.setScaleX(1.1);
            buttonC6.setScaleY(1.1);
        });
        buttonC1.setOnMouseExited((MouseEvent e) -> {
            buttonC6.setScaleX(1);
            buttonC6.setScaleY(1);
        });
        
        Button buttonC7 = new Button("");
        buttonC7.setStyle("-fx-background-image:url('/闽菜.jpg')");
        buttonC7.setPrefSize(270, 140);
        buttonC7.setOnMouseEntered((MouseEvent e) -> {
            buttonC7.setScaleX(1.1);
            buttonC7.setScaleY(1.1);
        });
        buttonC7.setOnMouseExited((MouseEvent e) -> {
            buttonC7.setScaleX(1);
            buttonC7.setScaleY(1);
        });
        
        Button buttonC8 = new Button("");
        buttonC8.setStyle("-fx-background-image:url('/鲁菜.jpg')");
        buttonC8.setPrefSize(270, 140);
        buttonC8.setOnMouseEntered((MouseEvent e) -> {
            buttonC8.setScaleX(1.1);
            buttonC8.setScaleY(1.1);
        });
        buttonC8.setOnMouseExited((MouseEvent e) -> {
            buttonC8.setScaleX(1);
            buttonC8.setScaleY(1);
        });
        
        //
        hBoxB.getChildren().addAll(buttonC1, buttonC2, buttonC3, buttonC4);
        hBoxB.setSpacing(70);
        hBoxB.setPadding(new Insets(0, 0, 0, 0));//所有节点与盒子的边距shang  you  xia  zuo 
        hBoxC.getChildren().addAll(buttonC5, buttonC6, buttonC7, buttonC8);
        hBoxC.setSpacing(70);
        hBoxC.setPadding(new Insets(0, 0, 0, 0));//所有节点与盒子的边距shang  you  xia  zuo 
        vBoxC.getChildren().addAll(hBoxA, hBoxB, hBoxC);
        vBoxC.setPadding(new Insets(0, 50, 10, 50));//所有节点与盒子的边距shang  you  xia  zuo 
        vBoxC.setSpacing(45);//节点间的垂直距离
        //
        
        /*
        
        对右边部分的操作
        */
        Button buttonR1 = new Button("");//, imageViewR1
        buttonR1.setStyle("-fx-background-image:url('/头像.jpg')");
        buttonR1.setMinSize(90, 90);       
        //buttonR1.setStyle( "-fx-border-radius: 50; -fx-background-radius:50; -fx-border-radius: 50; -fx-background-radius:50;");
        buttonR1.setOnMouseEntered((MouseEvent e) -> {
            buttonR1.setScaleX(1.1);
            buttonR1.setScaleY(1.1);
        });
        buttonR1.setOnMouseExited((MouseEvent e) -> {
            buttonR1.setScaleX(1);
            buttonR1.setScaleY(1);
        });
        
        Button buttonR2 = new Button("");
        buttonR2.setStyle("-fx-background-image:url('/论坛.jpg')");
        buttonR2.setPrefSize(90, 90);
        buttonR2.setOnMouseEntered((MouseEvent e) -> {
            buttonR2.setScaleX(1.1);
            buttonR2.setScaleY(1.1);
        });
        buttonR2.setOnMouseExited((MouseEvent e) -> {
            buttonR2.setScaleX(1);
            buttonR2.setScaleY(1);
        });
        
        Button buttonR3 = new Button("");
        buttonR3.setStyle("-fx-background-image:url('/close.jpg')");
        buttonR3.setPrefSize(90, 90);      
        buttonR3.setOnMouseEntered((MouseEvent e) -> {
            buttonR3.setScaleX(1.1);
            buttonR3.setScaleY(1.1);
        });
        buttonR3.setOnMouseExited((MouseEvent e) -> {
            buttonR3.setScaleX(1);
            buttonR3.setScaleY(1);
        });
        
        //公告栏部分
        VBox vBoxLast = new VBox();
        Label labelNotice = new Label("公告栏");
        labelNotice.setTextFill(Color.ORANGE); //设置Label 的文本颜色。
        labelNotice.setFont(Font.font("Cambria", 40));//设置字体，字号。
        //设置动态效果
        labelNotice.setOnMouseEntered((MouseEvent e) -> {
            labelNotice.setScaleX(1.1);
            labelNotice.setScaleY(1.1);
        });
        labelNotice.setOnMouseExited((MouseEvent e) -> {
            labelNotice.setScaleX(1);
            labelNotice.setScaleY(1);
        });
        labelNotice.setMaxSize(120, 300);
        
        Label labelOfNotice = new Label("       欢迎来到私厨，我们会为您提供最好的信息服务！");
        labelOfNotice.setWrapText(true);// 设置自动换行。
        //labelOfNotice.setTextFill(Color.ORANGE); //设置Label 的文本颜色。
        labelOfNotice.setFont(Font.font("Cambria", 20));//设置字体，字号。
        labelOfNotice.setMaxSize(140, 300);
        vBoxLast.getChildren().addAll(labelNotice, labelOfNotice);
        vBoxLast.setSpacing(15);
        
        vBoxR.setSpacing(80);//节点间的垂直距离
        vBoxR.setPadding(new Insets(0, 80, 50, 25));//所有节点与格子的外边距 shang  you  xia  zuo 
        vBoxR.getChildren().addAll(buttonR1, buttonR2, buttonR3, vBoxLast);
        
        /*
        
        窗口的搭建
        */
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setLeft(vBoxL);
        pane.setRight(vBoxR);
        pane.setCenter(vBoxC);
        pane.setStyle("-fx-background-image:url('/A.jpg')");
        Scene scene = new Scene(pane);//设置舞台大小
        primaryStage.setTitle("私厨");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true); // 设置全屏
        primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
        primaryStage.show();
        
               
        /*
        
        所有按钮事件编程
        */
        //左边三个
        buttonLA.setOnAction((ActionEvent event) -> {                   
            
            Player1 open = new Player1();
            try {
                open.start(new Stage());
                //stage.hide(); //点开新的界面后，是否关闭此界面
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainPane.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        });
        
        buttonLB.setOnAction((ActionEvent event) -> {
            Player2 open = new Player2();
            try {
                open.start(new Stage());
                //stage.hide(); //点开新的界面后，是否关闭此界面
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        buttonLC.setOnAction((ActionEvent event) -> {
            Player3 open = new Player3();
            try {
                open.start(new Stage());
                //stage.hide(); //点开新的界面后，是否关闭此界面
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //中间八个
        buttonC1.setOnAction((ActionEvent event) -> {
            C1 open  = new C1();
            open.start(new Stage());
   
        });
        
        buttonC2.setOnAction((ActionEvent event) -> {
            C2 open  = new C2();
            open.start(new Stage());
        });
        
        buttonC3.setOnAction((ActionEvent event) -> {
            C3 open  = new C3();
            open.start(new Stage());
        });
        
        buttonC4.setOnAction((ActionEvent event) -> {
            C4 open  = new C4();
            open.start(new Stage());    
        });
        
        buttonC5.setOnAction((ActionEvent event) -> {
            C5 open  = new C5();
            open.start(new Stage());
        });
        
        buttonC6.setOnAction((ActionEvent event) -> {
            C6 open  = new C6();
            open.start(new Stage());
        });
        
        buttonC7.setOnAction((ActionEvent event) -> {
            C7 open  = new C7();
            open.start(new Stage());    
        });
        
        buttonC8.setOnAction((ActionEvent event) -> {
            C8 open  = new C8();
            open.start(new Stage());    
        });
        
        //右边三个
        buttonR1.setOnAction((ActionEvent event) -> {
            //登录界面
            LoginPane open = new LoginPane();
            try{
                open.start(new Stage());
                //stage.hide(); //点开新的界面后，是否关闭此界面
            } 
            catch (Exception e1){
            }          
            
        });
        
        buttonR2.setOnAction((ActionEvent event) -> {
            Forum open = new Forum();
            open.start(new Stage());
            //stage.hide(); //点开新的界面后，是否关闭此界面
            
        });
        
        buttonR3.setOnAction((ActionEvent event) -> {
            primaryStage.close();//退出按钮
        });
                  
    }
    
    public static void main(String[] args) {
        launch(args);
    }
  
}