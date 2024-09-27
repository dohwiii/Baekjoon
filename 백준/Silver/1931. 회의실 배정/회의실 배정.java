
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Time> times;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        times = new ArrayList<>();
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, e));
        }
        // 끝나는 시간 오름차순 (먼저 끝나는 순으로)
        Collections.sort(times, new Comparator<>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        int t = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            Time now = times.get(i);
            if (t > now.start) {
                continue;
            }
            ans++;
            t = now.end;
        }
        System.out.println(ans);
    }


}
class Time {
    int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}