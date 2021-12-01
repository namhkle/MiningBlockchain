
/**
 * Implementing the process of block chain mining and proof of work
 *
 * @author Nam Le
 * @version August 02 2020
 */

import java.util.*;

public class Blockchain {
    private int difficulty = 220;
    private int maxNonce = (int) (Math.pow(2, 32));
    private int target = (int) (Math.pow(2, 256 - difficulty));
    Block block = new Block("Genesis");
    public Block head = block;

    public void add(Block block) {
        block.previousHash = this.block.hash();
        block.blockNo = this.block.blockNo + 1;
        this.block.next = block;
        this.block = this.block.next;
    }

    public void mine(Block block) {
        long startTime = new Date().getTime();
        for (int n = 0; n < this.maxNonce; n++) {
            if (block.hash().compareTo(String.valueOf(this.target)) <= 0) {
                this.add(block);
                long endTime = new Date().getTime();
                System.out.println("Successful block when n = " + n + " Target is: " + this.target);
                long timeTaken = (int) (endTime - startTime);
                System.out.println("Time used to find a vaild New block: " + timeTaken);
                System.out.println(block);
                break;
            } else {
                block.nonce++;
            }
        }
    }
}
