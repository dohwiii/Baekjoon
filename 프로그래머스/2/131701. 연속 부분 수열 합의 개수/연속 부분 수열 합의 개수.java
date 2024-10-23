import java.util.*;

class Solution {
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        arr = new int[elements.length * 2];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        System.arraycopy(elements, 0, arr, elements.length, elements.length);
        int maxLength = elements.length;
        
        for(int i=1; i<=maxLength; i++) {
            calc(i, elements);
        }
        return set.size();
    }
    public void calc(int size, int[] elements) {
        int start = 0;
        int end = 0;
        int sum = 0;
                
        while(true) {     
            sum += arr[end++];
            
            if(end == start + size) {
                set.add(sum);
                sum -= arr[start];
                start++;
            }
            if(start == elements.length) {  //끝까지 다 왔다면
                break;   
            }
        }
    }
}