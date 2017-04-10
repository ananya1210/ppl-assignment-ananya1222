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
public class utility {
    int i,j;
    
    
    void FileGirls(Girl g[])
    {
   
         //GIRL
         try
         {
            PrintWriter a = new PrintWriter("girl4.txt", "UTF-8");
     
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
            PrintWriter z = new PrintWriter("boy4.txt", "UTF-8");
            
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
            PrintWriter q = new PrintWriter("pair4.txt", "UTF-8");
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
    
    
    void kHappiestPair(Jodi p[], int k)
    {
        if(k < 0 || k > p.length)
            return;
    
        CalculateHappiness(p);
        
        Jodi[] temp = new Jodi[p.length];
        
        for(i = 0; i < p.length; i++)
            temp[i] = p[i];
          
        Jodi tmp = new Jodi();
        
        try
        {
            PrintWriter w = new PrintWriter("kHappiestPair.txt", "UTF-8");
        
            for(i = 0; i < k; i++)
            {  
               for( j = i+1; j < temp.length; j++)
               {               
                  if(temp[i].happiness < temp[j].happiness)
                  {
                     tmp = temp[i];
                     temp[i] = temp[j];
                     temp[j] = tmp;
                  }
                } 
               
                w.println("happy pair(G,B)_" + i + "    " +  temp[i].g.name + "    " + temp[i].b.name);
                System.out.println("happy pair(G,B)_" + i + "    " +  temp[i].g.name + "    " + temp[i].b.name);
            }
            
            w.close();
        }
         
        catch(Exception e){
             
        }  
        
    }
    
    
   
    
    
    
    
  
    
    
    void BreakUp(Jodi p[],int k)
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
        int y = 1;
        
        for(i=0 ; i< p.length ;i++)
        {
            if(p[i].g.status == 0)
                continue;
            
            if(y < k+1)
            {
                p[i].g.status =0;
                p[i].b.status = 0;
                
                y++;
            }
        }
        
    }

    
    void AssignNewBF(Jodi p[],int k,Boy b[])
    {
       int l=0;
       int x=1;
       
       try
       {
           
            PrintWriter w = new PrintWriter("NewPairFormed.txt", "UTF-8");
         
                for(i=0; i<p.length ;i++)
                {
                    if(x<k+1)
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
                                    
                                    
                                    w.println("Pair(G,B)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                    System.out.println("Pair(G,B)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                    l++;
                        
                                     x++;
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
                                        
                                        
                                        w.println("Pair(G,B)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                        System.out.println("Pair(G,B)_"+ l + "  " + p[i].g.name + "  " + b[j].name);
                                        l++;
                        
                                        x++;
                                        break;
                                    }
                    
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

    
   