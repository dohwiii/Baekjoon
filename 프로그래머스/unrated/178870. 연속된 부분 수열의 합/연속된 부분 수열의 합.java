import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
        int sum = sequence[0];
        int[] answer = new int[2];
        ArrayList<int[]> list = new ArrayList<>();
        
        while(s <= e)
        {
        
            if(sum == k)
            {
                list.add(new int[]{s, e});
                e++;
                if (e >= sequence.length) {
                    break;
                }
                sum += sequence[e];
            }
            else if(sum < k)
            {
                e++;
                if (e >= sequence.length) {
                    break;
                }
                sum = sum + sequence[e];
            }
            else if(sum > k)
            {
                sum = sum - sequence[s];                
                s++;
                
            }
            
        }
        int min = Integer.MAX_VALUE;
        for (int[] arr : list) {
            int diff = arr[1] - arr[0];
            min = Math.min(min, diff);
        }
        for (int[] arr : list) 
        {
            if (min == (arr[1] - arr[0])) {
                answer[1] = arr[1];
                answer[0] = arr[0];
                break;
            }
        }
        return answer;
        
    }
}