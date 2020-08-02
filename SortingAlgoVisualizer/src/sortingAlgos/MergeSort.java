package sortingAlgos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.PaintCode;
import mainGUI.Display;
import mainGUI.Elements;

public class MergeSort {

	private Timer mergeSort;
	private Display dis;
	private Elements.Node[] nodes;
	
	public MergeSort(Display disIn, Elements.Node[] list) {
		dis = disIn;
		nodes = list;
	}
	
	private void initBubbleSort() {
		mergeSort = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
	}
	
	public void run() {
		initBubbleSort();
		mergeSort.start();
	}
	
}
