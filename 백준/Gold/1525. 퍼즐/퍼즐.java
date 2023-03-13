import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String start;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = "";
        map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String k = st.nextToken();
                if (k.equals("0")) {
                    k = "9";
                }
                start = start + k;
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        map.put(start, 0);

        while (!queue.isEmpty())
        {
            String now = queue.poll();
            int index = now.indexOf("9"); //9의 인덱스를 반환 1번쨰
            int x = index / 3;
            int y = index % 3;

            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                int move = x1 * 3 + y1; //(0,0), (0,2), (1,1)

                if (x1 >= 0 && y1 >= 0 && x1 < 3 && y1 < 3)
                {
                    StringBuilder next = new StringBuilder(now);
                    char temp = next.charAt(move); //move번쨰의 문자를 char 변환
                    next.setCharAt(index, temp);
                    next.setCharAt(move, '9');
                    String nextStr = next.toString();

                    if (!map.containsKey(nextStr)) {
                        queue.add(nextStr);
                        map.put(nextStr, map.get(now) + 1);
                    }
                }
            }
        }
        if (map.containsKey("123456789")) {
            System.out.println(map.get("123456789"));
        }
        else
            System.out.println(-1);


    }

}