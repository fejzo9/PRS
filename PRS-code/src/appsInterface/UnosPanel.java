package appsInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UnosPanel extends JPanel {
	public UnosPanel(AppsFrame frame) {
		JButton unosNiz = new JButton("Unesite niz");
		JButton randomNiz = new JButton("Random niz");
		
		
		unosNiz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//						frame.hide();
//						new UnosFrame(frame);	
						
			}
		});
		
		randomNiz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					frame.hide();
					new RandomFrame(frame);	
				} catch (Exception e2) {
					System.out.println(e2);
				}
	
			}
		});
		
		this.add(unosNiz);
		this.add(randomNiz);
		
	}

}
