package cartoon;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class App extends Application {
    @Override
    public void start(Stage stage){
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(),1000,1200);
        stage.setScene(scene);
        stage.setTitle("Sunset!");
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}
