package recursion;

public class FibonacciFunc {

  public static void main(String[] args) {
    for (int i = 1; i < 15; i++) {
      System.out.printf("%d ", fibo(i));
    }
  }

  public static int fibo(int num) {
    if (num == 1) {
      return 0;
    }
    if (num == 2) {
      return 1;
    }
    return fibo(num - 1) + fibo(num - 2);
  }
}
