import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int total = answers.length;
        int[] one = new int[10_001];
        int[] two = new int[10_001];
        int[] three = new int[10_001];
        
        int[] arr = {1,2,3,4,5};
        for(int i=0; i<total; i++) {
            one[i] = arr[i % 5];
        }
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        for(int i=0; i<total; i++) {
            two[i] = arr2[i % 8];
        }
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i=0; i<total; i++) {
            three[i] = arr3[i % 10];
        }
        int score1 = 0, score2 = 0, score3 = 0;
        for(int i=0; i<total; i++) {
            int ans = answers[i];
            if(ans == one[i]) {
                score1++;
            }
            if(ans == two[i]) {
                score2++;
            }
            if(ans == three[i]) {
                score3++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if(score1 > score2 && score1 > score3) {
            list.add(1);
        }
        else if(score2 > score1 && score2 > score3) {
            list.add(2);
        }
        else if(score3 > score1 && score3 > score2) {
            list.add(3);
        }
        else if((score1 != 0 && score2 != 0 && score3 != 0) && (score1 == score2 && score2 == score3)) {
            list.add(1);
            list.add(2);
            list.add(3);
        }
        else if(score1 != 0 && score2 != 0 && score1 == score2) {
            list.add(1);
            list.add(2);
        }
        else if(score2 != 0 && score3 != 0 && score2 == score3) {
            list.add(2);
            list.add(3);
        }
        else if(score1 != 0 && score3!= 0 && score1 == score3) {
            list.add(1);
            list.add(3);
        } 
        
        int idx = 0;
        if(list.size() > 0 ){
           answer = new int[list.size()];
            for(int a : list) {
                answer[idx++] = a;
            }
         
        }
        
        
        return answer;
    }
}