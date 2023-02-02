package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the amount of money you want to start with? ");
		double startAmount = in.nextDouble();
		
		System.out.println("What is the probability that you win a single play? ");
		double winChance = in.nextDouble();
		
		System.out.println("What is your win limit? ");
		double winLimit = in.nextDouble();
		
		System.out.println("How many days do you want to play? ");
		double totalSimulations = in.nextDouble();
		
		int totalRuins = 0;
		
		for (int d=0; d < totalSimulations ; d++)
		{
		
			double totalMoney = startAmount;
			int plays = 0 ; 
	
			while(totalMoney <  winLimit && totalMoney > 0.0)
			{
				if (Math.random() < winChance) 
				{
					totalMoney++;
				}
				else
				{
					totalMoney--;
				}	
				plays++ ;
			}
			
			int day = d + 1;
			
			if(totalMoney >= winLimit)
			{
				System.out.println("Simulation " +day + ": " + plays + " WIN" );
			}
			else if(totalMoney <= 0.0)
			{
				System.out.println("Simulation " +day + ": " + plays + " LOSE");
				totalRuins++;
			}
		}
		
		System.out.println("Loses: " +totalRuins +" Simulations: " +totalSimulations);
		System.out.println("Ruin Rate from Simulation: " +(totalRuins/totalSimulations));
		double expectedRuin = 0;
		if(winChance == 0.5)
		{
			expectedRuin = 1-(startAmount/winLimit);
		}
		else
		{
			double a = (1-winChance)/winChance;
			expectedRuin = (Math.pow(a,startAmount) - Math.pow(a,winLimit))/(1-Math.pow(a,winLimit));
		}
		System.out.println("Expected Ruin Rate: " +expectedRuin);
	}

}
