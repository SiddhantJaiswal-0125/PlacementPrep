package ArraysAndStrings;

import java.util.*;

public class IsUniqueChars
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(isUnique(s))
            System.out.println("All Charcters Unique");
        else
            System.out.println("All Charcters are not Unique");


    }
    static boolean isUnique(String s)
    {
        if(s.length()>128)
            return false;
        boolean charSet[] = new boolean[128];
        for(int i  =0;i<s.length();i++)
            if(charSet[s.charAt(i)])
                return false;
            else
            charSet[s.charAt(i)] = true;
        return true;
    }
}
