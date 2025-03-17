package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12101 {
    static int n, k, cnt;
    static boolean find;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cnt = 0;
        find = false;

        dfs(0, new ArrayList<>());

        if(!find) {
            System.out.println("-1");
        }
    }

    public static void dfs(int sum, List<Integer> list) {
        if(sum == n) {
            cnt++;
            if(cnt == k) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if(i<list.size()-1) sb.append("+");
                }
                System.out.println(sb);
                find = true;
            }
            return;
        }

        if(sum > n || find) return;

        for (int i = 1; i <= 3; i++) {
            list.add(i);
            dfs(sum+i, list);
            list.remove(list.size()-1);
        }
    }
}
