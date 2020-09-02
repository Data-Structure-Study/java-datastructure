package com.codesquad.datastructurestudy.list.arraylist;

public class NameCard {

  private String[] name;
  private String[] phone;

  // NameCard 구조체 변수의 동적 할당 및 초기화 후 주소 값 반환
  public NameCard(String[] name, String[] phone) {
    this.name = name;
    this.phone = phone;
  }

  public NameCard() {
    this.name = new String[30];
    this.phone = new String[30];
  }

  // NameCard 구조체 변수의 정보 출력
  public static void showNameCardInfo(NameCard nameCard) {
    System.out.println("[이름] : " + nameCard.name);
    System.out.println("[번호] : " + nameCard.phone);
  }

  // 이름이 같으면 true, 다르면 false 값 반환
  public static boolean nameCompare(NameCard nameCard, String[] name) {
    return nameCard.name.equals(name);
  }

  // 전화번호 정보를 변경
  public static void changePhoneNum(NameCard nameCard, String[] phone) {
    nameCard.phone = phone;
  }

  public static void main(String[] args) {
    NameCard nameCard = new NameCard();
    List<Integer> list = new ArrayList();

    // 총 3명의 전화번호 정보를, 앞서 우리가 구현한 리스트에 저장한다.
    nameCard.name[0] = "이진수";
    nameCard.name[1] = "한지영";
    nameCard.name[2] = "조수진";
    nameCard.phone[0] = "010-1111-2222";
    nameCard.phone[1] = "010-2222-5555";
    nameCard.phone[2] = "010-3333-7777";

  }


}
