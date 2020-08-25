package table;

public class Person {

  private final int id;
  private final String name;
  private final String address;

  public Person(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public void printPersonInfo() {
    System.out.println(
        "ID: " + this.getId() + " / 이름: " + this.getName() + " / 주소: " + this.getAddress());
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
}
