import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line {
        int s, e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Line[] lines = new Line[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
//            start = Math.min(start, s);
//            end = Math.max(end, e);
            max = Math.max(max, e);
        }
        int start = 0, end = 1;

        StringBuilder sb = new StringBuilder();
        boolean isFound = false;
        while (start <= max && end <= max && start < end) {
            long len = checkLength(start, end, lines);
            if (len == K) {
                isFound = true;
                sb.append(start + " " + end);
                break;
            } else if (len > K) {
                start++;
                if (start == end) {
                    end = start + 1;
                }
            } else if (len < K) {
                end++;
            }
        }
        if (!isFound) {
            System.out.println("0 0");
            return;
        }
        System.out.println(sb);


    }

    public static long checkLength(int start, int end, Line[] lines) {
        long length = 0;
        for (int i = 0; i < lines.length; i++) {
            int s = lines[i].s;
            int e = lines[i].e;
            int overlap = Math.max(0, Math.min(e, end) - Math.max(s, start));
            length += overlap;
        }
        return length;
    }
}