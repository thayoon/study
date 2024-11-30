package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {a, b, c});
        }

        int min = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(union(now[0], now[1])) {
                // 부모가 다르다면 연결
                min += now[2]; // 가중치 추가
                if(cnt++ == N-1) break; // 모든 컴퓨터가 연결됨
            }
        }

        System.out.println(min);
    }

    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 경로 압축
    }

    public static boolean union(int a, int b) {
        // 부모 찾기
        a = find(a);
        b = find(b);

        if(a == b) return false; // 같다면 연결된 것
        else {
            parent[a] = b; // a의 부모를 b로 연결
            return true;
        }
    }
}
