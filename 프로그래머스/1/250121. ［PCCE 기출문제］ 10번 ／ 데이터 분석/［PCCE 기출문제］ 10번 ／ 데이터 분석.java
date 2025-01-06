import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        if(ext.equals("date")) {
            String vext = String.valueOf(val_ext);
            int year = Integer.parseInt(vext.substring(0, 4));
            int month = Integer.parseInt(vext.substring(4, 6));
            int day = Integer.parseInt(vext.substring(6, 8));
            
            for(int[] d : data) {
                String date = String.valueOf(d[1]);
                int dyear = Integer.parseInt(date.substring(0, 4));
                int dmonth = Integer.parseInt(date.substring(4, 6));
                int dday = Integer.parseInt(date.substring(6, 8));
                
                if(dyear < year) {
                    list.add(d);
                }
                else if((dyear == year && month > dmonth) || (dyear == year && month == dmonth && day > dday)) {
                    list.add(d);
                }
            }
            
        }
        else {
            int standard = map.get(ext);
            
            for(int[] d : data) {
                if(d[standard] < val_ext) {
                    list.add(d);
                }
            }
        }
        int sortIndex = map.get(sort_by);
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[sortIndex] - b[sortIndex];
            }
        });
        answer = list.toArray(new int[list.size()][]);
        
        return answer;
    }
}