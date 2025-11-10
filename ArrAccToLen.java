import java.util.*;
class ArrAccToLen{
    public static void main(String[] args){
        String sentence = "an apple a day keeps a doctor away";
        String[] words = sentence.split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String sortedSentence = String.join(" ", words);
        System.out.println(sortedSentence);
    }
}