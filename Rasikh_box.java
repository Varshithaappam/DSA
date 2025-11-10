import java.util.*;
public class Rasikh_box {
    static char[][] box_rotate(char[][] Box, boolean right) {
        int M = Box.length, N = Box[0].length;
        char[][] result = new char[N][M];
        if (right) { 
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    result[j][M - 1 - i] = Box[i][j];
        } 
        else { 
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    result[N - 1 - j][i] = Box[i][j];
        }
        return result;
    }
    
    static void Apply_Gravity(char[][] Box) {
        int M = Box.length, N = Box[0].length;
        for (int i = 0; i < N; i++) {
            int dropTo = M - 1;
            for (int j = M - 1; j >= 0; j--) {
                if (Box[j][i] == '*') {
                    Box[j][i] = '.';
                    Box[dropTo--][i] = '*';
                }
            }
            for (int j = dropTo; j >= 0; j--) {
                Box[j][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        sc.nextLine();
        char[][] Box = new char[M][N];
        for (int i = 0; i < M; i++) {
            String row[] = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < N; j++)
                Box[i][j] = row[j].charAt(0);
        }
        Apply_Gravity(Box);
        int K = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<K;i++) {
            String instructed_direction=sc.nextLine().trim();
            Box = box_rotate(Box, instructed_direction.equals("right"));
            Apply_Gravity(Box);
        }
        for(int i=0;i<Box.length;i++){
         for(int j=0;j<Box[0].length;j++)
         {
            System.out.print(Box[i][j]);
            if(j < Box[0].length - 1)
            System.out.print(" ");
         }
         if(i < Box.length - 1)
         System.out.println();
        }
    }
}