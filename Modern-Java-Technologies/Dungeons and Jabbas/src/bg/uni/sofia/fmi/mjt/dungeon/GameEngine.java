/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.uni.sofia.fmi.mjt.dungeon;
import bg.uni.sofia.fmi.mjt.dungeon.actor.*;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.*;
import java.util.Scanner;
/**
 *
 * @author dobri
 */
public class GameEngine {
    //        0 за наляво; 1 за нагоре; 2 за надясно; 3 за надолу)
    private final int LEFT = 0;
    private final int UP = 1;
    private final int RIGHT = 2;
    private final int DOWN = 3;
    
    static boolean endgame;
    char[][] map;
    Hero hero;
    int currentEnemy;
    Enemy[] enemies;
    int currentTreasure;
    Treasure[] treasures;
    
    public GameEngine(char[][] map, Hero hero,
            Enemy[] enemies, Treasure[] treasures)
    {
        this.map = map;
            
        this.hero = new Hero(hero.getName(), hero.getHealth()
                , hero.getMana(), hero.getPosition());
        
        this.enemies = enemies;
        this.treasures = treasures;
        
        currentEnemy = 0;        
        currentTreasure = 0;
        endgame = false;
    }
    
    public char[][] getMap(){ return map; }
    
    public String makeMove(int command)
    {
//        0 за наляво; 1 за нагоре; 2 за надясно; 3 за надолу)
        int x = hero.getPosition().getX();
        int y = hero.getPosition().getY();
        if(command == LEFT){
            y--;
        }else if(command == UP){
            x--;
        }else if(command == RIGHT){
            y++;
        }else if(command == DOWN){
            x++;
        }else{
            return "Unknown command entered.";
        }
        
        if(x < 0 || x > map.length || y < 0 || y > map[x].length 
                || map[x][y] == '#')
        {
            return "Wrong move. There is an obstacle and you cannot bypass it.";
        }
        
        if(map[x][y] == 'G')
        {
            endgame = true;
            return "You have successfully passed through the dungeon. Congrats!";
        }
        
        if(map[x][y] == '.')
        {
            map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
            hero.getPosition().setX(x);
            hero.getPosition().setY(y);
            map[x][y] = 'H';
            return "You moved successfully to the next position.";
        }
        
        if(map[x][y] == 'T')
        {
            map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
            hero.getPosition().setX(x);
            hero.getPosition().setY(y);
            map[x][y] = 'H';
            
            if(currentTreasure == treasures.length)
                return "No more tresures :/ Sorry.";
            
            String message = treasures[currentTreasure].collect(hero);
            currentTreasure++;
            return message;
        }
        
        if(map[x][y] == 'E')
        {
            int turn = 0;
            if(currentEnemy == enemies.length){
                map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
                hero.getPosition().setX(x);
                hero.getPosition().setY(y);
                map[x][y] = 'H';
                return "No more enemies. Hurray!";
            }
            Enemy currEnemy = enemies[currentEnemy];
            currentEnemy++;
            System.out.println("---------------------------------------");
            System.out.println("BATTLE STARTED!!!");
            while(true)
            {
                if(!hero.isAlive()){
                    endgame = true;
                    return "Hero is dead! Game over!";
                }else if(!currEnemy.isAlive()){
                    map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
                    hero.getPosition().setX(x);
                    hero.getPosition().setY(y);
                    map[x][y] = 'H';
                    return "Enemy " + currEnemy.getName() + " died.";
                }else if(turn % 2 == 0){
//                    hero turn
                    int att = hero.attack();
                    currEnemy.takeDamage(att);
                    System.out.println("Inflicted: " + att);
                }else{
//                    enemy turn
                    int att = currEnemy.attack();
                    hero.takeDamage(att);
                    System.out.println("Took: " + att);
                }
                
                turn++;
            }
        }
       return ""; 
    }
    
    public static void printMap(char[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] Args)
    {
        Scanner keyboard = new Scanner(System.in);
        Hero dobrin = new Hero("Dobrin", 100, 50, new Position(0,0));
        char[][] map = {{'S', '.', '#', '#', '.', '.', '.', '.', '.', 'T'}, 
                        {'#', 'T', '#', '#', '.', '.', '#', '#', '#', '.'},
                        {'#', '.', '#', '#', '#', 'E', '#', '#', '#', 'E'}, 
                        {'#', '.', 'E', '.', '.', '.', '#', '#', '#', '.'}, 
                        {'#', '#', '#', 'T', '#', '#', '#', '#', '#', 'G'}};
//        printMap(map);
        
        Treasure treasures[] = new Treasure[3];
        Treasure t1 = new Weapon("Longsword", 5);
        Treasure t2 = new Spell("Fireball", 10, 10);
        Treasure t3 = new HealthPotion(30);
        
        treasures[0] = t1;
        treasures[1] = t2;
        treasures[2] = t3;
        
        Enemy[] enemies = new Enemy[3];
        enemies[0] = new Enemy("Gargoyle", 15, 5, new Weapon("Club", 5), null);
        enemies[1] = new Enemy("Demon", 25, 15, new Weapon("Claws", 10), null);
        enemies[2] = new Enemy("Boss", 40, 20,
                new Weapon("Tail", 15), new Spell("Hailstorm", 20, 10));
        
        GameEngine game = new GameEngine(map, dobrin, enemies, treasures);
        while(!endgame)
        {
            printMap(game.getMap());
            System.out.println("--------------------------------------");
            System.out.println("0 left; 1 up; 2 right; 3 down");
            System.out.println(game.hero.getName() + " health: " + game.hero.getHealth());
            System.out.println(game.hero.getName() + " mana: " + game.hero.getMana());
            System.out.print("What is your next move mortal: ");
            int requestedMove = keyboard.nextInt();
            String move = game.makeMove(requestedMove);
            System.out.println("--------------------------------------");
            System.out.println(move);
        }
    }
}
