/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import m2.textio.ITextIO;
import m2.textio.TextIOFactory;

/**
 *
 * @author Pravien
 */
public class FileReader
{
   private Scanner scan;
   ITextIO io = TextIOFactory.getSysTextIO();
   
    public static void main(String[] args)
    {
            FileReader newFilereader = new FileReader ();
            Player newPlayer = new Player("karl");
            newPlayer.setGold(100);
            Player newPlayer1 = new Player("kasrl");
            newPlayer1.setGold(200);
            newFilereader.openFile();
            //newFilereader.disPlayHighScore();
           
           //newFilereader.updateTextInFile(newPlayer);
           //newFilereader.updateTextInFile(newPlayer1);
    
           
          newFilereader.sortTextFile();
           
           
          // newFilereader.sortTextFile();
            newFilereader.closeFile();
    }
    
    public ArrayList<ID> importTextFromTextFile (){
        ArrayList<ID> IDList = new ArrayList <>();
        
        while (scan.hasNext()){
           
           String name = scan.next();
           String score = scan.next();
           int scoreInt= Integer.parseInt(score);
           ID newID = new ID(name,scoreInt);
           IDList.add(newID);
        }
        return IDList;
    }
    public void sortTextFile (){
       ArrayList <ID> temp = importTextFromTextFile();
       ArrayList <Integer> TempOutPut = new ArrayList <>();
       ArrayList <ID> outArray = new ArrayList <>();
        int SmallValue=0;
        for (int i = 0; i < temp.size(); i++)
        {
            
            TempOutPut.add(temp.get(i).getScore());
        }
        
        Collections.sort(TempOutPut);
        Collections.reverse(TempOutPut);
        
        
        
        for (int i = 0; i < TempOutPut.size(); i++)
        {
            
            
            for (int j = 0; j < temp.size(); j++)
            {
                if(TempOutPut.get(i)==temp.get(j).getScore()){
                    outArray.add(temp.get(j));
                    temp.remove(j);
                }
                
            }
            
        }
        
        TestTupdateTextInFile(outArray);

    }
   // this method open the file, that we want to read an write to.
   public void openFile(){
       try{
       scan = new Scanner (new File("C:\\Users\\auron\\Documents\\NetBeansProjects\\TextualAdventureGame V1 - PravienCasper\\src\\main\\testfil.txt"));
       }
       catch (Exception e){
           io.put("could not find file");
       }
   }
   
   // this method Displays the current highscore
   public void disPlayHighScore(){
       String name = "";
       String score = "";
       // this try catch is just to catch the error the might occur
       // if you forget to open the file.
       try {
       // checks if the file is empty.
       if(scan.hasNext()==false){
           io.put("There are no current highscore\n");
           io.put("\n");
       }
       // else it gets the name and score from the textfile and print them out.
       else {
        io.put("-------- HIGHSCORE --------");
        io.put("\n");
        while (scan.hasNext()){
           
           name = scan.next();
           score = scan.next();
           
            io.put(name+" has score "+score+"\n");
           
        }
//        io.put("The current highscore is by "+name);
//        io.put("The score is "+score+"\n");
//        io.put("\n");
        io.put("\n");
        io.put("-------- EndOFHIGHSCORE --------");
        io.put("\n");
        io.put("\n");
       }
       }
       catch (Exception e){
           io.put("Forgot to open file");
       }
   }
   // this method is used to get the higscore from the textfile
   // and then updating it , if necessary.

   // This metod checks if the currentplayer score is greater then
   // the current highscore

   
   public void closeFile (){
       scan.close();
   }
   
//   // this method removes the old score and name
//   public void removeContetFromText() {
//       
//       PrintWriter writer = null;
//       try
//       {
//           writer = new PrintWriter("testfil.txt");
//           writer.print("");
//       } catch (FileNotFoundException ex)
//       {
//           
//           io.put("Could not find file");
//       } finally
//       {
//           writer.close();
//       }
//   }
   // this metod inserts the new name and highscore.
   public void updateTextInFile(Player newPlayer){
       String name = newPlayer.getName();
       String score = Integer.toString(newPlayer.getGold());
       File log  = new File ("C:\\Users\\auron\\Documents\\NetBeansProjects\\TextualAdventureGame V1 - PravienCasper\\src\\main\\testfil.txt");
    try{
        FileWriter writer = new FileWriter(log,true);
        writer.write(name);
        writer.write("\n");
        writer.write(score);
        writer.write("\n");
        writer.flush();
        
        writer.close();
    }    
    catch (Exception e) {
        io.put("Fejlede i updatetextInFile");
    }
}
   
      public void TestTupdateTextInFile(ArrayList<ID> temp){
       
    try{
        PrintWriter writer = new PrintWriter("C:\\Users\\auron\\Documents\\NetBeansProjects\\TextualAdventureGame V1 - PravienCasper\\src\\main\\testfil.txt");
        
        for (int i = 0; i < temp.size(); i++)
        {
            writer.println(temp.get(i).getName());
            writer.println(temp.get(i).getScore());
            
        }
        
        
        writer.close();
    }    
    catch (Exception e) {
        io.put("Fejlede i updatetextInFile");
    }
}
    
}
