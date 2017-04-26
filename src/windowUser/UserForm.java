package windowUser;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import windowUser.UserFormLabels;
import windowUser.UserFormTextBoxs;

public class UserForm extends JFrame {
	private final Integer width = 400;
	private final Integer height = 400;
	private UserFormTextBoxs textBoxs;
	private UserFormLabels labels;
	private JPanel panel = new JPanel();
	private JButton ButtonSaveUser;		

	public UserForm() {
		configPanel();
		configWindow();
	}
	
	private void configWindow() {
		  setTitle("Dodaj uzytkownika");
		  setSize(width, height);
		  setResizable(false);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  setLocationRelativeTo(null);
		  setContentPane(panel);
	}
	
	private void configPanel() {
		  createButtonSaveUser();
	      panel.setBackground(Color.WHITE);
	      panel.setLayout(null); 
	      labels = new UserFormLabels();
	      textBoxs = new UserFormTextBoxs();
	      labels.getLabels().forEach(l -> panel.add(l));
	      textBoxs.getTextBoxs().forEach(t -> panel.add(t));
	      panel.add(ButtonSaveUser);
	}
	
	private void createButtonSaveUser() {
		 ButtonSaveUser = new JButton("Zapisz");
		 ButtonSaveUser.setBounds(130, 310, 120, 50);
		 ButtonSaveUser.setBackground(Color.green);
	}

	public UserFormTextBoxs getTextBoxs() {
		return textBoxs;
	}

	public void setTextBoxs(UserFormTextBoxs textBoxs) {
		this.textBoxs = textBoxs;
	}

	public UserFormLabels getLabels() {
		return labels;
	}

	public void setLabels(UserFormLabels labels) {
		this.labels = labels;
	}
	
	public JButton getButtonSaveUser() {
		return ButtonSaveUser;
	}

	public void setButtonSaveUser(JButton buttonSaveUser) {
		ButtonSaveUser = buttonSaveUser;
	}
	
	public void closeFrame(){
	    super.dispose();
	}

}
