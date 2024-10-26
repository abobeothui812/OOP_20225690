package bt66;

public class add2Matrices {
    public static void main(String[] args) {
        int[][] matx1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matx2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] sum = new int[3][3];
        for (int i = 0; i < matx1.length; i++) {
            for (int j = 0; j < matx1[i].length; j++) {
                sum[i][j] = matx1[i][j] + matx2[i][j];
            }
        }
        System.out.println("Sum of 2 matrices: ");
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
