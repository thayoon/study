package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10472 {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int goal = 0; // 목표칸
            for (int i = 0; i < 3; i++) {
                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    if (str.charAt(j) == '*') { // 검은칸인 경우 1
                        goal |= 1 << (i * 3 + j);
                    }
                }
            }
            // 목표칸에서 흰색칸까지 클릭 수 구하기
            sb.append(bfs(goal)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[512]; // 2^9 (3x3 board)
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int board = now[0];
            int click = now[1];

            if(board == 0) { // 모든 칸이 흰색인 경우
                return click;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nextBoard = board;

                    for (int k = 0; k < 5; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx>=0 && nx<3 && ny>=0 && ny<3) {
                            nextBoard ^= 1<<(nx*3 + ny); // XOR: 1^1=0, 0^1=1
                        }
                    }

                    if(!visited[nextBoard]) {
                        visited[nextBoard] = true;
                        q.offer(new int[] {nextBoard, click+1});
                    }
                }
            }
        }

        return -1;
    }
}
