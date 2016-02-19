import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.*;


public class Ass2
{

 public static void main(String[] args) {

     try
	{ 
		Scanner sc = new Scanner(System.in);

		
	      String csvFile = "/home/webonise/Desktop/";
		csvFile=csvFile.concat(args[0]);

       //create BufferedReader to read csv file
	      BufferedReader br = new BufferedReader(new FileReader(csvFile));
	      String line = "";
		
		ArrayList<ArrayList<String>> All_data=new ArrayList<ArrayList<String>>();
       //read comma separated file line by line
	      while ((line = br.readLine()) != null)
		{
    	
			ArrayList<String> data = new ArrayList<String>();
			
			String [] CurrentArr=line.split(",");		
			for(int i=0;i<CurrentArr.length;i++)
			{
				data.add(CurrentArr[i].trim());
			}
			
			All_data.add(data);
				
	     }
		//System.out.println(All_data);
		//adding commandline values in data_arr
		ArrayList<String> data_arr = new ArrayList<String>();
		
		int ar_len=args.length;
		
			for(int i=1;i<ar_len;i++)
			{
				data_arr.add(args[i]);
			}
				
	
		//System.out.println(data_arr);
		
		
		ArrayList<String> find_data_id = new ArrayList<String>();
		ArrayList<Double> find_data_pric = new ArrayList<Double>();
		
		for(int i=0;i<All_data.size();i++)
		{
			for(int k=0;k<data_arr.size();k++)
			{
				if(All_data.get(i).contains(data_arr.get(k)))
				{
					find_data_id.add(All_data.get(i).get(0));
					double b=Double.parseDouble(All_data.get(i).get(1));
					find_data_pric.add(b);
				}
			}
		}
		
		
			double price=find_data_pric.get(0);
			String id=find_data_id.get(0);

			for(int k=1;k<find_data_id.size();k++)
			{
				if(price > find_data_pric.get(k))
				{
				
					
					price=find_data_pric.get(k);
					id=find_data_id.get(k);
				}
			}

			
			
			
			boolean flag=false;
                     HashMap<String,Double> map = new HashMap<String,Double>();
			
			while(flag!=true)
			{
			ArrayList<String> temp_id = new ArrayList<String>();
			ArrayList<Double> temp_pric = new ArrayList<Double>();

			double price1=find_data_pric.get(0);
			String id1=find_data_id.get(0);
			for(int k=1;k<find_data_id.size();k++)
			{
				if(id1.equals( find_data_id.get(k)))
				{
					price1+=find_data_pric.get(k);
				}
				else
				{
					temp_id.add(find_data_id.get(k));
					temp_pric.add(find_data_pric.get(k));
				}
			}
			map.put(id1,price1);
    	   		if(temp_id.isEmpty() || temp_id.size()==1)
				flag=true;

			find_data_id=temp_id;
			find_data_pric=temp_pric;
			}

			Map.Entry<String, Double> min=null;
			for (Map.Entry<String,Double> entry : map.entrySet())
			{

				if (min==null || min.getValue()>entry.getValue()) 
				{
			        min=entry;
			    }
 			 
			}

			
				
			System.out.println(min.getKey()+" "+min.getValue());
		
     } catch (Exception e) {
       System.err.println("CSV file cannot be read : " + e);
     }
   }



}
