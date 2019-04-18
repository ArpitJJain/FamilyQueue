package com.arpit.pojo;

public class ElementNode{
	protected ElementNode nextNode;
	protected ElementNode prevNode;
	protected ElementNode nextFamilyNode;
	protected ElementNode prevFamilyNode;
	protected Element data;
	
	public ElementNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(ElementNode nextNode) {
		this.nextNode = nextNode;
	}
	public ElementNode getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(ElementNode prevNode) {
		this.prevNode = prevNode;
	}
	public ElementNode getNextFamilyNode() {
		return nextFamilyNode;
	}
	public void setNextFamilyNode(ElementNode nextFamilyNode) {
		this.nextFamilyNode = nextFamilyNode;
	}
	public Element getData() {
		return data;
	}
	public void setData(Element data) {
		this.data = data;
	}
	public void setPrevFamilyNode(ElementNode prevFamilyNode) {
		this.prevFamilyNode = prevFamilyNode;
	}
	public ElementNode getPrevFamilyNode() {
		return prevFamilyNode;
	}
}
