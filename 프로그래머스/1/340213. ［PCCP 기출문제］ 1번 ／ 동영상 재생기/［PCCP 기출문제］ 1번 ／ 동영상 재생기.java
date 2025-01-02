import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 초 단위로 변환
        int videoLength = toSeconds(video_len);
        int currentPos = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        // 명령어 처리
        for (String command : commands) {
            // 오프닝 구간 건너뛰기
            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }

            // switch 표현식 사용
            currentPos = switch (command) {
                case "next" -> Math.min(videoLength, currentPos + 10);
                case "prev" -> Math.max(0, currentPos - 10);
                default -> currentPos; // 다른 명령은 무시
            };
        }

        // 최종적으로 오프닝 구간 확인
        if (currentPos >= opStart && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        return toTimeString(currentPos);
    }

    // 시간 문자열을 초 단위로 변환하는 메서드
    private static int toSeconds(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    // 초를 시간 문자열로 변환하는 메서드
    private static String toTimeString(int seconds) {
        int minutes = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", minutes, sec);
    }
}
