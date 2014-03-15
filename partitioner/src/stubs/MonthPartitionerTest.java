package stubs;

import static org.junit.Assert.assertEquals;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.junit.Test;

import solution.MonthPartitioner;

public class MonthPartitionerTest {
	
	private static String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	MonthPartitioner<Text, Text> mpart = new MonthPartitioner<Text, Text>();
	
	@Test
	public void testMonthPartitioner() {
		
		mpart.setConf(new Configuration());
		int result;
		for(int i=0;i<months.length;i++) {
			result = mpart.getPartition(new Text("some ip address"), new Text(months[i]), 12);
			assertEquals(result, i);
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
