package appsInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * @author fejzo_000
 *AppsFrame - Glavni Prozor aplikacije
 */

public class AppsFrame extends JFrame implements ActionListener {

	JTextArea textArea = new JTextArea(10,15);

	public AppsFrame() {
		
		ImageIcon image = new ImageIcon("sort2.png");
		this.setTitle("PRS - Sortiranje niza");
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		textArea.setForeground(Color.green);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		this.getContentPane().setBackground(new Color(0x123456));
		
		 JScrollPane scrollPane = new JScrollPane(textArea);
	     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.setLocationRelativeTo(null);
		
		this.getContentPane().add(scrollPane, BorderLayout.NORTH);
		this.getContentPane().add(new UnosPanel(this),BorderLayout.CENTER);
		this.getContentPane().add(new AlgoritmiPanel(), BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
//		this.setResizable(false);
		this.setMinimumSize(new Dimension(this.getWidth(),this.getHeight()));

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
