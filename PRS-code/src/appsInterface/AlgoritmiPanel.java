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
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;
import parallel.ParallelBubbleSort;
import parallel.ParallelInsertionSort;
import parallel.ParallelMergeSort;
import parallel.ParallelQuickSort;
import parallel.ParallelSelectionSort;

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
				
				long pocetak, kraj, protekloVrijeme;
				
				// Provjeravamo koji su buttoni selektovani
				if (bubbleSort.isSelected() && sekvencijalno.isSelected()) {

					// Instanca sekvencijalnog bubbleSort-a
					BubbleSort bubbleSort = new BubbleSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");
					
					pocetak = System.nanoTime();
					// Sortiramo niz
					bubbleSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (bubbleSort.isSelected() && paralelno.isSelected()) {
					
					// Instanca paralelnog bubbleSort-a
					ParallelBubbleSort parallelBubbleSort = new ParallelBubbleSort();
					
					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);
					
					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");
					
					pocetak = System.nanoTime();
					// Sortiramo niz
					parallelBubbleSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (insertionSort.isSelected() && sekvencijalno.isSelected()) {
					// Instanca sekvencijalnog insertionSort-a
					InsertionSort insertionSort = new InsertionSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					insertionSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (insertionSort.isSelected() && paralelno.isSelected()) {
					
					// Instanca paralelnog insertionSort-a
					ParallelInsertionSort insertionSort = new ParallelInsertionSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					insertionSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (selectionSort.isSelected() && sekvencijalno.isSelected()) {
					// Instanca sekvencijalnog insertionSort-a
					SelectionSort selectionSort = new SelectionSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					selectionSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (selectionSort.isSelected() && paralelno.isSelected()) {
					// Instanca paralelnog selectionSort-a
					ParallelSelectionSort selectionSort = new ParallelSelectionSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					selectionSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
						
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (mergeSort.isSelected() && sekvencijalno.isSelected()) {
					// Instanca sekvencijalnog smergeSort-a
					MergeSort mergeSort = new MergeSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					mergeSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
				} else if (mergeSort.isSelected() && paralelno.isSelected()) {
					// Instanca paralelnog mergeSort-a
					ParallelMergeSort mergeSort = new ParallelMergeSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					mergeSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
				} else if (quickSort.isSelected() && sekvencijalno.isSelected()) {
					
					// Instanca sekvencijalnog quickSort-a
					QuickSort quickSort = new QuickSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					quickSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
				} else if (quickSort.isSelected() && paralelno.isSelected()) {
					
					// Instanca paralelnog mergeSort-a
					ParallelQuickSort quickSort = new ParallelQuickSort();

					// niz brojevi koji je tipa List<Numbers> castujemo u niz T[] tipa Comparable<>
					T[] brojeviArray = toT(brojevi);

					// upisujemo u textAreu
					frame.textArea.append("\nNiz nakon sortiranja: \n");

					pocetak = System.nanoTime();
					// Sortiramo niz
					quickSort.sort((T[]) brojeviArray, 0, brojevi.size() - 1);
					kraj = System.nanoTime();
					
					// prolazimo kroz niz i ispisujemo ga na ekran
					for (int i = 0; i < brojeviArray.length; i++) {
						String broj = brojeviArray[i].toString() + "\n";
						frame.textArea.append(broj);
					}
					
					protekloVrijeme = kraj-pocetak;
					
					frame.textArea.append("\nPotrebno vrijeme da se izvrsi ovaj algoritam je: " + protekloVrijeme/1000 + "mikroSec");
					
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

	// Metoda za prebacivanje ArrayLista u Comparable niz T[]
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

	// Metoda za prebacivanje iz Comparable u ArrayListu
	public ArrayList<T> toArrayList(T[] array) {
		ArrayList<T> list = new ArrayList<>();
		for (T element : array) {
			list.add(element);
		}
		return list;
	}

}
