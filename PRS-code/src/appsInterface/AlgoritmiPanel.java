package appsInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AlgoritmiPanel extends JPanel {

	public AlgoritmiPanel() {
		//Kreiranje panela koji ce biti lijevo
		JPanel algoritmiPanel = new JPanel();
		algoritmiPanel.setBorder(BorderFactory.createTitledBorder("Algoritam"));
		algoritmiPanel.setLayout(new BoxLayout(algoritmiPanel, BoxLayout.Y_AXIS));

		//RadioButtoni za sortiranje
		JRadioButton bubbleSort = new JRadioButton("Bubble Sort");
		JRadioButton insertionSort = new JRadioButton("Insertion Sort");
		JRadioButton selectionSort = new JRadioButton("Selection Sort");
		JRadioButton mergeSort = new JRadioButton("Merge Sort");
		JRadioButton quickSort = new JRadioButton("Quick Sort");
		
		//Dodavanje radioButtona za sortiranje u grupu
		ButtonGroup grupaSort = new ButtonGroup();
		grupaSort.add(bubbleSort);
		grupaSort.add(insertionSort);
		grupaSort.add(selectionSort);
		grupaSort.add(mergeSort);
		grupaSort.add(quickSort);
		
		//Dodavanje radioButtona u Panel
		algoritmiPanel.add(bubbleSort);
		algoritmiPanel.add(insertionSort);
		algoritmiPanel.add(selectionSort);
		algoritmiPanel.add(mergeSort);
		algoritmiPanel.add(quickSort);
		
		//Kreiranje Panela koji ce biti desno
		JPanel paralelniPanel = new JPanel();
		paralelniPanel.setBorder(BorderFactory.createTitledBorder("Izvrsavanje"));
		paralelniPanel.setLayout(new BoxLayout(paralelniPanel, BoxLayout.Y_AXIS));
		
		//RadioButtoni za paralelizaciju
		JRadioButton sekvencijalno = new JRadioButton("Sekvencijalno");
		JRadioButton paralelno = new JRadioButton("Paralelno");
		
		//Dodavanje radioButtona za paralelizaciju u grupu
		ButtonGroup grupaParalel = new ButtonGroup();
		grupaParalel.add(sekvencijalno);
		grupaParalel.add(paralelno);
		
		//Dodavanje radioButtona u Panel
		paralelniPanel.add(sekvencijalno);
		paralelniPanel.add(paralelno);
		
		JButton sortiraj = new JButton("Sortiraj");
		
		
		this.setLayout(new BorderLayout());
		this.add(algoritmiPanel, BorderLayout.WEST);
		this.add(paralelniPanel, BorderLayout.EAST);
		this.add(sortiraj, BorderLayout.SOUTH);
		
	}
}
