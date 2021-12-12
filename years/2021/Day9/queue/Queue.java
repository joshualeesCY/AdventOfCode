package solutions.queue;
import java.util.*;
/**
* This Queue class implements queue capabilities (FIFO) using an array
*
* @author Joshua Lees
* @version 1.0
* File: Queue.java
* Created: October 2021
* ©Copyright Cedarville University, its Computer Science faculty,
* and the authors. All rights reserved.
* Summary of modifications:
* 8 Oct 2021 - integrated qInterface methods
* - wrote constructors
* 10 Oct 2021 - defined all methods 
* 11 Oct 2021 - refined and corrected methods
*
* Description: This class provides standard Queue capabilities using
* an Array. queue does not inherit from other classes, and is not 
* anticipated to be a base class for other classes.
*/
public class Queue<E> implements qInterface<E> {
 
 private static final int DEFAULT_CAPACITY = 10;
 private E qArray[];
 private int front = 0;
 private int rear = 0;
 private int size = 0;
 private int capacity = 0;
 
 public Queue() {
 this(DEFAULT_CAPACITY);
 }
 
 public Queue(int size) {
 qArray = (E[]) new Object[size];
 capacity = size;
 front = 0;
 rear = 0;
 size = 0;
 }
 
 @Override 
 public void enqueue (E elem) throws InvalidDataException {
 if (elem != null) {
 
 // check if we need to expand
 if (this.size() == qArray.length) {
 
 // create new array double original array length
 E[] newArray = (E[]) new Object[qArray.length * 2]; 
 
 // copy old data over into new
 for (int i=0; i < size(); i++) { 
 newArray[i] = qArray[(front + i) % capacity]; 
 } 
 // instance array points to new array
 qArray = newArray;
 capacity = newArray.length;
 
 // reset pointers
 front = 0; 
 rear = this.size(); 
 } 
 qArray[rear] = elem;
 rear = (rear + 1) % capacity;
 size += 1;
 }
 else {
 throw new InvalidDataException("Exception Thrown: Invalid data");
 }
 } 
 
 @Override
 public E dequeue () throws QueueEmptyException {
 if (this.size == 0) {
 throw new QueueEmptyException("Exception Thrown: Empty Queue casued by dequeue()"); 
 }
 E temp = qArray[front];
 // null out front value 
 qArray[front] = null;
 // increment front pointer (unless at the end of the array, in which case return front pointer to start of array)
 front = (front + 1) % capacity;
 size -= 1;
 // return front value
 return temp;
 } 
 @Override
 public E front () throws QueueEmptyException {
 // check for exception
 if (this.size == 0) {
 throw new QueueEmptyException("Exception Thrown: Empty Queue when calling front()"); 
 }
 // return value at front pointer
 
 return qArray[front]; 
 } 
 
 @Override
 public int size() {
 // return size of array
 return this.size;
 } 
 
 @Override
 public boolean isEmpty() {
 // true if size is 0
 if (size == 0) {
 return true;
 } 
 // else false
 return false;
 } 
} 
