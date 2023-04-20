import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
        int sum = sequence[0];
        int[] answer = new int[2];
        ArrayList<int[]> list = new ArrayList<>();
        int min = sequence.length + 1;
        
        while(s <= e)
        {
        
            if (sum == k) {
                list.add(new int[]{s, e});
                min = Math.min(min, e - s);
                if (++e >= sequence.length) {
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