package wallet;

public interface Wallet {

  int takeOutMoney(int coinNum, int billNum);

  void putMoney(int coinNum, int billNum);
}
