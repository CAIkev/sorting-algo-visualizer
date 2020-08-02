package mainGUI;

import mainGUI.PaintCode;

public class Elements {
	
	private Node[] elements; // Represents the entire list and its current order
	
	public class Node {
		
		int value; // Value or height of this element
		int code; // Stores state of this node (is this element being compared or swapped?)  
		
		// For now the project features a static list size; no need to have outside access to the constructor
		private Node(int initVal) {
			value = initVal;
			code = 0;
		}
		
		// No setVal() is needed because value is immutable
		public int getVal() {
			return value;
		}
		
		public int getCode() {
			return code; 
		}
		
		public void setCode(int newCode) {
			code = newCode;
		}
	}
	
	// Initializes with an in order list
	public Elements() { 
		elements = new Node[PaintCode.ELEMENT_QTY];
		for(int i = 0; i < PaintCode.ELEMENT_QTY; i++) {
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
