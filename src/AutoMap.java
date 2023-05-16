import java.io.*;

public class AutoMap {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int sides = 2;
        int dots = 4;

        for ( int i = 0 ; i < num ; i++){
            dots = ( dots * 4 ) - ( ( sides -1 ) * 4 ) - 3;
            sides = sides * 2 - 1;
        }
        bw.write(String.valueOf(dots)+"\n");
        br.close();
        bw.close();
    }
}