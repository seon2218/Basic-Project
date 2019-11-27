package package_VO;

/**
 * 
 *
 */
public class CategoryVO {

	private int cate_id;  					// 카테고리 아이디
	private String cate_name; 				// 카테고리 이름
	private boolean isActived = true; 		// 카테고리 삭제여부
	private static int cate_sq = 0;			// 카테고리 시퀀스
	 {
	      this.cate_id = cate_sq;
	      cate_sq++;
	 }

	   //cate_id++;
 
	 
public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
   
   
   
// set영역
   public void setCate_name(String cate_name){
      this.cate_name = cate_name;
   }
   
// get영역
   public String getCate_name(){
      return cate_name;
   }
   public int getCate_id() {
		return cate_id;
}



}
