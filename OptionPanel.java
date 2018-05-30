import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OptionPanel extends JPanel 
{
	private String[] modes = {"Easy", "Hard"};
	
	public OptionPanel()
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblTitle = new JLabel("<html><h1>Settings</h1></html>");
		add(lblTitle, gbc);
		gbc.gridy++;
		JLabel lblDiff = new JLabel("CPU Difficulty: ");
		add(lblDiff, gbc);
		gbc.gridx++;
		JList listModes = new JList(modes);
		JScrollPane list = new JScrollPane(listModes);
		list.setPreferredSize(new Dimension(90, 20));
		add(list, gbc);
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblBlank = new JLabel(" ");
		add(lblBlank, gbc);
		gbc.gridy++;
		JButton btnDone = new JButton("Done");
		add(btnDone, gbc);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer.setMode(listModes.getSelectedValue().toString());
			}
		});
	}
	
}
