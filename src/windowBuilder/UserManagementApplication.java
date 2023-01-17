package windowBuilder;

import java.awt.EventQueue;

import windowBuilder.view.frame.MainFrame;

public class UserManagementApplication {

	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		EventQueue.invokeLater(runnable);
	}


}






