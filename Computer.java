import java.util.ArrayList;

public class Computer
{
	private ArrayList<GameBlock> blocksLeft;
	private static String mode = "Easy";
	private GameBlock lastBlock;
	
	public Computer()
	{
		blocksLeft = new ArrayList<GameBlock>();
		lastBlock = new GameBlock(1, 1);
		int r = 2;
		int c = 1;
		for (int i = 1; i <= 100; i++)
		{
			blocksLeft.add(new GameBlock(r, c));
			if (r == 1 && c == 9) {
				r = 10;
				c = 2;
			}
			else if (r == 9 && c == 10) {
				r = 1;
				c = 1;
			}
			else if (c == 10) {
				c = r + 2;
				r = 10;
			}
			else if (r == 1) {
				r = c + 2;
				c = 1;
			}
			else {
				r--;
				c++;
			}
		}
//		for (GameBlock b: blocksLeft)
//		{
//			System.out.println(b.toString());
//		}
	}
	
	public static void setMode(String m)
	{
		mode = m;
	}
	
	public static GameBlock getBlock(int row, int col, ArrayList<GameBlock> blocksLeft)
	{
		GameBlock block = new GameBlock(0, 0);
		for (int i = 0; i < blocksLeft.size(); i++) {
			if (row == blocksLeft.get(i).getRow() && col == blocksLeft.get(i).getCol())
				block = blocksLeft.get(i);
		}
		return block;
	}
	
	public GameBlock fire(boolean hit)
	{
		GameBlock block = blocksLeft.get(0);
		switch (mode) {
			case "Easy": {
				if (!hit) {
					block = blocksLeft.get((int) (Math.random() * blocksLeft.size()));
				}
				else {
					if (getBlock(lastBlock.getRow() + 1, lastBlock.getCol(), blocksLeft).getRow() != 0)  //down
						block = getBlock(lastBlock.getRow() + 1, lastBlock.getCol(), blocksLeft);
					else if (getBlock(lastBlock.getRow(), lastBlock.getCol() + 1, blocksLeft).getRow() != 0)  //right
						block = getBlock(lastBlock.getRow(), lastBlock.getCol() + 1, blocksLeft);
					else if (getBlock(lastBlock.getRow() - 1, lastBlock.getCol(), blocksLeft).getRow() != 0)  //up
						block = getBlock(lastBlock.getRow() - 1, lastBlock.getCol(), blocksLeft);
					else if (getBlock(lastBlock.getRow(), lastBlock.getCol() - 1, blocksLeft).getRow() != 0)  // left
						block = getBlock(lastBlock.getRow(), lastBlock.getCol() - 1, blocksLeft);
				}
				break;
			}
			case "Hard": {
				if (hit) {
					if (getBlock(lastBlock.getRow() + 1, lastBlock.getCol(), blocksLeft).getRow() != 0)  //down
						block = getBlock(lastBlock.getRow() + 1, lastBlock.getCol(), blocksLeft);
					else if (getBlock(lastBlock.getRow(), lastBlock.getCol() + 1, blocksLeft).getRow() != 0)  //right
						block = getBlock(lastBlock.getRow(), lastBlock.getCol() + 1, blocksLeft);
					else if (getBlock(lastBlock.getRow() - 1, lastBlock.getCol(), blocksLeft).getRow() != 0)  //up
						block = getBlock(lastBlock.getRow() - 1, lastBlock.getCol(), blocksLeft);
					else if (getBlock(lastBlock.getRow(), lastBlock.getCol() - 1, blocksLeft).getRow() != 0)  // left
						block = getBlock(lastBlock.getRow(), lastBlock.getCol() - 1, blocksLeft);
				}
				break;
			}
		}
		lastBlock = block;
		blocksLeft.remove(block);
		return block;
	}
}
