import java.util.*;
class Solution {
    public void union(Set<Integer> target, Set<Integer> aSet, Set<Integer> bSet)
    {
        for(int a : aSet)
        {
            for(int b : bSet)
            {
                target.add(a+b);
                target.add(a-b);
                target.add(a*b);
                if(b != 0)
                {
                    target.add(a/b);
                }
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i < 9; i++)
        {
            list.add(new HashSet<>());
        }
        if(N == number)
        {
            return 1;
        }
        list.get(1).add(N); //1개일 땐 자기자신뿐
        
        for(int i = 2; i < 9; i++)
        {
            String value = "";
            
            for(int j = 1; j <= i/2; j++) //이전 박스
            {
                union(list.get(i), list.get(i-j), list.get(j));
                union(list.get(i), list.get(j), list.get(i-j));
            }
            for(int j=1; j<=i; j++)
            {
                 value += N;
            }
            list.get(i).add(Integer.parseInt(value));
            for(int v : list.get(i))
            {
                if(number == v)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}