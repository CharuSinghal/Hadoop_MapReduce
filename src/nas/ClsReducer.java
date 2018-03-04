package nas;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ClsReducer extends Reducer<Text, IntWritable, Text, FloatWritable> 
{
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
	{
		long sum = 0l;
		long count = 0l;

		for(IntWritable value : values)
		{
			sum += value.get();
			count++;
		}
		try
		{
			context.write(key, new FloatWritable((float)sum/count));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
