import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int answer;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];
        
        fill(rectangle);
        dfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        return (int)answer/2;
    }
    public void fill(int[][] rectangle)
    {
        for(int i=0; i<rectangle.length; i++)
        {
            int[] rec = rectangle[i];
            int x1 = 2*rec[0];
            int y1 = 2*rec[1];
            int x2 = 2*rec[2];
            int y2 = 2*rec[3];
            for(int j=x1; j<=x2; j++)
            {
                for(int k=y1; k<=y2; k++)
                {
                    if(map[j][k]==2)
                        continue;
                    map[j][k]=2;
                    if(j==x1 || j==x2 || k==y1 || k==y2)
                        map[j][k]=1;
                }
            }
        }
    }
    public void dfs(int characterX, int characterY, int itemX, int itemY)
    {
        Queue<Pos> queue=new LinkedList<>();
        queue.add(new Pos(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty())
        {
            Pos now = queue.poll();
            if(now.x == itemX && now.y == itemY)
            {
                answer = now.cnt;
                return;
            }
            
            for(int i=0; i<4; i++)
            {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                
                if(nx>=0 && nx<101 && ny>=0 && ny<101)
                {
                    if(!visited[nx][ny] && map[nx][ny] == 1)
                    {
                        visited[nx][ny] = true;
                        queue.add(new Pos(nx, ny, now.cnt+1));
                    }
                }
            }
        }
        
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