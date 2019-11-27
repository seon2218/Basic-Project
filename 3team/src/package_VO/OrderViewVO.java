package package_VO;
import java.util.*;

public class OrderViewVO {
	private int ord_id;
	private static int ord_sq = 0;
	private boolean isActived = true;

	
	private String mem_id;
	
	
	private int cart_id;
	private int cart_price;
	private String order_date;
	private String pro_name;
	
	{
		Calendar c = Calendar.getInstance();
		ord_id = ord_sq;
		ord_sq++;
		order_date = c.get(c.YEAR) + "년 " + (c.get(c.MONTH)+1) + "월" 
		+ c.get(c.DATE) + "일";
	}
	
	
	
	// get, set
	public String getPro_name() {
		return pro_name;
	}
	
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	public int getOrd_id() {
		return ord_id;
	}
	
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public static int getOrd_sq() {
		return ord_sq;
	}

	public static void setOrd_sq(int ord_sq) {
		OrderViewVO.ord_sq = ord_sq;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCart_price() {
		return cart_price;
	}

	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}


	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}





	

	

}
