package src.practrice.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MelonChart {

    static class MusicInfo implements Comparable<MusicInfo> {
        String genre;
        Integer playCount;
        Integer index;

        MusicInfo(String genre, Integer playCount, Integer index) {
            this.genre = genre;
            this.playCount = playCount;
            this.index = index;
        }


        @Override
        public int compareTo(MusicInfo o) {
            if(this.playCount < o.playCount) return 1;
            else if (this.playCount.equals(o.playCount)) {
                if(this.index > o.index) return 1;
            }else {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "[" + genre + ", " + playCount + ", " + index + "]";
        }

    }

    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        Integer [] plays = {500, 600, 150, 800, 2500};

        String [] genres2 = {"hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop", "gukak"};
        Integer [] plays2 = {2000, 500, 600, 150, 800, 2500, 2000, 8000};
        slove(genres, plays);
        slove(genres2, plays2);
    }

    public static void slove(String [] genres, Integer [] plays){
        /**
         * 1. 합계를 구한다
         * 2. 이때 장르가 몇개인지 나옴
         * */

        HashMap<String, List<MusicInfo>> genresMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0 ; i < genres.length ; i++){
            if(!genresMap.containsKey(genres[i])){
                List<MusicInfo> musicinfos = new ArrayList<>();
                musicinfos.add(new MusicInfo(genres[i], plays[i], i));
                musicinfos.add(new MusicInfo(genres[i], plays[i], i));
                genresMap.put(genres[i], musicinfos);
            }else {
                genresMap.get(genres[i]).add(new MusicInfo(genres[i], plays[i], i));
                genresMap.get(genres[i]).get(0).playCount += plays[i];
            }
        }

        List<MusicInfo> rankGenres = new ArrayList<>();

        for(String genre : genresMap.keySet()){
            rankGenres.add(genresMap.get(genre).getFirst());
        }
        Collections.sort(rankGenres);

        for (MusicInfo rankGenre : rankGenres) {
            List<MusicInfo> musicList = genresMap.get(rankGenre.genre);
            musicList.removeFirst();
            Collections.sort(musicList);

            int index = 0;
            for (MusicInfo musicInfo : musicList) {
                if (index >= 2) {
                    break;
                }
                resultList.add(musicInfo.index);
                index++;
            }
        }

        System.out.println(resultList);

    }
}
