
public class Resource implements IResource {

	private int maxUsersNumber;
	private int usedBy;
	private int usersNumber;

	public Resource(int maxUsersNumber) {
		this.maxUsersNumber = maxUsersNumber;
	}

	@Override
	public boolean canBeUsed() {
		return usersNumber <= maxUsersNumber;
	}

	@Override
	public void isReleased() {
		usersNumber --;
		System.out.println("Users: " + usersNumber);
	}

	@Override
	public void isUsed() {
		usersNumber ++;
		System.out.println("Users: " + usersNumber);
	}

	@Override
	public void setType(int type) {
		usedBy = type;
	}

	@Override
	public boolean isUnused() {
		return usersNumber == 0;
	}

	@Override
	public boolean isUsedBy(int type) {
		return usedBy == type;
	}


}
