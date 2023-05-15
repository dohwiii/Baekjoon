import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < T; i++)
        {
            String str = br.readLine();
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if(alphabet.charAt(j) != str.charAt(j))
                    break;
                if (alphabet.charAt(j) == str.charAt(j)) {
                    count++;
                }
            }
            System.out.println("#" + (i + 1) + " " + count);
        }
    }
}