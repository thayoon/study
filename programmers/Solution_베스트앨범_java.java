import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        int N = genres.length;
        HashMap<String, Integer> map = new HashMap<>(); // 총 재생 수 장르 우선순위
        HashMap<String, PriorityQueue<int[]>> songs = new HashMap<>();  // 장르별 인덱스, 재생 수 저장
        for(int i=0; i<N; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            songs.putIfAbsent(genres[i], new PriorityQueue<>((o1, o2) -> {
                if (o2[1] == o1[1]) {
                    // genres 재생 횟수가 같으면 index가 낮은 노래 먼저 수록
                    return o1[0] - o2[0];
                } else {
                    // genres 내에서 많이 재생된 노래 먼저
                    return o2[1] - o1[1];
                }
            }));
            songs.get(genres[i]).offer(new int[]{i, plays[i]});
        }
        List<Map.Entry<String, Integer>> genr = new ArrayList<>(map.entrySet());    // 장르 우선 순위 리스트
        genr.sort((o1, o2) -> o2.getValue()-o1.getValue()); // 내림차순 정렬
        
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> now : genr) {
            PriorityQueue<int[]> song = songs.get(now.getKey());
            int cnt = 0;
            while(!song.isEmpty() && cnt < 2) {
                answer.add(song.poll()[0]);
                cnt++;
            }
        }

        return answer;
    }
}