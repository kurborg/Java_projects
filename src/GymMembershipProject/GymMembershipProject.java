package GymMembershipProject;

import java.util.LinkedList;

public class GymMembershipProject 
{

	public static void main(String[] args) 
	{
		String mem;
		MembershipManagement mm = new MembershipManagement();
		FileHandler fh = new FileHandler();
		LinkedList <Member> members = fh.readFile();
		int choice = mm.getChoice();
		
		while(choice != -1)
		{
			switch(choice)
			{
			case 1:
				mem = mm.addMembers(members);
				fh.appendFile(mem);
				break;
			case 2:
				mm.removeMember(members);
				fh.overwriteFile(members);
				break;
			case 3:
				mm.printMemberInfo(members);
				break;
			default:
				System.out.println("\nNot a valid Input");
				break;
			}
			
			choice = mm.getChoice();
		}
		
		System.out.println("Thank you! Goodbye");
			
	}

}
