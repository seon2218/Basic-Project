package package_VO;

import java.util.Calendar;



public class NoticeboardVO {
   private int notice_id;          // 아이디
   private String notice_title;   // 제목
   private Calendar notice_date;   // 날짜
   private String notice_content; // 내용
   private String mem_id; //외래키 from 회원VO
   private boolean isActived = true;
  
   public static int notice_sq = 0;
   {
      this.notice_id= notice_sq++;
   }

   //   set영역
  
   public void setNotice_title(String notice_title){
      this.notice_title = notice_title;
   }
   public void setNotice_date(String notice_date){
      String[] date = notice_date.split("-");
      Calendar c = Calendar.getInstance();
      c.set(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]));
      this.notice_date = c;
   }
   public void setNotice_date(){
      this.notice_date = Calendar.getInstance();
   }
   public void setNotice_content(String notice_content){
      this.notice_content = notice_content;
   }
   public void setMem_id(String mem_id){
      this.mem_id = mem_id;
   }
   
   public void setNotice_id(int notice_id) {
      this.notice_id = notice_id;
   }
   
   //   get영역
   public int getNotice_id(){
      return notice_id;
   }
   public String getNotice_title(){
      return notice_title;
   }
   public Calendar getNotice_date(){
      return notice_date;
   }
   public String getNotice_content(){
      return notice_content;
   }
   public String getMem_id(){
      return mem_id;
   }

   public boolean isActived() {
      return isActived;
   }

   public void setActived(boolean isActived) {
      this.isActived = isActived;
   }

 
}