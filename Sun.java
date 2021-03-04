package cartoon;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;


public class Sun {
    private Ellipse _core;
    private Ellipse _glare;
    private Polygon _spike1;
    private Polygon _spike2;
    private Polygon _spike3;
    private Polygon _spike4;


    public Sun(){
      this.setSunNode();
      this.setSpikes();



    }

    public void setSunNode(){
        _core = new Ellipse(Constants.SUN_RADIUS, Constants.SUN_RADIUS);
        _core.setFill(Color.ORANGE);
        _core.setCenterX(Constants.SUN_START);
        _core.setCenterY(Constants.SUN_START);

        _glare = new Ellipse(Constants.GLARE_RADIUS,Constants.GLARE_RADIUS);
        _glare.setFill(Color.YELLOW);
        _glare.setCenterX(Constants.SUN_START + Constants.GLARE_OFFSET);
        _glare.setCenterY(Constants.SUN_START);

    }

    public void setSpikes(){
        _spike1 = new Polygon();
        _spike1.setFill(Color.ORANGE);
        _spike1.getPoints().setAll(
                150.0, 300.0,
                300.0, 250.0,
                300.0, 350.0);


        _spike2 = new Polygon();
        _spike2.setFill(Color.ORANGE);
        _spike2.getPoints().setAll(
                450.0, 300.0,
                300.0, 250.0,
                300.0, 350.0);


        _spike3 = new Polygon();
        _spike3.setFill(Color.ORANGE);
        _spike3.getPoints().setAll(
                250.0, 300.0,
                350.0, 300.0,
                300.0, 150.0);



    }

    public Node getSunNode(){
        return _core;
    }

    public void setLocX(double x){
        System.out.println("bro what the fuck");
        _core.setCenterX(x);
        // _spike.setCenterX(x-constants.OFFSET);


    }
    public double getLocX(){
        return _core.getCenterX();

    }



    public Node getSpike1(){
       return _spike1;
    }
    public Node getSpike2(){
        return _spike2;
    }
    public Node getSpike3(){
        return _spike3;
    }

    public Node getGlare() {
        return _glare;
    }

}
