import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        String name = FileGenerator.generateRandomString() + File.separator + FileGenerator.generateRandomString(0,10) + ".txt";
        File file = new File(name);
        if (file.getParentFile().mkdirs() && file.createNewFile())
            System.out.println("Directory and file are created here: " + name);
        else
            System.out.println("Can't create directory and file in " + name);
    }

    private static String generateRandomString(int minLen, int maxLen) {
        String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int randLen = minLen + random.nextInt(maxLen - minLen + 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < randLen; i++)
            result.append(letters.charAt(random.nextInt(letters.length())));
        return new String(result);
    }
    private static String generateRandomString(){
        return FileGenerator.generateRandomString(3, 20);
    }
}
