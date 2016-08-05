import java.awt.EventQueue;

import javax.swing.JFrame;

public class BikeGame extends JFrame {

	public BikeGame() {
		initUI();

	} // constructor

	private void initUI() {

		add(new Board());

		setResizable(false);
		pack();

		setTitle("Bikcycle Ride");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame ex = new BikeGame();
				ex.setVisible(true);
			}
		});

	} // main

} // BikeGame
