package solutions.queue;
/**
* This qInterface interface provides abstract methods for Queue to implement 
* 
* @author Joshua Lees
* @version 1.0
* File: qInterface.java
* Created: October 2021
* ©Copyright Cedarville University, its Computer Science faculty,
* and the authors. All rights reserved.
* Summary of modifications:
* 7 Oct 2021 - created and interface based off of Project 4 PDF
*
* Description: This interface provides abstract Queue methods for Queue.java to 
* Implement. qInterface does not inherit from other classes, and is intended to be 
* implemented and defined by other classes (specifically Queue.java)
*/ 
public interface qInterface<E> { 
 public void enqueue (E element) throws InvalidDataException; 
 public E dequeue () throws QueueEmptyException; 
 public E front () throws QueueEmptyException; 
 public int size(); 
 public boolean isEmpty(); 
}