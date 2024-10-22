import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        int[] stove = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            stove[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stove);
        
        int max = 0;
        for(int i=2; i<=stove[N-1]; i++) {
            int cnt = 0;
            for(int j=0; j<N; j++) {
                if(stove[j]%i == 0) cnt++;
            }
            max = Math.max(max, cnt);
        }
        
        System.out.println(max);
    }
    
}
