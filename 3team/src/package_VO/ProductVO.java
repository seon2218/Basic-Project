package package_VO;

public class ProductVO {

	private int pro_id; 		// 상품 id
	private String pro_name;    // 상품명
	private int pro_price;		// 상품가격
	private int pro_mount;		// 상품수량
	private String pro_writer;  // 저자
	private boolean isActived = true;  // 상품 삭제 여부
	private static int pro_sq = 0;
	 {
	      this.pro_id = pro_sq;
	      pro_sq++;
	 }
	   
	
	private int cate_id; // 카테고리 
	private int pb_id; // 출판사
	
	
	

	@Override
	public String toString() {
		return "ProductVO [pro_id=" + pro_id + ", pro_name=" + pro_name
				+ ", pro_price=" + pro_price + ", pro_mount=" + pro_mount
				+ ", pro_writer=" + pro_writer + ", isActived=" + isActived
				+ ", cate_id=" + cate_id + ", pb_id=" + pb_id + "]";
	}
	// set , get
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_mount() {
		return pro_mount;
	}
	public void setPro_mount(int pro_mount) {
		this.pro_mount = pro_mount;
	}
	public String getPro_writer() {
		return pro_writer;
	}
	public void setPro_writer(String pro_writer) {
		this.pro_writer = pro_writer;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
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
	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}
	

	
}
