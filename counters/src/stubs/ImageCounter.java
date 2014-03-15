package stubs;
import java.util.Iterator;

import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.CounterGroup;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ImageCounter extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: ImageCounter <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(ImageCounter.class);
    job.setJobName("Image Counter");

    /*
     * TODO implement
     */
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(ImageCounterMapper.class);
    
    job.setNumReduceTasks(0);
    
    
    
    
    boolean success = job.waitForCompletion(true);
    if (success) {
    	
    	//FileSystem fs = FileSystem.get(new Configuration());
    	
    	
      /*
       * Print out the counters that the mappers have been incrementing.
       * TODO implement
       */
    	CounterGroup gp = job.getCounters().getGroup("ImageCounter");
    	System.out.println("ImageCounter size: "+gp.size());
    	Iterator<Counter> ite = gp.iterator();
    	Counter c = null;
    	while(ite.hasNext()) {
    		 c = ite.next();
    		System.out.println(c.getDisplayName()+"="+c.getValue());
    		
    	}
    	return 0;
      
    } else
      return 1;

  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new ImageCounter(), args);
    System.exit(exitCode);
  }
}