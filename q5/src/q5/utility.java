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
 * @author astha anand
 */
public class utility {
     int i,j;
  
    void InputGirls(Girl g[])
    {   
        for(i=0;i<g.length;i++)
                g[i]=new Girl();
        Girl tmp = new Girl();
        
            for(i = 0; i < g.length-1 ; i++)
            {  
               for( j = 0; j < g.length-i-1 ; j++)
               {               
                  if( g[j+1].maintenanceBudget < g[j].maintenanceBudget)
                  {
                     tmp = g[j];
                     g[j] = g[j+1];
                     g[j+1] = tmp;
                  }
                } 
          
            }
        
    }
    
    void InputBoys(Boy b[])
    {
        for(i=0;i<b.length;i++)
                b[i]=new Boy();
        Boy tmp = new Boy();
        
            for(i = 0; i < b.length-1 ; i++)
            {  
               for( j = 0; j < b.length-i-1 ; j++)
               {               
                  if( b[j+1].attractiveness < b[j].attractiveness)
                  {
                     tmp = b[j];
                     b[j] = b[j+1];
                     b[j+1] = tmp;
                  }
                } 
          
            }
    }
    
    void FileGirls(Girl g[])
    {
   
         //GIRL
         try
         {
            PrintWriter w = new PrintWriter("girl5.txt", "UTF-8");
     
            for( i=0 ; i<g.length ; i++) 
            {
                 w.println(g[i].name + "   " +g[i].attractiveness + "   " +  g[i].intelligenceLevel + "    " + g[i].maintenanceBudget + "    " + g[i].status + "    " + g[i].type );
                    
            }
            w.close();
         }
         catch(Exception e){
             
         }  
    }
    
    void FileBoys(Boy b[])
    {
        //BOYS
        try
         {
            PrintWriter z = new PrintWriter("boy5.txt", "UTF-8");
            
            for( i=0 ; i<b.length ; i++) 
            {
                 z.println(b[i].name + "   " + b[i].attractiveness + "   " + b[i].intelligenceLevel + "   " + b[i].budget + "    " + b[i].minAttractivenessRequired + "    " + b[i].status + "    " + b[i].type);
                    
            }
            z.close();
         }
         catch(Exception e){
             
         }  
    }
    void Pairing(Boy b[] ,Girl g[])
    {
        int k = 0, m = 0, p = 0;
       
        try
        {
            PrintWriter w = new PrintWriter("Pair5.txt", "UTF-8");
     
           
            for(i=0; i<g.length; i++)
            {
           
                if(i%2==0)
                {
                     
                    while(g[k].status!=0)
                        k++;
            
                    for(j=0;j<b.length;j++)
                    {
                   
                        if(  b[j].status==0) 
                            if(b[j].EGBL(g[k].attractiveness, g[k].maintenanceBudget) && g[k].EGBL(b[j].budget))
                        {
                            g[k].status=1;
                            b[j].status=1;
                            g[k].boyfriend = b[j].name;
                            b[j].girlfriend = g[k].name;
                            g[k].id = j;
                            b[j].id = k;
                        
                            System.out.println("Pair(G,B)_"+ p + "  " + g[k].name + "  " + b[j].name); 
                            w.println("Pair(G,B)_"+ p + "  " + g[k].name + "  " + b[j].name);
                            p++;
                             break;
                        }
                    
                    
                    }
                    k++;
                }
            
                else
                {
                    
                     while(b[m].status!=0)
                        m++;
            
                    for(j=0;j<g.length;j++)
                    {
                   
                        if(  g[j].status==0 && b[m].EGBL(g[j].attractiveness, g[j].maintenanceBudget) && g[j].EGBL(b[m].budget))
                        {
                            g[j].status=1;
                            b[m].status=1;
                            g[j].boyfriend = b[m].name;
                            b[m].girlfriend = g[j].name;
                            g[j].id = m;
                            b[m].id = j;
                        
                            System.out.println("Pair(G,B)_"+ p + "  " + g[j].name + "  " + b[m].name); 
                            w.println("Pair(G,B)_"+ p + "  " + g[j].name + "  " + b[m].name);
                            p++;
                            break;
                        }
                    
                    
                    }
                   
                    m++;
                }
            
            }
            
            w.close();
        }
        
        catch(Exception e){
             
        }  
        
        
    }
    
    void MakeJodi(Girl g[], Boy b[], Jodi p[])
    {
        j=0;
        
        for(i=0; i<g.length; i++)
        {
                p[j] = new Jodi(g[i], b);
                j++;
            
        }
    }
    void kHappiestPair(Jodi p[], int k)
    {
        
    
        int gh=0, bh=0;
             
        for( i=0; i<p.length; i++)
        { 
            if(p[i].g.status == 0)
                continue;
            
            if (p[i].g.type == 0)
                gh = (int)Math.log( Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent));
            
            else if (p[i].g.type == 1)    
                gh = Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent);
            
            else if (p[i].g.type == 2)
                gh = (int)Math.getExponent( Math.abs(p[i].g.maintenanceBudget-p[i].b.MoneySpent)) ;
            
            p[i].g.happiness = gh;
           
        }
        
        for(i=0; i<p.length; i++)
        {
            if(p[i].g.status == 0)
                continue;
             
            if (p[i].b.type == 0)
            {
                bh = Math.abs(p[i].b.budget - p[i].b.MoneySpent);
            }
            else if (p[i].b.type == 1)
                
                bh = (p[i].g.intelligenceLevel) ;
            
            else 
                bh = (p[i].g.happiness) ;
          
            p[i].b.happiness = bh;
        }
        
        for( i=0; i < p.length ; i++)
        {
             if(p[i].g.status == 1)
                 p[i].happiness = p[i].b.happiness + p[i].g.happiness;
           
        }
        
        
       
        
        
        if(k < 0 || k > p.length)
            return;
        
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
               
                w.println("happy pair(Girl,Boy)_" + i + "    " +  temp[i].g.name + "    " + temp[i].b.name);
                System.out.println("happy pair(Girl,Boy)_" + i + "    " +  temp[i].g.name + "    " + temp[i].b.name);
            }
            
            w.close();
        }
         
        catch(Exception e){
             
        }  
        
    }
    

            
    }
    
    

