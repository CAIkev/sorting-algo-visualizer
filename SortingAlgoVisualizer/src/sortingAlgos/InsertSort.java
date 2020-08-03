package sortingAlgos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.Display;
import mainGUI.Elements;

public class InsertSort {

	private Timer insertSort;
	private Display dis;
	private Elements.Node[] nodes;
	
	public InsertSort(Display disIn, Elements.Node[] list) {
		dis = disIn;
		nodes = list;
	}
	
	private void initInsertSort() {
		insertSort = new Timer(15, new ActionListener() {
			private int i = 1;
			private int j = 0;
			private boolean nextFlag = true;
			private Elements.Node temp;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i >= nodes.length) {
					insertSort.stop();
					dis.repaint();
					dis.disableButtons(false);
					return;
				}
				if(nextFlag) {
					temp = nodes[i];
					j = i - 1;
					nextFlag = false; 
				}
				
				if(j >= 0 && nodes[j].getVal() > temp.getVal()) {
					temp.setCol(Color.RED);
					nodes[j].setCol(Color.RED);
					if(i+1 < nodes.length) {
						nodes[i+1].setCol(Color.GREEN);
					} else {
						nodes[i].setCol(Color.GREEN);
					}
					
					nodes[j+1] = nodes[j];
					nodes[j] = temp;
					j--;
					dis.repaint();
					return;
				}
			
				nodes[j+1] = temp;
				i++;
				if(i < nodes.length) {
					nodes[i].setCol(Color.GREEN);
				}
				nextFlag = true;
				dis.repaint();
			}
		});
	}
	
	public void run() {
		initInsertSort();
		insertSort.start();
	}
	
}
