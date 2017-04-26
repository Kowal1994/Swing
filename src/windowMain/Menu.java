package windowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import data.UserDeserialize;
import data.UserSeralize;
import data.Users;
import main.MessageBox;

public class Menu extends JMenuBar {
	
	public Menu() {
		createMenuPanel();
		creatMenuAbout();
	}
	
	private void createMenuPanel() {
		JMenu file = new JMenu("Plik");
		JMenuItem loadDataWithFileItem = new JMenuItem("Wczytaj");
		loadDataWithFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Table.getInstance().clearTable();
				DefaultTableModel model = (DefaultTableModel) Table.getInstance().getModel();
			    UserDeserialize.load().forEach(u->model.addRow(new Object[]{u.getImie(),u.getNazwisko(),
			    		u.getWiek(),u.getZawod(),u.getPlaca()}));
			}
		});
		
		JMenuItem saveDataWithFileItem = new JMenuItem("Zapisz");
		saveDataWithFileItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserSeralize.save(new Users(Table.getInstance().tableToLisUsers()));
			}
		});
		
		file.add(loadDataWithFileItem);
		file.add(saveDataWithFileItem);
		add(file);
	}
	
	private void creatMenuAbout() {
		JMenu about = new JMenu("About");
		about.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				MessageBox.show("Author:Konrad Kowalewski \n Contact:konradkowalewski@gmail.com");
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(about);
	}
}
