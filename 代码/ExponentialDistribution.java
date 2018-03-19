package com.Course.Queue;

import java.util.*;
/**
 *  指数分布的概率密度函数：y=lamda*exp(-lamda*x)    x>=0 
 *	由此可以计算概率分布函数：y=1-exp(-lamda*x)    x>=0   
 *	y是   X
 *	首先，把y当作是在（0，1）区间的均匀分布的随机变量。   
 *  然后，求y=1-exp(-lamda*x)的逆函数，x＝－(1/lamda)*ln（1－y)   
 *	令z＝1－y，显然z也是（0，1）区间的均匀分布的随机变量，于是就有x＝－(1/lamda)*ln（z）。   
 *	z可以通过(double)   rand()   /   RAND_MAX计算。原因是rand()   是随机分布函数。       
 *	最终满足指数分布的变量x，就可以通过x＝－(1/lamda)*ln（z）计算。
 */
public class ExponentialDistribution
{
	private double lamda ; //指数分布的参数lamda
	
	public ExponentialDistribution(double lamda) 
	{
		this.lamda = lamda;
	}
	
	public double getLamda() 
	{
		return lamda;
	}
	
	public void setLamda(double lamda) 
	{
		this.lamda = lamda;
	}

	/**
	 * 得到指数分布对应的参数值
	 */
	public double getX()
	{
		double z = Math.random();//随机生成一个[0,1)区间内的数字
		double x = - lamda * Math.log(z);//计算生成一个
		return x;
	}
	
	
	public static void main(String[] args) 
	{
		ExponentialDistribution edServe = new ExponentialDistribution(2);
		int i=1;
		while(i < 50)
		{
			System.out.println(edServe.getX());
			i++;
		}
	}
}
