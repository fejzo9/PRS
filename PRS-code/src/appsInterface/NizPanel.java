package appsInterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class NizPanel extends JPanel {

	public NizPanel() {
		setPreferredSize(new Dimension(100, 100));
		setBorder(new TitledBorder("Vrijeme izvršenja niza:"));
		
		this.setVisible(true);
	}
}
