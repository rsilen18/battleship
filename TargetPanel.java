import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TargetPanel extends JPanel
{
	private JTextField txtRow, txtCol;
	private GameGrid grid;
	private JPanel thisPanel = this;

	public TargetPanel()
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblTitle = new JLabel("Target");
		add(lblTitle, gbc);
		gbc.gridy++;
		JLabel lblBlank1 = new JLabel(" ");
		add(lblBlank1, gbc);
		gbc.gridy++;
		JLabel lblBlank = new JLabel(" ");
		add(lblBlank, gbc);
		gbc.gridx++;
		JLabel lblCols = new JLabel("  1          2          3          4          5          6          7          8          9          10  ");
		add(lblCols, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblRows = new JLabel("<html><h6>A<br/><br/><br/>B<br/><br/><br/>C<br/><br/><br/>D<br/><br/><br/>E<br/><br/><br/>F<br/><br/><br/>G<br/><br/><br/>H<br/><br/><br/>I<br/><br/><br/>J</h6></html>");
		add(lblRows, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		grid = new ShipLayout((int) (Math.random() * 5 + 1));
		grid.hideAll(true);
		grid.update();
		add(grid, gbc);
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblBlank2 = new JLabel(" ");
		add(lblBlank2, gbc);
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblRow = new JLabel("Enter row: ");
		add(lblRow, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		txtRow = new JTextField();
		txtRow.setPreferredSize(new Dimension(40, 20));
		add(txtRow, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblCol = new JLabel("Enter column: ");
		add(lblCol, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		txtCol = new JTextField();
		txtCol.setPreferredSize(new Dimension(40, 20));
		add(txtCol, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JButton btnFire = new JButton("Fire");
		add(btnFire, gbc);
		Timer timer = new Timer();
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ShipLayout grid1 = (ShipLayout) (grid);
					String cheese = txtRow.getText().toLowerCase();
					int col = Integer.parseInt(txtCol.getText());
					GameBlock block = grid.getBlock(cheese, Integer.parseInt(txtCol.getText()));
					block.setShot(true);
					block.hide(false);
					if (grid1.isSunk(grid1.inShip(cheese, col)))
						JOptionPane.showMessageDialog(thisPanel, "You sunk my " + grid1.inShip(cheese, col) + "!");
					grid.update();
					if (grid1.isSunk("carrier") && grid1.isSunk("battleship") && grid1.isSunk("submarine") && grid1.isSunk("destroyer") && grid1.isSunk("patrol")) {
						JOptionPane.showMessageDialog(thisPanel, "You won!");
						MainFrame.menuPanel();
					}
					else {
						timer.schedule(new TimerTask() {
							@Override
							public void run() {
								MainFrame.oceanPanelFire();
							}
						}, 3*1000);
					}
				} catch (IllegalArgumentException a) {
					JOptionPane.showMessageDialog(thisPanel, "Invalid Input");
				}
				txtRow.setText("");
				txtCol.setText("");
			}
		});
	}
	
}
