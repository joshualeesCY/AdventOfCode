package Day9.queue;
/**
* This InvalidDataException class implements queue capabilities (FIFO) using an array
*
* @author Joshua Lees
* @version 1.0
* File: InvalidDataException.java
* Created: October 2021
* ©Copyright Cedarville University, its Computer Science faculty,
* and the authors. All rights reserved.
* Summary of modifications:
* 8 Oct 2021 - created and implemented class
*
* Description: This class provides an InvalidDataException capabilities for any 
* invalid data entered by the user (typically just null). InvalidDataException 
* inherits from RuntimeException, and is not anticipated to be a base class 
* for other classes.
*/
public class InvalidDataException extends RuntimeException {
 public InvalidDataException(String err) {
 super(err);
 }
}
