package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16198 {
    static int N, max;
    static int[] energy;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine()); // 구슬 개수
        energy = new int[N]; // 에너지 구슬 무게 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(st.nextToken()); // 무게
        }
        visited = new boolean[N];
        max = 0;

        backtrack(0, 0);
        System.out.println(max);
    }

    public static void backtrack(int cnt, int e) {
        if(cnt == N-2) {
            max = Math.max(max, e); // max energy 갱신
            return;
        }

        for (int i = 1; i < N-1; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리

                // 이전 구슬과 다음 구슬의 무게 곱 계산
                int prev = i - 1;
                int next = i + 1;

                while (prev >= 0 && visited[prev]) prev--;
                while (next < N && visited[next]) next++;

                if (prev >= 0 && next < N) {
                    int now = energy[prev] * energy[next];
                    backtrack(cnt + 1, e + now); // 재귀 호출
                }

                visited[i] = false; // 방문 복원
            }
        }
    }
}
