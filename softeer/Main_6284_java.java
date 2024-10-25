import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Integer.parseInt(st.nextToken());
        long P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            K = K*P;
            K = K%1000000007;
        }
        
        System.out.println(K%1000000007);
    }
}
