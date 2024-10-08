import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 시작
        String firstLine = br.readLine();

        String[] inputs = firstLine.split(" ");

        // n, m
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] board = new String[n];

        // 한줄씩 입력 받고
        for(int i = 0; i < n; i++){
            board[i] = br.readLine();
        }

        br.close();
        // 입력 종료

        int result = Integer.MAX_VALUE;

        // 8칸씩 잘라낸다
        // 어짜피 끝보다 8 작은 칸까지 갈거라 그 앞까지만 배열을 돌린다.
        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                // 체스판 자르기
                int resultCount = cutTheChessBoard(i, j, board);
                // 최소의 결과 찾기
                result = Math.min(result, resultCount);
            }
        }

        // 출력 시작
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");

        bw.close();
        // 출력 종료
    }

    private static int cutTheChessBoard(int start, int end, String[] board) {
        int changeCount = 0;

        // 체스판 패턴
        String[] chessBoardPattern = {"WBWBWBWB", "BWBWBWBW"};

        //체스 보드 8칸씩 자르며 검증 시작
        for(int i = 0; i < 8; i++){
            int row = start + i;
            for(int j = 0; j < 8; j++){
                int col = end + j;

                // 첫줄이 하얀색이면 홀수는 하얀색 시작, 짝수는 검은색 시작
                // 이를 유의하면서 양쪽의 값이 다르면 색을 바꾸는 것으로 생각한다.
                if(board[row].charAt(col) != chessBoardPattern[row % 2].charAt(j))
                    changeCount++;
            }
        }

        // 체스판이 완전히 채워져 있는 경우 그대로 두면 바꾸는 카운트가 0
        // 만약 이 상태에서 처음 시작을 하나만 바꿔도 전체를 바꿔야 한다.
        // 그러면 검쟁색 시작 체스판은 전체 64 - 흰색으로 생각이 가능하다.
        return Math.min(changeCount, 64 - changeCount);
    }
}