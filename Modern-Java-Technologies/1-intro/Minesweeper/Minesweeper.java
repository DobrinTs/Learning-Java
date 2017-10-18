/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
import java.util.*;
/**
 *
 * @author dobri
 */
public class Minesweeper {

    public static int[][] initializeBoard(int height, int width, int mines)
    {
        int table[][] = new int[height][width];
        Set<Integer> positions = new HashSet<>();
        Random r = new Random();
        while(positions.size() < mines )
        {
            positions.add(r.nextInt(height*width));
        }
        
        for(int pos : positions)
        {
            table[pos/width][pos%width] = -1;
        }
        
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
            {
                if(table[i][j] == -1)
                    continue;
                table[i][j] = countNeighMines(table,height,width,i,j);
                
            }
        }
//        System.out.println(isMine(table,height,width,0,1));
//        System.out.println(isMine(table,height,width,0,-1));
//        System.out.println(isMine(table,height,width,1,1));
//        System.out.println(isMine(table,height,width,0,1));
//        System.out.println(isMine(table,height,width,1,4));
//        
//        System.out.println(countNeighMines(table,height,width,1,1));
        return table;
    }
    
    public static int countNeighMines(int[][] table,int height, int width, int x, int y)
    {
        int mines =0;
        for(int i=-1; i<=1; i++)
        {
            for(int j=-1; j<=1; j++)
            {
                if(i==0 && j==0)
                    continue;
                if(isMine(table,height,width,x+i,y+j))
                    mines++;
            }
        }
        return mines;
    }
    
    public static boolean isMine(int[][] table,int height, int width, int x, int y)
    {
        if(x < 0 || x >= height || y < 0 || y >= width)
            return false;
        if(table[x][y] == -1)
            return true;
        return false;
    }
        
    public static void printTable(int[][] table, boolean[][] played, int height, int width)
    {
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
                if(played[i][j] == true)
                    System.out.print(table[i][j] + " ");
                else
                    System.out.print("* ");
            
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter height: ");
        int height = keyboard.nextInt();
        System.out.print("Enter width: ");
        int width = keyboard.nextInt();
        System.out.print("Enter number of mines: ");
        int mines = keyboard.nextInt();
        
        int[][] table = initializeBoard(height, width, mines);
//        printTable(table, height, width);
        
        boolean[][] played = new boolean[height][width];
        int freeSpacesRemaining = height*width - mines;
        int x,y;
        while(freeSpacesRemaining > 0)
        {
            System.out.println("----------------------------");
            printTable(table, played, height, width);
            System.out.print("x: ");
            x = keyboard.nextInt();
            System.out.print("y: ");
            y = keyboard.nextInt();
            if(x < 0 || x >= height || y < 0 || y >= width)
            {
                System.out.println("Invalid position - exceeded limit");
                continue;
            }
            if(isMine(table,height,width,x,y))
            {
                System.out.println("GAME OVER - you hit a mine");
                return;
            }else if(!played[x][y])
            {
                played[x][y] = true;
                freeSpacesRemaining--;
            }
        }
        printTable(table, played, height, width);
        System.out.println("YOU WON!!");
    }
    
    //to-do:
    //boolean -> int
    // mina == -1
    //ina4e broi mini v sysedstvo
    
}
