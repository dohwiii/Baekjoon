import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0], min = arr[0];
        int maxLen = 0;
        int[] cnt = new int[11];    //1 ~ 10까지 등장 횟수
        int s = 0;

        for (int e = 0; e < N; e++) {
            if (max < arr[e]) {
                max = arr[e];
            }
            else if (min > arr[e]) {
                min = arr[e];
            }
            cnt[arr[e]]++;

            if (max - min <= 2) {
                maxLen = Math.max(maxLen, e - s + 1);
            }
            else {  //s 증가
                while (max - min > 2) {
                    cnt[arr[s]]--;
                    s++;
                    if (cnt[min] == 0) {    //줄인게 min이라면 다음 최솟값 탐색
                        int idx = min + 1;
                        while (idx < N && cnt[idx] == 0) {
                            idx++;
                        }
                        min = idx;

                    }
                    else if (cnt[max] == 0) {   //줄인게 max라면
                        int idx = max - 1;
                        while (idx > 1 && cnt[idx] == 0) { //포함안되어있다면 찾을 때까지 줄이기
                            idx--;
                        }
                        max = idx;
                    }
                }
            }
        }
        System.out.println(maxLen);



    }
}