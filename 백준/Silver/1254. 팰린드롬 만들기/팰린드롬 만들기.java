import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        int len = 0;
        int minLen = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i, str.length()))) {
                minLen += i;
                break;
            }
        }
        System.out.println(minLen);

    }

    private static boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}