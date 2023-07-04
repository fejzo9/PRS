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
	
	public RandomFrame(AppsFrame frame) {
		
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
		potvrtiBtn = new JButton("Potvrdi"); //Inicijalizujemo button

		//Dodajemo na frame labelu i textfield
		this.add(velNizaLbl,BorderLayout.NORTH);
		this.add(velNizaTxt, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null); //da bi se prozor prikazao na sredini ekrana, koristimo ovu komandu
	
		//Inicijalizujemo radioButtone
		JRadioButton cjelobrojni = new JRadioButton("Cjelobroni niz");
		JRadioButton decimalni = new JRadioButton("Decimalni niz");
		
		//Dodajemo radioButtone u grupu
		ButtonGroup grupaNiz = new ButtonGroup();
		grupaNiz.add(cjelobrojni);
		grupaNiz.add(decimalni);
		
		//Pravimo panel, u kojem ce se prikazivati radioButtoni jedan ispod drugog
		JPanel panelSouth = new JPanel();
		panelSouth.setBorder(BorderFactory.createTitledBorder("Brojevi"));
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));
		
		//Dodajemo radioButtone u Panel, kao i Button
		panelSouth.add(cjelobrojni,BorderLayout.NORTH);
		panelSouth.add(decimalni,BorderLayout.NORTH);
		panelSouth.add(potvrtiBtn,BorderLayout.SOUTH);
		
		//Panel dodajemo na Frame
		this.add(panelSouth, BorderLayout.SOUTH);
		
		//ActionListener za button
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
						}
					else if(broj>0 && decimalni.isSelected()) {
						Double[] niz = SortModel.randomDoublesi(broj);
						String text = SortModel.ispisStringDecimal(niz);
						frame.textArea.setText(text);
						frame.show();
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
