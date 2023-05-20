import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int index = 1;

        while (T-- > 0) {
            int[] lightBulb = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                lightBulb[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = lightBulb[0]; i < lightBulb[1]; i++) {
                for (int j = lightBulb[2]; j < lightBulb[3]; j++) {
                    if (i == j) {
                        count++;
                    }
                }
            }
            System.out.println("#" + index + " " + count);
            index++;
        }

    }
}