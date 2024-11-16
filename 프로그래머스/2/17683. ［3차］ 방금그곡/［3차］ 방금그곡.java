import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        PriorityQueue<Music> pq = new PriorityQueue<>();
        int index = 0;
        m = replaceMelody(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int start = Integer.parseInt(info[0].substring(0, 2)) * 60 + Integer.parseInt(info[0].substring(3, 5));
            int end = Integer.parseInt(info[1].substring(0, 2)) * 60 + Integer.parseInt(info[1].substring(3, 5));
            String title = info[2];
            String note = replaceMelody(info[3]);
            int playTime = end - start;
            StringBuilder sb = new StringBuilder();

            // 재생된 멜로디 생성
            if (playTime >= note.length()) {
                for (int i = 0; i < playTime / note.length(); i++) {
                    sb.append(note);
                }
                sb.append(note.substring(0, playTime % note.length()));
            } else {
                sb.append(note.substring(0, playTime));
            }

            // 멜로디 비교
            if (sb.toString().contains(m)) {
                pq.offer(new Music(index, playTime, title));
            }
            index++;
        }

        if (!pq.isEmpty()) {
            return pq.poll().title;
        }
        return "(None)";
    }

    // 멜로디 변환 (C#, D# 등을 한 글자로 변환)
    public String replaceMelody(String melody) {
        return melody.replaceAll("C#", "H")
                     .replaceAll("D#", "I")
                     .replaceAll("F#", "J")
                     .replaceAll("G#", "K")
                     .replaceAll("A#", "L")
                     .replaceAll("B#", "M");
    }

    // 음악 정보를 저장할 클래스
    static class Music implements Comparable<Music> {
        int playTime, index;
        String title;

        public Music(int index, int playTime, String title) {
            this.index = index;
            this.playTime = playTime;
            this.title = title;
        }

        @Override
        public int compareTo(Music m) {
            if (this.playTime != m.playTime) {
                return m.playTime - this.playTime; // 재생 시간이 긴 순
            }
            return this.index - m.index; // 입력 순서대로
        }
    }
}
