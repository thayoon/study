package softeer;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        // 이미 완성된 jigsaw Sudoku이기 때문에 구역만 나눠주면 됨
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(i+1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
