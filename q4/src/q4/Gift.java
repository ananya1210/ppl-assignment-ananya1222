/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;
import java.util.Random;

/**
 *
 * @author ananya anand
 */
public class Gift {
    //Attributes of gift.
    
    int price;
    int value;
    int type ;//0-Essential,1-Luxury,2-Utility
    
    int difficultyToObtain;
    int luxuryRating;
    
    int utilityValue;
    int utilityClass;
  
    //constructor of Gift
    
    public Gift()
    {
        
    }
    
    public Gift(int typeOfGift)
    {
        if(typeOfGift==0)
        {
            price = rand.nextInt(200) + 200;
            value = Value();
            type = typeOfGift;
            
        }
        else if(typeOfGift==1)
        {
            price = rand.nextInt(200) +800 ;
            value = Value();
            difficultyToObtain = DifficultyToObtain();
            luxuryRating = LuxuryRating();
            type = typeOfGift;
        }    
        else
        {
            price = rand.nextInt(200) + 600;
            value = Value();
            utilityValue = UtilityValue() ;
            utilityClass = UtilityClass();
            type = 2;
        }
    }
    
    
   //Random generation of different Attributes. 
   Random rand = new Random();
   
    public int Value()
   {
       int  n = rand.nextInt(3) + 1;
       return n;
   }
    
    public int DifficultyToObtain()
   {
       int  n = rand.nextInt(10) + 1;
       return n;
   }
     
   public int LuxuryRating()
   {
       int  n = rand.nextInt(3) + 1;
       return n;
   }
   
   public int UtilityValue()
   {
       int  n = rand.nextInt(10) + 1;
       return n;
   }
   
   public int UtilityClass()
   {
       int  n = rand.nextInt(3) + 1;
       return n;
   }

    
    
}
