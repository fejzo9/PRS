package appsInterface;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private JTextArea textArea = null;
	
	public TextPanel() {
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Consolas",Font.PLAIN,20));
		
		this.add(textArea);
		
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextToTextArea(String textArea) {
		this.textArea.setText(textArea);
	}
	
	
}
