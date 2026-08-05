import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();    // 장르별 재생횟수
        Map<String, List<Song>> songMap = new HashMap<>();
        
        
        for(int i=0; i<plays.length; i++) {
            String genre = genres[i];   // 장르
            int play = plays[i];    // 재생횟수
            
            int value = genreMap.getOrDefault(genre, 0) + play;
            genreMap.put(genre, value); // 재생횟수 누적
            
            List<Song> songs = songMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new Song(i, play));
            songMap.put(genre, songs);
        }
        List<String> genreSortList = new ArrayList<>(genreMap.keySet());
        genreSortList.sort((a, b) -> genreMap.get(b) - genreMap.get(a));    // 총 재생수 내림차순
        
        for(String key : songMap.keySet()) {
            List<Song> list = songMap.get(key);
            Collections.sort(list);
        }
        List<Integer> ans = new ArrayList<>();
        
        for(String genre : genreSortList) {
            List<Song> list = songMap.get(genre);
            
            for(int i=0; i<Math.min(2, list.size()); i++) {
                ans.add(list.get(i).index);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    static class Song implements Comparable<Song> {
        int index;
        int play;
        
        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song s) {
            if(s.play == this.play) {
                return this.index - s.index;    // 재생 횟수 같으면 고유번호 낮은 순서대로
            }
            return s.play - this.play;
        }
    }
}