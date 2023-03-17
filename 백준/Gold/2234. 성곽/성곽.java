import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] castle;
    static boolean[][] visited;
    static int[] direction;
    static Coordinate[] list;
    static ArrayList<Integer> space;
    static Map<Coordinate, ArrayList<Coordinate>> map;
    static int[] area;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //7
        M = Integer.parseInt(st.nextToken()); //4
        castle = new int[M][N]; //4x7
        visited = new boolean[M][N];
        direction = new int[4];
        list = new Coordinate[4];
        map = new HashMap<>();
        space = new ArrayList<>();
        area = new int[2501];

        list[0] = new Coordinate(0, -1);
        list[1] = new Coordinate(-1, 0);
        list[2] = new Coordinate(0, 1);
        list[3] = new Coordinate(1, 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());

                ArrayList<Integer> indexList2 = Bitmask(castle[i][j]); //2
                ArrayList<Coordinate> indexList = new ArrayList<>();
                for (int k : indexList2) {
                    indexList.add(list[k]);
                }
                map.put(new Coordinate(i, j), indexList);
            }
        }
        int room = 0;
        int num = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int x = BFS(i, j, num++);
                    space.add(x);
                    if (max < x) {
                        max = x;
                    }
                    room++;
                }
            }
        }
        System.out.println(room);
        System.out.println(max);
        System.out.println(maxRoom());
    }

    public static ArrayList<Integer> Bitmask(int x)
    {
        ArrayList<Integer> indexList = new ArrayList<>();
        String str = String.format("%04d", Integer.parseInt(Integer.toBinaryString(x))); //1011
        for (int k = 0; k < str.length(); k++) {
            if ((x & (1 << k)) != (1 << k)) {
                indexList.add(k);
            }
        }
        return indexList;
    }

    public static int maxRoom() {
        int sum = 0;
        int[] y = { 0, 1, 0, -1 };
        int[] x = { 1, 0, -1, 0 };
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nr = i + y[k];
                    int nc = j + x[k];

                    if ((0 <= nr && nr < M) && (0 <= nc && nc < N) && castle[i][j] != castle[nr][nc]) {
                        sum = Math.max(sum, area[castle[i][j]] + area[castle[nr][nc]]);
                    }
                }
            }
        }
        return sum;
    }

    public static int BFS(int x, int y, int num)
    {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y, 0));
        visited[x][y] = true;
        int count = 1;
        castle[x][y] = num;
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty())
        {
            Coordinate now = queue.poll();
            area[num]++;
            for(Coordinate key : map.keySet())
            {
                if (now.x == key.x && now.y == key.y)
                {
                    ArrayList<Coordinate> value = map.get(key);
                    for (int i = 0; i < value.size(); i++)
                    {
                        int x1 = now.x + value.get(i).x;
                        int y1 = now.y + value.get(i).y;

                        if (x1 >= 0 && y1 >= 0 && x1 < M && y1 < N)
                        {
                            if (!visited[x1][y1])
                            {
                                castle[x1][y1] = num;
                                queue.add(new Coordinate(x1, y1));
                                count++;
                                visited[x1][y1] = true;
                            }
                        }
                    }
                }

            }
        }
        return count;
    }
}

class Coordinate {
    int x, y, count;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinate(int x, int y, int count) {

        this.x = x;
        this.y = y;
        this.count = count;
    }
}