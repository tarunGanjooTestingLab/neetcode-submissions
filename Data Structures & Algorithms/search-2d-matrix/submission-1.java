class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = n*m-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            
            int i = mid/m;
            int j = mid%m;

            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return false;
    }
}
