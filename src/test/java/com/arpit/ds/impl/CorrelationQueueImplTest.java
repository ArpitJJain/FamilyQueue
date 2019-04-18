package com.arpit.ds.impl;


import org.junit.Assert;
import org.junit.Test;

import com.arpit.ds.CorrelationQueue;


public class CorrelationQueueImplTest {

	private CorrelationQueue queue;
	
	@Test
	public void test_Capacity() {
		queue = new CorrelationQueueImpl(5);
		Assert.assertEquals(queue.push(1, "a"),true);
		Assert.assertEquals(queue.push(2, "a"),true);
		Assert.assertEquals(queue.push(3, "a"),true);
		Assert.assertEquals(queue.push(4, "a"),true);
		Assert.assertEquals(queue.push(5, "a"),true);
		Assert.assertEquals(queue.push(6, "a"),false);
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
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop("b").getId(),1);
		Assert.assertEquals(queue.pop().getId(),2);
		Assert.assertEquals(queue.pop("c").getId(),1);
		
		Assert.assertEquals(queue.pop("a"),null);
		Assert.assertEquals(queue.pop("b"),null);
		Assert.assertEquals(queue.pop("c"),2);
		
	}

	public static void main(String[] args) {
		System.out.println(12);
	}
}