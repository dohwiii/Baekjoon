import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] computers) {
        visited= new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j)
                    continue;
                if(computers[i][j] == 1)
                {
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
            }
        }
        int answer=0;
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    public void dfs(int node)
    {
        if(visited[node])
            return;
        
        visited[node]=true;
        
        for(int next : list[node])
        {
            dfs(next);
        }
    }
}