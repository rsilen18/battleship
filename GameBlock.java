import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class GameBlock extends JLabel
{
	
	private boolean ship, shot, hide;
	private int row, col;
	
	public GameBlock(int r, int c)
	{
		row = r;
		col = c;
		ship = false;
		shot = false;
		hide = false;
	}
	
	public void setShot(boolean a)
	{
		shot = a;
	}
	
	public void setShip(boolean a)
	{
		ship = a;
	}
	
	public void hide(boolean a)
	{
		hide = a;
	}
	
	public boolean getShot()
	{
		return shot;
	}
	
	public boolean getShip()
	{
		return ship;
	}
	
	public String getRowLetter()
	{
		String r = "";
		switch (row) {
			case 1: {
				r = "a";
				break;
			}
			case 2: {
				r = "b";
				break;
			}
			case 3: {
				r = "c";
				break;
			}
			case 4: {
				r = "d";
				break;
			}
			case 5: {
				r = "e";
				break;
			}
			case 6: {
				r = "f";
				break;
			}
			case 7: {
				r = "g";
				break;
			}
			case 8: {
				r = "h";
				break;
			}
			case 9: {
				r = "i";
				break;
			}
			case 10: {
				r = "j";
				break;
			}
			default: {
				throw new IllegalArgumentException();
			}
		}
		return r;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public void update()
	{
		setFont(new Font("Serif", Font.BOLD, 23));
		if (ship && !shot && !hide) {
			setForeground(Color.DARK_GRAY);
			setText("  +  ");
		}
		else if ((!ship && !shot ) || hide) {
			setForeground(Color.BLUE);
			setText("  ~  ");
		}
		else if (!ship && shot) {
			setForeground(Color.WHITE);
			setText("  *  ");
		}
		else {
			setForeground(Color.RED);
			setText("  *  ");
		}
	}
	
	public String toString()
	{
		return "(" + row + "," + col + ")";
	}
	

}
