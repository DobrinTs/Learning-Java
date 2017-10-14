package initials;
import java.util.*;

/**
 *
 * @author dobri
 */
public class Initials {
    
    Initials()
    {
        letters = new HashMap<>();
        String A ="   A   \n"
                + "  A A  \n"
                + " AA AA  \n"
                + "A     A";
        letters.put('a', A);
        
        String B ="BBBB   \n"
                + "B   B\n"
                + "BBBB \n"
                + "B   B\n"
                + "BBBB";
        letters.put('b', B);
        
        String C =" CCCC \n"
                + "C   \n"
                + "C\n"
                + "C   \n"
                + " CCCC";
        letters.put('c', C);
        
        String D ="DDDD\n"
                + "D   D\n"
                + "D    D\n"
                + "D   D\n"
                + "DDDD";
        letters.put('d', D);
        
        String E ="EEEEE\n"
                + "E\n"
                + "EEEEE\n"
                + "E\n"
                + "EEEEE";
        letters.put('e', E);
        
        String F ="FFFFF\n"
                + "F\n"
                + "FFFFF\n"
                + "F\n"
                + "F";
        letters.put('f', F);
        
        String G =" GGGGG\n"
                + "G\n"
                + "G  GGG\n"
                + "G    G\n"
                + " GGGG";
        letters.put('g', G);
        
        String H ="H    H\n"
                + "H    H\n"
                + "HHHHHH\n"
                + "H    H\n"
                + "H    H";
        letters.put('h', H);
        
        String I ="IIIII\n"
                + "  I\n"
                + "  I\n"
                + "  I\n"
                + "IIIII";
        letters.put('i', I);
        
        String J =" JJJJ\n"
                + "    J\n"
                + "    J\n"
                + "J   J\n"
                + " JJJ";
        letters.put('j', J);
        
        String K ="K   K\n"
                + "K  K\n"
                + "KK\n"
                + "K  K\n"
                + "K   K";
        letters.put('k', K);
        
        String L ="L\n"
                + "L\n"
                + "L\n"
                + "L\n"
                + "LLLLL";
        letters.put('l', L);
        
        String M ="M     M\n"
                + "MM   MM\n"
                + "M M M M\n"
                + "M  M  M\n"
                + "M     M";
        letters.put('m', M);
        
        String N ="N     N\n"
                + "NN    N\n"
                + "N N   N\n"
                + "N  N  N\n"
                + "N    NN";
        letters.put('n', N);
        
        String O =" OOO\n"
                + "O   O\n"
                + "O   O\n"
                + "O   O\n"
                + " OOO";
        letters.put('o', O);
        
        String P ="PPP\n"
                + "P  P\n"
                + "PPP\n"
                + "P\n"
                + "P";
        letters.put('p', P);
        
        String Q =" QQQ\n"
                + "Q    Q\n"
                + "Q    Q\n"
                + "Q   Q\n"
                + " QQQ Q" ;
        letters.put('q', Q);
        
        String R ="RRR\n"
                + "R  R\n"
                + "RRR\n"
                + "R  R\n"
                + "R   R";
        letters.put('r', R);
        
        String S ="SSSS\n"
                + "S\n"
                + "SSSS\n"
                + "   S\n"
                + "SSSS";
        letters.put('s', S);
        
        String T ="TTTTT\n"
                + "  T\n"
                + "  T\n"
                + "  T\n"
                + "  T";
        letters.put('t', T);
        
        String U ="U   U\n"
                + "U   U\n"
                + "U   U\n"
                + "U   U\n"
                + " UUU";
        letters.put('u', U);
        
        String V ="V   V\n"
                + "V   V\n"
                + "V   V\n"
                + " V V \n"
                + "  V";
        letters.put('v', V);
        
        String W ="W     W\n"
                + "W     W\n"
                + "W  W  W\n"
                + "WWW WWW\n"
                + "W     W";
        letters.put('w', W);
        
        String X ="X   X\n"
                + " X X \n"
                + "  X\n"
                + " X X \n"
                + "X   X";
        letters.put('x', X);
        
        String Y ="Y   Y\n"
                + " Y Y \n"
                + "  Y\n"
                + "  Y\n"
                + "  Y";
        letters.put('y', Y);
        
        String Z ="ZZZZZ\n"
                + "   Z\n"
                + "  Z\n"
                + " Z\n"
                + "ZZZZZ";
        letters.put('z', Z);
    }
    
    public void printer(char c)
    {
        System.out.println(letters.get(c));
        System.out.println();
    }

    
    public static void main(String[] args) {
        Initials i = new Initials();
        
        System.out.println("Please enter your full name:");
        
        Scanner sc = new Scanner(System.in);
        String fullName;
        fullName = sc.nextLine();
        
        System.out.println("Hello " + fullName);
        System.out.println("Your initials are:");
        
        String[] names = fullName.toLowerCase().split(" ");
        for(String name : names){
            i.printer(name.charAt(0));
        }
        
    }
    
    Map<Character, String> letters;
}
