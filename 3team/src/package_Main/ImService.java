package package_Main;

import java.util.*;

import package_Database.Database;
import package_VO.*;

public class ImService implements Service {
	private Database db = Database.getDatabase();


	/*
	 * 현주 영역
	 */
	// 회원가입
	@Override
	public boolean dupleId(String mem_id) {
		return db.dupleId(mem_id);
	}
	
	@Override
	public boolean addMv(MemberVO mv) {
		return db.addMv(mv);
	}
	
	@Override
	public MemberVO logIn(Map<String, String> params) {
		return db.logIn(params);
	}




	// 카테고리

	@Override
	public List<CategoryVO> showCv() {
		return db.showCv();
	}

	
	
	// 장바구니
	@Override
	public List<ProductVO> showProductByCategory(int cate_id) {
		return db.showProductByCategory(cate_id);
	}
	
	@Override
	public boolean addCartv(CartVO cart) {
		return db.addCartv(cart);
	}
	
	@Override
	public List<CartVO> showCartv(String mem_id) {
		return db.showCartv(mem_id);
	}
	
	@Override
	public int searchCartId(String mem_id) { 	
		return db.searchCartId(mem_id); 
	}
	
	@Override
	public CartVO searchCartv(int cart_id) {
		return db.searchCartv(cart_id);
	}
	
	
	@Override
	public CategoryVO searchCv(int cate_id) {
		return db.searchCv(cate_id);
	}
	
	@Override
	public int getCartPrice(int cart_id) {
		return db.getCartPrice(cart_id);
	}
	
	@Override
	public CartProductVO searchMemberCartProduct(int cart_id) {	
		return db.searchMemberCartProduct(cart_id);
	}
	
	
	
	@Override
	public List<CartProductVO> showCartPv(int cart_id) {
		return db.showCartPv(cart_id);
	}

	@Override
	public boolean addCartProduct(Map<String, Object> params, int cart_id) {
		return db.addCartProduct(params, cart_id);
	}
	
	@Override
	public boolean checkStock(int cart_id) {
		return true;
	}

	@Override
	public List<OrderViewVO> showOrderList(String mem_id) {
		return db.showOrderList(mem_id);
	}
	

	@Override
	public boolean addOrder(int cart_id) {
		return db.addOrder(cart_id);
	}
	
	@Override
	public boolean addCash(CashVO cash) {
		return db.addCash(cash);
	}
	
	
	
	
	@Override
	public List<CashVO> showCashList(String mem_id) {
		return db.showCashList(mem_id);
	}
	
	// ** 관리자 모드 
	
	/*
	 * 현주 영역
	 */
	// 관리자: 상품관리
	@Override
	public ProductVO searchPv(int pro_id) {
		return db.searchPv(pro_id);
	}
	
	@Override
	public List<ProductVO> showPv() {
		return db.showPv();
	}
	@Override
	public boolean addPv(Map<String, Object> param) {
		return db.addPv(param);
	}

	@Override
	public boolean deletePv(int pro_id) {
		return db.deletePv(pro_id);
	}

	@Override
	public boolean updateProduct(Map<String, Object> udp) {
		return db.updateProduct(udp);
	}
	
	
	/*
	 * 현주 영역
	 */
	// 관리자: 업체관리
	@Override
	public List<PublisherVO> getPbList() {
		return db.getPbList();
	}
	
	@Override
	public boolean addPb(Map<String, String> pb) {
		return db.addPb(pb);
	}

	@Override
	public List<PublisherVO> getPbbList() {
		return db.getPbbList();
	}
	
	@Override
	public boolean deletePb(int pb_id) {
		return db.deletePb(pb_id);
	}
	
	@Override
	public PublisherVO searchPb(int pb_id) {
		return db.searchPb(pb_id);
	}


	/*
	 * 은선 영역
	 */
	// 관리자 : 회원관리
	@Override
	public List<MemberVO> showMv() {
		return db.showMv();
	}

	@Override
	public boolean updateMv(Map<String, String> params) {
		return db.updateMv(params);
	}
	
	@Override
	public boolean deleteMv(String mem_id) {
		return db.deleteMv(mem_id);
	}
	
	
	/*
	 * 현주,은선 영역
	 */
	// 공통
	// 게시판
	@Override
	public List<NoticeboardVO> showNv() {
		return db.showNv();
	}

	@Override
	public boolean addNv(NoticeboardVO nv) {
		return db.addNv(nv);
	}
	
	@Override
	public NoticeboardVO searchNv(int notice_id) {
		return db.searchNv(notice_id);
	}

	@Override
	public MemberVO searchMv(String mem_id) {
		return db.searchMv(mem_id);
	}

	@Override
	public boolean checkNoticeAutho(Map<String, Object> params) {
		return db.checkNoticeAutho(params);
	}

	@Override
	public boolean updateNv(NoticeboardVO nv) {
		return db.updateNv(nv);
	}
	
	@Override
	public boolean deleteNv(int notice_id) {
		return db.deleteNv(notice_id);
	}
	



}
