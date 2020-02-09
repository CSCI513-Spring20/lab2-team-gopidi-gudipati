import java.awt.Point;

public class Ship {
int scale = 50;
int xCell=6;
int yCell=6;
	public Point goEast(int x,int y) {
		if(x<450) {
			xCell = x+50;
			 yCell = y;	
		}
		else {
			xCell=xCell;
			yCell=yCell;
		}
		 
		return new Point(xCell,yCell);
		
	}
	public Point goWest(int x,int y) {
		if(xCell>0) {
		 xCell = x-50;
		 yCell = y;
		}
		else {
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell);
		
	}
	public Point goNorth(int x,int y) {
		if(yCell>0) {
		xCell = x;
		 yCell = y-50;
		}
		else {
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell);
		
	}
	public Point goSouth(int x,int y) {
		if(yCell<450) { 
		xCell = x;
		 yCell = y+50;
		}
		else {
			xCell=xCell;
			yCell=yCell;
		}
		return new Point(xCell,yCell);
		
	}

	public Point getShipLocation() {
		
		return new Point(xCell,yCell);
	}

}
