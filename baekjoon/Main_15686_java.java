package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686 {
    static int N, M, min;
    static int[][] map;
    static ArrayList<int[]> home, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 도시 크기
        M = Integer.parseInt(st.nextToken());   // 치킨 집 최대 수
        min = Integer.MAX_VALUE;                // 치킨 거리 쵣솟값
        map = new int[N][N];    // 도시
        home = new ArrayList<>();
        ch = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // todo: 집과 치킨집 좌표 저장하기
                if(map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if(map[i][j] == 2) {
                    ch.add(new int[]{i, j});
                }
            }
        }

        // todo: 조합으로 최대 M개 치킨집 뽑기
        for (int i = 1; i <= M; i++) {
            int[] visited = new int[i];
            combi(0, 0, i, visited);
        }

        System.out.println(min);
    }

    /**
     * 1부터 M까지 치킨집 조합으로 뽑기
     * @param cnt: 현재 인덱스
     * @param start: 시작 인덱스
     * @param r: bc 조건
     * @param visited: 길이가 r인 현재 뽑힌 치킨집 인덱스 배열
     */
    private static void combi(int cnt, int start, int r, int[] visited) {
        if(cnt == r) {
            // todo: 최소 거리 구하기
            int now = 0;    // 현재 선택한 치킨 거리 최솟값

            for (int i = 0; i < home.size(); i++) {
                int x = home.get(i)[0]; // 현재 집 x 좌표
                int y = home.get(i)[1]; // 현재 집 y 좌표
                int dis = Integer.MAX_VALUE;    // 현재 집과 선택한 치킨집 중 가까운 치킨집 거리

                for (int j = 0; j < r; j++) {
                    int cx = ch.get(visited[j])[0];  // 현재 치킨집 x 좌표
                    int cy = ch.get(visited[j])[1];  // 현재 치킨집 y 좌표
                    dis = Math.min(dis, Math.abs(x-cx) + Math.abs(y-cy));
                }

                // i번째 집과 선택한 치킨집 중 가장 가까운 거리의 치킨집 거리 더하기
                now += dis;
            }

            min = Math.min(min, now);
            return;
        }
        for (int i = start; i < ch.size(); i++) {
            visited[cnt] = i;
            combi(cnt+1, i+1, r, visited);
        }
    }
}
