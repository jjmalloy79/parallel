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
    List<String> newTimes = new ArrayList<String>();

    int provoked = 0;
    int unprovoked = 0;
	String str = "";
    String time ="";
	int [] attackTime = {0};
	int timer = 0;
    for (Text t : values)
    {
		//collects all the data
      String s = t.toString();
	  String tokens[] = s.split(",");
	  str = tokens[0];
	  time = tokens[1];

	
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

	List<Integer> meme_list = new ArrayList<>();
	for (int i = 0; i < newTimes.size(); i++)
	{
		meme_list.add(0);
	}

	for(int i = 0; i < newTimes.size(); i ++)
	{
		timer = Integer.parseInt(newTimes.get(i).substring(0,2));
		if(timer >= 0 && timer <= 2)
		{
			int index = 0;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 2 && timer <= 4)
		{
			int index = 1;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 4 && timer <= 6)
		{
			int index = 2;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 6 && timer <= 8)
		{
			int index = 3;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 8 && timer <= 10)
		{
			int index = 4;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 10 && timer <= 12)
		{
			int index = 5;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 14 && timer <= 16)
		{
			int index = 6;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 16 && timer <= 18)
		{
			int index = 7;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 18 && timer <= 20)
		{
			int index = 8;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 20 && timer <= 22)
		{
			int index = 9;
			meme_list.set(index, meme_list.get(index)++);
		}
		else if(timer > 22 && timer <= 24)
		{
			int index = 10;
			meme_list.set(index, meme_list.get(index)++);
		}
	}
	//String results = newTimes + "," + result;

    //context.write(key, new Text(result));
  }

}
