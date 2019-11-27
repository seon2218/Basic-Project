package package_VO;

public class MemberVO {
	private String mem_id; // id
	private String mem_pw; // 패스워드
	private String mem_name; // 회원이름
	private String mem_bir; // 생년월일
	private String mem_phone; // 폰번호
	private String mem_add; // 주소
	private boolean mem_autho;    // 관리권한
	private long mem_cash = 0; //캐시
	private boolean isActived = true;
	
	// get,set
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_add() {
		return mem_add;
	}
	public void setMem_add(String mem_add) {
		this.mem_add = mem_add;
	}
	public boolean getMem_autho() {
		return mem_autho;
	}
	public void setMem_autho(boolean mem_autho) {
		this.mem_autho = mem_autho;
	}
	public long getMem_cash() {
		return mem_cash;
	}
	public void setMem_cash(long mem_cash) {
		this.mem_cash = mem_cash;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	

	//add, sub // 보유한 값을 +, -
	
	public void addCash(long cash){
		this.mem_cash += cash;
	}
	public void subCash(long cash){
		this.mem_cash -= cash;
	}
}
