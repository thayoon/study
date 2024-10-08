import java.util.*;

class Solution {
    static int max;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        max = 0;    // 던전 돌 수 있는 최대 수
        visited = new boolean[dungeons.length]; // 던전 방문 처리
        
        perm(k, 0, dungeons);
        
        return max;
    }
    
    /**
     * 순서를 고려한 던전 방문
     * @param nowK : 현재 남은 피로도
     * @param done : 탐험 한 던전 수
     * @param dungeons : 던전 배열
     */
    private static void perm(int nowK, int done, int[][] dungeons) {
        max = Math.max(max, done);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && nowK >= dungeons[i][0]) {
                visited[i] = true;
                perm(nowK-dungeons[i][1], done+1, dungeons);
                visited[i] = false; // 백트레킹
            }
        }
    }
    
}