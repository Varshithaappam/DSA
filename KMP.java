class KMP{
    static int[] LPS(String pat){
        int m = pat.length();
        int lps[] = new int[m];
        int len = 0;
        int i = 1;
        while(i < m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    static void KMPSearch(String pat, String txt){
        int m = pat.length();
        int n = txt.length();
        int lps[] = LPS(pat);
        int i = 0;
        int j = 0;
        while(i < n){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            }
            else if(i < n && pat.charAt(j) != txt.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }
}