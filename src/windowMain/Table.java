package windowMain;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.User;

public class Table extends JTable {
	private static Table instance = null;
	
	private Table() {
		configureModel();
	}
	
	
	public static Table getInstance() {
		if(instance == null) {
			instance = new Table();
	     }
	     return instance;
	}

	private void configureModel() {
		setModel(new DefaultTableModel(
				new User[][] {

				},
				new String[] {
					"Imie", "Nazwisko", "Wiek", "Zawód","P³aca"
				}
			));
	}
	
	public User getSelectedUserRow(Integer index) {
		String imie = (String)getValueAt(index,0);
		String nazwisko = (String)getValueAt(index,1);
		Integer wiek = (Integer)getValueAt(index,2);
		String zawod = (String)getValueAt(index,3);
		Integer placa = (Integer)getValueAt(index,4);
		return new User.Bulider().imie(imie).nazwisko(nazwisko).wiek(wiek).zawod(zawod).placa(placa).build();
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public void changeValueRow(Integer row,User user){
		setValueAt(user.getImie(), row, 0);
		setValueAt(user.getNazwisko(), row, 1);
		setValueAt(user.getWiek(), row, 2);
		setValueAt(user.getZawod(), row, 3);
		setValueAt(user.getPlaca(), row, 4);
	}
	
	public List<User> tableToLisUsers() {
		List<User> users = new ArrayList<User>();
		User user;
		for (int i = 0; i < Table.getInstance().getRowCount(); i++) {
			user =  new User.Bulider().imie(getValueAt(i, 0).toString()).nazwisko(getValueAt(i, 1).toString()).
					wiek(Integer.valueOf(getValueAt(i, 2).toString())).zawod(getValueAt(i, 3).toString()).
					placa(Integer.valueOf(getValueAt(i, 4).toString())).build();
			users.add(user);
		}
		return users;
	}

	public void clearTable() {
		DefaultTableModel dtm = (DefaultTableModel)this.getModel();
	    dtm.setNumRows(0); 
	}
}
