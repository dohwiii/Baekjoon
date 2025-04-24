import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);  // 정렬 필수

        int answer = 5;  // 최대로 5개를 추가할 수도 있으므로 초기값은 5

        int left = 0;
        for (int right = 0; right < N; right++) {
            // 연속 범위가 5를 넘으면 왼쪽 포인터 이동
            while (arr[right] - arr[left] >= 5) {
                left++;
            }

            int inRange = right - left + 1;       // 현재 구간 안에 이미 있는 수
            answer = Math.min(answer, 5 - inRange); // 최소 추가할 숫자 수
        }

        System.out.println(answer);
    }
}