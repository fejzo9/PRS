package appsInterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class UnosFrame extends PomocniFrame {
//	private static String pattern = "\\d";
	
	public UnosFrame(AppsFrame frame) {
		super();
		
		velNizaTxt.setText("");
		this.add(potvrtiBtn,BorderLayout.SOUTH);
		
		potvrtiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String text = velNizaTxt.getText();
//			    Pattern r = Pattern.compile(pattern);
//			    Matcher m = r.matcher(text);
//			    if (m.matches())
//			    {
				try {
					int broj =  Integer.parseInt(velNizaTxt.getText());
					if(velNizaTxt.getText()!= "" && broj>0) {
						System.out.println("Dobar unos!\nUnijeli ste broj " + broj);
						frame.show();
						
					}	else {
						JOptionPane.showInternalMessageDialog(null, "Pogresan unos!\n\nUnesite cijeli nenegativan broj", "Greska unosa", JOptionPane.ERROR_MESSAGE);
						velNizaTxt.setText("");
					
					}
				}
				catch (Exception e1) {
					System.out.println(e1.toString());
					JOptionPane.showInternalMessageDialog(null, "Pogresan unos!\n\nUnesite cijeli pozitivan broj", "Greska unosa", JOptionPane.ERROR_MESSAGE);
					velNizaTxt.setText("");
				}
						
			}
//		}
		});
		
		this.setLocationRelativeTo(null);

		this.pack();
		this.setVisible(true);
	}

}
