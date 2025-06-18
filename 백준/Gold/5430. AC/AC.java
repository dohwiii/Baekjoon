import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        a:
        while (T-- > 0) {
            String p = br.readLine();   //함수
            int N = Integer.parseInt(br.readLine());    //수의 개수
            String arr = br.readLine();
            boolean isLeft = true;
            ArrayDeque<String> queue = new ArrayDeque<>();
            if (N > 0) {
                String[] tempArr = arr.substring(1, arr.length() - 1).split(",");    //1,2,3,4
                for (String s : tempArr) {
                    queue.offer(s);
                }
            }

            for (char c : p.toCharArray()) {
                if (c == 'R') { //뒤집기
                    isLeft = !isLeft;
                }
                else if (c == 'D') {    //첫 번째 수 버리기
                    if (queue.isEmpty()) {
                        sb.append("error\n");
                        continue a;
                    }
                    if (isLeft) {
                        queue.pollFirst();
                    } else {
                        queue.pollLast();
                    }
                }
            }
            sb.append("[");
            if (!queue.isEmpty()) {
                if (isLeft) {
                    while (queue.size() > 1) {
                        sb.append(queue.poll());
                        sb.append(",");
                    }
                    sb.append(queue.poll());
                } else {
                    while (queue.size() > 1) {
                        sb.append(queue.pollLast());
                        sb.append(",");
                    }
                    sb.append(queue.poll());
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}