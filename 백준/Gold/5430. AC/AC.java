import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String command = br.readLine(); //수행할 함수
            int n = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수

            String numStr = br.readLine(); //[ , , , ] 형태로 입력

            Deque<Integer> queue = new ArrayDeque<>();
            boolean direction = true; //true : 정방향 / 역방향 : false
            boolean isPossible = true;

            numStr = numStr.substring(1, numStr.length() - 1); //양괄호 빼기
            StringTokenizer st = new StringTokenizer(numStr, ",");
            for (int j = 0; j < n; j++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') { //뒤집기
                    direction = !direction;
                }
                else if (command.charAt(j) == 'D') { //첫번째 수 버리기
                    if (queue.isEmpty()) {
                        isPossible = false;
                        break;
                    } else {
                        if (direction) {
                            queue.pollFirst();
                        } else {
                            queue.pollLast();
                        }
                    }
                }
            }
            if (!isPossible) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (queue.size() > 1) {
                    if (direction) {
                        sb.append(queue.pollFirst());
                    } else if (!direction) {
                        sb.append(queue.pollLast());
                    }
                    sb.append(",");
                }
                if (queue.size() == 0) {
                    sb.append("]\n");
                }
                else
                {
                    sb.append(queue.pollFirst()).append("]\n");
                }
           }
        }
        System.out.println(sb);
    }
}