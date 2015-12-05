package test;

import java.io.*;
import java.math.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static LinkedList<String> handDeck1;
    static LinkedList<String> handDeck2;
    static LinkedList<String> deskDeck1;
    static LinkedList<String> deskDeck2;
    
    static
    {
    	handDeck1 = new LinkedList<String>();
    	handDeck2 = new LinkedList<String>();
    	deskDeck1 = new LinkedList<String>();
    	deskDeck2 = new LinkedList<String>();
    }
    
    public static int startAWar() {
    	if (handDeck1.size() < 3 || handDeck2.size() < 3) return 0;
    	for (int i=0 ;i < 3; i++)
    	{
    		String c1 = handDeck1.poll();
    		deskDeck1.add(c1);
    		String c2 = handDeck2.poll();
    		deskDeck2.add(c2);
    	}
        String c1 = handDeck1.poll();
        String c2 = handDeck2.poll();
        if (c1 == null || c2 == null) return 0;
        deskDeck1.add(c1);
        deskDeck2.add(c2);
        
        int result = compareCard(c1, c2);
        
        if (result < 0) {
        	while (!deskDeck1.isEmpty()) {
            	String c = deskDeck1.poll();
            	handDeck2.add(c);
            }
        	while (!deskDeck2.isEmpty()) {
            	String c = deskDeck2.poll();
            	handDeck2.add(c);
            }
            return 2;
        } 
        else if (result > 0)
        {
        	while (!deskDeck1.isEmpty()) {
            	String c = deskDeck1.poll();
            	handDeck1.add(c);
            }
            while (!deskDeck2.isEmpty()) {
            	String c = deskDeck2.poll();
            	handDeck1.add(c);
            }
            return 1;
        } 
        else
        {
        	return startAWar();
        }
    	
    }
    
    public static HashMap<String, Integer> m = new HashMap<String, Integer>();
    static
    {
        m.put("2", 1);
        m.put("3", 2);
        m.put("4", 3);
        m.put("5", 4);
        m.put("6", 5);
        m.put("7", 6);
        m.put("8", 7);
        m.put("9", 8);
        m.put("10", 9);
        m.put("J", 10);
        m.put("Q", 11);
        m.put("K", 12);
        m.put("A", 13);
    }
    
    public static int compareCard(String card1, String card2)
    {
        return m.get(card1.substring(0, card1.length()-1)) - m.get(card2.substring(0, card2.length()-1));
    }
    
    public static void main(String args[]) {
        
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            handDeck1.add(cardp1);
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            handDeck2.add(cardp2);
        }
        
        int steps = 0;
        
        while (true)
        {
        	steps++;
            String c1 = handDeck1.poll();
            String c2 = handDeck2.poll();
            
            if (c1 == null && c2 == null) 
            {
            	System.out.println("PAT");
            	break;
            }
            
            if (c1 == null)
            {
            	System.out.println("2 " + (steps-1));
            	break;
            }
            
            if (c2 == null)
            {
            	System.out.println("1 " + (steps-1));
            	break;
            }
            
            deskDeck1.add(c1);
            deskDeck2.add(c2);
            
            int result = compareCard(c1, c2);
            
            if (result < 0) {
            	while (!deskDeck1.isEmpty()) {
                	String c = deskDeck1.poll();
                	handDeck2.add(c);
                }
                while (!deskDeck2.isEmpty()) {
                	String c = deskDeck2.poll();
                	handDeck2.add(c);
                }
            } 
            else if (result > 0)
            {
            	while (!deskDeck1.isEmpty()) {
                	String c = deskDeck1.poll();
                	handDeck1.add(c);
                }
                while (!deskDeck2.isEmpty()) {
                	String c = deskDeck2.poll();
                	handDeck1.add(c);
                }
            } 
            else
            {
            	int isPAT = startAWar();
            	if (isPAT == 0)
            	{
            		System.out.println("PAT");
            		break;
            	}
            }
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        
    }
}