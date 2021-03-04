package cartoon;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Mountain {

    Polygon _mountain1;
    Polygon _mountain2;

    public  Mountain(){
       this.makeMountain1();
       this.makeMountain2();
       this.getMountain1();
       this.getMountain2();

    }

    public Polygon getMountain2() {
        return _mountain2;
    }

    public Polygon getMountain1() {
        return _mountain1;
    }

    public void makeMountain2() {
       _mountain2 = new Polygon();
        _mountain2.getPoints().setAll(
                0.0, 700.0,
                600.0, 700.0,
                495.0, 500.0
        );
        _mountain2.setFill(Color.GREY);
    }

    public void makeMountain1() {
        _mountain1 = new Polygon();
        _mountain1.getPoints().setAll(
                // x then y
                500.0, 700.0,
                800.0, 500.0,
                1000.0, 700.0
        );
        _mountain1.setFill(Color.GREY);

    }




}
