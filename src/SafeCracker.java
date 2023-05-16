import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SafeCracker {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int backpack = Integer.parseInt(st.nextToken());
        final int size = Integer.parseInt(st.nextToken());
        int maxPrice = 0;


        int[][] arr = new int[size][2];
        for ( int i = 0 ; i < size ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o2[0] - o1[0];
                else
                    return o2[1] - o1[1];
            }
        });

        int idx = 0;
        while ( backpack > 0 ){
            if ( backpack > arr[idx][0] ){
                backpack -= arr[idx][0];
                maxPrice += (arr[idx][0] * arr[idx][1]);
                idx++;
            } else {
                maxPrice += ( backpack * arr[idx][1]);
                break;
            }
        }

        bw.write(String.valueOf(maxPrice));
        br.close();
        bw.close();
    }
}
