import java.util.*;
public class ABC{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        String[] rawItems = sc.nextLine().trim().split("\\s+");
        char[] initialOrder = new char[N];
        for (int i = 0; i < N; i++) 
        initialOrder[i] = rawItems[i].charAt(0);
        String fixedItems = "";
        if (sc.hasNextLine()) 
        fixedItems = sc.nextLine().trim();
        Set<Integer> fixed = new HashSet<>();
        if (!fixedItems.isEmpty()) {
            String[] f = fixedItems.split("\\s+");
            for (String s : f) 
            if (!s.isEmpty()) 
            fixed.add(Integer.parseInt(s)-1);
        }
        int cntA=0,cntB=0,cntC=0;
        for (char ch: initialOrder) {
            if (ch=='A') 
            cntA++;
            else if (ch=='B') 
            cntB++;
            else 
            cntC++;
        }
        List<char[]> permutations = new ArrayList<>();
        permutations.add(new char[]{'A','B','C'});
        permutations.add(new char[]{'A','C','B'});
        permutations.add(new char[]{'B','A','C'});
        permutations.add(new char[]{'B','C','A'});
        permutations.add(new char[]{'C','A','B'});
        permutations.add(new char[]{'C','B','A'});

        int LeastShifts = Integer.MAX_VALUE;
        for (char[] ord : permutations) {
            int[] blockSize = new int[3];
            for (int i=0;i<3;i++){
                if (ord[i]=='A') 
                blockSize[i]=cntA;
                if (ord[i]=='B') 
                blockSize[i]=cntB;
                if (ord[i]=='C') 
                blockSize[i]=cntC;
            }
            char[] target = new char[N];
            int targetidx=0;
            for (int i=0;i<3;i++){
                for (int k=0;k<blockSize[i];k++) 
                target[targetidx++]=ord[i];
            }
            boolean valid=true;
            for(int pos: fixed){
                if (initialOrder[pos] != target[pos]) { 
                    valid=false; 
                    break; 
                }
            }
            if (!valid) 
            continue;
            int wrongPlacements=0;
            for (int i=0;i<N;i++) 
            if (initialOrder[i]!=target[i]) 
            wrongPlacements++;
            LeastShifts = Math.min(LeastShifts, wrongPlacements);
        }

        if (LeastShifts==Integer.MAX_VALUE) 
        System.out.println("Impossible");
        else System.out.println(LeastShifts);
    }
}