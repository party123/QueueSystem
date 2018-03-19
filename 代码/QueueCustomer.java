package com.Course.Queue;

public class QueueCustomer
{
	private int id;
	private double arriveTime;//顾客到达时间（由K个指数分布叠加得来）
	private double serveTime;//顾客要求服务时间（由指数分布得来），以分钟为单位
	
	public QueueCustomer(int id, double arriveTime, double serveTime) 
	{
		this.id = id;
		this.arriveTime = arriveTime;
		this.serveTime = serveTime;
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public double getArriveTime() 
	{
		return arriveTime;
	}
	
	public void setArriveTime(double arriveTime) 
	{
		this.arriveTime = arriveTime;
	}
	
	public double getServeTime()
	{
		return serveTime;
	}
	
	public void setServeTime(double serveTime) 
	{
		this.serveTime = serveTime;
	}

	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", arriveTime=" + arriveTime + ", serveTime=" + serveTime + "]";
	}
	
	
}
