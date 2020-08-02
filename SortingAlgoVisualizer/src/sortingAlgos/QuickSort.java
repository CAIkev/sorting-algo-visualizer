package sortingAlgos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mainGUI.PaintCode;
import mainGUI.Display;
import mainGUI.Elements;

public class QuickSort {

	private Timer quickSort;
	private Display dis;
	private Elements.Node[] nodes;
	
	public QuickSort(Display disIn, Elements.Node[] list) {
		dis = disIn;
		nodes = list;
	}
	
	private void initQuickSort() {
		quickSort = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
	}
	
	public void run() {
		initQuickSort();
		quickSort.start();
	}
	
}
