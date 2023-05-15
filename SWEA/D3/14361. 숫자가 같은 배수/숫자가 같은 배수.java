import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String nStr = String.valueOf(N);
            int K = 2;
            boolean isPossible = false;

            while (true) {
                int multiple = K * N;
                char[] multipleArr = numSplit(multiple);
                if (nStr.length() != String.valueOf(multiple).length()) {
                    break;
                }

                if (checkCondition(multipleArr, nStr)) {
                    isPossible = true;
                    break;
                }
                else
                    K++;
            }
            if (isPossible) {
                System.out.println("#" + (i + 1) + " " + "possible");
            }
            else
                System.out.println("#" + (i + 1) + " " + "impossible");

        }
    }

    public static boolean checkCondition(char[] multipleArr, String nStr) {
        int count = 0;
        for (int j = 0; j < multipleArr.length; j++) {
            for (int k = 0; k < nStr.length(); k++) {
                if (multipleArr[j] == nStr.charAt(k)) {
                    count++;
                    break;
                }
            }
        }
        return count == multipleArr.length;
    }

    public static char[] numSplit(int num) {
        String numLength = String.valueOf(num);
        char[] splitArr = new char[numLength.length()];
        int index = numLength.length() - 1;
        while (num > 0) {
            splitArr[index] = (char) (num % 10 + '0');
            num = num / 10;
            index--;
        }
        return splitArr;
    }
}