package windowMain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import data.User;
import data.UserValidator;
import main.MessageBox;
import windowUser.UserForm;


public class UserEditButton extends JButton implements ActionListener{
	public UserEditButton() {
		super("Edytuj");
		setBounds(275,300, 150, 50);
		setBackground(Color.blue);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Table table = Table.getInstance();
		Integer isNumberSelectedRow = table.getSelectedRow();
		if(isNumberSelectedRow == -1) {
			MessageBox.show("Wybierz rekord który chceesz edytowaæ");
		} else if(isNumberSelectedRow > -1)  {
			UserForm userForm = new UserForm();
			userForm.getTextBoxs().changeTextBoxValue(new User.Bulider().imie(table.getValueAt(isNumberSelectedRow, 0).toString())
					.nazwisko(table.getValueAt(isNumberSelectedRow, 1).toString()).wiek(Integer.valueOf(table.getValueAt(isNumberSelectedRow, 2).toString()))
					.zawod(table.getValueAt(isNumberSelectedRow, 3).toString()).placa(Integer.valueOf(table.getValueAt(isNumberSelectedRow, 4)
					.toString())).build());
			userForm.getButtonSaveUser().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					UserValidator.isFieldEmpty = false;
					UserValidator.isFieldValidationProblem = false;
					DefaultTableModel model = (DefaultTableModel) Table.getInstance().getModel();
					User user = new User();
					user.validationTextBox(userForm);	
					if(!UserValidator.isFieldEmpty && !UserValidator.isFieldValidationProblem) {
						Table.getInstance().changeValueRow(isNumberSelectedRow,user);
						userForm.closeFrame();
					}	
				}
			});
			
			userForm.setVisible(true);
		}
	}
}
