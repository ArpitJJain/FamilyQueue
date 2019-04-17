# Family Queue

The aim of this project is to design and implement a data structure which supports the following functions with the constraints specified.

You will be providing an implementation of the following interface

```java
public interface CorrelationQueue{
	Element pop();
	Element pop(String family);
	boolean push(long id, String family);
}
```
where Element is a pojo with fields `id` and `family`

### Description of the methods

`Element pop()` -  Removes and returns the oldest element of the queue 

`Element pop(String family)` -  Removes and returns the oldest element of the queue which belongs to the family specified.

`boolean add(long id, String family)` - Adds an element to the begining of the queue using the values supplied

`CorrelationQueueImpl(int maxSize)` - The implementation of the queue needs to take a constructor parameter that has one int parameter that is the Maximum Size of the queue.


#### Notes

1. The Ids with in a family are unique
2. The number of families is not fixed and the distribuition is not fixed either. So for a queue max size of 1M there can be 1 family of a million elements or a million families of one element each. 
3. Write time and space optimal solution for all these cases.
4. Avoid using Java collection library as much as possible. **Your implementation should definitely not use any of the existing Queue implementations.**
