package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import windowUser.UserForm;
import windowUser.UserFormTextBoxs;


@XmlRootElement
public class User {
	private String imie;
	private String nazwisko;
	private Integer wiek;
	private String zawod;
	private Integer placa;
	
	public User() {

	}
	
	public User(Bulider bulider) {
		imie = bulider.imie;
		nazwisko = bulider.nazwisko;
		wiek = bulider.wiek;
		zawod = bulider.zawod;
		placa = bulider.placa;
	}
	
	@XmlElement
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@XmlElement
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	@XmlElement
	public Integer getWiek() {
		return wiek;
	}
	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}
	
	@XmlElement
	public String getZawod() {
		return zawod;
	}
	public void setZawod(String zawod) {
		this.zawod = zawod;
	}
	
	@XmlElement
	public Integer getPlaca() {
		return placa;
	}
	public void setPlaca(Integer placa) {
		this.placa = placa;
	}
	
	public void validationTextBox(UserForm userForm) {
		UserFormTextBoxs textbox = userForm.getTextBoxs();
		setImie(UserValidator.toString(textbox.getImie().getText(),"imie"));
		setNazwisko(UserValidator.toString(textbox.getNazwisko().getText(),"nazwisko"));
		setWiek(UserValidator.toInteger(textbox.getWiek().getText(),"wiek"));
		setZawod(UserValidator.toString(textbox.getZawod().getText(),"zawod"));
		setPlaca(UserValidator.toInteger(textbox.getPlaca().getText(),"placa"));

	}
	@Override
	public String toString() {
		return "DataUser [imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek + ", zawod=" + zawod + ", placa="
				+ placa + "]";
	}
	
	public static class Bulider{
		
		private String imie;
		private String nazwisko;
		private Integer wiek;
		private String zawod;
		private Integer placa;
		
		public Bulider imie(String imie) {
			this.imie = imie;
			return this;
		}
		
		public Bulider nazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
			return this;
		}
		
		public Bulider wiek(Integer wiek) {
			this.wiek = wiek;
			return this;
		}
		
		public Bulider zawod(String zawod) {
			this.zawod = zawod;
			return this;
		}
		
		public Bulider placa(Integer placa) {
			this.placa = placa;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		
	}
	
}