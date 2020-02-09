
	
import javafx.scene.input.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OceanExplorer extends Application {
	final int dimension = 10;
	final int scale = 50;
	ImageView shipImageView;
	OceanMap oceanMap = new OceanMap();
	boolean[][] oceanGrid = oceanMap.getMap();
	AnchorPane myPane = new AnchorPane();
	Scene scene = new Scene(myPane, scale*dimension, scale*dimension);
	Ship ship = new Ship();
	public void start(Stage oceanStage) throws Exception {
		
		drawMap();
		loadShipImage();
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus Game");
		oceanStage.show();
		startSailing();
		
	}
	public void drawMap() {
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				myPane.getChildren().add(rect);
			}
		}
	}
	public void loadShipImage() throws InvocationTargetException {
		try {
			
		Image shipImage = new Image("ship.png",50,50,true,true);
		
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(6*scale);
		shipImageView.setY(6*scale);
		
		myPane.getChildren().add(shipImageView);
		}
		catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		
		}
		
	}

 	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			
			
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
				case RIGHT :
					//System.out.println("right");
					ship.goEast(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);
					//System.out.println(oceanMap.getShipLocation().x*scale+" "+oceanMap.getShipLocation().y*scale);
					
					break;
				case LEFT :
					ship.goWest(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);
					//ship.goWest();
					break;
				case UP :
					ship.goNorth(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);
					break;
				case DOWN :
					ship.goSouth(oceanMap.getShipLocation().x*scale,oceanMap.getShipLocation().y*scale);
					break;
				default :
					break;	
				}
				shipImageView.setX(ship.getShipLocation().x);
				shipImageView.setY(ship.getShipLocation().y);
				
				oceanMap.initiate(ship.getShipLocation().x/50, ship.getShipLocation().y/50);
				
			}
		});
	}
 
	
	public static void main(String[] args) {
		launch(args);
	}

}