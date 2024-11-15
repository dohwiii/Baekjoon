import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {    
                //대소문자 통일
                //HEAD와 NUMBER 분리
                String[] resultA = a.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                String[] resultB = b.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                String headA = resultA[0].toLowerCase();
                String numA = resultA[1];
                String headB = resultB[0].toLowerCase();
                String numB = resultB[1];
                if(headA.equals(headB)) { //대소문자 구분 없이 비교
                    //HEAD같다면 -> NUMBER 비교
                    int numAA = Integer.parseInt(numA);
                    int numBB = Integer.parseInt(numB);
                    return numAA - numBB;
                }
                return headA.compareTo(headB);
            }
        });
        return files;
    }
}