package com.arpit.ds;

import com.arpit.pojo.Element;

public interface CorrelationQueue{
	Element pop();
	Element pop(String family);
	boolean push(long id, String family);
}