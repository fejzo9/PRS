package appsInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UnosPanel extends JPanel {
	public UnosPanel(AppsFrame frame) {
		JButton odaberiFile = new JButton("Odaberite file");
		JButton randomNiz = new JButton("Random niz");
		JButton upisUFile = new JButton("Upis u file");
		JButton obrisiEkran = new JButton ("Obrisi ekran");
		
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
		
		obrisiEkran.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.textArea.setText("");
			}
		});
		
		upisUFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setDialogTitle("Save File");
	                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));

	                int userSelection = fileChooser.showSaveDialog(frame);
	                if (userSelection == JFileChooser.APPROVE_OPTION) {
	                    File fileToSave = fileChooser.getSelectedFile();
	                    String filePath = fileToSave.getAbsolutePath();
	                    fileToSave = new File(filePath + ".txt");
	                    
	                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
	                        writer.write(frame.textArea.getText());
	                        JOptionPane.showMessageDialog(frame, "Fajl je uspjesno sacuvan!");
	                    } catch (IOException ex) {
	                        JOptionPane.showMessageDialog(frame, "Greska prilikom cuvanja fajla: " + ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            }			
		});
		
		this.add(odaberiFile);
		this.add(randomNiz);
		this.add(upisUFile);
		this.add(obrisiEkran);
		
	}

}
