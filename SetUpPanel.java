import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SetUpPanel extends JPanel
{
	private JPanel thisPanel = this;
	private Vector<String> ships = new Vector<String>(5);
	private String[] vertList = {"Vertical", "Horizontal"};
	private GameGrid grid;
	
	public SetUpPanel()
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
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
		grid = new ShipLayout();
		add(grid, gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridy++;
		JButton instructions = new JButton("Instructions");
		add(instructions, gbc);
		instructions.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				 JOptionPane.showMessageDialog(thisPanel, "Instructions:" +
				 		"\n Enter the coordinates for the top left corner of the ship." +
						"\n Use the first scroll pane to indicate horizontal or vertical placement." +
				 		"\n Use the second scroll pane to select which ship to place." +
				 		"\n Once the ship is placed it cannot be moved.");
			}
		});
		gbc.gridx++;
		gbc.gridheight = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		JButton done = new JButton("Done");
		add(done, gbc);
		gbc.gridx -= 2;
		gbc.gridy += 2;
		gbc.gridheight = 1;
		JLabel lblRow = new JLabel("Row: ");
		add(lblRow, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		JTextField txtRow = new JTextField();
		txtRow.setPreferredSize(new Dimension(40, 20));
		add(txtRow, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblCol = new JLabel("Column: ");
		add(lblCol, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		JTextField txtCol = new JTextField();
		txtCol.setPreferredSize(new Dimension(40, 20));
		add(txtCol, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblOr = new JLabel("Orientation: ");
		add(lblOr, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		JList vert1 = new JList(vertList);
		JScrollPane list0 = new JScrollPane(vert1);
		list0.setPreferredSize(new Dimension(90, 20));
		add(list0, gbc);
		gbc.gridx--;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lblShip = new JLabel("Ship: ");
		add(lblShip, gbc);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.LINE_START;
		ships.add("Carrier");
		ships.add("Battleship");
		ships.add("Submarine");
		ships.add("Destroyer");
		ships.add("Patrol");
		JList ships1 = new JList(ships);
		JScrollPane list = new JScrollPane(ships1);
		list.setPreferredSize(new Dimension(90, 20));
		add(list, gbc);
		gbc.gridy++;
		JButton btnPlace = new JButton("Place");
		add(btnPlace, gbc);
		btnPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shipName = (String) ships1.getSelectedValue();
				ShipLayout shipGrid = (ShipLayout) grid;
				try {
					int col = Integer.parseInt(txtCol.getText());
					int row = grid.getBlock(txtRow.getText(), col).getRow();
					boolean vert = vert1.getSelectedValue().equals("Vertical");
					switch (shipName) {
						case "Carrier": {
							shipGrid.setCarrier(row, col, vert);
								ships.remove("Carrier");
							break;
						}
						case "Battleship": {
							shipGrid.setBattleship(row, col, vert);
								ships.remove("Battleship");
							break;
						}
						case "Submarine": {
							shipGrid.setSubmarine(row, col, vert);
								ships.remove("Submarine");
							break;
						}
						case "Destroyer": {
							shipGrid.setDestroyer(row, col, vert);
								ships.remove("Destroyer");
							break;
						}
						case "Patrol": {
							shipGrid.setPatrol(row, col, vert);
								ships.remove("Patrol");
							break;
						}
					}
				} catch (IllegalArgumentException a) {
					JOptionPane.showMessageDialog(thisPanel, "Invalid Input");
				} catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(thisPanel,  "Invalid Input");
				}
				grid = shipGrid;
				grid.update();
				txtRow.setText("");
				txtCol.setText("");
			}
		});
		Timer timer = new Timer();
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ships.size() == 0) {
					MainFrame.newOceanPanel(grid);
					timer.schedule(new TimerTask() {
						  @Override
						  public void run() {
							  MainFrame.targetPanel();
						  }
						}, 3*1000);
				}
				else
					JOptionPane.showMessageDialog(thisPanel, "Place all ships first");
			}
		});
	}
	
}
