import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 계산
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르를 재생 횟수 기준으로 정렬하기 위해 리스트로 변환
        ArrayList<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        // 장르별 재생 횟수를 기준으로 내림차순 정렬
        for (int i = 0; i < sortedGenres.size(); i++) {
            for (int j = i + 1; j < sortedGenres.size(); j++) {
                if (genrePlayCount.get(sortedGenres.get(i)) < genrePlayCount.get(sortedGenres.get(j))) {
                    String temp = sortedGenres.get(i);
                    sortedGenres.set(i, sortedGenres.get(j));
                    sortedGenres.set(j, temp);
                }
            }
        }

        // 장르별로 상위 2곡을 찾아서 결과에 추가
        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            ArrayList<int[]> songs = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    songs.add(new int[]{i, plays[i]});
                }
            }

            // 재생 횟수 내림차순으로 정렬 (상위 2곡만 필요)
            for (int i = 0; i < songs.size(); i++) {
                for (int j = i + 1; j < songs.size(); j++) {
                    if (songs.get(i)[1] < songs.get(j)[1]) {
                        int[] temp = songs.get(i);
                        songs.set(i, songs.get(j));
                        songs.set(j, temp);
                    }
                }
            }

            // 상위 2곡만 결과에 추가
            int count = 0;
            for (int[] song : songs) {
                if (count < 2) {
                    result.add(song[0]);
                    count++;
                }
            }
        }

        // 결과를 int[]로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
