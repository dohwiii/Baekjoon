
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int one = 0, two = 0;
        int lastTime = 0;
        int lastTime1 = 0, lastTime2 = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);

            if (one > two) {
                lastTime1 += (hour * 60 + min - lastTime);
            } else if (one < two) {
                lastTime2 += (hour * 60 + min - lastTime);
            }
            lastTime = hour * 60 + min;
            if (team == 1) {
                one++;
            } else {
                two++;
            }
        }
        if (one > two) {
            lastTime1 += (48 * 60 - lastTime);
        }
        else if (one < two) {
            lastTime2 += (48 * 60 - lastTime);
        }
        StringBuilder sb = new StringBuilder();
        int hour1 = lastTime1 / 60;
        int min1 = lastTime1 % 60;
        String str = String.format("%02d:%02d", hour1, min1);
        String str2 = String.format("%02d:%02d", lastTime2 / 60, lastTime2 % 60);
        sb.append(str);
        sb.append("\n");
        sb.append(str2);
        System.out.println(sb);

    }
}