package calculator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CalculatorComponent {
	private JComboBox<String> combBox;
	private JLabel lableText;
	private JLabel result;
	private JButton countButton;
	
	public CalculatorComponent() {
		  String[] var = {"Suma","Srednia","Max,Min"};
		  combBox  = new JComboBox<String>(var);
		  combBox.setBounds(120, 400, 100, 20);
		 
		  lableText = new JLabel("Wylicz płace:");
		  lableText.setBounds(30, 400, 100, 15);
		  
		  result = new JLabel();
		  result.setBounds(230, 400, 300, 20);
		  
		  countButton = new JButton();
		  countButton.setText("Licz");
		  countButton.setBounds(120,425, 100, 50);
		  countButton.setBackground(Color.RED);
		  countButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedComboBoxValue = combBox.getSelectedIndex();
				result.setText(Calculator.count(selectedComboBoxValue));
			}
		});
	}
	
	public List<Component> load() {
		List<Component> component = new ArrayList<Component>();
		component.add(combBox);
		component.add(lableText);
		component.add(result);
		component.add(countButton);
		return component;	
	}
}
