package appsInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.SortModel;

public class NizPanel extends JPanel {

	private JLabel velNizaLbl = null;
	private JTextField velNizaTxt = null;
	private JButton izvrsiBtn = null;
	
	public NizPanel() {
		setBorder(new TitledBorder("Vrijeme izvršenja niza:"));
		
		///
		
		//Izgled prozora, isti kao i osnovni prozor - AppsFrame
		ImageIcon image = new ImageIcon("sort2.png");
		this.setLayout(new BorderLayout());
		
		//Inicijalizujemo labelu, biramo zeljeni font i velicinu
		velNizaLbl = new JLabel("Unesite velicinu niza: ");
		velNizaLbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		velNizaTxt = new JTextField(10); //ogranicavamo textField da ima max 7 polja
		izvrsiBtn = new JButton("Vidi vrijeme izvršenja"); //Inicijalizujemo button
		
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
		panelSouth.add(izvrsiBtn,BorderLayout.EAST);
		this.add(panelSouth,BorderLayout.SOUTH); //dodajemo panel na frame
		
//		izvrsiBtn.addActionListener(e -> {
//			SortModel sortModel = new SortModel();
//			if(velNizaTxt.getText() > 0)
//			
//			sortModel.demonstrirajSortiranje(null, getIgnoreRepaint(), ABORT, getFocusTraversalKeysEnabled());
//		});
		
		///
		this.setVisible(true);
	}
}
