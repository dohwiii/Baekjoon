import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());    //횟수
            char[] arr = W.toCharArray();
            int[] prev = new int[26];   //이전 인덱스
            int[] prevK = new int[26];   //이전 인덱스
            int[] next = new int[W.length()];   //다음 인덱스
            int[] cntArr = new int[26];   //다음 인덱스
            int min = 10_001, max = 0;

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                cntArr[index]++;

                if (cntArr[index] == 1) {   //처음 등장
                    prevK[index] = i;
                }
                else {  //이미 등장한 적 있음
                    next[prev[index]] = i;  //이전에 등장한 인덱스의 다음 출현 인덱스는 지금 여기!
                }
                prev[index] = i;

                if (cntArr[index] == K) {
                    int len = i - prevK[index] + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
                else if (cntArr[index] > K) {
                    prevK[index] = next[prevK[index]];  //한칸 뒤로 땡기기
                    int len = i - prevK[index] + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if (max == 0 || min == 10_001) {
                sb.append("-1");
            }
            else {
                sb.append(min + " " + max);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}