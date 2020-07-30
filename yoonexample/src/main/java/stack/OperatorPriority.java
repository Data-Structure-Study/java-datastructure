package stack;

public enum OperatorPriority {
  TOP(3),
  MID(2),
  BOT(1),
  NONE(-1);

  private final int priority;

  OperatorPriority(int priority) {
    this.priority = priority;
  }

  public static OperatorPriority getOperatorPriority(char sign) {
    switch (sign) {
      case '*':
      case '/':
        return TOP;
      case '+':
      case '-':
        return MID;
      case '(':
        return BOT;
      default:
        return NONE;
    }
  }

  public int getPriority() {
    return priority;
  }
}
