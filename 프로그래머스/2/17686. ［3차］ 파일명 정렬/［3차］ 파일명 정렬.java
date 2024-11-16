import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Pattern pattern = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                Matcher m1 = pattern.matcher(a.toLowerCase());
                Matcher m2 = pattern.matcher(b.toLowerCase());
                m1.find();
                m2.find();
                if(m1.group(1).equals(m2.group(1))) {
                    return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
                }
                return m1.group(1).compareTo(m2.group(1));
            }
        });
        return files;
    }
}