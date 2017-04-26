package windowMain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import main.MessageBox;

public class UserDeleteButton extends JButton implements ActionListener{

	public UserDeleteButton() {
		super("Usuñ");
		setBounds(450,300,150,50);
		setBackground(Color.red);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Table table = Table.getInstance();
		Integer isNumberSelectedRow = table.getSelectedRow();
		if(isNumberSelectedRow == -1) {
			MessageBox.show("Wybierz wiersz który chcesz usunaæ");
		} else if(isNumberSelectedRow > -1)  {
			DefaultTableModel model = (DefaultTableModel) Table.getInstance().getModel();
			model.removeRow(isNumberSelectedRow);
		} 
	}
}

