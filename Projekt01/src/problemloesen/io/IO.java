package problemloesen.io;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class IO extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -681382952553657278L;

	private static IO instace;

	private IO() {
		super();
		this.startUp();
	}

	public static IO getInstance() {
		if (instace == null) {
			instace = new IO();
		}
		return instace;
	}

	private void startUp() {

		/* set everything up */
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Aufgabenauswahl");
		JMenuItem approxMenuItem = new JMenuItem("Gleichm‰ﬂige Approximation");
		JMenuItem pearlMenuItem = new JMenuItem("Perlenkette");

		this.setSize(800, 480);
		this.setTitle("Problemloesen WS 11/12 - Projekt 1: Minimierung nichtlinearer Funktionen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(1, 2));

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

	/*
	 * 
	 */
	public void setUpApprox() {
		// this.removeAll(); /* clean all */

		JPanel inputPanel = new JPanel();
		JPanel graphPanel = new JPanel();

		/* declare fields */
		// JTextField gradInput = new JTextField(); /* Grad des
		// Taylor-Polynoms*/
		// gradInput.add(new Label("Grad des Taylor-Polynoms"));
		// JTextField schrittweiteInput = new JTextField(); /* */
		// schrittweiteInput.add(new Label("Schrittweite im Intervall"));
		// JTextField functionInput = new JTextField(); /* Zu approximierende
		// Funktion */
		// functionInput.add(new Label("Zu approximierende Funktion"));
		// JTextField intervalBeginInput = new JTextField("0"); /* Intervall */
		// intervalBeginInput.add(new Label("Intervall Beginn:"));
		// JTextField intervalEndInput = new
		// JTextField(Double.toString(Math.PI));
		// intervalEndInput.add(new Label("Intervall Ende:"));

		inputPanel.setSize(100, 100);
		graphPanel.setSize(200, 200);

		inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// /* add fields to pannel */
		// inputPanel.add(gradInput);
		// inputPanel.add(schrittweiteInput);
		// inputPanel.add(functionInput);
		// inputPanel.add(intervalBeginInput);
		// inputPanel.add(intervalEndInput);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		// Create a parallel group for the horizontal axis
		ParallelGroup hGroup = layout
				.createParallelGroup(GroupLayout.Alignment.LEADING);

		inputPanel.setVisible(true);
		graphPanel.setVisible(true);

		/* add to main Window */
		this.add(inputPanel, 0);
		this.add(graphPanel, 1);

		this.update(this.getGraphics());

		return;
	}

	// @Override
	// public void paint (Graphics g)
	// {
	// super.paint(g);
	// Graphics2D g2 = (Graphics2D)g;
	// Line2D line = new Line2D.Double(30,30,80,80);
	// g2.setStroke(new BasicStroke(4));
	// g2.draw(line);
	//
	// }
}
