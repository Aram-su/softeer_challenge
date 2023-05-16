import java.util.*;
import java.io.*;


public class Obstacle{
    static int[][] map;
    static boolean[][] visited;
    static int SIZE;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        SIZE = Integer.parseInt(br.readLine());
        map = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];

        ArrayList<Integer> blocks = new ArrayList<>();

        //map 에 입력값 넣기
        for(int i = 0; i < SIZE; i++) {
            String s = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        // block 체크
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                int num = checking(i,j);
                if ( num != 0 )
                    blocks.add(num);
            }
        }

        Collections.sort(blocks);
        bw.write(String.valueOf(blocks.size())+"\n");
        for ( int num : blocks )
            bw.write(String.valueOf(num)+"\n");

        br.close();
        bw.close();
    }
    public static int checking(int x, int y){

        if ( x < 0 || x >= SIZE || y < 0 || y >= SIZE ) return 0;
        if ( map[x][y] == 0 ) return 0;
        if ( visited[x][y] ) return 0;

        visited[x][y] = true;

        return 1 + checking(x, y-1) + checking(x, y+1) + checking(x-1, y) + checking(x+1, y);
    }
}