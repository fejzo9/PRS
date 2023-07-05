package appsInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UnosPanel extends JPanel {
	public UnosPanel(AppsFrame frame) {
		JButton odaberiFile = new JButton("Odaberite file");
		JButton randomNiz = new JButton("Random niz");
		
		
		odaberiFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
						JFileChooser fileChooser = new JFileChooser();
		                FileNameExtensionFilter filter = new FileNameExtensionFilter("Tekstualne datoteke", "txt");
		                fileChooser.setFileFilter(filter);

		                int returnVal = fileChooser.showOpenDialog(frame);
		                if (returnVal == JFileChooser.APPROVE_OPTION) {
		                    File file = fileChooser.getSelectedFile();
		                    try {
		                        Scanner scanner = new Scanner(file);
		                        
		                        while (scanner.hasNext()) {
		                            String number = scanner.next();
		                            frame.textArea.append(number + "\n");
		                        }

		                        scanner.close();

		                 } catch (FileNotFoundException e2) {
		                        e2.printStackTrace();
		                    }
		                }
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
		
		this.add(odaberiFile);
		this.add(randomNiz);
		
	}

}
