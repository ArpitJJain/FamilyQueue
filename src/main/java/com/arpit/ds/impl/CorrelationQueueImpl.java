package com.arpit.ds.impl;

import java.util.HashMap;
import java.util.Map;

import com.arpit.ds.CorrelationQueue;
import com.arpit.pojo.Element;

public class CorrelationQueueImpl implements CorrelationQueue {
	private final  int capacity;
	private int elementCount;
	private Map<String,Element> familyPointerMap = new HashMap<String, Element>();
	
	public CorrelationQueueImpl(int capacity) {
		super();
		this.capacity = capacity;
	}

	public Element pop() {
		// TODO Auto-generated method stub
		return null;
	}

	public Element pop(String family) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean push(long id, String family) {
		if(elementCount == capacity) {
			return false;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
class ElementNode{
	protected ElementNode nextNode;
	protected ElementNode prevNode;
	protected ElementNode nextFamilyNode;
	protected Element data;
}
