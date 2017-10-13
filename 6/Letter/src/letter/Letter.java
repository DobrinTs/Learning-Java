/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letter;

/**
 *
 * @author dobri
 */
public class Letter {

    public static void dashLine()
    {
        for(int i=0; i<100; i++)
            System.out.print('-');
        System.out.println();
    }
    
    public static void hashLine()
    {
        System.out.print('|');
        for(int i=0; i<94; i++)
            System.out.print(' ');
        System.out.print("### ");
        System.out.println('|');
    }
    
    public static void emptyLine()
    {
        System.out.print('|');
        for(int i=0; i<98; i++)
            System.out.print(' ');
        System.out.println('|');
    }
    
    public static void contentLine(String text)
    {
        int len = text.length();
        System.out.print('|');
        for(int i=0; i<68; i++)
            System.out.print(' ');
        System.out.print(text);
        for(int i=0; i< 30 - len; i++)
            System.out.print(' ');
        System.out.println('|');
    }
    
    public static void main(String[] args) 
    {
        dashLine();
        for(int i=0;i<3;i++)
            hashLine();
        
        for(int i=0;i<4;i++)
            emptyLine();
        
        contentLine("Dobrin Tsvetkov");
        contentLine("Sofia");
        contentLine("Bulgaria");
        
        for(int i=0;i<1;i++)
            emptyLine();
        
        dashLine();
        
    }
    
}
