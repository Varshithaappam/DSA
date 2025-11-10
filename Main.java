import java.util.*;

public class Main {
    public static void Rasikn_box(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        char[][] Box = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Box[i][j] = sc.next().charAt(0);
            }
        }

        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            String direction = sc.next();
            if (direction.equalsIgnoreCase("right"))
                Box = rotateRight(Box);
            else
                Box = rotateLeft(Box);
            applyGravity(Box);
        }

        for (int i = 0; i < Box.length; i++) {
            for (int j = 0; j < Box[0].length; j++) {
                System.out.print(Box[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }

    static char[][] rotateRight(char[][] Box) {
        int M = Box.length, N = Box[0].length;
        char[][] result = new char[N][M];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                result[j][M - 1 - i] = Box[i][j];
        return result;
    }

    static char[][] rotateLeft(char[][] Box) {
        int M = Box.length, N = Box[0].length;
        char[][] result = new char[N][M];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                result[N - 1 - j][i] = Box[i][j];
        return result;
    }

    static void applyGravity(char[][] arr) {
        int M = arr.length, N = arr[0].length;
        for (int col = 0; col < N; col++) {
            int write = M - 1;
            for (int row = M - 1; row >= 0; row--) {
                if (arr[row][col] == '*') {
                    arr[row][col] = '.';
                    arr[write][col] = '*';
                    write--;
                }
            }
            for (int r = write; r >= 0; r--) arr[r][col] = '.';
        }
    }
}
