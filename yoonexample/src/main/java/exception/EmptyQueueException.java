package exception;

public class EmptyQueueException extends RuntimeException {

  public EmptyQueueException() {
    super("Queue is Emtpy.");
  }
}
