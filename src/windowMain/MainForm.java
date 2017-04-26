package windowMain;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import calculator.CalculatorComponent;

public class MainForm extends JFrame{
	
  private final Integer width = 700;
  private final Integer height = 600;
  private JPanel panel = new JPanel();
  public MainForm() {
	  configWindow();
	  configPanel();
	  addWindowListener();
  }
  
  private void configWindow() {
	  setTitle("Program zarzadzaj¹cy pracownikami");
	  setSize(width, height);
	  setResizable(false);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocationRelativeTo(null);
	  setJMenuBar(new Menu());
	  setContentPane(panel);
	  setVisible(true);
  }
  
  private void configPanel() {
      panel.setLayout(null); 
      createScrollPane();
      loadCalculatorComponent();
      panel.add(new UserNewButton());
      panel.add(new UserEditButton());
      panel.add(new UserDeleteButton());
      validate();
      repaint();
      
  }
  
  private void createScrollPane() {
	  JScrollPane scrollPane = new JScrollPane(Table.getInstance());
	  scrollPane.setBounds(100,0, 500, 300);
	  panel.add(scrollPane);
  }
  
  private void loadCalculatorComponent() {
	  CalculatorComponent calculatorComponent = new CalculatorComponent();
	  calculatorComponent.load().forEach(c->panel.add(c));
  }
  
  private void addWindowListener() {
	  this.addWindowListener(new WindowListener() {
		
	
		@Override
		public void windowClosing(WindowEvent e) {
			int n = JOptionPane.showConfirmDialog(  
	                null,
	                "Chcesz zamknac aplikacje","",
	                JOptionPane.YES_NO_OPTION);

	      if(n == JOptionPane.YES_OPTION) {
	    	  System.exit(0);
	     }
	   }

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
  }
}
