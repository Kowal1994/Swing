package windowMain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import data.User;
import data.UserValidator;
import windowUser.UserForm;

public class UserNewButton extends JButton implements ActionListener{
	
	public UserNewButton() {
		super("Dodaj");
		setBounds(100, 300, 150, 50);
		setBackground(Color.green);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		UserForm userForm = new UserForm();
		userForm.getButtonSaveUser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserValidator.isFieldEmpty = false;
				UserValidator.isFieldValidationProblem = false;
				DefaultTableModel model = (DefaultTableModel) Table.getInstance().getModel();
				User user = new User();
				user.validationTextBox(userForm);
				if(!UserValidator.isFieldEmpty && !UserValidator.isFieldValidationProblem) {
						model.addRow(new Object[]{user.getImie(),user.getNazwisko(),user.getWiek(),user.getZawod(),user.getPlaca()});
						userForm.closeFrame();
				} 
				
			}
		});
		
		userForm.getTextBoxs().clearTextBoxs();
		userForm.setVisible(true);
	}	
}
