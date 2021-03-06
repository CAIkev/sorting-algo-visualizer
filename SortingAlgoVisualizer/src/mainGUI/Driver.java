package mainGUI;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Driver {
	
	private static final Dimension FIXED_DIM = new Dimension(1280, 720);
	
	public Driver() {
		JFrame frame = new JFrame();	
		frame.setTitle("Sorting Algo Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(FIXED_DIM);
		frame.setResizable(false);
		
		frame.add(new Display());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Driver();
		
	}
	
}
