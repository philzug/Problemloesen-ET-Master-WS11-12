package problemloesen.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApproxListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO
		System.out.println("ApproxListner ausgelöst");
		System.out.println(e.getSource().getClass().getName());
	}

}