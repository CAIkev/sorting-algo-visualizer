import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SortingAlgos {

	// Corresponds to codes in Display class
	// private static final int RESET = 0; // Display resets code to 0 
	private static final int COMPARE = 1;
	private static final int SWAP = 2;
	
	private Display dis;
	private Elements.Node[] nodes;
	
	private Timer bubbleSort;
	
	public SortingAlgos(Display disIn, Elements.Node[] list) {
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
					nodes[j].setCode(COMPARE);
					nodes[j+1].setCode(COMPARE);
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
					nodes[j].setCode(SWAP);
					nodes[j+1].setCode(SWAP);
				}
				dis.repaint();
				j++;
			}
			
		});
	}

	public void runBubbleSort() {
		initBubbleSort();
		bubbleSort.start();
	}
	
}
