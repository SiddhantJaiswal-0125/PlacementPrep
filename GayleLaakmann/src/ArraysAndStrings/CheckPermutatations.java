package ArraysAndStrings;


import java.io.*;

public class CheckPermutatations
{
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        if(isPermutation(s1,s2))
            System.out.println("Yes, Both String are Permutation of Each Other");
        else
            System.out.println("No, Both Stirngs are not Permutation of Each Other");


    }
    static boolean isPermutation(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return  false;
       return solveBySorting(s1, s2);

    }
    static boolean solveBySorting(String s1, String s2)
    {
        return sortStrings(s1).equalsIgnoreCase(sortStrings(s2));
    }
    static  String sortStrings(String s)
    {
        char ch []  = s.toCharArray();
        java.util.Arrays.sort(ch);
        return new String(ch);
    }


}
