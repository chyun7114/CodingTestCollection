import java.util.*;

class Solution {
    
    public int solution(String[] arr) {
        int size = arr.length / 2 + 1;
        char[] operations = new char[size - 1];
        int[] numbers = new int[size];
        
        int[][] max = new int[size][size];
        int[][] min = new int[size][size];
        
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) numbers[i / 2] = Integer.parseInt(arr[i]);
            else operations[i / 2] = arr[i].charAt(0);
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int len = 1; len <= size; len++) {
            for (int i = 0; i + len - 1 < size; i++) {
                int j = i + len - 1;
                if (i == j) {
                    max[i][j] = numbers[i];
                    min[i][j] = numbers[i];
                    continue;
                }

                for (int k = i; k < j; k++) {
                    if (operations[k] == '+') {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else { 
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }

        
        return max[0][numbers.length - 1];
    }
}