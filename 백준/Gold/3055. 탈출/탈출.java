import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static char[][] map;
    static int[][] mapNum;
    static boolean[][] visited;
    static int result;
    static Queue<Coordinate> wqueue;
    static Queue<Coordinate> hqueue;
    static Coordinate start, end;
    static boolean isPossible;
    static ArrayList<Coordinate> water;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        mapNum = new int[R][C];
        wqueue = new LinkedList<>();
        hqueue = new LinkedList<>();
        result = 0;
        isPossible = false;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == '.') {
                    mapNum[i][j] = 0;
                }
                else if (map[i][j] == '*')
                {
                    wqueue.offer(new Coordinate(i, j, 0));
                    visited[i][j] = true;
                    mapNum[i][j] = 1;
                }
                else if (map[i][j] == 'S')
                {
                    hqueue.offer(new Coordinate(i, j, 0));
                    visited[i][j] = true;
                    mapNum[i][j] = 1;
                }
                else if (map[i][j] == 'D')
                {
                    mapNum[i][j] = 2;
                    end = new Coordinate(i, j);
                }
                else if (map[i][j] == 'X')
                {
                    mapNum[i][j] = 1;
                }


            }
        }
        BFS();

        if (isPossible)
        {
            System.out.println(result);
        }
        else
            System.out.println("KAKTUS");
    }

    public static void BFS()
    {
        while (!wqueue.isEmpty() || !hqueue.isEmpty())
        {
            int size = wqueue.size();
            if (size > 0)
            {
                while (size-- > 0)
                {
                    Coordinate now = wqueue.poll();

                    for (int i = 0; i < 4; i++)
                    {
                        int x1 = now.x + dx[i];
                        int y1 = now.y + dy[i];

                        if (x1 >= 0 && x1 < R && y1 >= 0 && y1 < C)
                        {
                            if (!visited[x1][y1])
                            {
                                if (mapNum[x1][y1] == 0)
                                {
                                    mapNum[x1][y1] = 1;
                                    wqueue.add(new Coordinate(x1, y1, now.count + 1));
                                    visited[x1][y1] = true;
                                }

                            }
                        }
                    }
                }

            }
            int size2 = hqueue.size();
            if (size2 > 0)
            {
                while (size2-- > 0)
                {
                    Coordinate now2 = hqueue.poll();

                    for (int i = 0; i < 4; i++)
                    {
                        int x1 = now2.x + dx[i];
                        int y1 = now2.y + dy[i];

                        if (x1 >= 0 && x1 < R && y1 >= 0 && y1 < C)
                        {
                            if (!visited[x1][y1])
                            {
                                if (mapNum[x1][y1] == 2)
                                {
                                    isPossible = true;
                                    result = now2.count + 1;
                                    return;
                                }
                                if (mapNum[x1][y1] == 0)
                                {
                                    mapNum[x1][y1] = 1;
                                    hqueue.add(new Coordinate(x1, y1, now2.count + 1));
                                    visited[x1][y1] = true;
                                }
                            }
                        }
                    }
                }

            }

        }

    }
}
class Coordinate
{
    int x, y, count;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Coordinate(int x, int y, int count) {

        this.x = x;
        this.y = y;
        this.count = count;
    }
}