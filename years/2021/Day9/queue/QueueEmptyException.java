package solutions.queue;
/**
* This QueueEmptyException class implements queue capabilities (FIFO) using an array
*
* @author Joshua Lees
* @version 1.0
* File: QueueEmptyException.java
* Created: October 2021
* ©Copyright Cedarville University, its Computer Science faculty,
* and the authors. All rights reserved.
* Summary of modifications:
* 8 Oct 2021 - created and implemented class
*
* Description: This class provides an QueueEmptyException capabilities for any 
* attempts at reading or dequeuing data from an empty Queue. InvalidDataException 
* Inherits from RuntimeException, and is not anticipated to be a base class 
* for other classes.
*/
public class QueueEmptyException extends RuntimeException {
 public QueueEmptyException(String err) {
 super(err);
 }
}