import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i < progresses.length; i++)
        {
            int finishDay = 100 - progresses[i];
            if(finishDay % speeds[i] == 0)
            {
                days[i] = finishDay / speeds[i];
            }
            else
            {
                days[i] = finishDay / speeds[i] + 1;
            }
        }

        boolean[] visited = new boolean[days.length];
        
        for(int i=0; i < days.length; i++)
        {
            if(!visited[i])
            {
                int fixProgress = days[i];
                int day = 0;  
            
                for(int j = i; j < days.length; j++)
                {
                    if(!visited[j])
                    {
                        if(fixProgress < days[j])
                        {
                            list.add(day);
                            break;
                        }
                        else if(fixProgress >= days[j])
                        {
                            day++;
                            visited[j] = true;
                            if(j == days.length-1)
                            {
                                list.add(day);
                                break;
                            }
                        }
                       
                        
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}