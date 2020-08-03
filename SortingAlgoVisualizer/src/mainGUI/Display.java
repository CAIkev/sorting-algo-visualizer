package mainGUI;

import sortingAlgos.*;

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
	
	private Elements elements;
	private Elements.Node[] nodes;
	private BubbleSort bubbleSort;
	private InsertSort insertSort;
	private SelectSort selectSort;
	
	private JButton[] buttons;
	private Timer genNewList;
	
	public Display() {
		setLayout(null);
		initClickables();
		initListGenerator();
		elements = new Elements();
		nodes = elements.getElements();
		initSortingAlgos();
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
	
	private void initSortingAlgos() {
		bubbleSort = new BubbleSort(this, nodes);
		insertSort = new InsertSort(this, nodes);
		selectSort = new SelectSort(this, nodes);
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
		buttons = new JButton[4];
		
		JButton genListButton = new JButton("Generate New List");
		genListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableButtons(true);
				genNewList.start();
			}
		});
		genListButton.setBounds(275, 600, 150, 30);
		add(genListButton);
		buttons[0] = genListButton;
		
		JButton bubbleSortButton = new JButton("BubbleSort");
		bubbleSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableButtons(true);
				bubbleSort.run();
			}
		});
		bubbleSortButton.setBounds(450, 600, 150, 30);
		add(bubbleSortButton);
		buttons[1] = bubbleSortButton;
		
		JButton insertSortButton = new JButton("InsertSort");
		insertSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableButtons(true);
				insertSort.run();
			}
		});
		insertSortButton.setBounds(625, 600, 150, 30);
		add(insertSortButton);
		buttons[2] = insertSortButton;
		
		JButton selectSortButton= new JButton("SelectSort");
		selectSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Run selectsort");
			}
		});
		selectSortButton.setBounds(800, 600, 150, 30);
		add(selectSortButton);
		buttons[3] = selectSortButton;
	}
	
	// The height, order, and state (color) of the lines are drawn based on the information stored in the nodes
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < elements.getCount(); i++) {
			g.setColor(nodes[i].getColor());
			nodes[i].setCol(Color.BLACK); // Reset color to black
			g.fillRect(87 + (i*11), 0, 10, nodes[i].getVal());
		}
	}
	
}
