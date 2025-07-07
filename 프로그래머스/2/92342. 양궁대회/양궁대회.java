import java.util.*;

class Solution {
    
    static int totalArrow;
    static int[] arr;
    static int[] answer = {-1};
    static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        totalArrow = n;
        arr = new int[11];    // 라이언의 점수 집계
        
        // 이 점수의 화살을 포함할 것인가 포함하지 않을것인가
        // 점수차가 가장 크게 만든다.
        // dfs + 백트래킹
        dfs(info, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] info, int idx, int cnt) {
        // 모든 화살의 집계가 끝난 경우
        if(idx == 11){
            if(totalArrow == cnt) {
                // 점수 계산 시작
                int aScore = 0;
                int rScore = 0;
                
                for(int i = 0; i < info.length; i++){
                    if(info[i] == 0 && arr[i] == 0) continue;
                    
                    if(info[i] >= arr[i]) aScore += 10 - i;
                    else rScore += 10 - i;
                }
                
                if(rScore > aScore){
                    if(rScore - aScore > maxDiff){
                        maxDiff = rScore - aScore;
                        answer = arr.clone();
                    }else if(rScore - aScore == maxDiff) {
                        // 가장 낮은 점수를 더 많이 맞춘 경우를 리턴
                        for(int i = 10; i >= 0; i--) {
                            if(answer[i] < arr[i]){
                                answer = arr.clone();
                                return;
                            }else if (answer[i] > arr[i]) {
                                return;
                            }
                        }
                    }
                }
            }
            return;
        }
        
        // 라이언 = 어피치 = 0 인 경우
        // 즉 둘다 점수 받기를 포기한 경우
        if(info[idx] == 0){
            dfs(info, idx + 1, cnt);
        }
        
        // 라이언이 이긴 경우
        // 어피치보다 더 맞춘 경우
        if(cnt + 1 + info[idx] <= totalArrow) {
            arr[idx] = info[idx] + 1;
            dfs(info, idx + 1, cnt + 1 + info[idx]);
            arr[idx] = 0;
        }
        
        // 어피치가 이긴 경우 
        // -> 라이언이 어피치 보다 못맞춘 경우
        if(info[idx] != 0) {
            for(int i = 0; i < info[idx]; i++){
                arr[idx] = i;
                dfs(info, idx + 1, cnt + i);
                arr[idx] = 0;
            }
        }

    }
}