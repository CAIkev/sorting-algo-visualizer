import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Display extends JPanel {
	
	private static final long serialVersionUID = 1L;
	// All pixel lengths in this class are centered around working with 100 elements (11 pixel width per element) 
	private static final int ELEMENT_QTY = 100; 
	
	private int[] elements;
	
	public Display() {
		setLayout(null);
		
		elements = new int[ELEMENT_QTY];
		for(int i = 0; i < ELEMENT_QTY; i++) {
			elements[i] = 10 + (i * 5);
		}
		
		JButton button = new JButton("Generate New List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNewList();
				repaint();
			}
		});
		button.setBounds(400, 600, 120, 30);
		add(button);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i = 0; i < ELEMENT_QTY; i++) {
			g.fillRect(87 + (i*11), 0, 10, elements[i]);
		}
	}
	
	public void setHeight(int index, int height) {
		elements[index] = height;
		repaint();
	}
	
	private void generateNewList() {
		Random rand = new Random();
		
		for(int i = 0; i < ELEMENT_QTY; i++) {
			int newIndex = rand.nextInt(elements.length);
			int temp = elements[newIndex];
			elements[newIndex] = elements[i];
			elements[i] = temp;
		}
	}
	
}
