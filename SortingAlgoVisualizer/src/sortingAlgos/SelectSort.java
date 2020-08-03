package sortingAlgos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.Display;
import mainGUI.Elements;

public class SelectSort {

	private Timer selectionSort;
	private Display dis;
	private Elements.Node[] nodes;
	
	public SelectSort(Display disIn, Elements.Node[] list) {
		dis = disIn;
		nodes = list;
	}
	
	private void initSelectionSort() {
		selectionSort = new Timer(3, new ActionListener() {
			private int i = 0;
			private int j = 1;
			private int minIndex = 0;
			private boolean newIteration = true;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i >= nodes.length - 1) {
					selectionSort.stop();
					dis.repaint();
					dis.disableButtons(false);
					return;
				}
				
				if(newIteration) {
					minIndex = i;
					newIteration = false; 
				}
				if(j < nodes.length) {
					nodes[j].setCol(Color.RED);
					nodes[minIndex].setCol(Color.RED);
					if(nodes[j].getVal() < nodes[minIndex].getVal()) {
						minIndex = j;
					}
					j++;
					nodes[i].setCol(Color.GREEN);
					dis.repaint();
					return;
				}
				
				Elements.Node temp = nodes[minIndex];
				nodes[minIndex] = nodes[i];
				nodes[i] = temp;
				i++;
				j = i+1;
				newIteration = true;
				nodes[i-1].setCol(Color.GREEN);
				dis.repaint();
			}
		});
	}
	
	public void run() {
		initSelectionSort();
		selectionSort.start();
	}
	
}
