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
                String[] strArr = str.substring(1, str.length() - 1).split(",");
                for (String s : strArr) {
                    queue.offer(s);
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
