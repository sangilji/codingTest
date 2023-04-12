class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        
        
        for(int i = 1; i<n+1;i++){
            for(int j = 1 ; j<n+1;j++){
                if(i==j){
                    continue;
                }
                arr[i][j] = 10000;
            }
        }
        for(int i = 0; i<results.length;i++){
            arr[results[i][0]][results[i][1]] =1;
        }
        for(int i = 1; i<n+1;i++){
            for(int j = 1 ; j<n+1;j++){
                if(i==j){
                    continue;
                }
                for(int k = 1; k<n+1;k++){
                    if(j==k || i ==k){
                        continue;
                    }
                    arr[j][k] = Math.min(arr[j][k],arr[j][i] + arr[i][k]);
                }
            }
        }
        
        for(int i = 1; i<n+1;i++){
            int count = 0;
            for(int j = 1 ; j<n+1;j++){
                if(arr[i][j] != 10000 || arr[j][i] != 10000){
                    count++;
                }
            }
            if(count==n){
                answer++;
            }
                
        }
        return answer;
    }
}