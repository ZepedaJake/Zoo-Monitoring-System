/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomonitoringsystem;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
//import javax.swing.*;




/**
 *
 * @author Shawna Loudon
 */
public class ZooMonitoringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        Scanner scnr = new Scanner(System.in);
        String monitorChoice = "";
        String entry = "";
        String returnTo = "";
        ArrayList<Animal> animals = new ArrayList<Animal>();
        ArrayList<Habitat> habitats = new ArrayList<Habitat>();
        boolean validEntry = false;
        boolean validMonitor = true;
        BufferedReader br = null;
        FileReader fr = null;

        //read animals.txt and create a list of the animals and their respective info
        try 
        {
            fr = new FileReader("animals.txt");
            br = new BufferedReader(fr);

            String currentLine = "";
                        
            br = new BufferedReader(new FileReader("animals.txt"));

            //create a short array to store info
            String[] animalInfo = new String[5];
            do
            {
                
                if(currentLine.contains("Animal"))
                {
                    //start reading the next 5 lines into animal info
                    Animal a = new Animal();
                    for(int x = 0; x<5;x++)
                    {
                        animalInfo[x] = currentLine;                                    
                        currentLine = br.readLine();
                    }   
                    //read info array into a new animal object
                    a.type = animalInfo[0];
                    a.name = animalInfo[1];
                    a.age = animalInfo[2];
                    a.health = animalInfo[3];
                    a.feed = animalInfo[4];
                                
                    //add new animal instance to list
                    animals.add(a);                              
                }
                currentLine = br.readLine();                          
            }
            while (currentLine != null);

	} 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        
        //read habitat.txt and create a list
        try 
        {
            fr = new FileReader("habitats.txt");
            br = new BufferedReader(fr);

            String currentLine = "";
                        
            br = new BufferedReader(new FileReader("habitats.txt"));

            //create a short array to store info
            String[] habitatInfo = new String[5];
            do
            {
                
                if(currentLine.contains("Habitat"))
                {
                    //start reading the next 4 lines into animal info
                    Habitat h = new Habitat();
                    for(int x = 0; x<4;x++)
                    {
                        habitatInfo[x] = currentLine;                                    
                        currentLine = br.readLine();
                    }   
                    //read info array into a new animal object
                    h.type = habitatInfo[0];
                    h.temp = habitatInfo[1];
                    h.food = habitatInfo[2];
                    h.clean = habitatInfo[3];
                    
                                
                    //add new animal instance to list
                    habitats.add(h);                              
                }
                currentLine = br.readLine();                          
            }
            while (currentLine != null);

	} 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        
        System.out.println("Welcome to SNHU Zoo Monitoring System");
        //main loop
        do
        {
            //when looping, if wrong option or mispelled option entered, show error message
            if(validMonitor == false)
            {
                JOptionPane.showMessageDialog(null,"Invalid Monitor Option","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("-----------------------");
                //System.out.println("\nInvalid Monitor Option\n");
            }
            
            System.out.println("-----------------------");
            System.out.println("Would you like to Monitor a Habitat or Animal?");
            monitorChoice = scnr.next();
                        
            //repeat this if the user later chooses to go back rather than home or exit
            do
            {
                //do this until an existing entry for habitat or animal is entered
                do
                {
                    returnTo = "";
                    validEntry = false;
                    
                    if(monitorChoice.equalsIgnoreCase("Animal") || monitorChoice.equalsIgnoreCase("Animals"))
                    {
                        validMonitor = true;
                        System.out.println("\nAnimal Options");
                        System.out.println("-----------------------");
                                       
                        //display each animal type from animal list
                        for(Animal a:animals)
                        {
                            String temp = a.type;
                            temp = temp.substring(9,temp.length());
                            System.out.println(temp);
                        
                            System.out.println();
                        }
                    
                        System.out.println("-----------------------");
                        System.out.println("Which animal would you like to view");
                        entry = scnr.next();
                    }
                    else if(monitorChoice.equalsIgnoreCase("Habitat") || monitorChoice.equalsIgnoreCase("Habitats"))
                    {
                        validMonitor = true;
                       System.out.println("\n\nHabitat Options");
                        System.out.println("-----------------------");
                                       
                        //display each animal type from habitat list
                        for(Habitat h:habitats)
                        {
                            String temp = h.type;
                            temp = temp.substring(10,temp.length());
                            System.out.println(temp);
                        
                            System.out.println();
                        }
                    
                        System.out.println("-----------------------");
                        System.out.println("Which habitat would you like to view");
                        entry = scnr.next();
                    }
                    else
                    {
                        //if neither animal or habitat was entered, set bool false and break loop to enter again
                        validMonitor = false;
                        break;
                    }
                
                    //just some space for viewing purposes
                    System.out.println("\n");
                    if(monitorChoice.equalsIgnoreCase("Habitat") || monitorChoice.equalsIgnoreCase("Habitats"))
                    {
                        //look for entry in list and display entry info
                        for(Habitat h:habitats)
                        {
                            if(h.type.toLowerCase().contains(entry.toLowerCase()))
                            {
                                //if a habitat is found set valid entry true, then read out habitat info
                                validEntry = true;
                                System.out.println("-----------------------\n");
                                PrintInfo(h.type);
                                PrintInfo(h.temp);
                                PrintInfo(h.food);
                                PrintInfo(h.clean);                                
                                System.out.println("\n-----------------------");
                                //System.out.println();
                                
                            }
                        }                    
                    }
                    else
                    {
                        //look for entry in list and display entry info
                        for(Animal a:animals)
                        {
                            if(a.type.toLowerCase().contains(entry.toLowerCase()))
                            {
                                //if an animal is found set valid entry true and read out animal info
                                validEntry = true;
                                System.out.println("\n-----------------------");
                                PrintInfo(a.type);
                                PrintInfo(a.name);
                                PrintInfo(a.age);
                                PrintInfo(a.health);
                                PrintInfo(a.feed);
                                System.out.println("\n-----------------------");
                                /*System.out.println(a.type);
                                System.out.println(a.name);
                                System.out.println(a.age);
                                System.out.println(a.health);
                                System.out.println(a.feed);
                                System.out.println();*/
                                //JOptionPane.showMessageDialog(null,"something had stars", "Important", JOptionPane.WARNING_MESSAGE);
                            }
                        }                    
                    }
                
                    if(validEntry == false)
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Entry","Error",JOptionPane.ERROR_MESSAGE);
                        System.out.println("-----------------------");
                        //System.out.println("Invalid Entry");
                    }
                }
                while(validEntry == false);
                
                //do this until user chooses to go back, home, or exit the program from here.
                do
                {
                    if(validMonitor == false)
                    {
                        break;
                    }
                    
                    //if user entered something wrong, show error message.
                    if(!returnTo.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Return Option","Error",JOptionPane.ERROR_MESSAGE);
                        System.out.println("-----------------------");                       
                    }
                    
                    System.out.println("\nWhat would you like to do next? (Home, Back, Exit)");
                    returnTo = scnr.next();
                    
                    if(returnTo.equalsIgnoreCase("Exit"))
                    {
                        monitorChoice = "Exit";
                    }      
                    System.out.println("\n\n"); 
                }
                while(!returnTo.equalsIgnoreCase("Back") && !returnTo.equalsIgnoreCase("Home") && !returnTo.equalsIgnoreCase("Exit"));
                
            }
            while(returnTo.equalsIgnoreCase("Back"));
            
        }
        while(!monitorChoice.equalsIgnoreCase("Exit"));
              
        System.out.println("Exiting. Goodbye");
               
    }    
    
    public static void PrintInfo(String s)
    {
        //if there are *'s show an alert box, and then print the info without the stars
        if(s.contains("*****"))
        {
            //chop out the stars, then show the messsage box
            s = s.substring(5,s.length());
            System.out.println(s);
            JOptionPane.showMessageDialog(null,s,"Important",JOptionPane.WARNING_MESSAGE);                                                          
        }
        else
        {
            System.out.println(s);
        }
        
    }
}
