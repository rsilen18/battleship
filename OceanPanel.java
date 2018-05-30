import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OceanPanel extends JPanel
{
	private GameGrid grid;
	private Computer cpu;
	private boolean lastShot;
	private Timer timer;
	private JPanel thisPanel = this;

	public OceanPanel()
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblTitle = new JLabel("Ocean");
		add(lblTitle, gbc);
		gbc.gridy++;
		JLabel lblBlank = new JLabel(" ");
		add(lblBlank, gbc);
		gbc.gridy++;
		JLabel lblBlank1 = new JLabel(" ");
		add(lblBlank1, gbc);
		gbc.gridx++;
		JLabel lblCols = new JLabel("  1          2          3          4          5          6          7          8          9          10  ");
		add(lblCols, gbc);
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblRows = new JLabel("<html><h6>A<br/><br/><br/>B<br/><br/><br/>C<br/><br/><br/>D<br/><br/><br/>E<br/><br/><br/>F<br/><br/><br/>G<br/><br/><br/>H<br/><br/><br/>I<br/><br/><br/>J</h6></html>");
		add(lblRows, gbc);
		gbc.gridx++;
		grid = new GameGrid();
		add(grid, gbc);
		cpu = new Computer();
		lastShot = false;
		timer = new Timer();
	}
	
	public OceanPanel(GameGrid g)
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblTitle = new JLabel("Ocean");
		add(lblTitle, gbc);
		gbc.gridy++;
		JLabel lblBlank = new JLabel(" ");
		add(lblBlank, gbc);
		gbc.gridy++;
		JLabel lblBlank1 = new JLabel(" ");
		add(lblBlank1, gbc);
		gbc.gridx++;
		JLabel lblCols = new JLabel("  1          2          3          4          5          6          7          8          9          10  ");
		add(lblCols, gbc);
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblRows = new JLabel("<html><h6>A<br/><br/><br/>B<br/><br/><br/>C<br/><br/><br/>D<br/><br/><br/>E<br/><br/><br/>F<br/><br/><br/>G<br/><br/><br/>H<br/><br/><br/>I<br/><br/><br/>J</h6></html>");
		add(lblRows, gbc);
		gbc.gridx++;
		grid = g;
		add(grid, gbc);
		cpu = new Computer();
		lastShot = false;
		timer = new Timer();
	}
	
	public void fire()
	{
		ShipLayout grid1 = (ShipLayout) grid;
		GameBlock block = cpu.fire(lastShot);
		timer.schedule(new TimerTask() {
			public void run() {
				grid.getBlock(block.getRow(), block.getCol()).setShot(true);
				grid.update();
			}
		}, 1*1000);
		if (grid1.isSunk("carrier") && grid1.isSunk("battleship") && grid1.isSunk("submarine") && grid1.isSunk("destroyer") && grid1.isSunk("patrol")) {
			JOptionPane.showMessageDialog(thisPanel, "You lost!");
			MainFrame.menuPanel();
		}
		else {
			lastShot = grid.getBlock(block.getRow(), block.getCol()).getShip();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					MainFrame.targetPanel();
				}
			}, 3*1000);
		}
	}
	
}
