package com.arpit.ds.impl;

import java.util.HashMap;
import java.util.Map;

import com.arpit.ds.CorrelationQueue;
import com.arpit.pojo.Element;
import com.arpit.pojo.ElementNode;

public class CorrelationQueueImpl implements CorrelationQueue {
	private final  int capacity;
	private int elementCount;
	private ElementNode headPointer;
	// This Map will be used to hold the reference of top of Family
	private Map<String,ElementNode> familyPointerMap = new HashMap<String, ElementNode>();

	public CorrelationQueueImpl(int capacity) {
		super();
		this.capacity = capacity;
	}

	/**
	 * Pop the Top of the queue. Returns Null when queue is empty
	 */
	public Element pop() {
		if(headPointer == null) {
			return null;
		}
		// This check is to avoid break the circular loop.
		if(headPointer.getNextNode() == headPointer) {
			Element e = headPointer.getData();
			headPointer=null;
			elementCount--;
			return e;
		}
		//Connect the previous node with next node to make this node free.
		popInternal(headPointer);
		Element e = headPointer.getData();
		
		// Check if existing node is top also head of the family node. then update head reference to 
		ElementNode test = familyPointerMap.get(e.getFamily());
		if (test == headPointer) {
			if(test != test.getNextFamilyNode()) {
				familyPointerMap.put(e.getFamily(),test.getNextFamilyNode());
			}else {
				familyPointerMap.remove(e.getFamily());
			}
		}
		headPointer=headPointer.getNextNode();
		elementCount--;
		return e;
	}

	/**
	 * Pop the top of Family. Returns null if family doesn't exist.
	 */
	public Element pop(String family) {
		ElementNode node = familyPointerMap.get(family);
		// Saftey null check
		if(node == null ) {
			return null;
		}
		// To break the circular loop
		if( node.getNextFamilyNode() == node) {
			familyPointerMap.remove(family);
			if(node==headPointer) {
				headPointer = null;
			}
			popInternal(node);
			elementCount--;
			return node.getData();
		}
		// Check if current family head is head of the queue as well. 
		boolean headCheck = false;
		if(node==headPointer) {
			headCheck = true;
		}
		//Connect previous node with next node
		popInternal(node);
		Element e = node.getData();
		//Update family head
		familyPointerMap.put(family,node.getNextFamilyNode());
		// if family head is head of the queue as well, then update the top of the queue
		if(headCheck) {
			headPointer = node.getNextNode();
		}
		elementCount--;
		return e;
	}

	/**
	 * Connects the previous node with next node. Can be used when we want to remove the existing node from he link
	 * @param node
	 */
	private void popInternal(ElementNode node) {
		if(node!=null) {
			node.getPrevNode().setNextNode(node.getNextNode());
			node.getPrevFamilyNode().setNextFamilyNode(node.getNextFamilyNode());
			node.getNextNode().setPrevNode(node.getPrevNode());
			node.getNextFamilyNode().setPrevFamilyNode(node.getPrevFamilyNode());
		}		
	}

	/**
	 * Add element in the queue. 
	 */
	public boolean push(long id, String family) {
		if(elementCount == capacity) {
			return false;
		}
		Element element = new Element(id, family);
		ElementNode node = new ElementNode();
		node.setData(element);
		if(headPointer == null) {
			headPointer = node;
			familyPointerMap.put(family, node);
		}else {
			if(headPointer.getPrevNode() == null) {
				headPointer.setPrevNode(node);
			}else {
				headPointer.getPrevNode().setNextNode(node);
			}
			if(headPointer.getNextNode() == null) {
				headPointer.setNextNode(node);
			}
			node.setNextNode(headPointer);
			node.setPrevNode(headPointer.getPrevNode());
			headPointer.setPrevNode(node);
			ElementNode familyHead =  familyPointerMap.get(family);
			if(null != familyHead) {
				if(null == familyHead.getPrevFamilyNode()) {
					familyHead.setPrevFamilyNode(node);
				}else {
					familyHead.getPrevFamilyNode().setNextFamilyNode(node);
				}
				if(familyHead.getNextFamilyNode() == null){
					familyHead.setNextFamilyNode(node);
				}

				node.setPrevFamilyNode(familyHead.getPrevFamilyNode());
				node.setNextFamilyNode(familyHead);
				familyHead.setPrevFamilyNode(node);
			}else {
				familyPointerMap.put(family, node);
			}
		}
		elementCount++;
		return true;
	}
}