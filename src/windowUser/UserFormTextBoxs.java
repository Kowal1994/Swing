package windowUser;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import data.User;

public class UserFormTextBoxs {
	private List<Component> textBoxs; 
	private JTextField imie = new JTextField();
	private JTextField nazwisko = new JTextField();
	private JTextField wiek = new JTextField();
	private JTextField zawod = new JTextField();
	private JTextField placa = new JTextField();
	
	public UserFormTextBoxs() {
		imie.setBounds(130, 65, 120, 20);
		nazwisko.setBounds(130, 115, 120, 20);
		wiek.setBounds(130, 165, 120, 20);
		zawod.setBounds(130, 215, 120, 20);
		placa.setBounds(130, 265, 120, 20);
		loadComponents();
	}
	
	public void loadComponents() {
		textBoxs = new ArrayList<Component>();
		imie.setText("abc");
		textBoxs.add(imie);
		textBoxs.add(nazwisko);
		textBoxs.add(wiek);
		textBoxs.add(zawod);
		textBoxs.add(placa);
	}

	public List<Component> getTextBoxs() {
		return textBoxs;
	}

	public void setTextBoxs(List<Component> textBoxs) {
		this.textBoxs = textBoxs;
	}

	public JTextField getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie.setText(imie);
	}

	public JTextField getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko.setText(nazwisko);
	}
	
	public JTextField getWiek() {
		return wiek;
	}

	public void setWiek(String wiek) {
		this.wiek.setText(wiek);
	}

	public JTextField getZawod() {
		return zawod;
	}

	public void setZawod(String zawod) {
		this.zawod.setText(zawod);
	}

	public JTextField getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa.setText(placa);
	}
	
	public void clearTextBoxs() {
		imie.setText("");
		nazwisko.setText("");
		wiek.setText("");
		zawod.setText("");
		placa.setText("");
	}

	public void changeTextBoxValue(User user) {
		imie.setText(user.getImie());
		nazwisko.setText(user.getNazwisko());
		wiek.setText(String.valueOf(user.getWiek()));
		zawod.setText(user.getZawod());
		placa.setText(String.valueOf(user.getPlaca()));
	}
}
