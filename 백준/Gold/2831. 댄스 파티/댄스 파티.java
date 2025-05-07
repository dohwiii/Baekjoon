import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> menShort = new ArrayList<>();   // 남자: 키 작은 여자 선호
        List<Integer> menTall = new ArrayList<>();    // 남자: 키 큰 여자 선호
        List<Integer> womenShort = new ArrayList<>(); // 여자: 키 작은 남자 선호
        List<Integer> womenTall = new ArrayList<>();  // 여자: 키 큰 남자 선호
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

        Collections.sort(menShort);
        Collections.sort(womenShort);
        Collections.sort(menTall);
        Collections.sort(womenTall);
        int ans = 0;
        int i = 0, j = 0;
        //키 작은 여자 선호 & 키 큰 남자 선호
        while (i < menShort.size() && j < womenTall.size()) {
            if (menShort.get(i) > womenTall.get(j)) {
                ans++;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        i = 0; j = 0;
        //키가 큰 여자 선호 & 키가 작은 남자 선호
        while (i < menTall.size() && j < womenShort.size()) {
            if (menTall.get(i) < womenShort.get(j)) {
                ans++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }


        System.out.println(ans);


    }

}