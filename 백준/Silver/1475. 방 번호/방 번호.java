import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //방 번호
        String N = br.readLine();
        int[] number = new int[10];

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            if (num == 6) {
                number[9]++;
            }
            else {
                number[num]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (max < number[i]) {
                max = number[i];
            }
        }
        int nine = number[9] / 2;

        if (number[9] % 2 == 1) {
            nine++;
        }
        max = Math.max(max, nine);
        System.out.println(max);
    }
}