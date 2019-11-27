package package_VO;

public class CartProductVO {   // 장바구니에 있는 상품들의 집합체.
	private int cartPro_id;			// 상품목록id
	private int cartPro_mount;		// 상품 수량
	
	private int pro_id;				// 외래키: 상품
	private int cart_id;			// 외래키: 장바구니id
	
	private boolean isActived = true;	// true : 장바구니 구매  false: 구매내역 
	
	private static int cartPro_sq = 0;
	
	//기본키 자동 생성
	{
		this.cartPro_id = cartPro_sq;
		cartPro_sq++;
	}
	

	
	//get, set
	
	@Override
	public String toString() {
		return "CartProductVO [cartPro_id=" + cartPro_id + ", cartPro_mount="
				+ cartPro_mount + ", pro_id=" + pro_id + ", cart_id=" + cart_id
				+ ", isActived=" + isActived + "]";
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	public int getCartPro_id() {
		return cartPro_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getCartPro_mount() {
		return cartPro_mount;
	}
	public void setCartPro_mount(int cartPro_mount) {
		this.cartPro_mount = cartPro_mount;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

}
