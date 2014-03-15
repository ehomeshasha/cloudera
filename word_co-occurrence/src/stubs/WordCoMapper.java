package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    /*
     * TODO implement
     */
	  
	  String last = null;
	  
	  
	  String[] terms = value.toString().toLowerCase().split("\\W+");
	  for(String t : terms) {
		  if (t.length() > 0) {
			  if(last != null) {
				  context.write(new Text(last + "," + t), new IntWritable(1));
			  }
			  last = t;
		  }
	  }
	  
	  
	  
    
  }
}
