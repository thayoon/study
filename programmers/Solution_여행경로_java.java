import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static List<String> airports;
    static String[] path;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length; // 총 티켓 수
        
        // 공항
        Set<String> airport = new LinkedHashSet<>();
        for(String[] ticket : tickets) {
            airport.add(ticket[0]);
            airport.add(ticket[1]);
        }
        airports = new ArrayList<>(airport);
        int size = airports.size();
        
        // 공항 티켓 맵
        map = new int[size][size];
        for(int i=0; i<N; i++) {
            map[airports.indexOf(tickets[i][0])][airports.indexOf(tickets[i][1])]++;
        }
        
        // dfs
        String[] list = new String[N+1];
        path = new String[N+1];
        Arrays.fill(path, "");
        dfs("ICN", 0, list);
        
        return path;
    }
    
    private static void dfs(String begin, int cnt, String[] list) {
        list[cnt] = begin;
        
        // bc
        if(cnt == N) {
            // todo: 알파벳 순서가 앞서는 경로
            if(path[0].isEmpty()) {
                path = list.clone();
            } else {
                String current = String.join(",", list);
                String exist = String.join(",", path);
                if (current.compareTo(exist) < 0) {
                    path = list.clone();
                }
            }

            return;
        }
        
        // 유도 파트
        for(int i=0; i<airports.size(); i++) {    // n개 공항까지 시도
            if(map[airports.indexOf(begin)][i] > 0) {
                map[airports.indexOf(begin)][i]--;
                dfs(airports.get(i), cnt+1, list);
                
                map[airports.indexOf(begin)][i]++;
            }
        }
    }
}