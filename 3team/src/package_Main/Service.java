package package_Main;

import java.util.*;

import package_VO.*;

public interface Service {
	/**
	 * 회원가입 - 아이디 중복검사 해주는 메서드
	 * @param String
	 *        멤버의 아이디
	 * @return boolean
	 *         아이디 중복검사 성공여부
	 * @author 현주
	 */
	
	public boolean dupleId(String mem_id);

	/**
	 * 로그인 메서드
	 * 
	 * @param Map<String, String>
	 *        로그인한 멤버의 id와 pw
	 * @return MemberVO
	 *         로그인한 멤버객체가 있으면 db의 memberList의 멤버객체를 반환
	 * @author 현주  
	 */

	public MemberVO logIn(Map<String, String> params);

	/**
	 * 회원가입시에 멤버를 추가해주는 메서드
	 * 
	 * @param MemberVO
	 * @return boolean
	 *         멤버객체 추가 성공여부
	 * @author 현주 
	 *         
	 */
	public boolean addMv(MemberVO mv);
	
	

	
	// 회원: 카테고리

	/**
	 * 전체 카테고리목록 조회
	 * @return List<CategoryVO>
	 *          전체 카테고리 목록을 보여줌
	 * @author 제윤
	 */
	public List<CategoryVO> showCv();

	/**
	 * 카테고리별 상품 조회
	 * 
	 * @param int
	 *         카테고리 아이디
	 * @return List<ProductVO>
	 *         카테고리별 상품 리스트
	 * @author 제윤
	 */
	public List<ProductVO> showProductByCategory(int cate_id);


	/**
	 * 카테고리 검색 메서드
	 * @author 
	 * @param int
	 *         cate_id
	 * @return CategoryVO
	 *         해당 카테고리 id와 카테고리 리스트의 id가 동일시 해당 객체 반환
	 * @author 제윤
	 */
	public CategoryVO searchCv(int cate_id);
	
	
	// 회원: 장바구니
	/**
	 * 장바구니 추가 메서드
	 * @param CartVO 
	 *        cart값을 입력받은 객체
	 * @return boolean
	 *         성공/실패 여부 리턴
	 * @author 제윤
	 */
	boolean addCartv(CartVO cart);
	
	
	/**
	 * 장바구니 조회 메서드
	 * 
	 * @param String 
	 *        mem_id 멤버의 id를 가진 장바구니들을 리스트에 담아 반환한다.
	 * @return List<CartVO>
	 * @author 제윤
	 */
	public List<CartVO> showCartv(String mem_id);
	
	
	/**
	 * 장바구니 멤버별 cart_id 조회 메서드
	 * @param mem_id
	 *        멤버의 ID
	 * @return int
	 *         cart_id
	 * @author 제윤
	 */
	public int searchCartId(String mem_id);
	
	/**
	 * 장바구니를 검색하는 메서드
	 * 
	 * @param cart_id
	 *        장바구니의 ID
	 * @return CartVO
	 *         장바구니 객체
	 */
	public CartVO searchCartv(int cart_id);
	

	/**
	 * 장바구니 상품 객체가 cart_id랑 같은게 있는지 확인 메서드
	 * 
	 * @param int 
	 *        cart_id 장바구니의 아이디
	 * @return CartProductVO
	 *         
	 * @author 제윤
	 */
	

	public CartProductVO searchMemberCartProduct(int cart_id);
	
	
	/**
	 * 장바구니 상품 조회
	 * 
	 * @param cart_id
	 *        장바구니의 아이디
	 * @return List<CartProductVO> 
	 *         CartProductVO에서 cart_id를 가진 상품들을 조회하여 리턴
	 * @author 제윤
	 */
	public List<CartProductVO> showCartPv(int cart_id);

	/**
	 * 장바구니에 상품을 추가하는 메서드
	 * 
	 * @param Map<String, Object> 
	 *       (상품객체: cart_id, pv, pro_mount, 장바구니 id)
	 * @return boolean
	 *         상품추가 성공여부
	 * @author 제윤
	 */
	public boolean addCartProduct(Map<String, Object> params, int cart_id);
	
	/**
	 * 장바구니 물품들의 재고를 확인 메서드
	 * 
	 * @param int
	 *         cart_id
	 * @return boolean
	 *         재고가 있으면 true 없으면 false
	 */
	public boolean checkStock(int cart_id);
	
	/**
	 * 주문 내역
	 * @param String
	 *        회원의 아이디
	 * @return List<OrderViewVO>
	 *         사용자가 주문한 상품 내역을 반환
	 * @author 은선
	 *
	 */
	public List<OrderViewVO> showOrderList(String mem_id);
	
	/**
	 * 주문내역에 주문내용 추가
	 * @param int 
	 *        cart_id
	 * @return boolean
	 */
	boolean addOrder(int cart_id);

	
	/**
	 * 장바구니의 총합계 조회
	 * 
	 * @param int
	 *        cart_id 장바구니의 id
	 * @return int
	 *         장바구니의 총합계
	 * @author 제윤
	 */

	public int getCartPrice(int cart_id);
	
	
	// 캐시
	/**
	 * 캐시 충전
	 * 
	 * @param CashVO
	 *        cash 사용자가 충전한 캐시객체
	 * @return boolean
	 *         캐시 충전 성공 여부
	 * @author 은선
	 */
	
