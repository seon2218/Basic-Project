package package_VO;

public class CartVO {
	private int cart_id;	// 카트 Id
	private boolean isPayed = false;	// 물품에 대한 구매 여부 
	
	private String mem_id;	// 외래키 회원id
	
	private static int cart_sq = 0;
	//기본키 자동 생성
	{
		this.cart_id = cart_sq;
		cart_sq++;
	}
	
	
	
	
	// set , get
	
	@Override
	public String toString() {
		return "CartVO [cart_id=" + cart_id + ", isPayed=" + isPayed
				+ ", mem_id=" + mem_id + "]";
	}
	public boolean isPayed() {
		return isPayed;
	}
	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}
	
	public int getCart_id() {
		return cart_id;
	}

	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

}
