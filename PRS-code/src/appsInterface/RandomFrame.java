package appsInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.SortModel;

/**
 * 
 * @author fejzo_000
 * 
 * Prozor RandomFrame, koji se otvori nakon sto na AppsFrame-u kliknemo na Button - Random Niz
 *
 */

public class RandomFrame extends JFrame {
	
	//Trebat ce nam Labela, TextField i na kraju Button
	private JLabel velNizaLbl = null;
	private JTextField velNizaTxt = null;
	private JButton potvrtiBtn = null;
	private JButton upisBtn = null;
	
	public RandomFrame(AppsFrame frame) {
		
		JFrame ovajFrame = this;
		
		//Izgled prozora, isti kao i osnovni prozor - AppsFrame
		ImageIcon image = new ImageIcon("sort2.png");
		this.setTitle("PRS - Unos niza");
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//Inicijalizujemo labelu, biramo zeljeni font i velicinu
		velNizaLbl = new JLabel("Unesite velicinu niza: ");
		velNizaLbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		velNizaTxt = new JTextField(10); //ogranicavamo textField da ima max 7 polja
		potvrtiBtn = new JButton("Prikazi na ekran"); //Inicijalizujemo button
		upisBtn = new JButton("Upisi u file"); //Inicijalizujemo button

		this.setLocationRelativeTo(null); //da bi se prozor prikazao na sredini ekrana, koristimo ovu komandu
		
		//Panel za labelu i textfield
		JPanel panelNorth = new JPanel();
		panelNorth.add(velNizaLbl,BorderLayout.NORTH);
		panelNorth.add(velNizaTxt, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH); //dodali panel na frame
		
	
		//Inicijalizujemo radioButtone
		JRadioButton cjelobrojni = new JRadioButton("Cjelobroni niz");
		JRadioButton decimalni = new JRadioButton("Decimalni niz");
		
		//Dodajemo radioButtone u grupu
		ButtonGroup grupaNiz = new ButtonGroup();
		grupaNiz.add(cjelobrojni);
		grupaNiz.add(decimalni);
		
		//Pravimo panel, u kojem ce se prikazivati radioButtoni jedan ispod drugog
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createTitledBorder("Brojevi"));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		
		//Dodajemo radioButtone u Panel
		panelCenter.add(cjelobrojni,BorderLayout.NORTH);
		panelCenter.add(decimalni,BorderLayout.NORTH);		
		this.add(panelCenter, BorderLayout.CENTER);//Panel dodajemo na Frame
		
		//Pravimo panel u kojem ce biti buttoni
		JPanel panelSouth = new JPanel();
		panelSouth.add(potvrtiBtn,BorderLayout.EAST);
		panelSouth.add(upisBtn,BorderLayout.WEST);
		this.add(panelSouth,BorderLayout.SOUTH); //dodajemo panel na frame
		
		//ActionListener za button Prikaz na ekran
		potvrtiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {	
					int broj = Integer.parseInt(getVelNizaTxt());
					
					if(broj>0 && cjelobrojni.isSelected()) {
						Integer[] niz = SortModel.randomCijeli(broj);
						String text = SortModel.ispisStringInteger(niz);
						frame.textArea.setText(text);
						frame.show();
						ovajFrame.dispose();
						}
					else if(broj>0 && decimalni.isSelected()) {
						Double[] niz = SortModel.randomDoublesi(broj);
						String text = SortModel.ispisStringDecimal(niz);
						frame.textArea.setText(text);
						frame.show();
						ovajFrame.dispose();
					}
					else if(broj>0 && !(cjelobrojni.isSelected() || decimalni.isSelected())) {
							selekcija();
						}
					else {
							greska();
						}
					}catch(NumberFormatException e1) {
					    greska();
					}	
				
			} 
		});
		
		//ActionListener za button Upisi u file
		//ovo izgleda ruzno, treba ga srediti
		upisBtn.addActionListener(new ActionListener() {
			int brojac = 0; //brojac koji ce se povecavati svaki put kada se klikne na button
			@Override
			public void actionPerformed(ActionEvent e) {
				brojac++;
				String fileName = "file" + brojac + ".txt";
				int broj = Integer.parseInt(getVelNizaTxt());
				FileWriter writer = null;
				
				if(broj>0 && cjelobrojni.isSelected()) {
					Integer[] niz = SortModel.randomCijeli(broj);
					String text = SortModel.ispisStringInteger(niz);
					try{
						writer = new FileWriter(fileName);
			            writer.write(text);
			            System.out.println("Tekst je uspješno upisan u datoteku.");
			            frame.show();
			            ovajFrame.dispose();
					} catch (IOException e1) {
			            System.out.println("Došlo je do greške prilikom upisa u datoteku: " + e1.getMessage());
			        }finally {
			            if (writer != null) {
			                try {
			                    writer.close(); // Zatvaranje Writer-a
			                } catch (IOException e1) {
			                    System.out.println("Došlo je do greške prilikom zatvaranja Writer-a: " + e1.getMessage());
			                }
			            }
				}} else if(broj>0 && decimalni.isSelected()) {
					Double[] niz = SortModel.randomDoublesi(broj);
					String text = SortModel.ispisStringDecimal(niz);
					try{
						writer = new FileWriter(fileName);
			            writer.write(text);
			            System.out.println("Tekst je uspješno upisan u datoteku.");
			            frame.show();
			            ovajFrame.dispose();
					} catch (IOException e1) {
			            System.out.println("Došlo je do greške prilikom upisa u datoteku: " + e1.getMessage());
			        }finally {
			            if (writer != null) {
			                try {
			                    writer.close(); // Zatvaranje Writer-a
			                } catch (IOException e1) {
			                    System.out.println("Došlo je do greške prilikom zatvaranja Writer-a: " + e1.getMessage());
			                }
			            }}
				}else if(broj>0 && !(cjelobrojni.isSelected() || decimalni.isSelected())) {
					selekcija();
				}
				else {
					greska();
				}	
		}});
		
		//vezano za frame
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	public String getVelNizaTxt() {
		return velNizaTxt.getText();
	}
	
	/**
	 * metode greska() i selekcija() koje nam daju poruke kada se desi 
	 * nepravilan unos u textField
	 */
	public void greska() {
		String poruka = "Pogresan unos!\n\nMolim vas unesite pozitivan cijeli broj.";
		JOptionPane.showMessageDialog(null, poruka, "Upozorenje", JOptionPane.WARNING_MESSAGE);
		velNizaTxt.setText("");
	}
	public void selekcija() {
		String poruka = "Niste selektovali nijedan radio button!\n\nMolim vas selektujte.";
		JOptionPane.showMessageDialog(null, poruka, "Upozorenje", JOptionPane.WARNING_MESSAGE);
	}
	public void prekoracenje() {
		String poruka = "PREKORACENJE!\n\nMolim vas unesite manju velicinu niza, do maksimalno 999.";
		JOptionPane.showMessageDialog(null, poruka, "Prekoracenje", JOptionPane.WARNING_MESSAGE);
	}

}
