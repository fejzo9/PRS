package appsInterface;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;


public class AppsFrame extends JFrame implements ActionListener {

	public AppsFrame() {
		
		ImageIcon image = new ImageIcon("sort2.png");
		this.setTitle("PRS - Sortiranje niza");
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(null);
//		this.setSize(new Dimension(1500,800));
		this.getContentPane().setBackground(new Color(0x123456));
		 
		this.setLocationRelativeTo(null);
		
		this.add(new TextPanel(), BorderLayout.NORTH);
		this.add(new UnosPanel(this),BorderLayout.CENTER);
		this.add(new AlgoritmiPanel(), BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
