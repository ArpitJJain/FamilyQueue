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
	
	/*@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" Data : ").append(data).append('\n');
		buffer.append(" Previous Node : ").append(prevNode.getData()).append('\n');
		buffer.append(" Next Node : ").append(nextNode.getData()).append('\n');
		buffer.append(" Previous Family Node : ").append(prevFamilyNode.getData()).append('\n');
		buffer.append(" Next Family Node : ").append(nextFamilyNode.getData());
		return buffer.toString();
	}*/
}
