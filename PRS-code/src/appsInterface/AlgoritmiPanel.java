package appsInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import algorithms.BubbleSort;

public class AlgoritmiPanel<T extends Comparable<T>> extends JPanel {
	
	List<Number> brojevi;
	
	public AlgoritmiPanel(AppsFrame frame) {
		
		// Kreiranje panela koji ce biti lijevo
		JPanel algoritmiPanel = new JPanel();
		algoritmiPanel.setBorder(BorderFactory.createTitledBorder("Algoritam"));
		algoritmiPanel.setLayout(new BoxLayout(algoritmiPanel, BoxLayout.Y_AXIS));

		// RadioButtoni za sortiranje
		JRadioButton bubbleSort = new JRadioButton("Bubble Sort");
		JRadioButton insertionSort = new JRadioButton("Insertion Sort");
		JRadioButton selectionSort = new JRadioButton("Selection Sort");
		JRadioButton mergeSort = new JRadioButton("Merge Sort");
		JRadioButton quickSort = new JRadioButton("Quick Sort");

		// Dodavanje radioButtona za sortiranje u grupu
		ButtonGroup grupaSort = new ButtonGroup();
		grupaSort.add(bubbleSort);
		grupaSort.add(insertionSort);
		grupaSort.add(selectionSort);
		grupaSort.add(mergeSort);
		grupaSort.add(quickSort);

		// Dodavanje radioButtona u Panel
		algoritmiPanel.add(bubbleSort);
		algoritmiPanel.add(insertionSort);
		algoritmiPanel.add(selectionSort);
		algoritmiPanel.add(mergeSort);
		algoritmiPanel.add(quickSort);

		// Kreiranje Panela koji ce biti desno
		JPanel paralelniPanel = new JPanel();
		paralelniPanel.setBorder(BorderFactory.createTitledBorder("Izvrsavanje"));
		paralelniPanel.setLayout(new BoxLayout(paralelniPanel, BoxLayout.Y_AXIS));

		// RadioButtoni za paralelizaciju
		JRadioButton sekvencijalno = new JRadioButton("Sekvencijalno");
		JRadioButton paralelno = new JRadioButton("Paralelno");

		// Dodavanje radioButtona za paralelizaciju u grupu
		ButtonGroup grupaParalel = new ButtonGroup();
		grupaParalel.add(sekvencijalno);
		grupaParalel.add(paralelno);

		// Dodavanje radioButtona u Panel
		paralelniPanel.add(sekvencijalno);
		paralelniPanel.add(paralelno);

		JButton sortiraj = new JButton("Sortiraj");

		sortiraj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// kupimo ono sta se nalazi u textArei
				String text = frame.textArea.getText();

				// Definisemo regularni izraz za prepoznavanje brojeva
				String regex = "\\-?\\d+\\.?\\d+";

				// Stvaramo pattern objekat sa definisanim regexom
				Pattern pattern = Pattern.compile(regex);

				// Stvaramo Matcher objekat pomocu ulaznog stringa i pattern objekta
				Matcher matcher = pattern.matcher(text);

				// Pravimo listu za smjestanje brojeva
				brojevi = new ArrayList<>();

				// Prolazimo kroz Matcher i dohvacamo brojeve
				while (matcher.find()) {
					String match = matcher.group();
					try {
						int integerBroj = Integer.parseInt(match);
						brojevi.add(integerBroj);
					} catch (NumberFormatException e1) {
						try {
							double decimalniBroj = Double.parseDouble(match);
				            brojevi.add(decimalniBroj);
						} catch (NumberFormatException ex) {
							// Broj nije valjan, nastavljamo
							System.out.println("Pogresan format! Nije broj upitanju!");
							continue;
						}
					}
				}
				
//				try {
//				numbers = toT(brojevi);}catch (Exception e1) {
//					System.out.println("Ne moze se castovati!"+"\n\n"+e1);
//				}

				if (bubbleSort.isSelected() && sekvencijalno.isSelected()) {
					
					BubbleSort bubbleSort = new BubbleSort();
					
					T[] brojeviArray = toT(brojevi);
					
					frame.textArea.append("\n\nNiz nakon sortiranja: \n");
					bubbleSort.sort((T[]) brojeviArray, 0, brojevi.size()-1);
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					System.out.println("Sekvencijalni BubbleSort");
				} else if (bubbleSort.isSelected() && paralelno.isSelected()) {

					System.out.println("Parelelni BubbleSort");
				} else if (insertionSort.isSelected() && sekvencijalno.isSelected()) {
					System.out.println("Sekvencijalni InsertionSort");
				} else if (insertionSort.isSelected() && paralelno.isSelected()) {
					System.out.println("Paralelni InsertionSort");
				} else if (selectionSort.isSelected() && sekvencijalno.isSelected()) {
					System.out.println("Sekvencijalni SelectionSort");
				} else if (selectionSort.isSelected() && paralelno.isSelected()) {
					System.out.println("Paralelni SelectionSort");
				} else if (mergeSort.isSelected() && sekvencijalno.isSelected()) {
					System.out.println("Sekvencijalni MergeSort");
				} else if (mergeSort.isSelected() && paralelno.isSelected()) {
					System.out.println("Paralelni MergeSort");
				} else if (quickSort.isSelected() && sekvencijalno.isSelected()) {
					System.out.println("Sekvencijalni QuickSort");
				} else if (quickSort.isSelected() && paralelno.isSelected()) {
					System.out.println("Paralelni QuickSort");
				} else if ((!bubbleSort.isSelected() && !insertionSort.isSelected() && !selectionSort.isSelected()
						&& !mergeSort.isSelected() && !quickSort.isSelected())
						&& (sekvencijalno.isSelected() || paralelno.isSelected())) {
					String poruka = "Zaboravljena selekcija!\n\nMolim vas da selektujete neki od algoritam buttona.";
					JOptionPane.showMessageDialog(null, poruka, "Greska", JOptionPane.WARNING_MESSAGE);
				} else if ((bubbleSort.isSelected() || insertionSort.isSelected() || selectionSort.isSelected()
						|| mergeSort.isSelected() || quickSort.isSelected())
						&& (!sekvencijalno.isSelected() && !paralelno.isSelected())) {
					String poruka = "Zaboravljena selekcija!\n\nMolim vas da selektujete neki od buttona za izvrsavanje.";
					JOptionPane.showMessageDialog(null, poruka, "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String poruka = "Zaboravljena selekcija!\n\nMolim vas da selektujete neki od buttona za algoritam kao i neki od buttona za izvrsavanje.";
					JOptionPane.showMessageDialog(null, poruka, "Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		this.setLayout(new BorderLayout());
		this.add(algoritmiPanel, BorderLayout.CENTER);
		this.add(paralelniPanel, BorderLayout.EAST);
		this.add(sortiraj, BorderLayout.SOUTH);

	}

	//Metoda za prebacivanje ArrayLista u Comparable niz T[] 
//	public T[] toT(List<Number> brojevi) {
//		 // Stvaranje novog generičkog niza pomoću refleksije
//        T[] array = (T[]) Array.newInstance(Object.class, brojevi.size());
//
//        // Kopiranje elemenata liste u niz
//        for (int i = 0; i < brojevi.size(); i++) {
//            array[i] = (T) brojevi.get(i);
//        }
//        return array;
//	}
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> T[] toT(List<Number> brojevi) {
	    // Stvaranje novog generičkog niza pomoću refleksije
	    T[] array = (T[]) new Comparable[brojevi.size()];

	    // Kopiranje elemenata liste u niz
	    for (int i = 0; i < brojevi.size(); i++) {
	        array[i] = (T) brojevi.get(i);
	    }

	    return array;
	}
	
	//Metoda za prebacivanje iz Comparable u ArrayListu
	public ArrayList<T> toArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }
	
}
