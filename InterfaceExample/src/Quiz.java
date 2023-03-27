//Quiz Class 3.27
public class Quiz implements Measurable
{
	private double score;
	
	public Quiz(double score)
	{
		if(score < 0)
		{
			this.score = 0;
		}
		else if(score > 100)
		{
			this.score = 100;
		}
		
		this.score = score;
	}
	
	public double getMeasure()
	{
		return score;
	}
}
