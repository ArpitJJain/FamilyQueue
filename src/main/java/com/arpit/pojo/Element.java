package com.arpit.pojo;

public class Element {
	private long id;
	private String family;
	public long getId() {
		return id;
	}
	public String getFamily() {
		return family;
	}
	public Element(long id, String family) {
		super();
		this.id = id;
		this.family = family;
	}
	
	/*@Override
	public String toString() {
		return "~FAMILY ["+family+"] : ID ["+id+"]~";
	}*/
}
