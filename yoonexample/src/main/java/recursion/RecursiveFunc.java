package recursion;

public class RecursiveFunc {

  public static void main(String[] args) {
    recursive(3);
  }

  public static void recursive(int num) {
    if (num <= 0) { // 재귀의 탈출조건
      return;
    }
    System.out.println("재귀 호출! " + num);
    recursive(num - 1);
  }
}
