package stubs;
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class IndexMapper extends Mapper<Text, Text, Text, Text> {

	Text word = new Text();
	Text location = new Text();
	
  @Override
  public void map(Text key, Text value, Context context) throws IOException,
      InterruptedException {

    /*
     * TODO implement
     */
    String[] tokens = value.toString().split("\\W+");
    FileSplit fileSplit = (FileSplit) context.getInputSplit();
    Path path = fileSplit.getPath();
    String fileName = path.getName();
    for(int i=0;i<tokens.length;i++) {
    	if (tokens[i].length() > 0) {
    		word.set(tokens[i]);
        	location.set(fileName+"@"+key.toString());
        	context.write(word, location);
    	}
    }
  }
}