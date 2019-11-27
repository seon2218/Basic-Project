package package_VO;

import java.util.Calendar;

public class CashVO {
	
	
	private int cash_id;	// 캐시 Id
	
	private String mem_id;	
	private long addCash;
	private long subCash;
	private boolean isActived = true;

	private String cash_date;
	
	private static int cash_sq = 0;

	{
	      Calendar c = Calendar.getInstance();
	      cash_id = cash_sq;
	      cash_sq++;
	      cash_date = c.get(c.YEAR) + "년 " + (c.get(c.MONTH)+1) + "월" 
	      + c.get(c.DATE) + "일";
	   }
	
	// get, set
	public int getCash_id() {
		return cash_id;
	}

	public void setCash_id(int cash_id) {
		this.cash_id = cash_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public long getAddCash() {
		return addCash;
	}

	public void setAddCash(long addCash) {
		this.addCash = addCash;
	}

	public long getSubCash() {
		return subCash;
	}

	public void setSubCash(long subCash) {
		this.subCash = subCash;
	}

	public static int getCash_sq() {
		return cash_sq;
	}

	public static void setCash_sq(int cash_sq) {
		CashVO.cash_sq = cash_sq;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

	public String getCash_date() {
		return cash_date;
	}
	
	


}
