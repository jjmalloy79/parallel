import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/*
  The four template paramters are:
    Input Key - which is the # of books a word appears in
    Input Value -which is the word (ngram)
    Output Key - which is the # of books a collection of words appears in
    Output Value - a collection of all the words
*/
public class SharksReducer extends Reducer<IntWritable, Text, IntWritable, Text>
{
  @Override
  public void reduce(IntWritable key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException
  {
    List<String> words = new ArrayList<String>();

    int provoked = 0;
    int unprovoked = 0;
    for (Text t : values)
    {
      String s = t.toString();
	  String tokens[] = s.split(",");
	  String str = tokens[0];
	  String time = tokens[1];
	  int [] attackTime = new int[12];
	 ArrayList newTimes = ArrayList();
// percentage of nonproked to provoked
      if (str.contains("Unprovoked"))
      {
        unprovoked++;
      }
      else if (str.contains("Provoked"))
      {
        provoked++;
      }
      else
      {
        unprovoked++;
      }
    }
	
    double percentage = ((float)provoked / ((float)unprovoked + (float)provoked)) * 100;
 
   String percentResults = Integer.toString((int)Math.floor(percentage));
	if(time.contains("h"))
	{
		newTimes.add(time);
	}
	for(int i = 0; i < newTimes.length; i ++)
	{
		if(timer >= 0 && timer <= 2)
		{
			attackTime[0] = attackTime[0]++;
		}
		else if(timer > 2 && timer <= 4)
		{

		}
		else if(timer > 4 && timer <= 6)
		{

		}
		else if(timer > 6 && timer <= 8)
		{

		}
		else if(timer > 8 && timer <= 10)
		{

		}
		else if(timer > 10 && timer <= 12)
		{

		}
		else if(timer > 14 && timer <= 16)
		{

		}
		else if(timer > 16 && timer <= 18)
		{

		}
		else if(timer > 18 && timer <= 20)
		{

		}
		else if(timer > 20 && timer <= 22)
		{

		}
		else if(timer > 22 && timer <= 24)
		{

		}
	}
	String results = newTimes + "," + result;
System.out.println(attackTime[0]);
    //context.write(key, new Text(result));
  }

}
