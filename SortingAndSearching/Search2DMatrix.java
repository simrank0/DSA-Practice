package SortingAndSearching;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int n = matrix.length, m= matrix[0].length;
        if(target< matrix[0][0] || target> matrix[n-1][m-1]) return false;
        int i;
        for(i=1; i<n; i++){
            if(matrix[i][0]>target){
                break;
            }
        }
        for(int j = 0; j<m; j++){
            if(matrix[i-1][j]==target) return true;
            if(matrix[i-1][j]>target) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        //Expected: True
        System.out.println(search2DMatrix.searchMatrix(matrix, target));

        target = 21;
        //Expected: False
        System.out.println(search2DMatrix.searchMatrix(matrix, target));
    }
}
