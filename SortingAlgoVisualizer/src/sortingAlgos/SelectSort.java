package sortingAlgos;

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
		selectionSort = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
	}
	
	public void run() {
		initSelectionSort();
		selectionSort.start();
	}
	
}
