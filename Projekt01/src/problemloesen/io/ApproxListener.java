package problemloesen.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ApproxListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO
		System.out.println("ApproxListner ausgelöst");
		
		IO.getInstance().setUpApprox();
		
		return;
	}

}