package com.Course.Queue;

public class Run
{
	private static QueueSystem queueSystem = new QueueSystem(1, 400, 0, 0, 0, 0);
	
	public static void main(String[] args)
	{
		for(int i=1; i<=20; i++)
			RunSystem();
	}
	
	public static void RunSystem()
	{
		//QueueSystem queueSystem = new QueueSystem(1, 100, 0, 0, 0, 0);
		
		//求P所设定的指数分布lamda
		ExponentialDistribution edServe = new ExponentialDistribution(12);
		
		//用作顾客到达间隔的Erlang分布
		ErlangDistribution erlang = new ErlangDistribution(8, 3);
		
		//系统指定的服务总时间
		double totalServeTime = queueSystem.getTotalServeTime();
		//系统当前已经服务顾客的总时间
		double currentServeTime = 0;
		//记录上一个顾客的到达时间
		double lastArriveTime = 0 ;
		//记录当前顾客的到达时间
		double currentArriveTime = 0 ;
		//记录服务的顾客总数
		int count = 0;
		
		//作为顾客的标识号
		int id = 1;
		//顾客的到达时间
		double arriveTime = 0;
		//为每个顾客提供的服务时间
		double serveTime = 2.0;
		//记录顾客的排队时间
		double waitTime = 0;
		
		//假设系统初始时就已经有了一个顾客，因此第一个顾客的排队时间为0，到达时间也记为0
		if(id == 1)
		{
			arriveTime = 0;
			//serveTime = edServe.getX();
		}
		
		QueueCustomer customer = new QueueCustomer(id,arriveTime,serveTime);
		currentServeTime += serveTime;
		currentArriveTime = lastArriveTime = customer.getArriveTime();
		
		while(currentServeTime <= totalServeTime && lastArriveTime <= totalServeTime)
		{
			
			count++;
			id++;
			lastArriveTime = currentArriveTime;
			
			//下一个顾客的到达时间为上一个顾客的到达时间加上时间间隔
			arriveTime = lastArriveTime + erlang.getErlangArriveTime();
			//serveTime = edServe.getX();
			
			customer = new QueueCustomer(id,arriveTime,serveTime);
			
			currentServeTime += serveTime;
			currentArriveTime = customer.getArriveTime();
			
			//当前顾客的排队时间等于上个顾客的到达时间加上其要求服务的时间减去当前顾客的到达时间
			if(lastArriveTime + customer.getServeTime() > currentArriveTime)
				waitTime += lastArriveTime + customer.getServeTime() - currentArriveTime;
		
		}
		
		queueSystem.setQueueTime(waitTime);
		queueSystem.setTotalCount(count);
		queueSystem.setU( (double)1/edServe.getLamda() );//设置系统服务能力
		queueSystem.setArriveLamda((double)1/(erlang.getK() * erlang.getLamda()));//设置到达强度
		
		System.out.println("(" + "k" + "," + "α"
				+ ")" + "====>" + "(" + erlang.getK() + "," + queueSystem.getResult(1) + ")");
		System.out.println("=====================================================");
		System.out.println();
	}
}
