
public class ShipLayout extends GameGrid
{
	private GameBlock[] carrier, battleship, submarine, destroyer, patrol;
	
	public ShipLayout(int layoutNum)
	{
		super();
		carrier = new GameBlock[5];
		battleship = new GameBlock[4];
		submarine = new GameBlock[3];
		destroyer = new GameBlock[3];
		patrol = new GameBlock[2];
		switch (layoutNum)
		{
			case 1: {
				for (int c = 2; c <= 6; c++) {
					super.getBlock("C", c).setShip(true);
					carrier[c-2] = super.getBlock("C", c);
				}
				for (int r = 7; r <= 10; r++) {
					super.getBlock(r, 9).setShip(true);
					battleship[r-7] = super.getBlock(r, 9);
				}
				for (int c = 7; c <= 9; c++) {
					super.getBlock("D", c).setShip(true);
					submarine[c-7] = super.getBlock("D", c);
				}
				for (int r = 5; r <= 7; r++) {
					super.getBlock(r, 5).setShip(true);
					destroyer[r-5] = super.getBlock(r, 5);
				}
				for (int c = 2; c <= 3; c++) {
					super.getBlock("I", c).setShip(true);
					patrol[c-2] = super.getBlock("I", c);
				}
				break;
			}
			case 2: {
				for (int c = 6; c <= 10; c++) {
					super.getBlock("J", c).setShip(true);
					carrier[c-6] = super.getBlock("J", c);
				}
				for (int c = 7; c <= 10; c++) {
					super.getBlock("I", c).setShip(true);
					battleship[c-7] = super.getBlock("I", c);
				}
				for (int c = 8; c <= 10; c++) {
					super.getBlock("H", c).setShip(true);
					submarine[c-8] = super.getBlock("H", c);
				}
				for (int c = 8; c <= 10; c++) {
					super.getBlock("G", c).setShip(true);
					destroyer[c-8] = super.getBlock("G", c);
				}
				for (int c = 9; c <= 10; c++) {
					super.getBlock("F", c).setShip(true);
					patrol[c-9] = super.getBlock("F", c);
				}
				break;
			}
			case 3: {
				for (int r = 2; r <= 6; r++) {
					super.getBlock(r, 9).setShip(true);
					carrier[r-2] = super.getBlock(r, 9);
				}
				for (int c = 1; c <= 4; c++) {
					super.getBlock("J", c).setShip(true);
					battleship[c-1] = super.getBlock("J", c);
				}
				for (int r = 4; r <= 6; r++) {
					super.getBlock(r, 2).setShip(true);
					submarine[r-4] = super.getBlock(r, 2);
				}
				for (int c = 5; c <= 7; c++) {
					super.getBlock("G", c).setShip(true);
					destroyer[c-5] = super.getBlock("G", c);
				}
				for (int c = 6; c <= 7; c++) {
					super.getBlock("A", c).setShip(true);
					patrol[c-6] = super.getBlock("A", c);
				}
				break;
			}
			case 4: {
				for (int c = 6; c <= 10; c++) {
					super.getBlock("D", c).setShip(true);
					carrier[c-6] = super.getBlock("D", c);
				}
				for (int r = 5; r <= 8; r++) {
					super.getBlock(r, 2).setShip(true);
					battleship[r-5] = super.getBlock(r, 2);
				}
				for (int c = 2; c <= 4; c++) {
					super.getBlock("A", c).setShip(true);
					submarine[c-2] = super.getBlock("A", c);
				}
				for (int r = 7; r <= 9; r++) {
					super.getBlock(r, 8).setShip(true);
					destroyer[r-7] = super.getBlock(r, 8);
				}
				for (int c = 2; c <= 3; c++) {
					super.getBlock("J", c).setShip(true);
					patrol[c-2] = super.getBlock("J", c);
				}
				break;
			}
			case 5: {
				for (int r = 5; r <= 9; r++) {
					super.getBlock(r, 3).setShip(true);
					carrier[r-5] = super.getBlock(r, 3);
				}
				for (int c = 6; c <= 9; c++) {
					super.getBlock("B", c).setShip(true);
					battleship[c-6] = super.getBlock("B", c);
				}
				for (int c = 3; c <= 5; c++) {
					super.getBlock("C", c).setShip(true);
					submarine[c-3] = super.getBlock("C", c);
				}
				for (int c = 6; c <= 8; c++) {
					super.getBlock("G", c).setShip(true);
					destroyer[c-6] = super.getBlock("G", c);
				}
				for (int c = 9; c <= 10; c++) {
					super.getBlock("I", c).setShip(true);
					patrol[c-9] = super.getBlock("I", c);
				}
				break;
			}
			default: {
				break;
			}		
		}
	}
	
