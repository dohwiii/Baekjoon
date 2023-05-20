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
            int N = Integer.parseInt(br.readLine());
            int[] arr = Stream.of(String.valueOf(N).
                    split("")).mapToInt(Integer::parseInt)
                    .toArray();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i == j)
                        continue;
                    int temp = swap(i, j, arr);
                    if (temp == 0) {
                        continue;
                    }
                    max = Math.max(max, temp);
                    min = Math.min(min, temp);

                }
            }
            min = Math.min(N, min);
            max = Math.max(N, max);
            System.out.println("#" + index + " " + min + " " + max);
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