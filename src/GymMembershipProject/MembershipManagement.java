package GymMembershipProject;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement 
{
	final private Scanner reader = new Scanner(System.in);	

	private int getIntInput()
	{
		int num = 0;
		
		while(num == 0)
		{
			try
			{
				num = reader.nextInt();
				
				if (num == 0)
					throw new InputMismatchException();
				reader.nextLine();
			}
			catch(InputMismatchException e)
			{
				reader.nextLine();
				System.out.println("\nError Invalid Input: Please try again");
			}
		}
		
		return num;
	}
	
	public void printClubOptions()
	{
		System.out.println("1) Club Mercury");
		System.out.println("2) Club Neptune");
		System.out.println("3) Club Jupiter");
		System.out.println("4) Multi Clubs");
	}
	
	public int getChoice()
	{
		int choice;
		
		System.out.print("WELCOME TO OZONE FITNESS CENTER" + "\n" + 
		"===============================" + "\n" 
		+ "1) Add Member" + "\n" + "2) Remove Member" + 
		"\n" + "3) Display Member Information" + "\n\n" + 
		"Please enter your option or -1 to quit: \n");
		
		choice = getIntInput();
		return choice;
	}
	
	public String addMembers(LinkedList<Member> m) 
	{
		String name;
		int club;
		String mem;
		double fees;
		int MemberID;
		Member mbr;
		Calculator<Integer> cal;
		
		System.out.println("Please enter the member's name: \n");
		name = reader.nextLine();
		
		printClubOptions();
		System.out.println("Please enter the clubs the member has access to");
		club = getIntInput();
		while(club < 1 || club > 4)
		{
			System.out.println("Please enter the right club option");
			club = getIntInput();
		}
		
		if (m.size()>0)
			MemberID = m.getLast().getMemberID()+1;
		else 
			MemberID = 1;
		
		if(club!= 4)
		{
			cal = (n)->{
				switch(n)
				{
				case 1:
					return 900;
				case 2:
					return 950;
				case 3:
					return 1000;
				default:
					return -1;
				}
			};
			
			fees = cal.calculateFees(club);
			
			mbr = new SingleClubMember('S', MemberID, name, fees, club);
			m.add(mbr);
			mem = mbr.toString();
			
			System.out.println("Single Club Member added\n");
		}
		else
		{
			cal = (n)->
			{
				if(n == 4) 
					return 1200;
				else 
					return -1;
			};
			
			fees = cal.calculateFees(club);
			mbr = new MultiClubMember('M', MemberID, name, fees, 100);
			m.add(mbr);
			mem = mbr.toString();
			
			System.out.println("Multi Club Member added\n");
		}
		
		return mem;
	}
	
	public void removeMember(LinkedList<Member> m)
	{
		int memberID;
		
		System.out.println("Please enter the member ID to remove");
		memberID = getIntInput();
		
		for(int i = 0; i <m.size(); i++)
		{
			if(m.get(i).getMemberID()==memberID)
			{
				m.remove(i);
				System.out.println("Member has been removed");
				return;
			}
		}
		
		System.out.println("Member could not be found");
		return;
	}
	
	public void printMemberInfo(LinkedList<Member> m)
	{
		int memberID;
		
		System.out.println("Please enter the member ID to show info");
		memberID = getIntInput();
		
		for(int i = 0; i <m.size(); i++)
		{
			if(m.get(i).getMemberID()==memberID)
			{
				String[] memberInfo = m.get(i).toString().split(",");

				System.out.println("Member Type = "+ memberInfo[0]);
				System.out.println("MemberID = "+ memberInfo[1]);
				System.out.println("Member Name = "+ memberInfo[2]);
				System.out.println("Membership Fees = "+ memberInfo[3]);
				
				if (memberInfo[0] == "S") 
				{
				System.out.println("Club ID = "+ memberInfo[4]);
				}
				else 
				{
				System.out.println("Membership Points = "+ memberInfo[4]);
				}
				
				return;
			}
		}
		
		System.out.println("Member could not be found");
	}

}
