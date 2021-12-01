/**
 * Implementing the process of block chain mining and proof of work
 *
 * @author Nam Le
 * @version August 02 2020
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        for (int i = 0; i < 10; i++) {
            blockchain.mine(new Block("Block " + Integer.toString(i + 1)));
            System.out.println("--------------------------------");
        }

        while (blockchain.head != null) {
            System.out.println(blockchain.head);
            blockchain.head = blockchain.head.next;
            System.out.println("--------------------------------");
        }
    }
}
 