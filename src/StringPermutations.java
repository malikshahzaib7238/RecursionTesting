import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }
        permute(str.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int currentIndex, List<String> result) {
        if (currentIndex == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);
            permute(chars, currentIndex + 1, result);
            swap(chars, currentIndex, i); // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";  // You can take input via command-line or other methods
        List<String> permutations = generatePermutations(input);
        System.out.println("Permutations of " + input + ":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
