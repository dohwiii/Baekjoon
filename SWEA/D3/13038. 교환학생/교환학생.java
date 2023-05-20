import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int index = 1;

        while (T-- > 0) {
            int classCnt = Integer.parseInt(br.readLine());
            int[] week = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 8; i++) {
                week[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 1; i < 8; i++) {
                if (week[i] == 1) {
                    result = classDayStart(classCnt, i, week);
                    min = Math.min(min, result);
                }
            }
            System.out.println("#" + index + " " + min);
            index++;
        }

    }

    public static int classDayStart(int N, int start, int[] week) {
        int classCnt = 0;
        int minDays = 0;
        int index = start;

        while (N != classCnt) {
            if (index > 7) {
                index = index % 7;
            }
            if (week[index] == 1) {
                classCnt++;
            }
            minDays++;
            index++;
        }
        return minDays;
    }
}