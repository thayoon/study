package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main_2668 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static TreeSet<Integer> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        ans = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        sb.append(ans.size()).append("\n");
        for(int num: ans) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int cur, int start) {
        if(arr[cur] == start) {
            ans.add(start);
        }
        if(!visited[arr[cur]]) {
            visited[arr[cur]] = true;
            dfs(arr[cur], start);
            visited[arr[cur]] = false;
        }
    }
}
