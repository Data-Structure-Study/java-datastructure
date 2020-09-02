package com.codesquad.datastructurestudy.recursive;

public class HanoiTower {

  private static void moveHanoiTower(int number, String from, String by, String to) {
    if (number == 1) {
      System.out.println("원반 " + number + "를 " + from + "에서 " + to + "로 이동");
    } else {
      moveHanoiTower(number-1, from,to, by);
      System.out.println("원반 " + number + "를 " + from + "에서 " + to + "로 이동");
      moveHanoiTower(number-1, by, from, to);
    }
  }

  public static void main(String[] args) {
    moveHanoiTower(3, "A", "B", "C");
  }
}
