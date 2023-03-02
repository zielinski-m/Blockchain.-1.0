import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static List<Block> blockchain = new ArrayList<>();
    public static void main(String[] args) throws NoSuchAlgorithmException {

        blockchain.add(new Block("0", "First Blockchain"));
        System.out.println(blockchain.get(0).hash);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "Second Block", 18));
        System.out.println(blockchain.get(1).hash);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "Third Block", 12365));
        System.out.println(blockchain.get(2).hash);

        blockchain.get(2).mineBlock();
    }

    private static boolean isChainValid() throws NoSuchAlgorithmException {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(Utility.blockchainHash(currentBlock))) {
                System.out.println("Hash invalid");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous hash invalid");
                return false;
            }
        }
        return true;
    }

}


