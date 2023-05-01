import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        int N = maps.length; //행
        int M = maps[0].length; //열
        boolean[][] visited = new boolean[N][M];
        boolean arrive = false;

        Queue<Pos> queue=new LinkedList<>();
        queue.offer(new Pos(0,0,0));
        visited[0][0] = true;
        
        while(!queue.isEmpty())
        {
            Pos now = queue.poll();
            
            if(now.x == N-1 && now.y == M-1)
            {
                answer = now.cnt + 1;
                arrive = true;
                break;
            }
            
            for(int i=0; i<4; i++)
            {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx< N && ny>=0 && ny<M)
                {
                    if(!visited[nx][ny] && maps[nx][ny] == 1)
                    {
                        queue.offer(new Pos(nx, ny, now.cnt+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if(arrive)
            return answer;
        else
            return -1;
    }
}
class Pos
{
    int x,y,cnt;
    public Pos(int x, int y, int cnt)
    {
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}