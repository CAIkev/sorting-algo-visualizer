package mainGUI;

import java.awt.Color;


public class Elements {
	
	private static final int ELEMENT_QTY = 100; 
	
	private Node[] elements; // Represents the entire list and its current order
	
	public class Node {
		
		int value; // Value or height of this element
		Color col; // Stores state of this node (is this element being compared or swapped?)  
		
		// For now the project features a static list size; no need to have outside access to the constructor
		private Node(int initVal) {
			value = initVal;
			col = Color.BLACK;
		}
		
		// No setVal() is needed because value is immutable
		public int getVal() {
			return value;
		}
		
		public Color getColor() {
			return col; 
		}
		
		public void setCol(Color newCol) {
			col = newCol;
		}
	}
	
	// Initializes with an in order list
	public Elements() { 
		elements = new Node[ELEMENT_QTY];
		for(int i = 0; i < ELEMENT_QTY; i++) {
			elements[i] = new Node(10 + (i * 5));
		}
	} 
	
	public Node[] getElements() {
		return elements;
	}
	
	public int getCount() {
		return elements.length;
	}
	
}
