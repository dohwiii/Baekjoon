import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int index = 1;

        while (T-- > 0) {
            String str = br.readLine();
            boolean isPossible = false;
            int winCnt = 0; //이긴 적
            int remainGame = 15 - str.length(); //남은 판 수

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'o') {
                    winCnt++;
                }
            }
            if (remainGame >= 8 - winCnt) {
                isPossible = true;
            }
            if (isPossible) {
                System.out.println("#" + index + " " + "YES");
            }
            else
                System.out.println("#" + index + " " + "NO");
            index++;
        }

    }

    public static int swap(int a, int b, int[] arr) {
        int[] newArr = arr.clone();

        int temp = newArr[a];
        newArr[a] = newArr[b];
        newArr[b] = temp;

        if (newArr[0] == 0) {
            return 0;
        }

        String[] temp2 = Arrays.stream(newArr).mapToObj(String::valueOf).toArray(String[]::new);
        String result = String.join("", temp2);
        return Integer.parseInt(result);
    }
}