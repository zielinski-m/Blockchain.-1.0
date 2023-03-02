import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {

    public static String blockchainHash(Block b) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = md.digest(getByteArray(b));

        return hexToString(encodedHash);
    }

    private static String hexToString(byte[] hex) {
        BigInteger number = new BigInteger(1, hex);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32) {
            hexString.insert(0, "0");
        }
        return hexString.toString();
    }

    private static byte[] getByteArray(Block b) {
        String str = new String(b.data + b.previousHash + Long.toString(b.timestamp) + Integer.toString(b.nonce));
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
