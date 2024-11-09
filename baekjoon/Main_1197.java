package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        parents = new int[V+1]; // 각 정점의 부모 정점 저장
        for (int i = 1; i <= V; i++) {
            parents[i] = i; // 정점의 부모를 자기 자신으로 초기화
        }

        // 간선들을 가중치 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()); // A번, B번 정점 간선의 가중치

            pq.offer(new int[] {A, B, C}); // 간선 추가
        }

        long result = 0; // 간선 가중치 합의 최소값
        int cnt = 0; // 연결 간선
        while(!pq.isEmpty()) {
            int[] now = pq.poll(); // 가중치가 가장 낮은 간선부터
            if(union(now[0], now[1])) { // 두 정점이 연결되지 않은 경우에만 선택
                result += now[2]; // 최소 스패닝 트리 가중치 추가
                if(cnt++ == V-1) break; // 간선의 개수가 V-1이면 MST 완성
            }
        }

        System.out.println(result);
    }
    public static int find(int v) {
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]); // 경로 압축
    }
    public static boolean union(int A, int B) {
        A = find(A);
        B = find(B);

        if(A == B) {
            return false; // 같은 루트 정점이라면 union하지 않음
        } else {
            parents[A] = B; // A의 루트를 B에 연결하여 union
            return true;
        }
    }
}
