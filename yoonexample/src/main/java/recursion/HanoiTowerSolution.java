package recursion;

public class HanoiTowerSolution {

  public static void main(String[] args) {
    HanoiTowerMove(3, 'A', 'B', 'C');
  }

  public static void HanoiTowerMove(int num, char from, char by, char to) {
    if (num == 1) {
      System.out.printf("원반1을 %c에서 %c로 이동 %n", from, to); // 재귀의 탈출조건
    } else {
      HanoiTowerMove(num - 1, from, to, by); // 1단계: 작은 원반 n-1개를 from에서 by로 이동
      System.out.printf("원반%d을(를) %c에서 %c로 이동 %n", num, from, to); // 2단계: 큰 원반 이동
      HanoiTowerMove(num - 1, by, from, to); // 3단계: by에 있던 작은 원반 n-1개를 from을 거쳐 to로 이동
    }
  }
}
