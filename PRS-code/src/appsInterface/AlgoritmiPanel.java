package appsInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

public class AlgoritmiPanel extends JPanel {

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

				//Pravimo listu za smjestanje brojeva
				 List<Number> numbers = new ArrayList<>();
				 
				 //Prolazimo kroz Matcher i dohvacamo brojeve
				 while (matcher.find()) {
			            String match = matcher.group();
			            try {
			                // Pokušavamo parsirati broj kao decimalni (double)
			                double decimalNumber = Double.parseDouble(match);
			                numbers.add(decimalNumber);
			            } catch (NumberFormatException e1) {
			                // Ako parsiranje kao decimalni nije uspjelo, pokušavamo partisati kao cjelobrojni (int)
			                try {
			                    int integerNumber = Integer.parseInt(match);
			                    numbers.add(integerNumber);
			                } catch (NumberFormatException ex) {
			                    // Broj nije valjan, nastavljamo
			                	continue;
			                }
			            }
			        }
				 
				if (bubbleSort.isSelected() && sekvencijalno.isSelected()) {
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
}
