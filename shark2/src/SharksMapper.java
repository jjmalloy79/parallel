import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/*
  The four template paramters are:
    Input Key - which is a long integer offset
    Input Value - which is a line of text from the file
    Output Key - which is the # of books a word appears in
    Output Value - which is the word (ngram)
*/
public class SharksMapper extends Mapper<LongWritable, Text, Text, Text>
{
  @Override
  public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException
  {
      String range="";
	  String range1 = "0-2";
	  String range2 = "2-4";
	  String range3 = "4-6";
	  String range4 = "6-8";
	  String range5 = "8-10";
	  String range6 = "10-12";
	  String range7 = "12-14";
	  String range8 = "14-16";
	  String range9 = "16-18";
	  String range10 = "18-20";
	  String range11 = "20-22";
	  String range12 = "22-24";
	  String provoked = "";
	  int year = 0;
   	  String line = value.toString();
      String tokens[] = line.split(",");
      year = Integer.parseInt(tokens[2]);
	 provoked = tokens[3];
	 String timeOfDay = tokens[11];
	
	int timer = 0;
	 if(year > 1960)
	{
		if(timeOfDay.contains("h"))
		{
			System.out.println("Time: " + timeOfDay);
			String sharks [] = timeOfDay.split("h");
			System.out.println("Shark: " + sharks[0]);
			timer = Integer.parseInt(sharks[0]);
			if(timer >= 0 && timer <= 2)
			{
				range = range1;
			}
			else if(timer > 2 && timer <= 4)
			{
				range = range2;
			}
			else if(timer > 4 && timer <= 6)
			{
				range = range3;
			}
			else if(timer > 6 && timer <= 8)
			{
				range = range4;
			}
			else if(timer > 8 && timer <= 10)
			{
				range = range5;
			}
			else if(timer > 10 && timer <= 12)
			{
				range = range6;
			}
			else if(timer > 12 && timer <= 14)
			{
				range = range7;
			}
			else if(timer > 14 && timer <= 16)
			{
				range = range8;
			}
			else if(timer > 16 && timer <= 18)
			{
				range = range9;
			}
			else if(timer > 18 && timer <= 20)
			{
				range = range10;
			}
			else if(timer > 20 && timer <= 22)
			{
				range = range11;
			}
			else if(timer > 22 && timer <= 24)
			{
				range = range12;
			}
		context.write(new Text(range), new Text(provoked));
		}
	} 
  }
}
