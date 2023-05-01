class Solution {
    static boolean[] visited;
    static int answer = 0;
    static boolean arrive;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        arrive = false;
        
        bfs(begin, target, words, 0);
        
        if(arrive)
            return answer;
        else
            return 0;
    }
    public void bfs(String begin, String target, String[] words, int count)
    {
        if(begin.equals(target))
        {
            answer = count;
            arrive = true;
            return;
        }
        for(int i=0; i<words.length; i++)
        {
            if(!visited[i])
            {
                String now = words[i];
                int cnt = 0;
                for(int j=0; j<begin.length(); j++)
                {
                    if(now.charAt(j) == begin.charAt(j))
                    {
                        cnt++;
                    }
                }
                if(cnt == begin.length()-1)
                {
                    visited[i] = true;
                    bfs(now, target, words, count + 1);
                    visited[i] = false;
                }
            }
            
        }
    }
}