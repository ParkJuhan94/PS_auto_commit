import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Song> songList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            songList.add(new Song(genres[i], i, plays[i]));
        }
        Collections.sort(songList);

        // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            int value = plays[i];

            if(map.containsKey(genres[i])){
                map.put(genres[i], map.get(key) + plays[i]);
            }else{
                map.put(genres[i], plays[i]);
            }
        }

        // 3100 1450 -> pop classic
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        ArrayList<String> genreList = new ArrayList<>();
        for(int i = 0; i < valueList.size(); i++){
            for(String key : map.keySet()){
                if(map.get(key) == valueList.get(i)){
                    genreList.add(key);
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        int limitCnt = 0;
        for(String genre : genreList){
            limitCnt = 0;
            for(Song song : songList){
                if(song.genre.equals(genre)){
                    answerList.add(song.idx);
                    limitCnt++;
                }
                if(limitCnt == 2){
                    break;
                }
            }
        }

        int ansIdx = 0;
        int[] answer = new int[answerList.size()];
        for(int n : answerList){
            answer[ansIdx++] = n;
        }

        return answer;
    }
}

class Song implements Comparable<Song>{
    String genre;
    int idx;
    int count;

    public Song(String genre, int idx, int count) {
        this.genre = genre;
        this.idx = idx;
        this.count = count;
    }

    // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    @Override
    public int compareTo(Song o) {
        if(o.count == count){
            return idx - o.idx;
        }else{
            return o.count - count;
        }
    }
}