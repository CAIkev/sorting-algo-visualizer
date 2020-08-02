package sortingAlgos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.PaintCode;
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
			private Elements.Node temp;
			private Boolean forcedChange = false;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i >= nodes.length-1) {
					bubbleSort.stop();
					dis.repaint();
					dis.disableButtons(false);
					return;
				}
				if(j >= nodes.length-i-1) {
					j = 0;
					i++;
					return;
				}
				
				if(!forcedChange && nodes[j].getVal() <= nodes[j+1].getVal()) {
					forcedChange = true;
					nodes[j].setCode(PaintCode.COMPARE);
					nodes[j+1].setCode(PaintCode.COMPARE);
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
					nodes[j].setCode(PaintCode.SWAP);
					nodes[j+1].setCode(PaintCode.SWAP);
				}
				dis.repaint();
				j++;
			}
			
		});
	}
	
	public void run() {
		initBubbleSort();
		bubbleSort.start();
	}
	
}
