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
	
	int timer = 0;
	ArrayList endingTime = new ArrayList ();
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
		int temp = 0;
		String token[] = newTimes.get(i).split("h");
		timer = Integer.parseInt(token[0]);
		if(timer >= 0 && timer <= 2)
		{
			int index = 0;
			temp = meme_list.get(0);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 2 && timer <= 4)
		{
			int index = 1;
			temp = meme_list.get(1);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 4 && timer <= 6)
		{
			int index = 2;
			temp = meme_list.get(2);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 6 && timer <= 8)
		{
			int index = 3;
			temp = meme_list.get(3);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 8 && timer <= 10)
		{
			int index = 4;
			temp = meme_list.get(4);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 10 && timer <= 12)
		{
			int index = 5;
			temp = meme_list.get(5);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 12 && timer <= 14)
		{
			int index = 6;
			temp = meme_list.get(6);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 14 && timer <= 16)
		{
			int index = 7;
			temp = meme_list.get(7);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 16 && timer <= 18)
		{
			int index = 8;
			temp = meme_list.get(8);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 18 && timer <= 20)
		{
			int index = 9;
			temp = meme_list.get(9);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 20 && timer <= 22)
		{
			int index = 10;
			temp = meme_list.get(10);
			temp++;
			meme_list.set(index, temp);
		}
		else if(timer > 22 && timer <= 24)
		{
			int index = 11;
			temp = meme_list.get(11);
			temp++;
			meme_list.set(index, temp);
		}
	}
	for(int j = 0; j < 12; j++)
	{
		if(meme_list.get(j) > 0)
		{
			String data = Integer.toString(j) + Integer.toString(meme_list.get(j));
			endingTime.add(data);
		}
	}
	String results = percentResults + "," + endingTime;

    context.write(key, new Text(results));
  }

}
