package com.arpit.pojo;

public class Element {
	private long id;
	private String family;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public Element(long id, String family) {
		super();
		this.id = id;
		this.family = family;
	}
}
