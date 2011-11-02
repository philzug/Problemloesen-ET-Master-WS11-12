package problemloesen.io;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class IO extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -681382952553657278L;

	public IO()  {
		super();
		this.startUp();
	}

	private void startUp() {
		
		/* set everything up */
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Aufgabenauswahl");
		JMenuItem approxMenuItem = new JMenuItem("Gleichm‰ﬂige Approximation");
		JMenuItem pearlMenuItem = new JMenuItem("Perlenkette");
		
		this.setSize(800, 480);
		this.setTitle("Problemloesen WS 11/12 - Projekt 1: Minimierung nichtlinearer Funktionen");

		/* action listener */
		PearlListener pearlL = new PearlListener();
		ApproxListener approxL = new ApproxListener();
		pearlMenuItem.addActionListener((ActionListener) pearlL);
		approxMenuItem.addActionListener((ActionListener) approxL);

		/* add everything together */
		menu.add(pearlMenuItem);
		menu.add(approxMenuItem);
		bar.add(menu);
		this.setJMenuBar(bar);
		
		this.setVisible(true);

		/* fuer den 'Goldenen Schnitt' ^^ */
		/*
		 * int x_size = 800; int y_size = (int) (x_size * 1.618);
		 * frame.setSize(y_size, x_size);
		 */

		return;
	}
}
