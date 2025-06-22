import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static final char EMPTY_SPACE = '.';
    static final char WALL = '#';
    static final char START = '@';
    static final char FIRE = '*';

    static char[][] board;
    static int w;
    static int h;
    static Queue<int[]> fireQueue;
    static Queue<int[]> personQueue;

    private static void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];

            for(int i = 0; i < h; i++){
                String temp = br.readLine();
                for(int j = 0; j < w; j++){
                    char c = temp.charAt(j);
                    if(c == FIRE){
                        fireQueue.add(new int[]{i, j});
                    }else if (c == START){
                        personQueue.add(new int[]{i, j, 0});
                    }

                    board[i][j] = c;
                }
            }

            int res = -1;

            out : while(true){
                // 불이 번진다
                int fireSize = fireQueue.size();
                for(int i = 0; i < fireSize; i++){
                    int[] curFire = fireQueue.poll();
                    setFire(curFire[0], curFire[1]);
                }

                // 상근이 이동 (벽 x, 불 x)
                int personSize = personQueue.size();
                for(int i = 0; i < personSize; i++){
                    int[] curPerson = personQueue.poll();
                    res = movePerson(curPerson[0], curPerson[1], curPerson[2]);
                    if(res != -1){
                        break out;
                    }
                }

                if(personQueue.isEmpty()) break;
            }

            if(res == -1){
                sb.append("IMPOSSIBLE\n");
            }else{
                sb.append(res + "\n");
            }
        }
    }

    private static int movePerson(int x, int y, int time){
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                return time + 1;
            }

            if(board[nx][ny] == EMPTY_SPACE){
                board[nx][ny] = START;
                personQueue.add(new int[]{nx, ny, time + 1});
            }
        }

        return -1;
    }

    private static void setFire(int x, int y){
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= h || ny >= w){
                continue;
            }

            // 빈공간에 번진다
            // 상근이가 있는 곳도 번진다
            if(board[nx][ny] == EMPTY_SPACE || board[nx][ny] == START){
                board[nx][ny] = FIRE;
                fireQueue.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}