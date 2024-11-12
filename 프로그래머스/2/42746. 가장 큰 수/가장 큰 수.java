import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String aStr = String.valueOf(a);
                String bStr = String.valueOf(b);
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                
                if(a == 0) {
                    return 1;
                }
                else if(b == 0) {
                    return -1;
                }
                if(aStr.length() > bStr.length()) {
                    sb1.append(aStr).append(bStr);  //긴거 앞에 붙임
                    sb2.append(bStr).append(aStr);  //짧은거 앞에 붙임
                    
                    if(Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString())) {
                        return -1;   //자리 유지
                    }
                    else {
                        return 1;   //자리변경
                    }
                }
                else if(aStr.length() < bStr.length()) {
                    sb1.append(aStr).append(bStr);  //짧은거 앞에 붙임
                    sb2.append(bStr).append(aStr);  //긴거 앞에 붙임
                    
                    if(Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString())) {
                        return -1;   //자리 유지
                    }
                    else {
                        return 1;   //자리변경
                    }
                }
                else {  //길이 같음
                    for(int i=0; i < aStr.length(); i++) {
                        if(aStr.charAt(i) > bStr.charAt(i)) {
                            return -1;  //자리 바뀌지 않음
                        }
                        else if(aStr.charAt(i) < bStr.charAt(i)) {
                            return 1;   //자리 바뀜 b가 앞으로 오도록
                        }
                    }
                }
                return (bStr.charAt(0) - '0') - (aStr.charAt(0) - '0');
            }
        });
        // System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                isZero = false;
            }
            sb.append(arr[i]);
        }
        if(isZero) {
            return "0";
        }
        return sb.toString();
    }
}