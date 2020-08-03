package sortingAlgos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.Display;
import mainGUI.Elements;

public class BubbleSort {

	private Timer bubbleSort;
	private Display dis;
	private Elements.Node[] nodes;
	
	public BubbleSort(Display disIn, Elements.Node[] list) {
		dis = disIn;
		nodes = list;
	}
	
	private void initBubbleSort() {
		bubbleSort = new Timer(1, new ActionListener() {
			private int i = 0;
			private int j = 0;
			private int completedIndex = nodes.length;
			private Elements.Node temp;
			private Boolean forcedChange = false;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i >= nodes.length-1) {
					bubbleSort.stop();
					nodes[completedIndex].setCol(Color.BLACK);
					dis.repaint();
					dis.disableButtons(false);
					return;
				}
				if(j >= nodes.length-i-1) {
					j = 0;
					i++;
					nodes[--completedIndex].setCol(Color.GREEN);
					
					return;
				}
				
				if(!forcedChange && nodes[j].getVal() <= nodes[j+1].getVal()) {
					forcedChange = true;
					nodes[j].setCol(Color.RED);
					nodes[j+1].setCol(Color.RED);
					if(completedIndex < nodes.length) {
						nodes[completedIndex].setCol(Color.GREEN);
					}
					dis.repaint();
					return;
				}
				if(forcedChange) {
					forcedChange = false;
				}
				
				if(nodes[j].getVal() > nodes[j+1].getVal()) {
					temp = nodes[j];
					nodes[j] = nodes[j+1];
					nodes[j+1] = temp;
					if(completedIndex < nodes.length) {
						nodes[completedIndex].setCol(Color.GREEN);
					}
					nodes[j].setCol(Color.RED);
					nodes[j+1].setCol(Color.RED);
					dis.repaint();
				}
				j++;
			}
			
		});
	}
	
	public void run() {
		initBubbleSort();
		bubbleSort.start();
	}
	
}
