package package_VO;

public class PublisherVO {

	private int pb_id;
	private String pb_name;
	private static int pb_sq = 0;
	private boolean isActived = true;
	{
		this.pb_id = pb_sq;
		pb_sq++;
	}
	
	
	
	@Override
	public String toString() {
		return "PublisherVO [pb_id=" + pb_id + ", pb_name=" + pb_name
				+ ", isActived=" + isActived + "]";
	}
	// get, set
	public int getPb_id() {
		return pb_id;
	}
	public void setPb_id(int pb_id) {
		this.pb_id = pb_id;
	}
	public String getPb_name() {
		return pb_name;
	}
	public void setPb_name(String pb_name) {
		this.pb_name = pb_name;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}
	
	
	
	
	
	
}
