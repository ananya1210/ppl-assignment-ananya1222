/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.util.ArrayList;
import static java.util.Arrays.equals;

/**
 *
 * @author astha anand
 */
public class Makejodi {
    private static final String xx = "commited";
    ArrayList<couple> cup(Girl g[], Boy b[],int noboys,int nogirls)
     {  
        String s[] = new String[100];
        ArrayList<couple> ch = new ArrayList<>();
        for(int i = 0;i < nogirls ;i ++)
        {   Girl g1 =  g[i]; 
            for(int j  =0; j < noboys;j++)
            {  Boy b1 = b[j];String st = b1.status;
                if( g1.exp <= b1.budget && g1.beauty >= b1.minval)
                {   if(st.equals(xx))
                    continue;
                    b1.gf= g[i].name;
                    g1.bf = b[i].name;
                    b1.status = "commited";
                    g1.status =  "commited";
                    couple c = new couple();
                    c.b= b1.name;
                    c.g = g1.name;
                    ch.add(c);
                    break;
                }
                
            }
            
        }
        return ch;
     }
}
