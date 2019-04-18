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
	private Map<String,ElementNode> familyPointerMap = new HashMap<String, ElementNode>();

	public CorrelationQueueImpl(int capacity) {
		super();
		this.capacity = capacity;
	}

	public Element pop() {
		if(headPointer == null) {
			return null;
		}
		// This check is to avoid break the circular loop.
		if(headPointer.getNextNode() == headPointer) {
			Element e = headPointer.getData();
			headPointer=null;
			return e;
		}
		popInternal(headPointer);
		Element e = headPointer.getData();
		headPointer=headPointer.getNextNode();
		return e;
	}

	public Element pop(String family) {
		ElementNode node = familyPointerMap.get(family);
		if(node == null ) {
			return null;
		}if( node.getNextFamilyNode() == node) {
			familyPointerMap.put(family,null);
			return node.getData();
		}
		popInternal(node);
		Element e = node.getData();
		node=node.getNextNode();
		familyPointerMap.put(family,node);
		return e;
	}

	private void popInternal(ElementNode headPointer) {
		if(headPointer==null) {
			return;
		}
		headPointer.getPrevNode().setNextNode(headPointer.getNextNode());
		headPointer.getPrevFamilyNode().setNextFamilyNode(headPointer.getNextFamilyNode());
		headPointer.getNextNode().setPrevNode(headPointer.getPrevNode());
		headPointer.getNextFamilyNode().setPrevFamilyNode(headPointer.getPrevFamilyNode());
		elementCount--;
	}

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