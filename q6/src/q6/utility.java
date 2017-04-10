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
 * @author astha anand
 */
public class utility {
    int i,j;
    
    
    void FileGirls(Girl g[])
    {
   
         //GIRL
         try
         {
            PrintWriter a = new PrintWriter("girl6.txt", "UTF-8");
     
            for( i=0 ; i<g.length ; i++) 
            {
                g[i]=new Girl();
                 a.println(g[i].name + "   " +g[i].attractiveness + "   " +  g[i].intelligenceLevel + "    " + g[i].maintenanceBudget + "    " + g[i].status + "    " + g[i].type );
                    
            }
            a.close();
         }
         catch(Exception e){
             
         }  
    }
    
    void FileBoys(Boy b[])
    {
        //BOYS
        try
         {
            PrintWriter z = new PrintWriter("boy6.txt", "UTF-8");
            
            for( i=0 ; i<b.length ; i++) 
            {
                b[i]=new Boy();
                 z.println(b[i].name + "   " + b[i].attractiveness + "   " + b[i].intelligenceLevel + "   " + b[i].budget + "    " + b[i].minAttractivenessRequired + "    " + b[i].status + "    " + b[i].type);
                    
            }
            z.close();
         }
         catch(Exception e){
             
         }  
    }
   
    void FileJodi(Boy b[],Girl g[])
    {
        //PAIR
        try
         {
            PrintWriter q = new PrintWriter("pair6.txt", "UTF-8");
            int p=0;
            for(i=0 ; i<g.length ; i++)
            {
                for(j=0 ; j<b.length ; j++)
                {
                    if(  b[j].status==0 && g[i].status==0) 
                        if(b[j].EGBL(g[i].attractiveness, g[i].maintenanceBudget) && g[i].EGBL(b[j].budget))
                    {
                        g[i].status=1;
                        b[j].status=1;
                        g[i].boyfriend = b[j].name;
                        b[j].girlfriend = g[i].name;
                        g[i].id = j;
                        b[j].id = i;
                       
                        q.println("Pair(G,B)_"+ p + "  " + g[i].name + "  " + b[j].name);
                        p++;
                         
                    }
                }
            }
            
            q.close();
         }
         catch(Exception e){
                      
         } 
    }
   
   Random rand = new Random();
   
   
    
   
    
    
    void MakeJodi(Girl g[], Boy b[], Jodi p[])
    {
        j=0;
        
        for(i=0; i<g.length; i++)
        {
                p[j] = new Jodi(g[i],b );
                j++;
            
        }
    }
    
    
   
       
    
    
    
    void CalculateHappiness(Jodi p[])
    {
        int glh=0, byh=0;
             
        for( i=0; i<p.length; i++)
        { 
            if(p[i].g.status == 0)
                continue;
            
            if (p[i].g.type == 0)
                glh = (int)Math.log( Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent));
            
            else if (p[i].g.type == 1)    
                glh = Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent);
            
            else if (p[i].g.type == 2)
                glh = (int)Math.getExponent( Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent)) ;
            
            p[i].g.happiness = glh;
           
        }
        
        for(i=0; i<p.length; i++)
        {
            if(p[i].g.status == 0)
                continue;
             
            if (p[i].b.type == 0)
            {
                byh = Math.abs(p[i].b.budget - p[i].b.MoneySpent);
            }
            else if (p[i].b.type == 1)
                
                byh = (p[i].g.intelligenceLevel) ;
            
            else 
                byh = (p[i].g.happiness) ;
          
            p[i].b.happiness = byh;
        }
        
        for( i=0; i < p.length ; i++)
        {
             if(p[i].g.status == 1)
                 p[i].happiness = p[i].b.happiness + p[i].g.happiness;
           
        }
        
        
    }
     void BreakUp(Jodi p[],int t)
    {
        CalculateHappiness(p);
        
        Jodi tmp = new Jodi();
        
            for(i = 0; i < p.length-1 ; i++)
            {  
               for( j = 0; j < p.length-i-1 ; j++)
               {               
                  if( p[j+1].happiness < p[j].happiness)
                  {
                     tmp = p[j];
                     p[j] = p[j+1];
                     p[j+1] = tmp;
                  }
                } 
          
            }    
        
        for(i=0 ; i< p.length ;i++)
        {
            if(p[i].g.status == 0)
                continue;
            
            if(p[i].happiness < t)
            {
                p[i].g.status =0;
                p[i].b.status = 0;
            }
        }
        
        
    }
      void AssignNewBF(Jodi p[],Boy b[])
    {
       int l=0;
       
       try
       {
           
            PrintWriter w = new PrintWriter("NewPairFormed.txt", "UTF-8");
         
                for(i=0; i<p.length ;i++)
                {
                    
                        if(p[i].g.status == 0)
                        {
                            for(j=0;j<b.length;j++)
                            {
                                if(b[j].status == 1)
                                    continue;
                
                                else if(b[j].status == 0 && b[j].id == -1)
                                {
                                    b[j].status = 1;
                                    b[j].girlfriend = p[i].g.name;
          
                        
                                    p[i].g.status = 1;
                                    p[i].g.boyfriend = b[j].name;
                                    p[i].g.id = j;
                                    
                                    
                                    w.println("Pair(Girl,Boy)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                    System.out.println("Pair(Girl,Boy)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                    l++;
                        
                                   
                                     break;
                                }
                
                                 else if(b[j].status == 0 && b[j].id != -1)
                                {
                                    if(b[j].girlfriend != p[i].g.name)
                                    {
                                        b[j].status = 1;
                                        b[j].girlfriend = p[i].g.name;
                                        //  b[j].id = i;
                        
                                        p[i].g.status = 1;
                                        p[i].g.boyfriend = b[j].name;
                                        p[i].g.id = j;
                                        
                                        
                                        w.println("Pair(Girl,Boy)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                        System.out.println("Pair(Girl,Boy)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                        l++;
                        
                                       
                                        break;
                                    }
                    
                                }
                            }
         
                        }
                    
                                   
                }
                
            w.close();
        }
        
       catch(Exception e){
        
        }

    }  
    
    
    
}
