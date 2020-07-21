package recursion;

public class RecursiveFactorial {

  public static void main(String[] args) {
    System.out.println("1! = " + factorial(1));
    System.out.println("2! = " + factorial(2));
    System.out.println("3! = " + factorial(3));
    System.out.println("4! = " + factorial(4));
    System.out.println("9! = " + factorial(9));
  }

  public static int factorial(int num) { // 숫자가 조금만 커져도 문제될 수 있음
    if (num == 0) {
      return 1;
    }
    return num * factorial(num - 1);
  }
}
