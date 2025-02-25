import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        
        // 가능한 5원 동전의 최대 개수부터 0까지 탐색
        for (int i = n / 5; i >= 0; i--) {
            int remain = n - i * 5;
            if (remain % 2 == 0) { // 남은 금액이 2원으로 딱 맞게 떨어지면
                answer = i + (remain / 2);
                break;
            }
        }
        System.out.println(answer);
    }
}