
	
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
	Ship ship = new Ship(oceanMap);
	public void start(Stage oceanStage) throws Exception {
		
		drawMap();
		loadShipImage();
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus Game");
		oceanStage.show();
		//startSailing();
		
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
		shipImageView.setX(oceanMap.getShipLocation().x*scale);
		shipImageView.setY(oceanMap.getShipLocation().y*scale);
		
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
					ship.goEast();
					break;
				case LEFT :
					ship.goWest();
					break;
				case UP :
					ship.goNorth();
					break;
				case DOWN :
					ship.goSouth();
					break;
				default :
					break;	
				}
				shipImageView.set(ship.getShipLocation().x*scale);
				shipImageView.set(ship.getShipLocation().y*scale);
			}
		});
	}
 
	
	public static void main(String[] args) {
		launch(args);
	}

}