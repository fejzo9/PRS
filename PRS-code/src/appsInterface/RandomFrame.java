package appsInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class RandomFrame extends PomocniFrame {
	
	public RandomFrame(AppsFrame frame) {
		
		super();
	
		JRadioButton cjelobrojni = new JRadioButton("Cjelobroni niz");
		JRadioButton decimalni = new JRadioButton("Decimalni niz");
		
		ButtonGroup grupaNiz = new ButtonGroup();
		grupaNiz.add(cjelobrojni);
		grupaNiz.add(decimalni);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBorder(BorderFactory.createTitledBorder("Brojevi"));
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));
		
		panelSouth.add(cjelobrojni,BorderLayout.NORTH);
		panelSouth.add(decimalni,BorderLayout.NORTH);
		panelSouth.add(potvrtiBtn,BorderLayout.SOUTH);	
		this.add(panelSouth, BorderLayout.SOUTH);
		
		potvrtiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				SortModel.randomCijeli(ABORT);
				frame.show();
				velNizaTxt.setText("");
				
			}
		});
	}

}
