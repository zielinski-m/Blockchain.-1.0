import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timestamp;
    int nonce;

    public Block( String previousHash, String data) throws NoSuchAlgorithmException {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = Utility.blockchainHash(this);
    }

    public Block( String previousHash, String data, int nonce) throws NoSuchAlgorithmException {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.nonce = nonce;
        this.hash = Utility.blockchainHash(this);
    }

    public void mineBlock() throws NoSuchAlgorithmException {
        String findHash = new String(hash);
        nonce = 0;
        hash = "";

        while (!hash.equals(findHash)) {
            hash = Utility.blockchainHash(this);
            nonce++;

        }
        System.out.println("Mined: " + hash + "Nonce: " + nonce);
    }
}