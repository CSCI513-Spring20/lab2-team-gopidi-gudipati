

import java.awt.Point;

public class OceanMap {
	boolean[][] oceanMap = new boolean[10][10];
	int xCell =6;
	int yCell =6;
	
	public void initiate(int a, int b) {
		xCell =a;
		yCell =b;
	}

	
	
	public boolean[][] getMap(){
		
		return oceanMap;
	}
	public Point getShipLocation() {
		return new Point(xCell,yCell);
	}
}