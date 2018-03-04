package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ClsReducer extends Reducer<Text, IntWritable, Text, LongWritable> 
{
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
	{
		try
		{
			Long count = 0L;

			for(IntWritable value : values)
			{
				count += value.get();
			}

			context.write(key, new LongWritable(count));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
