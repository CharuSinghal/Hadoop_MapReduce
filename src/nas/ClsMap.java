package nas;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ClsMap extends Mapper<Text, Text, Text, IntWritable> 
{
	public void map(Text key, Text value, Context context)
	{
		try
		{
			String[] values = value.toString().split(",");
			context.write(new Text(values[1]), new IntWritable(Integer.parseInt(values[2])));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
