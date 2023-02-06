package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;




public class Music implements Initializable{

    @FXML
    private Button back,next,play;

    @FXML
    private AnchorPane background;

    @FXML
    private Slider Volume;

    @FXML
    private ProgressBar Progress_Bar;

    @FXML
    private Label title;

    private static File directory ;
    private File [] files;
    private static ArrayList<File> songs ;

    private int songNumber;
    private Timer timer;
    private TimerTask task;
    private boolean running;

    protected static MediaPlayer media_Player;
    private Media media;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = new ArrayList<File>();

        directory = new File("src/assets/music");

        files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                songs.add(file);
            }
        }

        title.setText(songs.get(songNumber).getName());
        media = new Media(songs.get(songNumber).toURI().toString());
        media_Player = new MediaPlayer(media);

        

    }
    

    
    @FXML
    void PlayPause(MouseEvent event) {
        begintimer();
        media_Player.setVolume(Volume.getValue() * 0.01);
        Status status = media_Player.getStatus();
       
        if (status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
            
            media_Player.play();
        } else {
            media_Player.pause();
        }
    }
        
    
    

    @FXML
    void Next_Song(MouseEvent event) {
        if (songNumber < songs.size() - 1){
            songNumber ++;
            media_Player.stop();

            if(running){
                cancelTimer();
            }

            title.setText(songs.get(songNumber).getName());
            media = new Media(songs.get(songNumber).toURI().toString());
            media_Player = new MediaPlayer(media);
            PlayPause(event);
        }

        else{
            songNumber = 0;
            media_Player.stop();

            if (running) {
                cancelTimer();
            }

            title.setText(songs.get(songNumber).getName());
            media = new Media(songs.get(songNumber).toURI().toString());
            media_Player = new MediaPlayer(media);
            PlayPause(event);
        }
    }

    @FXML
    void Back_Song(MouseEvent event) {
        if (songNumber > 0) {
            songNumber--;
            media_Player.stop();
            if (running) {
                cancelTimer();
            }

            title.setText(songs.get(songNumber).getName());
            media = new Media(songs.get(songNumber).toURI().toString());
            media_Player = new MediaPlayer(media);
            PlayPause(event);
        }

        else {
            songNumber = songs.size() - 1;
            media_Player.stop();
            if (running) {
                cancelTimer();
            }

            title.setText(songs.get(songNumber).getName());
            media = new Media(songs.get(songNumber).toURI().toString());
            media_Player = new MediaPlayer(media);
            PlayPause(event);
        }
    }

    @FXML
    void Change_Volume(MouseEvent event) {
        Volume.valueProperty().addListener(new ChangeListener<Number>() {

        @Override
        public void changed(ObservableValue<? extends Number> arg0, Number arg1,
        Number arg2) {

        media_Player.setVolume(Volume.getValue() * 0.01);

        }

        });
    }

    public void begintimer(){
        timer = new Timer();
        task = new TimerTask() {
            public void run(){
                running = true;
                double current = media_Player.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                Progress_Bar.setProgress(current/end);

                if(current/end == 1){
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer(){
        running = false;
        timer.cancel();
    }


}
