import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int start = p - 1;
        int lastIndex = m * t - m + start;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int length = 0;
        while(true) {
            String radixNum = Integer.toString(num, n);
            length += radixNum.length();
            sb.append(radixNum);
            if(length > lastIndex) {
                break;
            }
            num++;
        }
        String str = sb.toString().toUpperCase();
        sb = new StringBuilder();
        int cnt = 1;
        int index = start;
        while(cnt <= t) {
            sb.append(str.charAt(index));
            index = index + m;
            cnt++;
        }

        return sb.toString();
    }
} 