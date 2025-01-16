class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        // 1단계 ~ 4단계: 대문자 -> 소문자, 불필요한 문자 제거, 연속 마침표 제거, 앞뒤 마침표 제거
        boolean lastWasDot = false;
        for (char c : new_id.toLowerCase().toCharArray()) {
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                if (c == '.') {
                    if (lastWasDot) continue; // 연속된 마침표 건너뜀
                    lastWasDot = true;
                } else {
                    lastWasDot = false;
                }
                sb.append(c);
            }
        }

        // 4단계: 앞뒤 마침표 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);

        // 5단계: 빈 문자열 처리
        if (sb.length() == 0) sb.append("a");

        // 6단계: 길이 제한 처리
        if (sb.length() >= 16) {
            sb.setLength(15); // 첫 15자만 남김
            if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1); // 끝 마침표 제거
        }

        // 7단계: 길이 보정
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1)); // 마지막 문자 반복 추가
        }

        return sb.toString();
    }
}