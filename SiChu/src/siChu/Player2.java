package siChu;

import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Player2 extends Application {
    
    private Double endTime = new Double(0);
    private Double currentTime = new Double(0);
    public String media_URL = getClass().getResource("大杂烩video.mp4").toString();
    //public String url = "http://pengpai-1253965071.cosgz.myqcloud.com/%E5%BB%BA%E7%A7%91%E9%99%A2%E4%B8%8A%E5%B8%8220170911%E6%88%90%E5%93%81.mp4";
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {

        BorderPane mediaPane = new BorderPane();
        mediaPane.setStyle("-fx-background-image:url('/D.jpg')");
        Media media = new Media(media_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.fitHeightProperty().bind(mediaPane.heightProperty());
        mediaView.fitWidthProperty().bind(mediaPane.widthProperty());
        Button playButton = new Button("播放");
       
        playButton.setOnAction(e -> {
            if (playButton.getText().equals("播放")) {
                mediaPlayer.play();
                playButton.setText("暂停");
            }
            else{
                mediaPlayer.pause();
                playButton.setText("播放");
            }
        });
        
         // 视频时间轴
        Slider slVideo = new Slider();
        Label lbCurrentTime = new Label();
        lbCurrentTime.setTextFill(Color.WHITE); //设置Label 的文本颜色。
        slVideo.setPrefWidth(935);//进度条的长度
        
        mediaPlayer.currentTimeProperty().addListener(e ->{
                currentTime = mediaPlayer.getCurrentTime().toSeconds();//视频现在的时间
                endTime = mediaPlayer.getStopTime().toSeconds();//视频的结束时间
                lbCurrentTime.setText(Seconds2Str(currentTime)+"/"+Seconds2Str(endTime));
                slVideo.setValue(currentTime/endTime*100);//使进度条随视频动起来
        });
        slVideo.valueProperty().addListener(e ->{
            if (slVideo.isValueChanging()){
                mediaPlayer.seek(mediaPlayer.getTotalDuration().multiply(slVideo.getValue()/100));//改变进度条可以改变视频的时间
            }
        });

        //音频进度条
        Slider slVolume = new Slider();
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(100);//进度条长度
        slVolume.setValue(50);//进度条初始值
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));
        
        HBox hBoxA = new HBox(10);
        hBoxA.setAlignment(Pos.CENTER);
        hBoxA.getChildren().addAll( slVideo,  lbCurrentTime);
        
        HBox hBoxB = new HBox(30);
        hBoxB.setAlignment(Pos.BASELINE_RIGHT);
        Label labelY = new Label("音量");
        labelY.setTextFill(Color.WHITE);
        hBoxB.getChildren().addAll(labelY, slVolume);
        hBoxB.setPadding(new Insets(5, 0, 0, 300));
        
        Button btnClose = new Button();
        btnClose.setPrefSize(35, 35);
        btnClose.setStyle("-fx-background-image:url('/D2.jpg')");
        btnClose.setOnMouseEntered((MouseEvent e) -> {
            btnClose.setScaleX(1.1);
            btnClose.setScaleY(1.1);
        });
        btnClose.setOnMouseExited((MouseEvent e) -> {
            btnClose.setScaleX(1);
            btnClose.setScaleY(1);
        });
        
        HBox hBoxC = new HBox(30);
        hBoxC.setAlignment(Pos.CENTER);
        hBoxC.getChildren().addAll(playButton, hBoxB, btnClose);
        hBoxC.setPadding(new Insets(10, 0, 0, 0));
        
        btnClose.setOnAction((ActionEvent event) -> { 
            mediaPlayer.pause();
            primaryStage.close();
        });
        
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBoxA, hBoxC);
        
        mediaPane.setCenter(mediaView);
        mediaPane.setBottom(vBox);
     
        Scene mediaScene = new Scene(mediaPane, 1055, 1050);//设置舞台大小
        primaryStage.setTitle("MedioPlayer");
        primaryStage.setScene(mediaScene);
        //设置窗口大小
        primaryStage.setWidth(1055); 
        primaryStage.setHeight(1050);
        //primaryStage.setResizable(false); //将窗口大小固定
        primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
        primaryStage.show();
        
    }
    
    private String Seconds2Str(Double seconds){
        Integer count = seconds.intValue();
        Integer Hours = count / 3600;
        count = count % 3600;
        Integer Minutes = count /60;
        count = count % 60;
        String str = Hours.toString()+":"+Minutes.toString()+":"+count.toString();
        return str;
    }

    private double doubleValueOf(ReadOnlyDoubleProperty heightProperty) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}