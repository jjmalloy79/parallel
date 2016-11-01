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
public class SharksReducer extends Reducer<Text, Text, Text, Text>
{
  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException
  {
    List<String> sharks = new ArrayList<String>();

    int provoked = 0;
    int unprovoked = 0;
    for (Text t : values)
    {
      String s = t.toString();
	  String tokens[] = s.split(",");
	  String str = tokens[0];
	  String time = tokens[1];
	  int [] attackTime = new int[12];
	// ArrayList newTimes = ArrayList();
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

    //context.write(key, new Text(result));
  }

}
