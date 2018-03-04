package wordcount;

import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ClsMap extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	public void map(LongWritable key, Text value,Context context)
	{
		StringTokenizer tokens = new StringTokenizer(value.toString());
		
		while(tokens.hasMoreTokens())
		{
			try
			{
				context.write(new Text(tokens.nextToken()), new IntWritable(1));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
}
