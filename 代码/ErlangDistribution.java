package com.Course.Queue;

public class ErlangDistribution 
{
	private int K;//Erlang分布对应的阶数
	private int lamda;//设置指数分布的lamda
	
	public ErlangDistribution(int k,int lamda)
	{
		this.K = k;
		this.lamda =lamda;
	}
	
	public int getK() 
	{
		return K;
	}

	public void setK(int k)
	{
		K = k;
	}

	public int getLamda() 
	{
		return lamda;
	}


	public void setLamda(int lamda) 
	{
		this.lamda = lamda;
	}

	public double getErlangArriveTime()
	{
		double arriveTime = 0;
		ExponentialDistribution ed = new ExponentialDistribution((double)1/lamda);
		
		for(int i = 0; i < K;i++)
		{
			arriveTime += ed.getX();
		}
		
		return arriveTime;
	}
	
	public static void main(String[] args)
	{
		ErlangDistribution ed =new ErlangDistribution(2, 2);
		for(int i = 0; i < 50; i++)
		{
			System.out.println(ed.getErlangArriveTime());
		}
	}
}
