package appsInterface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class PomocniFrame extends JFrame {

	protected JLabel velNizaLbl = null;
	protected JTextField velNizaTxt = null;
	protected JButton potvrtiBtn = null;
	
	public PomocniFrame() {
		ImageIcon image = new ImageIcon("sort2.png");
		this.setTitle("PRS - Unos niza");
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		velNizaLbl = new JLabel("Unesite velicinu niza: ");
		velNizaLbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		velNizaTxt = new JTextField(10);
		potvrtiBtn = new JButton("Potvrdi");
		
		this.setLocationRelativeTo(null);
		
		this.add(velNizaLbl,BorderLayout.NORTH);
		this.add(velNizaTxt, BorderLayout.CENTER);
//		this.show();
//		this.pack();
		this.setVisible(true);
		
	}
}
