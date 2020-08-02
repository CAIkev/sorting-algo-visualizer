import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;


//All pixel lengths in this class are centered around working with 100 elements (11 pixel width per element) 
public class Display extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// Corresponds to codes in SortingAlgos class
	private static final int BLACK = 0;
	private static final int ORANGE = 1;
	private static final int GREEN = 2;
	
	private Elements elements;
	private Elements.Node[] nodes;
	private SortingAlgos sorter;
	
	public Display() {
		setLayout(null);
		elements = new Elements();
		nodes = elements.getElements();
		sorter = new SortingAlgos(nodes);
		
		JButton button1 = new JButton("Generate New List");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNewList();
				repaint(); // Calls printComponent()
			}
		});
		button1.setBounds(100, 600, 150, 30);
		add(button1);
		
		JButton button2 = new JButton("Bubblesort");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Run bubblesort (no functionality right now)");
				repaint(); // Calls printComponent()
			}
		});
		button2.setBounds(275, 600, 150, 30);
		add(button2);
	}
	
	private Color getColor(int code) {
		if(code == ORANGE) {
			return Color.ORANGE;
		}
		if(code == GREEN) {
			return Color.GREEN;
		}
		
		return Color.BLACK;
	}
	
	// The height, order, and state (color) of the lines are drawn based on the information stored in the nodes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < elements.getCount(); i++) {
			g.setColor(getColor(nodes[i].getCode()));
			nodes[i].setCode(BLACK);
			g.fillRect(87 + (i*11), 0, 10, nodes[i].getVal());
		}
	}
	
	// Shuffles the nodes/elements
	// Nodes are simply re-ordered, no new Nodes are created
	private void generateNewList() {
		Random rand = new Random();
		
		for(int i = 0; i < elements.getCount(); i++) {
			Elements.Node temp = nodes[i];
			int newIndex = rand.nextInt(elements.getCount());
			nodes[i] = nodes[newIndex];
			nodes[newIndex] = temp;
		}
	}
	
}