	public boolean addCash(CashVO cash);
	
	
	/**
	 * 캐시 사용 내역 
	 * 
	 * @param String
	 *        mem_id 회원의 아이디
	 * @return List<CashVO>
	 *         캐시 충전 전체 내역 List로 반환
	 * @author 은선
	 */
	public List<CashVO> showCashList(String mem_id);
	


	
	// ** 관리자 모드 
	// 관리자: 상품관리
	/**
	 * 상품 검색 메서드
	 * 
	 * @param int
	 *        해당 상품 정보를 조회하기 위하여 상품 id를 이용
	 * @return ProductVO
	 *         해당 상품 id와 리스트 중 id가 같으면 해당 정보 반환
	 * @author 현주
	 */
	public ProductVO searchPv(int pro_id);
	
	
	/**
	 * 상품 재고 조회
	 * @return List<ProductVO>
	 *          product
	 * @author 현주 
	 */
	List<ProductVO> showPv();
	
	/**
	 * 관리자 : 상품 추가
	 * @param Map<String, Object> param
	 *        int pb_id, String pro_name, int pro_mount, 
	 *        int pro_price, String pro_writer, boolean value,
	 *        String Cate_name, int Pb_id
	 * @return boolean
	 * @author 현주
	 */
	public boolean addPv(Map<String, Object> param);

	/**
	 * 관리자: 상품 삭제
	 * @param int pro_id
	 *        상품 id
	 * @return boolean
	 * @author 현주
	 */
	public boolean deletePv(int pro_id);

	/**
	 * 관리자: 상품 변경
	 * @param Map<String, Object> udp
	 * 		  pro_id, pro_name, pro_price, pro_mount
	 * @return boolean 
	 * @author 현주
	 */
	public boolean updateProduct(Map<String, Object> udp);
	
	
	// 관리자: 업체관리
	/**
	 * 전체 업체 목록 조회
	 * 
	 * @return List<PublisherVO>
	 *         업체 목록을 모두 보여줌
	 * @author 현주
	 */

	public List<PublisherVO> getPbList();
	/**
	
	 * @param Map<String, String> pb_name
	 * @return boolean
	 *         이름이 중복되거나 빈칸 입력시 성공/실패 여부
	 * @author 현주
	 */

	public boolean addPb(Map<String, String> pb);
	
	/**
	 * 업체선택 메서드
	 * @return List<PublisherVO>
	 *         publisherListd에서 업체를 찾아 그 업체를 돌려줌
	 * @author 현주
	 */

	public List<PublisherVO> getPbbList();
	
	/**
	 * 업체 삭제 메서드
	 * 
	 * @author 
	 * @param int
	 *        pb_id 업체를 삭제하기 위하여 업체 id를 이용
	 * @return boolean
	 *         해당 업체 id가 리스트 중 같으면 해당 기능을 off하여 일단 안보여지고 나중에 on하여 다시 사용할 수 있음
	 * @author 현주
	 */

	public boolean deletePb(int pb_id);
	/**
	 * 업체 검색 메서드
	 * 
	 * @param int pb_id 업체의 정보를 조회하기 위한 업체 id 이용
	 * @return PublisherVO 업체 id를 비교하여 같으면 해당 업체의 정보(이름, 소개)를 반환
	 * @author 현주
	 */
	public PublisherVO searchPb(int pb_id);


	// 관리자 : 회원관리
	/**
	 * 관리자모드 - 회원조회
	 * @return List<MemberVO>
	 * @author 은선  
	 * 
	 * */
	public List<MemberVO> showMv();

	/**
	 * 관리자모드 - 회원정보 변경
	 * @param Map<String, String>
	 * mem_id, mem_name, mem_password, mem_birth, mem_phone
	 * @return boolean
	 * @author 은선 
	 */
	public boolean updateMv(Map<String, String> params);
	
	/**
	 * 관리자모드 - 회원퇴출
	 * @param String
	 * @return boolean
	 * @author 은선  
	 */

	public boolean deleteMv(String mem_id);
	
	
	// 공통
	// 게시판
	/**
	 * 전체 게시글 조회
	 * @return List<NoticeboardVO>
	 * @author 은선 
	 */

	public List<NoticeboardVO> showNv();

	/**
	 * 공통 - 게시글 작성 메서드
	 * @param NoticeboardVO
	 * @return boolean
	 * @author 현주, 은선
	 * 
	 */

	public boolean addNv(NoticeboardVO nv);
	

	/**
	 * 게시글 번호로 검색
	 * @author 
	 * @param String
	 * @return MemberVO
	 * @author 현주, 은선
	 */
	
	public NoticeboardVO searchNv(int notice_id);
	
	/**
	 * 내가 작성한 게시글 검색
	 * @author 
	 * @param String
	 * @return MemberVO
	 * @author 현주, 은선
	 */

	public MemberVO searchMv(String mem_id);

	/**
	 * 게시글 수정 및 삭제 권한 체크
	 * @param Map<String, Object> 
	 *         notice_id, mem_autho, current_id
	 * @return boolean
	 *         관리자계정/자신의게시글 true
	 * @author 현주, 은선
	 */
	public boolean checkNoticeAutho(Map<String, Object> params);

	/**
	 * 게시글 수정
	 * @author 
	 * @param NoticeboardVO
	 *        게시글 수정 객체
	 * @return boolean
	 *         게시글 수정 성공여부
	 * @author 현주, 은선
	 */
	public boolean updateNv(NoticeboardVO nv);
	
	
	/**
	 *게시글 삭제
	 * @param int
	 *        사용자 또는 관리자가 삭제하고자 선택한 게시글 번호
	 * @return boolean
	 *         게시글 성공여부
	 * @author 현주, 은선
	 *
	 */
	public boolean deleteNv(int notice_id);

	



}
