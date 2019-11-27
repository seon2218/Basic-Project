package package_VO;

public class UsedBookVO {

	private int ub_id;
	private String ub_name;
	private int ub_price;
	private String ub_writer; // 저자
	
	private int ub_grade; // 중고책의 등급
	private int status; // 유저가 관리자에게 넣으면 status 1, 관리자가 판단하면 status 2, 유저가 그럼 판매하겠다! status 3, 판매x status 4
	
	

	private int cart_id; // 카테고리
	private int pb_id; // 출판사
	
	private boolean isActived = true;  
	
	   {
	      ub_id++;
	   }
	   
	// set , get   
	public int getUb_id() {
		return ub_id;
	}
	public void setUb_id(int ub_id) {
		this.ub_id = ub_id;
	}
	public String getUb_name() {
		return ub_name;
	}
	public void setUb_name(String ub_name) {
		this.ub_name = ub_name;
	}
	public int getUb_price() {
		return ub_price;
	}
	public void setUb_price(int ub_price) {
		this.ub_price = ub_price;
	}
	public String getUb_writer() {
		return ub_writer;
	}
	public void setUb_writer(String ub_writer) {
		this.ub_writer = ub_writer;
	}
	public int getUb_grade() {
		return ub_grade;
	}
	public void setUb_grade(int ub_grade) {
		this.ub_grade = ub_grade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getPb_id() {
		return pb_id;
	}
	public void setPb_id(int pb_id) {
		this.pb_id = pb_id;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	   
}
