import java.io.*;
import java.util.*;

public class Transmission {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[8];
        String output;

        for ( int i = 0 ; i < 8 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        if ( arr[0] == 8 ){
            output = "descending";
            for ( int i = 1 ; i < 8;  i++){
                if ( arr[0] != (arr[i]+i) ){
                    output = "mixed";
                    break;
                }
            }
        } else if( arr[0] == 1 ){
            output = "ascending";
            for ( int i = 1 ; i < 8;  i++){
                if ( arr[0] != (arr[i]-i) ){
                    output = "mixed";
                    break;
                }
            }
        } else {
            output = "mixed";
        }
        bw.write(output);
        br.close();
        bw.close();
    }
}
