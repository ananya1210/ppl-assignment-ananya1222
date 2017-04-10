/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.*;

/**
 *
 * @author ananya anand
 */
public class Jodi {
     //Attributes of Pairs
     
     public Girl g;
     public Boy b;
     
     int happiness=0;
     int compatibility=0;
     
    //constructor of Pairs
     
     
    public Jodi(Girl girl, Boy boy[])
    {
        this.g = girl;
        if(g.status == 1)
        {
            this.b = boy[g.id] ;
           
        }
    }
     
    public Jodi()
    {
         
    }
    
    
}
