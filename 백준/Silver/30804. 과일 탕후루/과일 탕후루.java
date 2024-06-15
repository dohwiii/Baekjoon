
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] num = new int[10]; ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int result = 0;

        while (left < N) {
            while (right < N) {
                num[fruits[right]]++;
                right++;

                //종류가 2개 이상이라면
                if (!checkCnt()) {
                    right--;
                    num[fruits[right]]--;

                    break;
                }
            }
            result = Math.max(result, right - left);
            num[fruits[left]]--;
            left++;
        }
        System.out.println(result);


    }

    public static boolean checkCnt() {
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            if (num[i] > 0) {
                cnt++;
            }
            if (cnt > 2) {
                return false;
            }
        }
        return true;
    }


}