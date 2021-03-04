package cartoon;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static javafx.scene.paint.Color.rgb;

public class Cartoon {
    private Rectangle _water;
    private Rectangle  _background;
    private Sun _sun;
    private Mountain _mountain;
    private BorderPane _cartoonPane;
    private Label _label;


    public Cartoon(BorderPane cartoonPane) {
        _cartoonPane = cartoonPane;
        _label = new Label();

        this.setupWater();
        this.setupMountainPane();
        this.setUpButton();
        this.setupTimeline();

        _cartoonPane.setTop(_label);
    }


    public void setupWater() {
        // colors and locations of the water
        _water = new Rectangle(Constants.WATER_WIDTH, Constants.WATER_HEIGHT);
        _water.setFill(Color.BLUE);
        _water.setX(100.0);
        _water.setY(0.0);
    }

    public void setupMountainPane() {
        Pane mountainPane = new Pane();
        mountainPane.setPrefSize(Constants.MOUNTAINPANE_WIDTH,Constants.MOUNTAINPANE_HEIGHT);
        _background = new Rectangle(Constants.MOUNTAINPANE_WIDTH,Constants.MOUNTAINPANE_HEIGHT);
        _background.addEventHandler(KeyEvent.KEY_PRESSED, new ColorHandler());
        _background.setFocusTraversable(true);
        _background.setFill(Color.GREEN);


        _sun = new Sun();
        _mountain = new Mountain();

        mountainPane.getChildren().addAll(
                _background,
                _mountain.getMountain1(),
                _mountain.getMountain2(),
                _sun.getSunNode());

        _cartoonPane.setCenter(mountainPane);
    }

    public void setUpButton(){
        Button quitter = new Button("Quit");
        StackPane buttonPane = new StackPane();
        buttonPane.getChildren().addAll(_water, quitter);
        quitter.setOnAction(new ClickHandler());
        _cartoonPane.setBottom(buttonPane);

    }


    private class ClickHandler implements EventHandler<ActionEvent>{
        public ClickHandler(){
        }
        @Override
        public void handle(ActionEvent event){
            Platform.exit();
        }
    }


    private class ColorHandler implements EventHandler<KeyEvent>{
        public ColorHandler(){

        }
        @Override
        public void handle(KeyEvent event){
            KeyCode keyPressed = event.getCode();
            switch(keyPressed){
                case W: _background.setFill(rgb((int)(Math.random()*256), 0, ((int)(Math.random()*256))));
                break;

                case S:_background.setFill(rgb((int)(Math.random()*256), ((int)(Math.random()*256)), ((int)(Math.random()*256))));
                break;
            }

        }

    }
    public void setupTimeline(){
        KeyFrame sunset = new KeyFrame(Duration.seconds(0.5), new TimeHandler());
        Timeline timeline = new Timeline(sunset);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {
        private double _distance;
        public void handle (ActionEvent event){
            _distance = Constants.DISTANCE;
            _sun.setLocX(_sun.getLocX()+_distance);
            double d = _sun.getLocX();
            String location = Double.toString(d);
            _label.setText(location);

        }
    }

}