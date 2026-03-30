class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rcount = matrix.length;
        int ccount = matrix[0].length;

        if(rcount == 1 && ccount == 1) {
            if(target == matrix[0][0]) {
                return true;
            } 
            return false;
        }

        int l = 0; int r = rcount-1;
        int m = 0;
        while(l <= r) {
            m = (l+r)/2;
            if(target == matrix[m][ccount-1]) {
                return true;
            } else if(target > matrix[m][ccount-1]) {
                l = m+1;
            } else {
                if(target >= matrix[m][0]) {
                    break;
                }
                r = m-1;
            }
        }
        l = 0; r = ccount-1;
        System.out.println("m=" + m);
        while(l <= r) {
            int m2 = (l+r)/2;
            if(target == matrix[m][m2]) {
                return true;
            } else if(target > matrix[m][m2]) {
                l = m2+1;
            } else {
                r = m2-1;
            }
        }
        return false;
    }
}
