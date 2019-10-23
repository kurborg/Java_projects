package GymMembershipProject;

public class SingleClubMember extends Member
{
	private int club;
	
	SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub)
	{
		super (pMemberType, pMemberID, pName, pFees);
		club = pClub;
		toString();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + club;
	}

	public int getClub() 
	{
		return club;
	}

	public void setClub(int club) 
	{
		this.club = club;
	}
}
