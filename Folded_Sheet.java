import java.util.*;

public class Folded_Sheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        sc.nextLine();
        String[] ops = sc.hasNextLine() ? sc.nextLine().trim().split("\\s+") : new String[0];
        LinkedList<Integer>[][] sheet = new LinkedList[rows][cols];
        int num = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                sheet[i][j] = new LinkedList<>();
                sheet[i][j].add(num++);
            }
        for (String op : ops) {
            if (op.length() < 2) continue;
            char type = op.charAt(0);
            int k = Integer.parseInt(op.substring(1));
            if (type == 'v') {
                LinkedList<Integer>[][] newSheet = new LinkedList[rows][Math.max(k, cols - k)];
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < newSheet[0].length; j++)
                        newSheet[i][j] = new LinkedList<>();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < k; j++)
                        newSheet[i][Math.max(k, cols - k) - k + j].addAll(sheet[i][j]);
                    for (int j = k; j < cols; j++) {
                        int t = Math.max(k, cols - k) - 1 - (j - k);
                        LinkedList<Integer> tmp = new LinkedList<>(sheet[i][j]);
                        Collections.reverse(tmp);
                        newSheet[i][t].addAll(tmp);
                    }
                }
                sheet = newSheet;
                cols = sheet[0].length;
            } 
            else if (type == 'h') {
                LinkedList<Integer>[][] newSheet = new LinkedList[Math.max(k, rows - k)][cols];
                for (int i = 0; i < newSheet.length; i++)
                    for (int j = 0; j < cols; j++)
                        newSheet[i][j] = new LinkedList<>();
                for (int i = 0; i < k; i++)
                    for (int j = 0; j < cols; j++)
                        newSheet[Math.max(k, rows - k) - k + i][j].addAll(sheet[i][j]);
                for (int i = k; i < rows; i++) {
                    int t = Math.max(k, rows - k) - 1 - (i - k);
                    for (int j = 0; j < cols; j++) {
                        LinkedList<Integer> tmp = new LinkedList<>(sheet[i][j]);
                        Collections.reverse(tmp);
                        newSheet[t][j].addAll(tmp);
                    }
                }
                sheet = newSheet;
                rows = sheet.length;
            }
        }
        LinkedList<Integer> stack = sheet[0][0];
        System.out.print(stack.getLast() + " " + stack.getFirst());
    }
}
