package bt63;
import java.util.Scanner;
public class ngoiSaoNhaptuH {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the height of stars: ");
            int h = scanner.nextInt();
            if (h<2 || h>10){
                System.out.println("Height must be between 2 and 10");
                return;
            }
            for(int i=1;i<=h;i++){
                for(int j=0;j<(h+h-1);j++){
                    int totalSpaceNeeded = h+h-1;
                    int leftSpace = totalSpaceNeeded/2-i;
                    int rightSpace = totalSpaceNeeded/2+i;
                    if(j>leftSpace && j<rightSpace)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
               
            }
        }
    }
}
