/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;

/**
 *
 * @author ananya anand
 */
public class Q5 {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        utility u = new utility();
        
        Girl[] g = new Girl[30];
        Boy[] b = new Boy[100];
    
        u.InputGirls(g); /*take girls as input and sort it in inc order of their maintenanceBudget*/
        u.FileGirls(g);  /* writing the input on file "girl5.txt" */
    
        u.InputBoys(b); /*take boys as input and sort it in inc order of their attractiveness */
        u.FileBoys(b);  /*writing the input on file "boy5.txt" */
        
        Jodi[] p = new Jodi[g.length];
        u.Pairing(b,g);  /* making pair as one girl chooses a boy, then one boy choses a girl, and so on*/ 
      
        u.MakeJodi(g, b, p); /* it makes an array of pairs of type jodi */
        
        Random rand = new Random();
        
        int k = rand.nextInt(10) + 5;
        
        u.kHappiestPair(p,k);/* calculate happiness of each pair formed and print k happiest couple as output */
    }
        
        
}   
    

