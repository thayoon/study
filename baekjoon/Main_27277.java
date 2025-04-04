package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_27277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int a1 = 0;
        int a2 = N-1;

        while(list.size() < N) {
            list.add(arr[a2--]);
            list.add(arr[a1++]);

            if(a2 == a1) list.add(arr[a2]);
        }

        int max = 0;
        int prev = 0;
        for(int next : list) {
            max += Math.max(0, next-prev);
            prev = next;
        }

        System.out.println(max);
    }
}
