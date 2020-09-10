package com.codesquad.datastructurestudy.list.arraylist;

public interface Wallet {

  // 모든 멤버변수는 public static final. 생략 가능
  int coin100Num = 0;
  int bill5000Num = 0;

  // 모든 메서드는 public abstract 이어야함. 생략 가능
  int takeOutMoney(int coin100Num, int bill5000Num);
  void putMoney(int coin100Num, int bill5000Num);

}
