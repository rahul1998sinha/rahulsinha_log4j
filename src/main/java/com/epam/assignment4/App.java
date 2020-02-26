package com.epam.assignment4;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Interest
{
	private static final Logger LOGGER1 =LogManager.getLogger(Interest.class);
	double principle;
	double rateOfInterest;
	double timePeriod;
	Interest(double principle,double rateOfInterest,double timePeriod)
	{
		 this.principle=principle;
		 this.rateOfInterest=rateOfInterest;
		 this.timePeriod=timePeriod;
		 LOGGER1.info("Into Interest Class");
	}
	double simpleInterest()
	{
		LOGGER1.info("Into Simple Interest method");
		return (principle*rateOfInterest*timePeriod)/100;
	}
	double compoundInterest()
	{
		LOGGER1.info("Into Compound Interest Method");
		return principle*Math.pow((1+(rateOfInterest/100)),timePeriod);
	}
}
class HouseConstruction
{
	private static final Logger LOGGER2 =LogManager.getLogger(HouseConstruction.class);
	String materialStandard;
	double totalArea;
	boolean automatedHouse;
	HouseConstruction(String materialStandard,double totalArea,boolean automatedHouse)
	{
		this.materialStandard=materialStandard;
		this.totalArea=totalArea;
		this.automatedHouse=automatedHouse;
		LOGGER2.info("Into HouseConstruction Class");
	}
	double totalConstructionCost()
	{
		LOGGER2.info("totalConstructionCost Method");
		double totalCost=0.0;
		if(materialStandard.equals("standard"))
		{
			totalCost=1200*totalArea;		
		}
		else if(materialStandard.equals("abovestandard"))
		{
			totalCost=1500*totalArea;
		} 
		else if(materialStandard.equals("highstandard"))
		{
			if(automatedHouse==true)
				totalCost=2500*totalArea;
			else
				totalCost=1800*totalArea;
		}
		LOGGER2.info(" HouseConstruction Method Ends");
		return totalCost;
			
	}
}
public class App
{
    private static final Logger LOGGER =LogManager.getLogger(App.class);
	public static void main( String[] args ) throws IOException
    {
    	Scanner scanner = new Scanner(System.in);
    	OutputStreamWriter output = new OutputStreamWriter(System.out);
    	LOGGER.info("Into App Class");
    	LOGGER.info("Into Main() of App Class");
    	double principle,rateOfInterest,timePeriod,totalAmount,totalArea,interestCalculated,totalHouseCost;
    	char choiceAtEnd;
    	boolean automatedHouse;
    	int choice;
    	String materialStandard;
    	do
    	{
    		
    		output.write("\n--------------------------\n");
    		output.flush();
    		output.write("EPAM ASSIGNMENT 3");
    		output.flush();
    		output.write("\n-----Menu-----");
    		output.flush();
    		output.write("\n1.Interest Calculator");
    		output.flush();
    		output.write("\n2.Total Construction Cost");
    		output.flush();
    		output.write("\n Enter your choice .");
    		output.flush();
    		choice=scanner.nextInt();
    		output.write("\n--------------------------\n");
    		output.flush();
    		switch(choice)
    		{
    			case 1: LOGGER.info("Case 1");
    				    output.write("Interest Calculator");
    					output.flush();
    					output.write("\n Enter the principle Amount");
    					output.flush();
    					principle = scanner.nextDouble();
    					output.write("\n Enter the Rate of Interest p.a.");
    					output.flush();
    					rateOfInterest = scanner.nextDouble();
    					output.write("\n Enter the time period(years)");
    					output.flush();
    					timePeriod = scanner.nextDouble();
    					Interest interest = new Interest(principle,rateOfInterest,timePeriod);
    					output.write("\n \n Compute");
    					output.flush();
    					output.write("\n 1.Simple Interest");
    					output.flush();
    					output.write("\n 2.Compound Interest");
    					output.flush();
    					output.write("\n Enter your choice");
    					output.flush();
    					choice = scanner.nextInt();
    					switch(choice)
    					{
        	    			case 1: interestCalculated = interest.simpleInterest();
        	    					totalAmount=principle+interestCalculated;
        	    					output.write("\n Simple Interest : " + interestCalculated);
        	    					output.flush();
        	    					output.write("\n Total Amount : " + totalAmount);
        	    					output.flush();
        	    					break;
        	    			case 2: interestCalculated = interest.compoundInterest();
        	    					totalAmount=interestCalculated;
        	    					interestCalculated=interestCalculated-principle;
        	    					output.write("\n Compound Interest : " + interestCalculated);
        	    					output.flush();
        	    					output.write("\n Total Amount : " + totalAmount);
        	    					output.flush();
        	    					break;
        	    			default:output.write("\n Wrong Choice");
								 	output.flush();
								 	break;	
    					}
    					break;
    			case 2: LOGGER.info("Case 2");
    					output.write("\n Total Construction Cost Calculation");
    					output.flush();
    					scanner.nextLine();
    					output.write("\n Enter the Material Standard(standard/abovestandard/highstandard)");
    					output.flush();
    					materialStandard = scanner.nextLine();
    					output.write("\n Enter the total Area of the house");
    					output.flush();
    					totalArea = scanner.nextDouble();
    				    automatedHouse=false;
    					if(materialStandard.equals("highstandard"))
    					{
    						output.write("\n Do you want to have auotmated house(true/false)");
    						output.flush();
    						automatedHouse=scanner.hasNextBoolean();
    					}
    					HouseConstruction house = new HouseConstruction(materialStandard,totalArea,automatedHouse);
    					totalHouseCost=house.totalConstructionCost();
    					output.write("\n Total Construction Cost :" + totalHouseCost);
    					output.flush();
    					break;
    			default:LOGGER.info("Default Case");
    					output.write("\n Wrong Choice");
						output.flush();
						break;
    		}
    		output.write("\n Do you want to continue");
    		output.flush();
    		scanner.nextLine();
    		choiceAtEnd = scanner.next().charAt(0);
    		}while(choiceAtEnd!='n' && choiceAtEnd!='N');
    		scanner.close();
    		LOGGER.info("End of Main()");
    }
}
// Program developed by Rahul Sinhapackage com.epam.assignment4;



