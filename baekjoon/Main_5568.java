package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_5568 {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");

        System.out.println(hs.size());
    }

    public static void dfs(int depth, String num) {
        if(depth == k) {
            hs.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, num+arr[i]);
                visited[i] = false;
            }
        }
    }
}
