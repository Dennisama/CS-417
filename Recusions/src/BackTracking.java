import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking {
    public static ArrayList<String> dictionary;

    public static void permutations( String s ){ //not recursive, just easier for user to call
        perm(s, "");
    }

    public static void perm(String s, String res){ //actually recursive, take remaining part of string and some partial result
        if(s.length() == 0) { //base case
            System.out.println(res);
        } else { //recursive case
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i); //the char to add to resulting permutation
                String next = s.substring(0, i) + s.substring(i+1); //cut out the char that was selected
                perm(next, res + c); //call recursively with shorter string and longer result
            }
        }
    }


    public static boolean makeWord( String s ){ //check if any permutation of s is a word, using all chars
        return mw(s, "");
    }

    //Attention !
    public static boolean mw(String s, String res) {
        if(s.length() == 0) { //base case, check if res is a word
            if(dictionary.contains(res)) {
                System.out.println(res);
                return true;
            } else {
                return false;
            }
        } else { //recursive case
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i); //the char to add to resulting permutation
                String next = s.substring(0, i) + s.substring(i+1); //cut out the char that was selected
                boolean found = mw(next, res + c); //call recursively with shorter string and longer result
                if(found) { //if found a word, return true
                    return true;
                }
            } //if for loop exits, I tried all permutations and never found a word
            return false;
        }
    }

    public static void main( String[] args ){

        permutations("");
        System.out.println();
        permutations("cat"); // cat, cta, act, atc, tca, tac
        System.out.println();
        permutations("word");
        System.out.println();
        //permutations("longer");


        dictionary = new ArrayList<String>(Arrays.asList(new String[] {"sword", "words", "act", "cat", "tac", "longer"}));

        String input = "rswod";
        if( !makeWord(input) )
            System.out.println("Couldn't make word from " + input);
        System.out.println();

        input = "cat";
        if( !makeWord(input) )
            System.out.println("Couldn't make word from " + input);
        System.out.println();

        input = "sor";
        if( !makeWord(input) )
            System.out.println("Couldn't make word from " + input);
        System.out.println();

        input = "gernol";
        if( !makeWord(input) )
            System.out.println("Couldn't make word from " + input);
        System.out.println();

    }
}
