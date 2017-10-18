/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringanalyzer;

/**
 *
 * @author dobri
 */
public class StringAnalyzer {

    public static int getPlateauLength(String s)
    {
        if(s.length() == 0)
        {
            return 0;
        }
        
        int longestLen = 1;
        int crrLen = 1;
        char crrChar = s.charAt(0);
        for(int i=1; i<s.length();i++)
        {
            if(s.charAt(i) == crrChar)
            {
                crrLen++;
            }else{
                if(crrLen > longestLen)
                    longestLen = crrLen;
                
                crrLen = 1;
                crrChar = s.charAt(i);
            }
        }
        
        return longestLen;
    }
    
    public static void main(String[] args) {
        System.out.println( getPlateauLength("") );
        System.out.println( getPlateauLength("abbabcaaaccdcdcdc") );
        System.out.println( getPlateauLength("abcdef") );
        System.out.println( getPlateauLength("abccddddeffff") );
    }
    
}
