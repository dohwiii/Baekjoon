import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dishes;
    static int[] eat;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시의 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        dishes = new int[N]; //접시
        eat = new int[d + 1]; //초밥 가짓수
        int result = 1;

        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine()); //초밥 종류 번호
        }
        eat[c]++;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = N - k; i < N; i++) {
            if (eat[dishes[i]] == 0) { //큐에 아직 없다면 result 증가
                result++;
            }
            eat[dishes[i]]++; //먹은 횟수 증가
            queue.offer(dishes[i]);
        }
        int cnt = result;
        for (int i = 0; i < N - 1; i++) {
            int now = queue.poll();
            eat[now]--;
            if (eat[now] == 0) {
                cnt--;
            }
            queue.add(dishes[i]);
            if (eat[dishes[i]] == 0) {
                cnt++;
            }
            eat[dishes[i]]++;

            if (cnt > result) {
                result = cnt;
            }
        }
        System.out.println(result);

    }
}