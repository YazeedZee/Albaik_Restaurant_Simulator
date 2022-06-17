package application;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class City
{
	//new arrays
    static ArrayList<AlbaikBranch> Branches = new ArrayList<AlbaikBranch>();
    static ArrayList<AlbaikBranchWithOnline> onlineBranch = new ArrayList<AlbaikBranchWithOnline>();
    static //ArrayList<Customer> customer = new ArrayList<Customer>();
    //ArrayList<String> history = new ArrayList<String>();
    //object
    AlbaikOrder order = new AlbaikOrder();
    AlbaikBranch branch = new AlbaikBranch();
    static int hour = 11;
    //solution method
    public static int solution(int num)// to convert 50% of Walk-In men or Women to be Online Customers or to use delivery applications, so 25% of each type.
    {
    	int num1 = num/4;
    	return num1;
    }
    //main method
    public static void main ( String[] args )
    {
    	SecureRandom rnd = new SecureRandom();
    	Random gen = new Random();
    	Scanner input = new Scanner(System.in);
        //method to count how many minutes in each branch (updateLatency)
        //method to generate customers and branches

    	int work=0;//per min
    	int num;
    	while(work<=1)// should be 720min as 12 hours
    	 {
    			// if (work%1== 0)// should be 60min as an hour
    			 {
    					num = gen.nextInt(3)+1;// to choose how many branches do you want to
    					double percentage = gen.nextDouble();
    					if (percentage<=0.5)
    					{
    						for (int count=0;count<=num;count++)
    						{
    							onlineBranch.add(new AlbaikBranchWithOnline());//
    						}
    					}
    					else
    					{
    						Branches.add(new AlbaikBranch());
						}
    			 }
    			 work++;
    			 // take off 60 s from each order time Orders from branch
    	 }
    	 work=0;//per min
    	 //exit too
    	 /////////////////////////////////////////////
    	 System.out.print("1 for Branches, 2 for Summary, 3 for quiting: ");
    	 int a= input.nextInt();
    	 while(true)// for orders and customers
    	 {
    		 if(a==1)// to choose Regular Branch
    		 {
    			 	System.out.print("Branch Directory: 1 for Regular Branch, 2 Onilne Branch, 3 for Quiting: ");
    			 	int b = input.nextInt();

    	    		if (b==1)
    			 	{
    	    			System.out.println("|Branch | CustomerID |   Branch Type   | Customer Type     | Customer Arrival  | Order Placing Time | Order Ready Time | PickUp Time | Total Latency | Waiting Time | Order Time |");
        	    		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			    		 for(int i=0;i<Branches.size();i++)
			    	    	{
			    			 	order.setArriving();
			    			 	Branches.get(i).setOrderTag();
			    	    		int NOC = rnd.nextInt(120)+3;//number of customers
			    	    		for(int j=0;j<= NOC;j++)//to add to other branches
			    	    		{
			    	    			try
			    	    			{
				    	    			Branches.get(i).genWalkInCustomers();

				    	    			System.out.printf("|%7d|%12d|%s",1+i,Branches.get(i).orderTag(),Branches.get(i).Orders.get(i).toString(Branches.get(i),Branches.get(i).Men_Queue.get(j)));
				    	    			System.out.println();
				    	    			System.out.printf("|%7d|%12d|%s",1+i,Branches.get(i).orderTag(),Branches.get(i).Orders.get(i).toString(Branches.get(i),Branches.get(i).Women_Queue.get(j)));
				    	    			System.out.println();
			    	    			}
			    	    			//list of hours rowa
			    	    			//for each hour summary
			    	    			//max latency for each
			    	    			//max number

			                        catch(IndexOutOfBoundsException e)
			                        {/*
			                        	System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
			                            System.out.printf("#\tBranch: %02d\t\t\t\t\t\t\t#%n",i+1);
			                            System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
			                            System.out.println("#\tNo More Customer\t\t\t\t\t\t\t#");
			                            System.out.println("#\t\t\t\t\t\t\t\t\t\t#");
			                            System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
			                            System.out.println();*/
			                        }
			    	    		}
			    	    		Branches.get(i).setOrderTag();
			    	    		Branches.get(i).setTotal();
			    	    		System.out.println();
			    	    		//Branches.clear();
			    	    	}
    			 	}
    			 	else if(b==2)// to choose Online Branch
    	    		{
    			 		System.out.println("|Branch | CustomerID |   Branch Type   | Customer Type     | Customer Arrival  | Order Placing Time | Order Ready Time | PickUp Time | Total Latency | Waiting Time | Order Time |");
        	    		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    	    			for(int i=0;i<onlineBranch.size();i++)
    	    			{
    	    				order.setArriving();
    	    				onlineBranch.get(i).setOrderTag();
    	    				int NOC = rnd.nextInt(10)+3;//number of customers
    	    	    		for(int j=0;j<= NOC;j++)//to add to other branches
    	    	    		{
    	    	    			try
    	                        {
    	    	    				onlineBranch.get(i).genWalkInCustomers();
    	    	    				onlineBranch.get(i).genOnlineCustomers();
    	    	    				System.out.printf("|%6dA|%12d|%s",1+i,onlineBranch.get(i).orderTag(),onlineBranch.get(i).Orders.get(i).toString(onlineBranch.get(i),onlineBranch.get(i).Men_Queue.get(j)));
    		    	    			System.out.println();
    		    	    			System.out.printf("|%6dA|%12d|%s",1+i,onlineBranch.get(i).orderTag(),onlineBranch.get(i).Orders.get(i).toString(onlineBranch.get(i),onlineBranch.get(i).Women_Queue.get(j)));
    		    	    			System.out.println();
    		    	    			System.out.printf("|%6dA|%12d|%s",1+i,onlineBranch.get(i).orderTag(),onlineBranch.get(i).Orders.get(i).toString(onlineBranch.get(i),onlineBranch.get(i).Online_Queue.get(j)));
    		    	    			System.out.println();
    		    	    			System.out.printf("|%6dA|%12d|%s",1+i,onlineBranch.get(i).orderTag(),onlineBranch.get(i).Orders.get(i).toString(onlineBranch.get(i),onlineBranch.get(i).Delivery_Queue.get(j)));
    		    	    			System.out.println();
    	    	    				//Branches.get(i).genWalkInCustomers();
    		    	    		//	System.out.printf("%d|%d|%d|%d|%d|%d|%d|%d|%d|",hour,onlineBranch.get(i).Men_Queue.size(),onlineBranch.get(i).getLatencyMen(),onlineBranch.get(i).Online_Queue.size(),onlineBranch.get(i).Delivery_Queue.size(),onlineBranch.get(i).Women_Queue.size(),onlineBranch.get(i).getLatencyWomen());


    	                        }
    	                        catch (IndexOutOfBoundsException e)
    	                        {/*
    	                        	System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
    	                            System.out.printf("#\tBranch: %02d#%n",i+1);
    	                            System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
    	                            System.out.println("#\tNo More Customer\t\t\t\t\t\t\t#");
    	                            System.out.println("#\t\t\t\t\t\t\t\t\t\t#");
    	                            System.out.println("#+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#");
    	                            System.out.println();*/
    	                        }
    	    	    		}
    	    	    		onlineBranch.get(i).setOrderTag();
    	    	    		onlineBranch.get(i).setTotal();
    	    	    		System.out.println();
    	    			}
    	    		}
    			 	else if(b==3)
    			 	{
    			 		//to quit
    			 		break;
    			 	}

    		 }
    		else if(a==2)
    		{
    			System.out.print("Summmary Directoy: 1 for Regular Branch, 2 Onilne Branch, 3 for Quiting: ");
			 	int c= input.nextInt();
    			// to choose Summary
    			System.out.println("|hour |# Walk-In Customer    | Walk-In Max-Wait Time| # Online Customer    | Online Max-Wait Time | # Delivery Customer  |Delivery Max-Wait Time| # Women Customer   | Women Max-Wait Time  | ");
    			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    			// current hour//////\\\\\\\need to be tested
    			//walkin # customers and max waiting time//////\\\\\\need to be tested
    			// online # customer and max waiting time //////\\\\\\need to be tested
    			// delivery # customer and max waiting time//////\\\\\\need to be tested
    			// women # customer and max waiting timw//////\\\\\\need to be tested
    			if(c==1)
    			{
    		    	// System.out.println("|hour|# Walk-In Customer    | Walk-In Max-Wait Time||# Online Customer    | Online Max-Wait Time| |# Delivery Customer    |Delivery Max-Wait Time||# Women Customer    | Women Max-Wait Time |");

    				//System.out.println("IN C");//spy
    					for(int i=0;i<Branches.size();i++)
		    	    	{

		    				Branches.get(i).setOrderTag();
		    				int NOC = rnd.nextInt(10)+3;//number of customers
		    	    		for(int j=0;j<= NOC;j++)//to add to other branches
		    	    		{
		    	    			try
    	                        {
			    	    			for(int z=11;z<25;z++)
			    	    			{
				    	    			Branches.get(i).genWalkInCustomers();
				    	    			//System.out.println("HHHHHHHHHHHHHHHHHHHHH" + hour);//spy
				    	    			if(hour*60>=Branches.get(i).Orders.get(i).getArriving())//
				    	    			{
				    	    				Branches.get(i).Orders.get(i).setArriving();
				    						Branches.get(i).Orders.get(i).generateOrder();
				    	    				if(hour>24)
				    	    				{
				    	    					hour=11;
				    	    					System.out.printf("|%4d | %20d | %20s | %20d | %20d | %20d | %20d | %18d | %20s | %n", z, Branches.get(i).Men_Queue.size(),Branches.get(i).Orders.get(i).getMax(Branches.get(i).Orders.get(i).getWait()),0,0,0,0, Branches.get(i).Women_Queue.size(),Branches.get(i).Orders.get(i).getMax(Branches.get(i).Orders.get(i).getWait()));
				    	    				}
				    	    				else
				    	    				{
				    	    					System.out.printf("|%4d | %20d | %20s | %20d | %20d | %20d | %20d | %18d | %20s | %n", z, Branches.get(i).Men_Queue.size(),Branches.get(i).Orders.get(i).getMax(Branches.get(i).Orders.get(i).getWait()),0,0,0,0, Branches.get(i).Women_Queue.size(),Branches.get(i).Orders.get(i).getMax(Branches.get(i).Orders.get(i).getWait()));
				    	    				}
				    	    			}
				    	    			hour++;

				    	    			if(hour>=25)
				    	    			{
				    	    				return;
				    	    			}
			    	    			}

    	                        }
		    	    			 catch (IndexOutOfBoundsException e)
    	                        {

    	                        }
		    	    			//Branches.clear();
		    	    			//Branches.get(i).setOrderTag();
		    	    			//Branches.get(i).setTotal();
		    	    		}
		    	    	}
    				}
    			if(c==2)
    			{
    				//System.out.print(Branches.size()+"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");//spy

    				for(int i=0;i<onlineBranch.size();i++)
	    	    	{
    					order.setArriving();
	    				order.generateOrder();
	    				onlineBranch.get(i).setOrderTag();
	    				int NOC = rnd.nextInt(10)+3;//number of customers
	    				//System.out.print(NOC+"NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");//spy
	    	    		for(int j=0;j<= NOC;j++)//to add to other branches
	    	    		{

	    	    			try
	                        {

		    	    			for(int z=10;z<25;z++)
		    	    			{
		    	    				onlineBranch.get(i).genWalkInCustomers();
				    				onlineBranch.get(i).genOnlineCustomers();
				    				onlineBranch.get(i).Orders.get(i).setArriving();
			    					onlineBranch.get(i).Orders.get(i).generateOrder();
		    	    				onlineBranch.get(i).genWalkInCustomers();
				    				onlineBranch.get(i).genOnlineCustomers();
		    	    				//System.out.print("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+z);
		    	    				if(hour*60>=onlineBranch.get(i).Orders.get(i).getArriving())
		    	    				{

			    	    				System.out.printf("|%4d | %20d | %20s | %20d | %20d | %20d | %20d | %18d | %20s | %n", z, (onlineBranch.get(i).Men_Queue.size()/2),onlineBranch.get(i).Orders.get(i).getMax(onlineBranch.get(i).Orders.get(i).getWait()),onlineBranch.get(i).Online_Queue.size()+solution(onlineBranch.get(i).Men_Queue.size())+solution(onlineBranch.get(i).Women_Queue.size()),0,onlineBranch.get(i).Delivery_Queue.size()+solution(onlineBranch.get(i).Men_Queue.size())+solution(onlineBranch.get(i).Women_Queue.size()),0, (onlineBranch.get(i).Women_Queue.size()/2),onlineBranch.get(i).Orders.get(i).getMax(onlineBranch.get(i).Orders.get(i).getWait()));
		    	    				}
		    	    				hour++;
			    	    			//if(hour>=25)
			    	    			{

			    	    			}
		    	    			}return;
	                        }
	    	    			 catch (IndexOutOfBoundsException e)
	                        {

	                        }
	    	    			//onlineBranch.clear();
	    	    			hour=1;
	    	    		}
	    	    	}
    			}
    			///\/\\/\/\/\/\/\/\/\/\
    			if(c==3)
    	    	{
    	    		break;
    	    	}
    		}
    		else if(a==3)
    		{
    			// to quit
    			break;
    		}
    		 hour++;
    		// work++;
    	 	}
    	// onlineBranch.clear();
        //method to do the process which is decreasing the time every customer order is finished ////branch.do_process(orders);
    	//////////////////
    	 // summary output
    	 //high volumee
    }
}