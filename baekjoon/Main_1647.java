package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int M = Integer.parseInt(st.nextToken()); // 길의 개수

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {A, B, C});
        }

        int min = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(cnt == N-2) break; // 마을 분할

            if(union(now[0], now[1])) {
                min += now[2];
                cnt++;
            }
        }

        System.out.println(min);
    }
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;
        else {
            parent[a] = b;
            return true;
        }
    }
}
