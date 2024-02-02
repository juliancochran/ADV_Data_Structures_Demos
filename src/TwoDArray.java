public class TwoDArray {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] row : nums)   {
            for(int num : row)  {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
