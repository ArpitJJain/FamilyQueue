package com.arpit.ds.impl;


import org.junit.Assert;
import org.junit.Test;

import com.arpit.ds.CorrelationQueue;
import com.arpit.pojo.Element;


public class CorrelationQueueImplTest {

	private CorrelationQueue queue;
	
	@Test
	/*
	 * Description : This test will check if queue is allowing the elements to be added beyond capacity.
	 * Steps : 
	 * 		Initialize the queue with size n = 5.
	 * 		Add n+1 elements in the queue.
	 * 		for first n element, push method should return true to indicate successful addition.
	 * 		for (n+1)th element, queue should return false to indicate nothing added.
	 */
	public void test_Capacity() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
		Assert.assertEquals(queue.push(7, "a"),false);
		Assert.assertEquals(queue.push(8, "a"),false);
	}
	
	@Test
	public void test_Pop() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop().getId(),3);
		Assert.assertEquals(queue.pop().getId(),4);
		Assert.assertEquals(queue.pop().getId(),5);
		Assert.assertEquals(queue.pop(),null);
	}
	
	@Test
	public void test_PopFamily() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a").getId(),3);
		Assert.assertEquals(queue.pop("a").getId(),4);
		Assert.assertEquals(queue.pop("a").getId(),5);
		Assert.assertEquals(queue.pop("a"),null);
		Assert.assertEquals(queue.pop(),null);
	}

	@Test
	/*
	 * Description : This test will test basic queue operation with pop method.
	 * Steps : 
	 * 		Initialize the queue with size n = 5.
	 * 		Add elements to the full Capacity.
	 * 		Pop all elements and ensure the sequence FIFO.
	 * 		Add elements again to full capacity.
	 * 		Pop all elements and ensure the sequence FIFO.
	 * 		Add few elements.
	 * 		pop few elements and ensure the sequence.
	 * 		Add Few more elements
	 * 		pop few elements and ensure the sequence.
	 * 		Add elements again to full capacity.
	 * 		Pop all elements and ensure the sequence FIFO.
	 */
	public void test_BasicQueueFunctionWithPop() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);

		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop().getId(),3);
		Assert.assertEquals(queue.pop().getId(),4);
		Assert.assertEquals(queue.pop().getId(),5);
		Assert.assertEquals(queue.pop(),null);

		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
		
		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop().getId(),3);
		Assert.assertEquals(queue.pop().getId(),4);
		Assert.assertEquals(queue.pop().getId(),5);
		Assert.assertEquals(queue.pop(),null);
		
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);

		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.pop().getId(),3);
		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop().getId(),3);
		
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
		
		Assert.assertEquals(queue.pop().getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop().getId(),3);
		Assert.assertEquals(queue.pop().getId(),4);
		Assert.assertEquals(queue.pop().getId(),5);
		Assert.assertEquals(queue.pop(),null);

	}
	
	
	@Test
	/*
	 * Description : This test will test basic queue operation with pop (family) method.
	 * Steps : 
	 * 		Similar to test_BasicQueueFunctionWithPop just change the pop() to pop(family)
	 */
	public void test_BasicQueueFunctionWithPopFamily() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);

		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a").getId(),3);
		Assert.assertEquals(queue.pop("a").getId(),4);
		Assert.assertEquals(queue.pop("a").getId(),5);
		Assert.assertEquals(queue.pop(),null);

		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
		
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a").getId(),3);
		Assert.assertEquals(queue.pop("a").getId(),4);
		Assert.assertEquals(queue.pop("a").getId(),5);
		Assert.assertEquals(queue.pop(),null);
		
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);

		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.pop("a").getId(),3);
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a").getId(),3);
		
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
		
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a").getId(),3);
		Assert.assertEquals(queue.pop("a").getId(),4);
		Assert.assertEquals(queue.pop("a").getId(),5);
		Assert.assertEquals(queue.pop(),null);

	}

	
	@Test
	public void test_mixFamily() {
		queue = new CorrelationQueueImpl(6);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(1, "b"),true);
		Assert.assertEquals(queue.push(1, "c"),true);

		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(2, "b"),true);
		Assert.assertEquals(queue.push(2, "c"),true);
		
		Assert.assertEquals(queue.pop("a").getId(),1);
		Assert.assertEquals(queue.pop("a").getId(),2);
		Assert.assertEquals(queue.pop("a"),null);
		
		Assert.assertEquals(queue.pop("b").getId(),1);
		Assert.assertEquals(queue.pop("b").getId(),2);
		Assert.assertEquals(queue.pop("b"),null);
		
		Assert.assertEquals(queue.pop("c").getId(),1);
		Assert.assertEquals(queue.pop("c").getId(),2);
		Assert.assertEquals(queue.pop("c"),null);
		
		Assert.assertEquals(queue.pop("a"),null);
		Assert.assertEquals(queue.pop(),null);
	}
	
	@Test
	public void test_mixPop() {
		queue = new CorrelationQueueImpl(6);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(1, "b"),true);
		Assert.assertEquals(queue.push(1, "c"),true);

		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(2, "b"),true);
		Assert.assertEquals(queue.push(2, "c"),true);
		
		Assert.assertEquals(queue.pop("a").getId(),1);

		Element e = queue.pop();
		Assert.assertEquals(e.getId(),1);
		Assert.assertEquals(e.getFamily(),"b");
		
		e = queue.pop("b");
		Assert.assertEquals(e.getId(),2);
		Assert.assertEquals(e.getFamily(),"b");
		
		e = queue.pop();
		Assert.assertEquals(e.getId(),1);
		Assert.assertEquals(e.getFamily(),"c");
		
		e = queue.pop();
		Assert.assertEquals(e.getId(),2);
		Assert.assertEquals(e.getFamily(),"a");

		e = queue.pop("c");
		Assert.assertEquals(e.getId(),2);
		Assert.assertEquals(e.getFamily(),"c");

		Assert.assertEquals(queue.pop("a"),null);
		Assert.assertEquals(queue.pop("b"),null);
		Assert.assertEquals(queue.pop("c"),null);
		Assert.assertEquals(queue.pop(),null);
		
	}
}