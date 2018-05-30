import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu extends JPanel 
{
	
	public Menu()
	{
		setSize(600, 650);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		URL image = null;
		try {
			image = getClass().getClassLoader().getResource("image/battleship logo.png");
		} catch (Exception e)
		{
			System.out.print("nope");
		}
		ImageIcon bi = new ImageIcon(image);
		JLabel hi = new JLabel(bi);
		add(hi, gbc);
//		BufferedImage logojpg = null;
//		try
//		{
//			logojpg = ImageIO.read(new File("battleship logo.png"));
//		}
//		catch (IOException e1)
//		{
//			e1.printStackTrace();
//		}
//		JLabel lblLogo = new JLabel(new ImageIcon(logojpg));
//		add(lblLogo, gbc);
		gbc.gridy++;
		JLabel lblBlank = new JLabel(" ");
		add(lblBlank, gbc);
		gbc.gridwidth = 1;
		gbc.gridy++;
		JButton newGame = new JButton("New Game");
		add(newGame, gbc);
		gbc.gridx++;
		JButton resGame = new JButton("Resume");
		add(resGame, gbc);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.changePanel(new SetUpPanel());
			}
		});
		resGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.oceanPanel();
			}
		});
	}
	
}
