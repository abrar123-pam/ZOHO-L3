import java.util.Random;
import java.util.UUID;

public class UniqueIDGenerator {

    public String generateUniqueID(int length) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Random random = new Random();

        StringBuilder sb = new StringBuilder(uuid);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }

        return sb.substring(0, length);
    }

}

