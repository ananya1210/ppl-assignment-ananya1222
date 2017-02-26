/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;
import java.io.*;
import java.util.*;
public class csv_gen {
	    void csv(int noboys,int nogirls){
		try{
			FileWriter boy_file = new FileWriter("boys.csv");
			FileWriter girl_file = new FileWriter("girls.csv");
			int j;
			Random boy_rand = new Random();
			Random girl_rand = new Random();
			for(j=0;j<noboys;j++){
				boy_file.write("B"+j+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(1000)+","+"Single"+"\n");
			}
			for(j=0;j<nogirls;j++){
				girl_file.write("G"+j+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(1000)+","+girl_rand.nextInt(10)+","+"Single"+"\n");
			}
			boy_file.close();
			girl_file.close();
		}catch(IOException e){		
		
		}
	
		
}
	    
}
