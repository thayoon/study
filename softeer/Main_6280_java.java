import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long len = 2;
        
        // 2 -> 3^2 -> 5^2 -> 9^2 -> 17^2...
        for(int i=0; i<N; i++) {
            len = len*2 - 1;
        }

        System.out.println(len*len);
    }
}
