/**
 * Hauptdatei für die Aufgabe "Minimierung nichtlinearer Funktionen" 
 * aus dem Fach Problemlösen WS 11/12 mit Main-Methode
 * @see http://www2.hs-fulda.de/~grams/ 
 * 
 * @author 
 * 
 *
 */
package problemloesen;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Projekt01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* create main window */
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Aufgabenauswahl");
		JFrame frame = new JFrame();
		JMenuItem approxMenuItem = new JMenuItem("Gleichmäßige Approximation"); 
		JMenuItem pearlMenuItem = new JMenuItem("Perlenkette"); 
		JPanel mainPanel = new JPanel();
		
		menu.add(pearlMenuItem);
		menu.add(approxMenuItem);
		bar.add(menu);
		frame.setJMenuBar(bar);
		mainPanel.setBounds(0, 0, 640, 480);
		//mainPanel.setName("Problemloesen WS 11/12 - Projekt 1: Minimierung nichtlinearer Funktionen");
		frame.add(mainPanel);
		frame.setTitle("Problemloesen WS 11/12 - Projekt 1: Minimierung nichtlinearer Funktionen");
		frame.setVisible(true);
		frame.setSize(640, 480);
		mainPanel.setVisible(true);
	
	}

}
