/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;

/**
 *
 * @author ananaya anand
 */
public class Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         utility u = new utility();
        
        Girl[] g = new Girl[50];
        Boy[] b = new Boy[150];
        u.FileGirls(g);
        u.FileBoys(b);
        
        Jodi[] p = new Jodi[g.length];
        u.FileJodi(b,g);
      
        u.MakeJodi(g, b, p);
        
        Random rand = new Random();
        
        int t = rand.nextInt(30) + 1;
        
      //  u.SortHappyPairIncOdr(p);
    
        
        u.BreakUp(p,t);
      
       
        u.AssignNewBF(p,b);
        
    }
        
        // TODO code application logic here
    }
    

