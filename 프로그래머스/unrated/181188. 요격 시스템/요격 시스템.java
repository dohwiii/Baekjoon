import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        
        for(int i=0; i<targets.length;i ++)
        {
             queue.offer(new Pos(targets[i][0], targets[i][1]));
        }
        Pos first = queue.poll();
        int s = first.s;
        int e = first.e - 1;
        int count = 1;
        
        while(!queue.isEmpty())
        {
            Pos now = queue.poll();
            if(e < now.s && e < now.e)
            {
                e = now.e - 1;
                count++;
            }
        }
        return count;
    }
}
class Pos implements Comparable<Pos>
{
    int s;
    int e;
    
    public Pos(int s, int e)
    {
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Pos p)
    {
        return this.e - p.e;
    }

}