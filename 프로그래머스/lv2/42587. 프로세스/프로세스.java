import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Index> queue = new LinkedList<>();
        int result = 0;
        
        for(int i=0; i<priorities.length; i++)
        {
            queue.add(new Index(priorities[i], i));
        }
        int[] answer = new int[priorities.length];
        int index = 0;
                      
        while(!queue.isEmpty())
        {
            boolean isPossible = false;
            Index now = queue.poll();
            
            for(Index i : queue)
            {
                if(now.prop < i.prop)
                {
                    isPossible = true;
                }
            }
            if(isPossible)
            {
                queue.add(new Index(now.prop, now.index));
            }
            else
                answer[index++] = now.index;
        }
        for(int i=0; i<priorities.length; i++)
        {
            if(answer[i] == location)
            {
                result = i+1;
            }       
        }
        System.out.println(Arrays.toString(answer));
        return result;
    }
}
class Index
{
    int prop, index;
    public Index(int prop, int index)
    {
        this.prop=prop;
        this.index=index;
    }
}