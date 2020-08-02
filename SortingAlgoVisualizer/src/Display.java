import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


//All pixel lengths in this class are centered around working with 100 elements (10 pixel width per element) 
public class Display extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// Corresponds to codes in SortingAlgos class
	private static final int BLACK = 0;
	private static final int ORANGE = 1;
	private static final int GREEN = 2;
	
	private Elements elements;
	private Elements.Node[] nodes;
	private SortingAlgos sorter;
	
	private JButton[] buttons;
	private Timer genNewList;
	
	public Display() {
		setLayout(null);
		initClickables();
		initListGenerator();
		elements = new Elements();
		nodes = elements.getElements();
		sorter = new SortingAlgos(this, nodes);
	}
	
	// Shuffles the nodes/elements, pauses 1 ms per swap
	// Nodes are simply re-ordered, no new Nodes are created
	private void initListGenerator() {
		genNewList = new Timer(1, new ActionListener() {
			private int index = 0;
			Random rand = new Random();
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(index >= elements.getCount()) {
					genNewList.stop();
					index = 0;
					disableButtons(false);
					return;
				} else {
					Elements.Node temp = nodes[index];
					int newIndex = rand.nextInt(elements.getCount());
					nodes[index] = nodes[newIndex];
					nodes[newIndex] = temp;
					index++;
					repaint();
				}
			}
			
		});
	}
	
	public void disableButtons(Boolean disable) {
		if(disable) {
			for(JButton x : buttons) {
				x.setEnabled(false);
			}
		} else {
			for(JButton x : buttons) {
				x.setEnabled(true);
			}
		}
	}
	
	private void initClickables() {
		buttons = new JButton[2];
		
		JButton button1 = new JButton("Generate New List");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableButtons(true);
				genNewList.start();
			}
		});
		button1.setBounds(100, 600, 150, 30);
		add(button1);
		buttons[0] = button1;
		
		JButton button2 = new JButton("Bubblesort");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableButtons(true);
				sorter.runBubbleSort();
			}
		});
		button2.setBounds(275, 600, 150, 30);
		add(button2);
		buttons[1] = button2;
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
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < elements.getCount(); i++) {
			g.setColor(getColor(nodes[i].getCode()));
			nodes[i].setCode(BLACK); // Reset color to black
			g.fillRect(87 + (i*11), 0, 10, nodes[i].getVal());
		}
	}
	
	/*
	private void check() { // Total value should add up to 25750
		int total = 0;
		for(int i = 0; i < nodes.length; i++) {
			total += nodes[i].getVal();
		}
		
		if(total == 25750) {
			System.out.println("Passes immutable node vals check");
		} else {
			System.out.println("FAILED Total vals was: " + total);
		}
	}*/
}
