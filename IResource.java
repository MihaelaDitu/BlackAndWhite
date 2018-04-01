
public interface IResource {
	boolean canBeUsed();

	void isReleased();

	void isUsed();

	void setType(int type);

	boolean isUnused();

	boolean isUsedBy(int type);

}
