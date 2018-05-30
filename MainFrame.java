import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame 
{
	private static CardLayout cl;
	private static JPanel overall, oceanPanel, targetPanel, optionPanel;
	
	public MainFrame()
	{
		setTitle("Battleship");
		cl = new CardLayout();
		overall = new JPanel();
		overall.setLayout(cl);
		JMenuBar mBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem home = new JMenuItem("Home");
		JMenuItem ocean = new JMenuItem("Ocean Grid");
		JMenuItem target = new JMenuItem("Target Grid");
		JMenuItem settings = new JMenuItem("Settings");
		menu.add(home);
		menu.add(ocean);
		menu.add(target);
		menu.add(settings);
		mBar.add(menu);
		JPanel menuPanel = new Menu();
		oceanPanel = new OceanPanel();
		targetPanel = new TargetPanel();
		optionPanel = new OptionPanel();
		setBounds(100, 100, 600, 650);
		overall.add(menuPanel, "menuPanel");
		overall.add(oceanPanel, "oceanPanel");
		overall.add(targetPanel, "targetPanel");
		overall.add(optionPanel, "optionPanel");
		add(overall);
		cl.show(overall, "menuPanel");
		setJMenuBar(mBar);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "menuPanel");
			}
		});
		ocean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "oceanPanel");
			}
		});
		target.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "targetPanel");
			}
		});
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "optionPanel");
			}
		});
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void changePanel(JPanel a)
	{
		overall.add(a, "panel");
		cl.show(overall, "panel");
	}
	
	public static void oceanPanel()
	{
		cl.show(overall, "oceanPanel");
	}
	
	public static void newOceanPanel(GameGrid g)
	{
		oceanPanel = new OceanPanel(g);
		overall.add(oceanPanel, "oceanPanel");
		cl.show(overall, "oceanPanel");
	}
	
	public static void oceanPanelFire()
	{
		cl.show(overall, "oceanPanel");
		OceanPanel p = (OceanPanel) oceanPanel;
		p.fire();
	}
	
	public static void targetPanel()
	{
		cl.show(overall, "targetPanel");
	}
	
	public static void menuPanel()
	{
		cl.show(overall, "menuPanel");
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
	}
	
}
