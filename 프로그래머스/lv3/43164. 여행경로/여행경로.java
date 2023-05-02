import java.util.*;

class Solution {
    static boolean[] visited;
    ArrayList<String> allRoute;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length]; //행 길이
        allRoute = new ArrayList<>();
        String[] answer = {};
        
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(allRoute);
        answer= allRoute.get(0).split(" ");
        
        return answer; 
    }
    public void dfs(String start, String route, String[][] tickets, int cnt)
    {
        if(cnt == tickets.length)
        {
            allRoute.add(route);
        }
        
        for(int i=0; i<tickets.length; i++)
        {
            if(start.equals(tickets[i][0]) && !visited[i])
            {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
                
            }
        }
    }
}