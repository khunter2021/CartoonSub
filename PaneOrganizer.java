package cartoon;

import javafx.animation.KeyFrame;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class PaneOrganizer {
    private BorderPane _root;



	public PaneOrganizer() {
            //instantiate the BorderPane and call the private methods here
            _root = new BorderPane();
            BorderPane cartoonPane = new BorderPane();
            _root.setCenter(cartoonPane);
            new Cartoon(cartoonPane);

        }


    // make public getRoot() method that returns the BorderPane
    public BorderPane getRoot(){
	    return _root;
	}


    }






