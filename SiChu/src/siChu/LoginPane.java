package siChu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPane extends Application {
    private String key;
    private String password;
    Map hashMap = new HashMap();
    //ArrayList name = new ArrayList(); 
    @Override
    public void start(Stage primaryStage) {
        Login login = new Login();
        
        GridPane pane = new GridPane();
        
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(50, 50, 50, 50));
        pane.setHgap(10.5);
        pane.setVgap(10.5);
        pane.add(new Label("登录名："), 0, 0);
        pane.add(new Label("  密码："), 0, 1);
        Text tips = new Text();//提示
        pane.add(tips, 1, 3);
        
        HBox hboxB  = new HBox();
        Button btA = new Button();
        Button btB = new Button();
        Button btC = new Button();
        btA.setText("登 录");//随机数对数输出框
        btB.setText("注 册");//个数输出框
        hboxB.getChildren().addAll(btA, btB);
        hboxB.setSpacing(40);   
        hboxB.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(hboxB,1,2);
        
        TextField textFieldA = new TextField(null);
       
        TextField textFieldB = new TextField(null);    
              
        pane.add(textFieldA, 1, 0);//userName
        pane.add(textFieldB, 1, 1);//password
        
        pane.setStyle("-fx-background-image:url('/B.jpg')");
        Scene scene = new Scene(pane, 700, 400);
        primaryStage.setTitle("Login!");
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
        primaryStage.setWidth(700);
        primaryStage.setHeight(400);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
        //登录的操作代码
        btA.setOnAction((ActionEvent e) -> {
            Integer name = Integer.valueOf(textFieldA.getText());
            String b = String.valueOf(hashMap.get(name));
            int c = Integer.valueOf(b);
            
            if (c == login.getPassword()){
                tips.setText("登录成功！");
                tips.setFont(Font.font ("Verdana", 13));
                tips.setFill(Color.ORANGE);
                SimpleDateFormat df = new SimpleDateFormat("mm:ss");//设置日期格式
                //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                String a = df.format(new Date());
                primaryStage.close();
            }
            else{
                tips.setText("密码或账号错误，请重新输入！");
                tips.setFont(Font.font ("Verdana", 13));
                tips.setFill(Color.RED);
            }
         
        });
        
        //注册的操作代码
        btB.setOnAction((ActionEvent e) -> { 
            key = textFieldA.getText();
            password =textFieldB.getText();
                 
            if(key ==null || password == null){
                tips.setText("不能为空，请重新输入！");
                tips.setFont(Font.font ("Verdana", 13));
                tips.setFill(Color.RED);
            }
            else{               
                login.setUserID(Integer.valueOf(textFieldA.getText()));
                login.setPassword(Integer.valueOf(textFieldB.getText()));
                hashMap.put(key, password);
                
                tips.setText("注册成功！ 请重新输入账号与密码");
                tips.setFont(Font.font ("Verdana", 13));
                tips.setFill(Color.ORANGE);
                textFieldA.setText(null);
                textFieldB.setText(null);
                
            }
            
        });
        
        btC.setOnAction((ActionEvent e) -> { 
            primaryStage.close();           
        });
        
       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public Map getHashMap(){
        return hashMap;
    }
    
}

        