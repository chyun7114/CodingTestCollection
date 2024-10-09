import java.io.*;

public class Main {
    // 문자열을 만들기 위한 StringBuilder 생성
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        // 입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] video = new String[n];

        for(int i = 0; i < n; i++) {
            video[i] = br.readLine();
        }

        br.close();
        //입력 종료

        getQuadTree(video,0, 0, n);
        System.out.println(sb.toString());
    }

    public static void getQuadTree(String[] video, int x, int y, int size) {
        // 종료조건 설정
        // 압축이 가능하면 그대로 압축 후 재귀 종료
        if(isPossible(video, x, y, size)){
            // 압축이 가능하다면 첫 글자나 마지막이나 똑같겠지?
            sb.append(video[x].charAt(y));
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
        getQuadTree(video, x, y, newSize);
        getQuadTree(video, x, y + newSize, newSize);
        getQuadTree(video, x + newSize, y, newSize);
        getQuadTree(video, x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public static boolean isPossible(String[] video, int x, int y, int size) {
        char first = video[x].charAt(y);

        // 전체 탐색하여 모두 같은지 비교하고 만약 다르면 바로 함수 종료
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(video[i].charAt(j) != first){
                    return false;
                }
            }
        }
        return true;
    }
}