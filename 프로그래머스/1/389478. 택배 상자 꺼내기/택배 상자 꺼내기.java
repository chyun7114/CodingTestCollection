class Solution {
    public int solution(int n, int w, int num) {
        // 상자는 몇 층에 있는가
        int pickY = ((num - 1) / w) + 1;
        
        // 상자는 몇번째 줄에 있는가 
        int pickX = (pickY % 2 != 0) ? (num - 1) % w + 1 : (pickY * w) - num + 1;
        
        int now = num;
        int pickCnt = 0;
        
        while(now <= n) {
            pickCnt++;
            
            // 위의 상자 부터 꺼내기
            if((pickY + pickCnt) % 2 == 0) {
                now += (w - pickX) * 2 + 1;
            }else{
                now += pickX * 2 - 1;
            }
        }
        
        return pickCnt;
    }
}