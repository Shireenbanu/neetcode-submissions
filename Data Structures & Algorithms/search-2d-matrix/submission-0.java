class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int  colLength = matrix.length;
        int rowLength = matrix[0].length;

        int low =0; 
        int high = (colLength * rowLength)-1;

        while(low<=high){
            int mid = (low+high)/2;

            // System.out.println(" mid: "+ mid + " row = "+ (mid/rowLength) + " high = "+ (mid%rowLength));
            
            int matrixLow = getCellItem(low,matrix,rowLength);
            int matrixHigh = getCellItem(high,matrix,rowLength);

            int matrixMid = getCellItem(mid,matrix,rowLength);

            // System.out.println("matrixLow: "+ matrixLow + " matrixHigh: "+ matrixHigh + " midMatrix: "+ matrixMid);
            if( matrixMid == target){
                System.out.println("found: "+ matrixMid);
                return true;
            }
            if(target<matrixMid){
              high = mid-1;  
            }
            else
            {
             low = mid+1;
            }
        }
        return false;
    }


    public int getCellItem(int index, int arr[][], int rowLen){

        return arr[index/rowLen][index%rowLen]; 

    }
}


