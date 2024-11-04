import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String subStr = s.substring(1, s.length() - 1);
        String[] arr = subStr.split("\\{|\\}");
        List<List<Integer>> list = new ArrayList<>();
        for(String str : arr) {
            if(!str.equals(",") && !str.isEmpty()) {
                List<Integer> tempList = new ArrayList<>();
                if(str.length() == 1) {
                    tempList.add(str.charAt(0) - '0');
                }
                else {
                    String[] splitStr = str.split(",");
                    for(int i=0; i<splitStr.length; i++) {
                        tempList.add(Integer.parseInt(splitStr[i]));
                    }
                }
                list.add(tempList);
            }
        }
        Collections.sort(list, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.size() - o2.size();
        }
        });
        int size = list.get(list.size() - 1).size();
        answer = new int[size];
        boolean[] visited = new boolean[100001];
        int index = 0;
        for(List<Integer> temp : list) {
            for(int num : temp) {
                if(!visited[num]) {
                    answer[index++] = num;
                    visited[num] = true;
                }
            }
        }
        return answer;
    }
}