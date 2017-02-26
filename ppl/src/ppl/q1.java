/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ppl;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
public class q1{
	
	public static void main(String args[]){
		int i,j;
		i=0;
		j=0;
                int noboys=Integer.parseInt(args[0]);
                int nogirls=Integer.parseInt(args[1]);
		Boy b[] = new Boy[noboys+1];
		csv_gen csv_files = new csv_gen();
		csv_files.csv(noboys,nogirls);  
		String csvFile = "boys.csv";
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] boys_table = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				b[i] = new Boy();
                                b[i].name = boys_table[0];
				b[i].iq= Integer.parseInt(boys_table[1]);
				b[i].attr = Integer.parseInt(boys_table[2]);
				b[i].minval = Integer.parseInt(boys_table[3]);
				b[i].budget = Integer.parseInt(boys_table[4]);
				b[i].gf="";
				b[i].status = boys_table[5];
				i++;
			}
		}
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Girl g[] = new Girl[nogirls+1];
		csvFile = "girls.csv";
		line = "";
		csvSplit = ",";
		buff = null;
		
		
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] girls_table = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				g[j] = new Girl();
                                g[j].name = girls_table[0];
				g[j].beauty = Integer.parseInt(girls_table[1]);
				g[j].exp = Integer.parseInt(girls_table[2]);
				g[j].intl = Integer.parseInt(girls_table[3]);
				g[j].status = girls_table[4];
				g[j].bf="";
				j++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(buff != null){
					try{
						buff.close();
					}catch(IOException e){
					e.printStackTrace();
					}
				}
		}
                ArrayList<couple> c  = new ArrayList<>();
		Makejodi jk = new Makejodi();
                c = jk.cup(g, b,noboys,nogirls);
                String s[] = new String[100];
                Iterator itr = c.iterator();
                int cnt = 0;
                while (itr.hasNext())
                {   couple z = (couple) itr.next();
                    s[cnt] = "Boy: "+ z.b +" is committed with "+"Girl: "+ z.g  ;
                    cnt  ++;
                }
                MyLogger.logger(s,cnt);	
	}
	}