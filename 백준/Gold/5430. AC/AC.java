import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            boolean isPossible = true;
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Deque<String> queue = new ArrayDeque<>();
            if (str.length() > 2) {
                StringBuilder num = new StringBuilder();
                for (int i = 1; i < str.length() - 1; i++) {
                    char ch = str.charAt(i);
                    if (ch == ',') {
                        queue.offer(num.toString());
                        num.setLength(0); // 초기화
                    } else {
                        num.append(ch);
                    }
                }
                // 마지막 숫자 추가
                if (num.length() > 0) {
                    queue.offer(num.toString());
                }
            }

            boolean direction = true;  //true: 왼쪽 -> 오른쪽 / false: 오른쪽 -> 왼쪽
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    direction = !direction; //방향 전환
                }
                else if (c == 'D') {
                    if (queue.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    if (direction) {    //정방향
                        queue.removeFirst();
                    }
                    else {
                        queue.removeLast();
                    }
                }
            }
            if (!isPossible) {
                sb.append("error\n");
                continue;
            }
            if (queue.isEmpty()) {
                sb.append("[]\n");
                continue;
            }
            sb.append("[");
            if (direction) {
                while (queue.size() > 1) {
                    sb.append(queue.pollFirst() + ",");
                }
                sb.append(queue.pollFirst() + "]");
            }
            else {
                while (queue.size() > 1) {
                    sb.append(queue.pollLast() + ",");
                }
                sb.append(queue.pollLast() + "]");
            }

            sb.append("\n");

        }
        System.out.println(sb);
    }

}
