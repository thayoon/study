package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 땅 개수
        int Q = Integer.parseInt(st.nextToken()); // 오리 수

        boolean[] visited = new boolean[N+1]; // 점유된 땅 저장

        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine()); // 오리가 원하는 땅 번호
            int duck = 0; // 처음 마주치는 점유된 땅

            int cur = x;
            while(cur > 1) {
                if(visited[cur]) {
                    duck = cur; // 점유된 땅 갱신
                }
                cur /= 2; // 부모 노드 이동
            }

            if(duck == 0) visited[x] = true; // 점유할 수 있다면 점유 처리
            sb.append(duck).append("\n");
        }

        System.out.println(sb);
    }
}
