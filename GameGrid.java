import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.IllegalArgumentException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameGrid extends JPanel
{
	
	private GameBlock[][] grid;
	
	public GameGrid()
	{
		setBackground(Color.LIGHT_GRAY);
		setSize(300, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		grid = new GameBlock[10][10];
		for (int r = 0; r < 10; r++)
		{
			for (int c = 0; c < 10; c++)
			{
				grid[r][c] = new GameBlock(r + 1, c + 1);
				gbc.gridx = c;
				gbc.gridy = r;
				grid[r][c].update();
				add(grid[r][c], gbc);
			}
		}
	}
	
	public GameBlock getBlock(String r, int c)
	{
		int row = 0;
		switch (r.toLowerCase()) {
			case "a": {
				row = 1;
				break;
			}
			case "b": {
				row = 2;
				break;
			}
			case "c": {
				row = 3;
				break;
			}
			case "d": {
				row = 4;
				break;
			}
			case "e": {
				row = 5;
				break;
			}
			case "f": {
				row = 6;
				break;
			}
			case "g": {
				row = 7;
				break;
			}
			case "h": {
				row = 8;
				break;
			}
			case "i": {
				row = 9;
				break;
			}
			case "j": {
				row = 10;
				break;
			}
			default: {
				throw new IllegalArgumentException();
			}
		}
		if (c <= 0 || c > 10)
			throw new IllegalArgumentException();
		return grid[row-1][c-1];
	}
	
	public GameBlock getBlock(int r, int c)
	{
		return grid[r-1][c-1];
	}
	
	public void hideAll(boolean a)
	{
		if (a)
		{
			for (int r = 0; r < 10; r++)
			{
				for (int c = 0; c < 10; c++)
				{
					grid[r][c].hide(true);
				}
			}
		}
		else
		{
			for (int r = 0; r < 10; r++)
			{
				for (int c = 0; c < 10; c++)
				{
					grid[r][c].hide(false);
				}
			}
		}
	}
	
	public void update()
	{
		for (int r = 0; r < 10; r++)
		{
			for (int c = 0; c < 10; c++)
			{
				grid[r][c].update();
			}
		}
	}
	
}
