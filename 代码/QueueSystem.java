package com.Course.Queue;

/**
 * 排队系统，系统中排队位置为无穷多，服务员数目为1
 */
public class QueueSystem 
{
	private int startCount;//系统中初始的顾客数
	private double totalServeTime;//系统中总的开放时间,以分钟为单位
	private int totalCount;//系统服务的总顾客数
	private double queueTime;//系统中所有顾客的总排队时间
	private double U;//服务员能力
	private double arriveLamda;//到达强度
	
	
	public QueueSystem(int startCount, double totalServeTime, int totalCount, double queueTime, double U, double arriveLamda)
	{
		this.startCount = startCount;
		this.totalServeTime = totalServeTime;
		this.totalCount = totalCount;
		this.queueTime = queueTime;
		this.U = U;
		this.arriveLamda = arriveLamda;
	}

	public int getStartCount()
	{
		return startCount;
	}
	
	public void setStartCount(int startCount) 
	{
		this.startCount = startCount;
	}
	
	public double getTotalServeTime() 
	{
		return totalServeTime;
	}
	
	public void setTotalServeTime(double totalServeTime) 
	{
		this.totalServeTime = totalServeTime;
	}
	
	public int getTotalCount() 
	{
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) 
	{
		this.totalCount = totalCount;
	}
	
	public double getQueueTime() 
	{
		return queueTime;
	}
	
	public void setQueueTime(double queueTime) 
	{
		this.queueTime = queueTime;
	}
	
	public double getU() 
	{
		return U;
	}
	
	public void setU(double U) 
	{
		this.U = U;
	}
	
	public double getArriveLamda()
	{
		return arriveLamda;
	}
	
	public void setArriveLamda(double arriveLamda) 
	{
		this.arriveLamda = arriveLamda;
	}

	public double getEwq() 
	{
		double Ewq = 0;
		if(totalCount > 0)
			Ewq = (double)queueTime / (double)totalCount;
		return Ewq;
	}
	
	public double getResult(int count)
	{
		double P = arriveLamda/U;
		double Ewq = getEwq();
		if(count == 1)
			System.out.println("系统开放时间：" + totalServeTime + "  系统服务员能力：" + U + "  系统服务顾客数：" + totalCount + "  顾客总排队时间：" + queueTime);
		return ((Math.log(2 * U * Ewq) - Math.log(1 + 2 * U * Ewq))/(Math.log(P)));
	}
	
}
