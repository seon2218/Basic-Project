package package_Main;

import java.util.regex.Pattern;

public class RegEx {
	/**
	 * @author 정준
	 * @param mem_id
	 * @return
	 */
	public static boolean checkMemId(String mem_id){
		String patternId = "\\S{3}\\S*";
		return Pattern.matches(patternId, mem_id);
	}
	
	public static boolean checkMemPw(String mem_pw){
		String patternPw = "\\S{4}\\S*";
		return Pattern.matches(patternPw, mem_pw);
	}
	
	public static boolean checkMemName(String mem_name){
		String patternName = "[가-힣]{2,4}";
		return Pattern.matches(patternName, mem_name);
	}
	
	public static boolean checkMemBirth(String mem_bir){
		String patternBirth = "[0-2][0-9]{3}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))";
		return Pattern.matches(patternBirth, mem_bir);
		
	}
	public static boolean checkMemPhone(String mem_phone){
		String patternPhone = "0[0-1]{2}-[0-9]{3,4}-[0-9]{3,4}";
		return Pattern.matches(patternPhone, mem_phone);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
