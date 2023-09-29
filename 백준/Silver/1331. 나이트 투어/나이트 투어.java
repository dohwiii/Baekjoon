import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1, 2, -2, 2, -2};
    static String[][] board = new String[6][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 6;
        Map<String, Pos> map = new HashMap<>();
        boolean[][] visited = new boolean[6][6];

        for (int i = 0; i < 6; i++) {
            char alp = 'A';
            for (int j = 0; j < 6; j++) {
                String value = String.valueOf(alp) + num;
                board[i][j] = value;
                map.put(value, new Pos(i, j));
                alp++;
            }
            num--;
        }
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < 36; i++) {
            String input = br.readLine();
            queue.add(input);
        }
        String s = queue.poll();
        String start = s;
        String end = "";

        while (!queue.isEmpty()) {
            boolean isPossible = false;
            Pos now = map.get(s);
            end = queue.poll();
            Pos next = map.get(end);

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6) {
                    if (!visited[nx][ny]) {
                        if (next.x == nx && next.y == ny) {
                            visited[nx][ny] = true;
                            isPossible = true;
                            break;
                        }
                    }
                }

            }
            s = end;
            if (!isPossible) {
                System.out.println("Invalid");
                System.exit(0);

            }
        }
        boolean isPossible = false;
        Pos now = map.get(start);
        Pos next = map.get(end);
        for (int i = 0; i < 8; i++) {
            int nx = next.x + dx[i];
            int ny = next.y + dy[i];

            if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6) {
                if (!visited[nx][ny]) {
                    if (now.x == nx && now.y == ny) {
                        visited[nx][ny] = true;
                        isPossible = true;
                        break;
                    }
                }
            }
        }
        if (isPossible) {
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");

        }
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
