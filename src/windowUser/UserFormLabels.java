package windowUser;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class UserFormLabels {
	private List<Component> labels;
	private JLabel imie = new JLabel("Imie");
	private JLabel nazwisko = new JLabel("Nazwisko");
	private JLabel wiek = new JLabel("Wiek");
	private JLabel zawod = new JLabel("Zawod");
	private JLabel placa = new JLabel("Placa");
	
	public UserFormLabels() {
		imie.setBounds(50, 50, 100, 50);
		nazwisko.setBounds(50, 100, 100, 50);
		wiek.setBounds(50, 150, 100, 50);
		zawod.setBounds(50, 200, 100, 50);
		placa.setBounds(50, 250, 100, 50);
		loadLabels();
	}
	
	public void loadLabels() {
		labels = new ArrayList<Component>();
		labels.add(imie);
		labels.add(nazwisko);
		labels.add(wiek);
		labels.add(zawod);
		labels.add(placa);
	}

	public List<Component> getLabels() {
		return labels;
	}
	
}
