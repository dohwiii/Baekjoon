import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> menShort = new PriorityQueue<>();   // 남자: 키 작은 여자 선호
        PriorityQueue<Integer> menTall = new PriorityQueue<>();    // 남자: 키 큰 여자 선호
        PriorityQueue<Integer> womenShort = new PriorityQueue<>(); // 여자: 키 작은 남자 선호
        PriorityQueue<Integer> womenTall = new PriorityQueue<>();  // 여자: 키 큰 남자 선호
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 남자 입력
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (h < 0) menShort.add(-h);  // 키 작은 여자 선호
            else menTall.add(h);         // 키 큰 여자 선호
        }
        st = new StringTokenizer(br.readLine());
        // 여자 입력
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (h < 0) womenShort.add(-h);  // 키 작은 남자 선호
            else womenTall.add(h);         // 키 큰 남자 선호
        }

        int ans = 0;
        //키 작은 여자 선호 & 키 큰 남자 선호
        while (!menShort.isEmpty() && !womenTall.isEmpty()) {
            if (menShort.poll() > womenTall.peek()) {
                ans++;
                womenTall.poll();
            }
        }
        //키가 큰 여자 선호 & 키가 작은 남자 선호
        while (!menTall.isEmpty() && !womenShort.isEmpty()) {
            if (menTall.peek() < womenShort.poll()) {
                ans++;
                menTall.poll();
            }
        }

        System.out.println(ans);


    }
}