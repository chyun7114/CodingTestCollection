import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int h;
    static int w;
    static char[][] map;
    static int curX;
    static int curY;

    static void solveProblem() throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char temp = s.charAt(j);
                    map[i][j] = temp;
                    if (temp == '>' || temp == '<' || temp == 'v' || temp == '^') {
                        curX = i;
                        curY = j;
                    }
                }
            }

            int count = Integer.parseInt(br.readLine());
            String command = br.readLine();

            int direction = state(map[curX][curY]);
            int next = 0;

            for (int i = 0; i < count; i++) {
                char cur = command.charAt(i);

                switch (cur) {
                    case 'U': {
                        direction = 0;
                        map[curX][curY] = '^';
                        int nx = curX + dx[direction];
                        int ny = curY + dy[direction];

                        if (rangeIn(nx, ny, map) && map[nx][ny] == '.') {
                            map[curX][curY] = '.';
                            map[nx][ny] = '^';
                            curX = nx;
                            curY = ny;
                        }
                        break;
                    }
                    case 'D': {
                        direction = 1;
                        map[curX][curY] = 'v';
                        int nx = curX + dx[direction];
                        int ny = curY + dy[direction];

                        if (rangeIn(nx, ny, map) && map[nx][ny] == '.') {
                            map[curX][curY] = '.';
                            map[nx][ny] = 'v';
                            curX = nx;
                            curY = ny;
                        }
                        break;
                    }
                    case 'L': {
                        direction = 2;
                        map[curX][curY] = '<';
                        int nx = curX + dx[direction];
                        int ny = curY + dy[direction];

                        if (rangeIn(nx, ny, map) && map[nx][ny] == '.') {
                            map[curX][curY] = '.';
                            map[nx][ny] = '<';
                            curX = nx;
                            curY = ny;
                        }
                        break;
                    }
                    case 'R': {
                        direction = 3;
                        map[curX][curY] = '>';
                        int nx = curX + dx[direction];
                        int ny = curY + dy[direction];

                        if (rangeIn(nx, ny, map) && map[nx][ny] == '.') {
                            map[curX][curY] = '.';
                            map[nx][ny] = '>';
                            curX = nx;
                            curY = ny;
                        }
                        break;
                    }
                    case 'S': {
                        int sx = curX;
                        int sy = curY;

                        while (rangeIn(sx, sy, map)) {
                            sx += dx[direction];
                            sy += dy[direction];
                            if (rangeIn(sx, sy, map)) {
                                next = map[sx][sy];
                                if (next == '*') {
                                    map[sx][sy] = '.';
                                    break;
                                } else if (next == '#') {
                                    break;
                                } else if (next == '.' || next == '-') {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int state(char c) {
        if (c == '^') {
            return 0;
        } else if (c == 'v') {
            return 1;
        } else if (c == '<') {
            return 2;
        } else if (c == '>') {
            return 3;
        }
        return -1;
    }

    static boolean rangeIn(int x, int y, char[][] gameMap) {
        return x >= 0 && x < gameMap.length && y >= 0 && y < gameMap[x].length;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
