import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        // 유효한 2글자 쌍 추출
        extractValidPairs(str1, list1);
        extractValidPairs(str2, list2);
        
        // 정렬 및 교집합, 합집합 계산
        int[] result = mergeAndCalculate(list1, list2);
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
    
    private void extractValidPairs(String str, List<String> list) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char front = str.charAt(i);
            char back = str.charAt(i + 1);
            if (Character.isLetter(front) && Character.isLetter(back)) {
                list.add("" + front + back);
            }
        }
    }
    
    private int[] mergeAndCalculate(List<String> list1, List<String> list2) {
        List<String> sortedList1 = mergeSort(list1);
        List<String> sortedList2 = mergeSort(list2);

        int intersection = 0;
        int union = 0;
        
        int i = 0, j = 0;
        while (i < sortedList1.size() && j < sortedList2.size()) {
            String elem1 = sortedList1.get(i);
            String elem2 = sortedList2.get(j);
            
            if (elem1.equals(elem2)) {
                intersection++;
                union++;
                i++;
                j++;
            } else if (elem1.compareTo(elem2) < 0) {
                union++;
                i++;
            } else {
                union++;
                j++;
            }
        }
        
        while (i < sortedList1.size()) {
            union++;
            i++;
        }
        while (j < sortedList2.size()) {
            union++;
            j++;
        }
        
        return new int[] {intersection, union};
    }
    
    private List<String> mergeSort(List<String> list) {
        if (list.size() <= 1) {
            return list;
        }
        
        int mid = list.size() / 2;
        List<String> left = mergeSort(list.subList(0, mid));
        List<String> right = mergeSort(list.subList(mid, list.size()));
        
        return merge(left, right);
    }
    
    private List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        
        return result;
    }
}
