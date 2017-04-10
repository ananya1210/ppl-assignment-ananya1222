/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;


/**
 *
 * @author ananya anand
 */
public class Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException
    {
        utility u = new utility();
        
        Girl[] g = new Girl[50];
        Boy[] b = new Boy[150];
        u.FileGirls(g);
        u.FileBoys(b);
        
        Jodi[] p = new Jodi[g.length];
        u.FileJodi(b,g);
      
        u.MakeJodi(g, b, p);
        
        Random rand = new Random();
        
        int k = rand.nextInt(10) + 5;
        
      //  u.SortHappyPairIncOdr(p);
    
        
        u.BreakUp(p,k);
      
       
        u.AssignNewBF(p,k,b);
        
    }
    
}
