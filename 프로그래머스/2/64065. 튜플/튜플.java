import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            String[] str = arr[i].split(",");
            for(String temp : str) {
                int num = Integer.parseInt(temp);
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}