/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatcher;

/**
 *
 * @author dobri
 */
public class PatternMatcher {

    public static boolean match(String s, String p)
    {
        System.out.println("s: " + s + ", p: " + p);
        if(p.length() == 0)
                return true;
        //we are sure that p.length()>=1
        if(s.length() == 0)
            return false;
 
        if(p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))
        {
            return match(s.substring(1), p.substring(1)) 
                    || match(s.substring(1), p); 
        }
        else if(p.charAt(0) == '*')
        {
            return match(s, p.substring(1));
        }
        else{
            return match(s.substring(1), p);
        }      
    }
    
    
    public static void main(String[] args) {
//        System.out.println( match("abcdef", "de") );
//        System.out.println( match("abcdef", "d?") );
//        System.out.println( match("abcdef", "*ef") );
        
        System.out.println( match("abcdef", "a?cd*g") );
//        System.out.println( match() );
    }
    
}
