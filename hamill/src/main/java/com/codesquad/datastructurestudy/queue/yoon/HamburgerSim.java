package com.codesquad.datastructurestudy.queue.yoon;

import java.util.Random;

public class HamburgerSim {

  private static final int CUS_COME_TERM = 15;
  private static final int CHE_BUR = 0;
  private static final int BUL_BUR = 1;
  private static final int DUB_BUR = 2;
  private static final int CHE_TERM = 12;
  private static final int BUL_TERM = 15;
  private static final int DUB_TERM = 24;

  public static void main(String[] args) {
    int makeProcess = 0;
    int cheOrder = 0;
    int bulOrder = 0;
    int dubOrder = 0;
    int sec;

    CircularQueue queue = new CircularQueue();
    Random random = new Random();

    for (sec = 0; sec < 3600; sec++) {
      if (sec % CUS_COME_TERM == 0) {
        switch (random.nextInt(10) % 3) {
          case CHE_BUR:
            queue.enqueue(CHE_TERM);
            cheOrder++;
            break;
          case BUL_BUR:
            queue.enqueue(BUL_TERM);
            bulOrder++;
            break;
          case DUB_BUR:
            queue.enqueue(DUB_TERM);
            dubOrder++;
            break;
        }
      }
      if (makeProcess <= 0 && !queue.isEmpty()) {
        makeProcess = queue.dequeue();
      }
      makeProcess--;
    }

    System.out.println("Simulation Report!");
    System.out.println(" - Cheese burger : " + cheOrder);
    System.out.println(" - Bulgogi burger : " + bulOrder);
    System.out.println(" - Double burger : " + dubOrder);
    System.out.println(" - Waiting room size : " + queue.QUEUE_LENGTH);
  }
}