	public ShipLayout()
	{
		carrier = new GameBlock[5];
		battleship = new GameBlock[4];
		submarine = new GameBlock[3];
		destroyer = new GameBlock[3];
		patrol = new GameBlock[2];
	}
	
	public void clearShip(String ship)
	{
		switch (ship.toLowerCase()) {
			case "carrier": {
				for (GameBlock b: carrier) {
					b.setShip(false);
				}
				carrier = new GameBlock[5];
				break;
			}
			case "battleship": {
				for (GameBlock b: battleship) {
					b.setShip(false);
				}
				battleship = new GameBlock[4];
				break;
			}
			case "submarine": {
				for (GameBlock b: submarine) {
					b.setShip(false);
				}
				submarine = new GameBlock[3];
				break;
			}
			case "destroyer": {
				for (GameBlock b: destroyer) {
					b.setShip(false);
				}
				destroyer = new GameBlock[3];
				break;
			}
			case "patrol": {
				for (GameBlock b: patrol) {
					b.setShip(false);
				}
				patrol = new GameBlock[2];
				break;
			}
		}
	}
	
	public void setCarrier(int row, int col, boolean vert)
	{
		if (vert) {
			for (int r = row; r < row + 5; r++) {
				if (isOverlap(getBlock(r, col), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
		else {
			for (int c = col; c < col + 5; c++) {
				if (isOverlap(getBlock(row, c), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
			if (vert)
			{
				if (row > 6)
					throw new IllegalArgumentException();
				for (int r = row; r < row + 5; r++) {
					super.getBlock(r, col).setShip(true);
					carrier[r-row] = super.getBlock(r, col);
				}
			}
			else
			{
				if (col > 6)
					throw new IllegalArgumentException();
				for (int c = col; c < col + 5; c++) {
					super.getBlock(row, c).setShip(true);
					carrier[c-col] = super.getBlock(row, c);
				}
			}
	}
	
	public void setBattleship(int row, int col, boolean vert)
	{
		if (vert) {
			for (int r = row; r < row + 4; r++) {
				if (isOverlap(getBlock(r, col), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
		else {
			for (int c = col; c < col + 4; c++) {
				if (isOverlap(getBlock(row, c), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
			if (vert)
			{
				if (row > 7)
					throw new IllegalArgumentException();
				for (int r = row; r < row + 4; r++) {
					super.getBlock(r, col).setShip(true);
					battleship[r-row] = super.getBlock(r, col);
				}
			}
			else
			{
				if (col > 7)
					throw new IllegalArgumentException();
				for (int c = col; c < col + 4; c++) {
					super.getBlock(row, c).setShip(true);
					battleship[c-col] = super.getBlock(row, c);
				}
			}
	}
	
	public void setSubmarine(int row, int col, boolean vert)
	{
		if (vert) {
			for (int r = row; r < row + 3; r++) {
				if (isOverlap(getBlock(r, col), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
		else {
			for (int c = col; c < col + 3; c++) {
				if (isOverlap(getBlock(row, c), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
			if (vert)
			{
				if (row > 8)
					throw new IllegalArgumentException();
				for (int r = row; r < row + 3; r++) {
					super.getBlock(r, col).setShip(true);
					submarine[r-row] = super.getBlock(r, col);
				}
			}
			else
			{
				if (col > 8)
					throw new IllegalArgumentException();
				for (int c = col; c < col + 3; c++) {
					super.getBlock(row, c).setShip(true);
					submarine[c-col] = super.getBlock(row, c);
				}
			}
	}
	
	public void setDestroyer(int row, int col, boolean vert)
	{
		if (vert) {
			for (int r = row; r < row + 3; r++) {
				if (isOverlap(getBlock(r, col), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
		else {
			for (int c = col; c < col + 3; c++) {
				if (isOverlap(getBlock(row, c), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
			if (vert)
			{
				if (row > 8)
					throw new IllegalArgumentException();
				for (int r = row; r < row + 3; r++) {
					super.getBlock(r, col).setShip(true);
					destroyer[r-row] = super.getBlock(r, col);
				}
			}
			else
			{
				if (col > 8)
					throw new IllegalArgumentException();
				for (int c = col; c < col + 3; c++) {
					super.getBlock(row, c).setShip(true);
					destroyer[c-col] = super.getBlock(row, c);
				}
			}
	}
	
	public void setPatrol(int row, int col, boolean vert)
	{
		if (vert) {
			for (int r = row; r < row + 2; r++) {
				if (isOverlap(getBlock(r, col), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
		else {
			for (int c = col; c < col + 2; c++) {
				if (isOverlap(getBlock(row, c), carrier, battleship, submarine, destroyer, patrol))
					throw new IllegalArgumentException();
			}
		}
			if (vert)
			{
				if (row > 9)
					throw new IllegalArgumentException();
				for (int r = row; r < row + 2; r++) {
					super.getBlock(r, col).setShip(true);
					patrol[r-row] = super.getBlock(r, col);
				}
			}
			else
			{
				if (col > 9)
					throw new IllegalArgumentException();
				for (int c = col; c < col + 2; c++) {
					super.getBlock(row, c).setShip(true);
					patrol[c-col] = super.getBlock(row, c);
				}
		
			}
	}
	
	public boolean isSunk(String ship)
	{
		boolean sunk = true;
		switch(ship) {
			case "carrier": {
				for (GameBlock b: carrier) {
					if (!b.getShot())
						sunk = false;
				}
				return sunk;
			}
			case "battleship": {
				for (GameBlock b: battleship) {
					if (!b.getShot())
						sunk = false;
				}
				return sunk;
			}
			case "submarine": {
				for (GameBlock b: submarine) {
					if (!b.getShot())
						sunk = false;
				}
				return sunk;
			}
			case "destroyer": {
				for (GameBlock b: destroyer) {
					if (!b.getShot())
						sunk = false;
				}
				return sunk;
			}
			case "patrol": {
				for (GameBlock b: patrol) {
					if (!b.getShot())
						sunk = false;
				}
				return sunk;
			}
			default: {
				return !sunk;
			}
		}
	}
	
	public static boolean isOverlap(GameBlock b, GameBlock[] carrier, GameBlock[] battleship, GameBlock[] submarine, GameBlock[] destroyer, GameBlock[] patrol)
	{
		boolean a = false;
		for (GameBlock b1: carrier) {
			if (b == null || b1 == null)
				a = a;
			else if (b.getRow() == b1.getRow() && b.getCol() == b1.getCol())
				a = true;
		}
		for (GameBlock b1: battleship) {
			if (b == null || b1 == null)
				a = a;
			else if (b.getRow() == b1.getRow() && b.getCol() == b1.getCol())
				a = true;
		}
		for (GameBlock b1: submarine) {
			if (b == null || b1 == null)
				a = a;
			else if (b.getRow() == b1.getRow() && b.getCol() == b1.getCol())
				a = true;
		}
		for (GameBlock b1: destroyer) {
			if (b == null || b1 == null)
				a = a;
			else if (b.getRow() == b1.getRow() && b.getCol() == b1.getCol())
				a = true;
		}
		for (GameBlock b1: patrol) {
			if (b == null || b1 == null)
				a = a;
			else if (b.getRow() == b1.getRow() && b.getCol() == b1.getCol())
				a = true;
		}
		return a;
	}
	
	public String inShip(String r, int c)
	{
		String ship = "none";
		for (GameBlock b: carrier) {
			if (b.getRowLetter().equals(r.toLowerCase()) && b.getCol() == c)
				ship = "carrier";
		}
		for (GameBlock b: battleship) {
			if (b.getRowLetter().equals(r.toLowerCase()) && b.getCol() == c)
				ship = "battleship";
		}
		for (GameBlock b: submarine) {
			if (b.getRowLetter().equals(r.toLowerCase()) && b.getCol() == c)
				ship = "submarine";
		}
		for (GameBlock b: destroyer) {
			if (b.getRowLetter().equals(r.toLowerCase()) && b.getCol() == c)
				ship = "destroyer";
		}
		for (GameBlock b: patrol) {
			if (b.getRowLetter().equals(r.toLowerCase()) && b.getCol() == c)
				ship = "patrol";
		}
		return ship;
	}
	
}
