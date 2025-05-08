import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] men = new int[N];
        int[] women = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            men[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            women[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(men);
        Arrays.sort(women);
        int s = 0, e = N - 1;
        int ans = 0;

        while (s < N && e >= 0) {
            //키가 큰 여성 선호 & 키가 작은 남자 선호
            if (men[s] > 0 && women[e] < 0) {
                if (men[s] < Math.abs(women[e])) {
                    ans++;
                    s++;
                }
                e--;

            } else if (men[s] < 0 && women[e] > 0) {  //키가 작은 여성 선호 & 키가 큰 남성 선호
                if (Math.abs(men[s]) > women[e]) {
                    ans++;
                    s++;
                }
                e--;
            } else if (men[s] < 0 && women[e] < 0) {  //키가 작은 여성 선호 & 키가 작은 남성 선호
                s++;
            } else if (men[s] > 0 && women[e] > 0) {  //키가 큰 여성 선호 & 키가 큰 남성 선호
                e--;
            }
        }
        System.out.println(ans);

    }
}