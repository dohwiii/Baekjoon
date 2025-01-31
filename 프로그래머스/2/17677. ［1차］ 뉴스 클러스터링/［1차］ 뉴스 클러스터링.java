import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String[] arr1 = extractValidPairs(str1);
        String[] arr2 = extractValidPairs(str2);
        
        // 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // Merge 과정에서 교집합, 합집합 계산
        int[] result = mergeAndCalculate(arr1, arr2);
        int intersection = result[0];
        int union = result[1];
        
        // 공집합 처리
        if (union == 0) {
            return 65536;
        }
        
        // 자카드 유사도 계산
        double similarity = (double) intersection / union;
        return (int) (similarity * 65536);
    }
    
    // 유효한 2글자 쌍 추출
    private String[] extractValidPairs(String str) {
        str = str.toLowerCase();
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char front = str.charAt(i);
            char back = str.charAt(i + 1);
            if (Character.isLetter(front) && Character.isLetter(back)) {
                tempList.add("" + front + back);
            }
        }
        // 배열로 변환
        return tempList.toArray(new String[0]);
    }
    
    // 병합하여 교집합과 합집합 계산
    private int[] mergeAndCalculate(String[] arr1, String[] arr2) {
        int i = 0, j = 0;
        int intersection = 0;
        int union = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].equals(arr2[j])) {
                intersection++;
                union++;
                i++;
                j++;
            } else if (arr1[i].compareTo(arr2[j]) < 0) {
                union++;
                i++;
            } else {
                union++;
                j++;
            }
        }
        
        // 남은 요소 처리
        union += (arr1.length - i) + (arr2.length - j);
        
        return new int[] {intersection, union};
    }
}
