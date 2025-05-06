import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr = new int[500_000];
    static int s = 1, e = 1;
    static long total = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            String str = br.readLine();
            if (str.length() == 1) {    //2 입력
                //연산
                long result = calculate();
                sb.append(result + "\n");
            }
            else {  //1 입력 -> 추가
                int num = Integer.parseInt(str.substring(2, str.length()));
                total += num;
                arr[e] = num;  //값 추가
                e++;
            }

        }
        for (int i = s; i < e; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

    public static long calculate() {
        int len = e - s; //현재 값이 있는 길이
        int divide = len / 2;   //앞쪽개수
        int backCnt = len - divide; //뒤쪽개수
        long tempSum = 0;
        int tempIndex = 0;
        while (tempIndex < divide) {
            tempSum += arr[s + tempIndex];
            tempIndex++;
        }
        long frontSum = tempSum;
        long backSum = total - frontSum;

        if (frontSum <= backSum) {   //front 삭제 -> s 늘리기
            s += divide;
            total -= frontSum;
            return frontSum;
        }
        else {  //back 삭제 -> e 줄이기
            e -= backCnt;
            total -= backSum;
            return backSum;
        }
    }
}