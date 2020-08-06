package exception;

public class EmptyDequeException extends RuntimeException {

  public EmptyDequeException() {
    super("Deque is Emtpy.");
  }
}
