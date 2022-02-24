package ArraysAndStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class URLify
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given = br.readLine();
        int truelength = Integer.parseInt(br.readLine());
        String resOut = new URLify().urlify(given, truelength);
        System.out.println(resOut);

    }
    String urlify(String given, int truelength)
    {
        int ind = 0;
        int count = 0;
        for(int i =0;i<truelength;i++)
            if(given.charAt(i) == ' ')
                count++;

        ind = truelength+ (2*count);
        char ch[] = given.toCharArray();

//        if(ind<given.length())
        if(truelength<given.length()) {
            System.out.println("HERE");
            ch[truelength] = '\0';
        }


        for(int i = truelength-1;i>=0;i--)
            if(ch[i] == ' ')
            {
                 ch[ind-1] = '0';
                 ch[ind-2] ='2';
                 ch[ind-3] =  '%';
                 ind = ind -3;

            }
        else
                ch[--ind] = ch[i];
    return  new String(ch);
    }

}
