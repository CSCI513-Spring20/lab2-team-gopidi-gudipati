

import java.awt.Point;

public class OceanMap {
	boolean[][] oceanMap = new boolean[10][10];
	
	
	
	public boolean[][] getMap(){
		
		return oceanMap;
	}
	public Point getShipLocation() {
		int xCell = 5;
		int yCell = 5;
		return new Point(xCell,yCell);
	}
}