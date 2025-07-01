
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] cars = new String[N];
        for (int i = 0; i < N; i++) {
            cars[i] = br.readLine();
        }
        Set<String> seen = new HashSet<>();
        int pointer = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String out = br.readLine();
            seen.add(out);  //나간 차량 방문기록
            if (out.equals(cars[pointer])) {    //순서가 맞는 차량
                pointer++;
            }
            while (pointer < N && seen.contains(cars[pointer])) {
                pointer++;
                ans++;
            }
        }
        System.out.println(ans);


    }
}