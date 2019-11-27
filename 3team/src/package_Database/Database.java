package package_Database;

import java.util.*;

import package_VO.*;
import package_Main.*;

public class Database {

	private List<MemberVO> memberList = new ArrayList<MemberVO>(); // 멤버

	private List<CategoryVO> categoryList = new ArrayList<CategoryVO>(); // 카테고리
	private List<PublisherVO> publisherList = new ArrayList<PublisherVO>(); // 출판사

	private List<ProductVO> productList = new ArrayList<ProductVO>(); // 상품

	private List<CartVO> cartList = new ArrayList<CartVO>(); // 카트(장바구니)
	private List<CartProductVO> cartProductList = new ArrayList<CartProductVO>(); // 카트에 담긴 상품
	private List<OrderViewVO> orderList = new ArrayList<OrderViewVO>(); // 주문내역
	
	private List<CashVO> cashList = new ArrayList<CashVO>(); // 캐시

	private List<NoticeboardVO> noticeboardList = new ArrayList<NoticeboardVO>(); // 게시판
	private List<UsedBookVO> usedbookList = new ArrayList<UsedBookVO>(); // 중고도서
	

	private static Database database = new Database();

	private Database() {
	}

	// get, set

	public static Database getDatabase() {
		return database;
	}

	// 초기화
	{
		// 멤버 초기화
		MemberVO admin = new MemberVO();
		admin.setMem_id("genie");
		admin.setMem_pw("genie");
		admin.setMem_name("관리자");
		admin.setMem_bir("1995-04-27");
		admin.setMem_phone("010-1231-2465");
		admin.setMem_add("주소 없음");
		admin.setMem_cash(99999999);
		admin.setMem_autho(true);
		memberList.add(admin);

		MemberVO member = new MemberVO();
		member.setMem_id("kkk");
		member.setMem_pw("1234");
		member.setMem_name("김씨");
		member.setMem_bir("1997-05-20");
		member.setMem_phone("010-1020-3040");
		member.setMem_add("대전광역시-유성구-구암동-608");
		member.setMem_cash(10000000);
		memberList.add(member);

		MemberVO member2 = new MemberVO();
		member2.setMem_id("jjj");
		member2.setMem_pw("1234");
		member2.setMem_name("전씨");
		member2.setMem_bir("1989-02-23");
		member2.setMem_phone("010-1234-3422");
		member2.setMem_add("대전광역시-중구-대흥동-대덕인재개발원");
		member2.setMem_cash(9000000);
		memberList.add(member2);

		MemberVO member3 = new MemberVO();
		member3.setMem_id("bbb");
		member3.setMem_pw("1234");
		member3.setMem_name("박씨");
		member3.setMem_bir("1988-12-11");
		member3.setMem_phone("010-1340-1234");
		member3.setMem_add("대전광역시-서구-둔산동-타임월드");
		member3.setMem_cash(8000000);
		memberList.add(member3);

		MemberVO member4 = new MemberVO();
		member4.setMem_id("uuu");
		member4.setMem_pw("1234");
		member4.setMem_name("유씨");
		member4.setMem_bir("2001-07-20");
		member4.setMem_phone("010-2939-4123");
		member4.setMem_add("대전광역시-서구-탄방동-CGV");
		member4.setMem_cash(25000);
		memberList.add(member4);

		MemberVO member5 = new MemberVO();
		member5.setMem_id("lll");
		member5.setMem_pw("1234");
		member5.setMem_name("이씨");
		member5.setMem_bir("1965-03-11");
		member5.setMem_phone("010-1234-3565");
		member5.setMem_add("대전광역시-대덕구-비래동-비레키키");
		member5.setMem_cash(300000);
		memberList.add(member5);

		MemberVO member6 = new MemberVO();
		member6.setMem_id("gu");
		member6.setMem_pw("1234");
		member6.setMem_name("구씨");
		member6.setMem_bir("1933-03-11");
		member6.setMem_phone("010-1346-3435");
		member6.setMem_add("서울특별시-강남구-도곡동-타워팰리스");
		member6.setMem_cash(3000);
		memberList.add(member6);

		MemberVO member7 = new MemberVO();
		member7.setMem_id("www");
		member7.setMem_pw("1234");
		member7.setMem_name("왕씨");
		member7.setMem_bir("2001-12-25");
		member7.setMem_phone("010-1207-1207");
		member7.setMem_add("서울특별시-강남구-청담동-GS자이");
		member7.setMem_cash(100000);
		memberList.add(member7);

		MemberVO member8 = new MemberVO();
		member8.setMem_id("eun");
		member8.setMem_pw("1234");
		member8.setMem_name("은씨");
		member8.setMem_bir("1996-10-01");
		member8.setMem_phone("010-1744-8974");
		member8.setMem_add("대전광역시-중구-은행동-성심당");
		member8.setMem_cash(10000);
		memberList.add(member8);

		MemberVO member9 = new MemberVO();
		member9.setMem_id("mmm");
		member9.setMem_pw("1234");
		member9.setMem_name("문씨");
		member9.setMem_bir("1956-05-28");
		member9.setMem_phone("010-2548-1845");
		member9.setMem_add("'서울특별시-종로구-세종로-청와대");
		member9.setMem_cash(0);
		memberList.add(member9);

		MemberVO member10 = new MemberVO();
		member10.setMem_id("sky");
		member10.setMem_pw("1234");
		member10.setMem_name("서씨");
		member10.setMem_bir("1992-01-26");
		member10.setMem_phone("010-1234-3565");
		member10.setMem_add("서울시-관악구-대학동-SKY캐슬");
		member10.setMem_cash(100);
		memberList.add(member10);

	}

	{
		// 카테고리 초기화
		CategoryVO cate = new CategoryVO();
		cate.setCate_name("국내도서");
		categoryList.add(cate);

		CategoryVO cate2 = new CategoryVO();
		cate2.setCate_name("외국도서");
		categoryList.add(cate2);

		CategoryVO cate3 = new CategoryVO();
		cate3.setCate_name("e-book");
		categoryList.add(cate3);

	}

	{

		// 출판사 초기화
		PublisherVO Pb1 = new PublisherVO(); // 0
		Pb1.setPb_name("대덕인재개발원");
		publisherList.add(Pb1);

		PublisherVO Pb2 = new PublisherVO(); // 1
		Pb2.setPb_name("Havard");
		publisherList.add(Pb2);

		PublisherVO Pb3 = new PublisherVO();
		Pb3.setPb_name("한빛미디어");
		publisherList.add(Pb3);

		PublisherVO Pb4 = new PublisherVO();
		Pb4.setPb_name("YouCanDoIt");
		publisherList.add(Pb4);

		PublisherVO Pb5 = new PublisherVO();
		Pb5.setPb_name("이지스퍼블리싱");
		publisherList.add(Pb5);

		PublisherVO Pb6 = new PublisherVO();
		Pb6.setPb_name("책나무출판사");
		publisherList.add(Pb6);

		PublisherVO Pb7 = new PublisherVO(); // 5
		Pb7.setPb_name("위키북스");
		publisherList.add(Pb7);

		PublisherVO Pb8 = new PublisherVO();
		Pb8.setPb_name("길벗");
		publisherList.add(Pb8);

		PublisherVO Pb9 = new PublisherVO();
		Pb9.setPb_name("cheerUp출판사");
		publisherList.add(Pb9);

		PublisherVO Pb10 = new PublisherVO();
		Pb10.setPb_name("동아출판사");
		publisherList.add(Pb10);
	}

	{
		// 프로덕트 초기화
		ProductVO product1 = new ProductVO();
		product1.setPro_name("영만샘의 혼자공부하는 자바");
		product1.setPro_price(5000);
		product1.setPro_mount(100);
		product1.setPro_writer("이영만샘");
		product1.setPb_id(0); // 출판사랑 연결
		product1.setCate_id(0); // 카테고리 연결
		productList.add(product1);

		ProductVO product2 = new ProductVO();
		product2.setPro_name("HTML5+CSS3 바이블");
		product2.setPro_price(30000);
		product2.setPro_mount(80);
		product2.setPro_writer("배미숙샘");
		product2.setPb_id(0);
		product2.setCate_id(0);
		productList.add(product2);

		ProductVO product3 = new ProductVO();
		product3.setPro_name("관계도 반품이 됩니다");
		product3.setPro_price(20000);
		product3.setPro_mount(70);
		product3.setPro_writer("박민근");
		product3.setPb_id(1);
		product3.setCate_id(0);
		productList.add(product3);

		ProductVO product4 = new ProductVO();
		product4.setPro_name("거절 잘해도 좋은 사람입니다");
		product4.setPro_price(10000);
		product4.setPro_mount(40);
		product4.setPro_writer("양지아링");
		product4.setPb_id(2);
		product4.setCate_id(0);
		productList.add(product4);

		ProductVO product5 = new ProductVO();
		product5.setPro_name("개떡같이 말하면 개떡같이 알아듣습니다");
		product5.setPro_price(30000);
		product5.setPro_mount(60);
		product5.setPro_writer("김윤정");
		product5.setPb_id(3);
		product5.setCate_id(0);
		productList.add(product5);

		ProductVO product6 = new ProductVO();
		product6.setPro_name("DEMIAN");
		product6.setPro_price(50000);
		product6.setPro_mount(35);
		product6.setPro_writer("헤르만헤세");
		product6.setPb_id(4);
		product6.setCate_id(1);
		productList.add(product6);

		ProductVO product7 = new ProductVO();
		product7.setPro_name("Life of pi");
		product7.setPro_price(30000);
		product7.setPro_mount(60);
		product7.setPro_writer("얀 마텔");
		product7.setPb_id(5);
		product7.setCate_id(1);
		productList.add(product7);

		ProductVO product8 = new ProductVO();
		product8.setPro_name("The Little Prince");
		product8.setPro_price(20000);
		product8.setPro_mount(20);
		product8.setPro_writer("생텍쥐페리");
		product8.setPb_id(6);
		product8.setCate_id(1);
		productList.add(product8);

		ProductVO product9 = new ProductVO();
		product9.setPro_name("e돈의 감각");
		product9.setPro_price(9000);
		product9.setPro_mount(20);
		product9.setPro_writer("이명로");
		product9.setPb_id(7);
		product9.setCate_id(2);
		productList.add(product9);

		ProductVO product10 = new ProductVO();
		product10.setPro_name("e여자 둘이 살고 있습니다");
		product10.setPro_price(10000);
		product10.setPro_mount(20);
		product10.setPro_writer("김하나");
		product10.setPb_id(8);
		product10.setCate_id(2);
		productList.add(product10);

	}

	{
		// cart(장바구니) 초기화
		CartVO cart = new CartVO();
		cart.setMem_id("genie");
		cartList.add(cart);

		CartVO cart1 = new CartVO();
		cart1.setMem_id("kkk");
		cartList.add(cart1);

		CartVO cart2 = new CartVO();
		cart2.setMem_id("jjj");
		cartList.add(cart2);

		CartVO cart3 = new CartVO();
		cart3.setMem_id("bbb");
		cartList.add(cart3);

		CartVO cart4 = new CartVO();
		cart4.setMem_id("uuu");
		cartList.add(cart4);

		CartVO cart5 = new CartVO();
		cart5.setMem_id("lll");
		cartList.add(cart5);

		CartVO cart6 = new CartVO();
		cart6.setMem_id("gu");
		cartList.add(cart6);

		CartVO cart7 = new CartVO();
		cart7.setMem_id("www");
		cartList.add(cart7);

		CartVO cart8 = new CartVO();
		cart8.setMem_id("eun");
		cartList.add(cart8);

		CartVO cart9 = new CartVO();
		cart9.setMem_id("mmm");
		cartList.add(cart9);

		CartVO cart10 = new CartVO();
		cart10.setMem_id("sky");
		cartList.add(cart10);
	}

	{
		// 카트에 담긴 상품 초기화
		CartProductVO cartPro = new CartProductVO(); // 장바구니에 있는 상품들의 집합체
		// 니까 장바구니랑 연결해줘야하고 상품이랑 연결해주고 그 상품들의 수량도 지정해줘야됨.
		cartPro.setCart_id(0); // 장바구니랑 연결 - 그 장바구니를 가지고 있는 사람이랑 연결됨.
		cartPro.setPro_id(0); // 상품이랑 연결
		cartPro.setCartPro_mount(5); // 장바구니목록에서 위에서 연결해준 Pro_id의 수량
		cartProductList.add(cartPro);

		CartProductVO cartPro2 = new CartProductVO();
		cartPro2.setCart_id(1);
		cartPro2.setPro_id(1);
		cartPro2.setCartPro_mount(4);
		cartProductList.add(cartPro2);

		CartProductVO cartPro3 = new CartProductVO();
		cartPro3.setCart_id(2);
		cartPro3.setPro_id(2);
		cartPro3.setCartPro_mount(3);
		cartProductList.add(cartPro3);

		CartProductVO cartPro4 = new CartProductVO();
		cartPro4.setCart_id(3);
		cartPro4.setPro_id(3);
		cartPro4.setCartPro_mount(2);
		cartProductList.add(cartPro4);

		CartProductVO cartPro5 = new CartProductVO();
		cartPro5.setCart_id(4);
		cartPro5.setPro_id(4);
		cartPro5.setCartPro_mount(1);
		cartProductList.add(cartPro5);

		CartProductVO cartPro6 = new CartProductVO();
		cartPro6.setCart_id(5);
		cartPro6.setPro_id(5);
		cartPro6.setCartPro_mount(10);
		cartProductList.add(cartPro6);

		CartProductVO cartPro7 = new CartProductVO();
		cartPro7.setCart_id(6);
		cartPro7.setPro_id(6);
		cartPro7.setCartPro_mount(9);
		cartProductList.add(cartPro7);

		CartProductVO cartPro8 = new CartProductVO();
		cartPro8.setCart_id(7);
		cartPro8.setPro_id(7);
		cartPro8.setCartPro_mount(8);
		cartProductList.add(cartPro8);

		CartProductVO cartPro9 = new CartProductVO();
		cartPro9.setCart_id(8);
		cartPro9.setPro_id(8);
		cartPro9.setCartPro_mount(7);
		cartProductList.add(cartPro9);

		CartProductVO cartPro10 = new CartProductVO();
		cartPro10.setCart_id(9);
		cartPro10.setPro_id(9);
		cartPro10.setCartPro_mount(6);
		cartProductList.add(cartPro10);
	}

	// 게시판 초기화
	{
		NoticeboardVO board = new NoticeboardVO();
		board.setNotice_title("[공지사항]국내도서 신상 입고");
		board.setNotice_content("신상 상품이 입고되었습니다. 물품 재고를 잘 확인하여주세요.");
		board.setMem_id("genie");
		board.setNotice_date();
		noticeboardList.add(board);

		NoticeboardVO board2 = new NoticeboardVO();
		board2.setNotice_title("너무 비싸요");
		board2.setNotice_content("가격 좀 내려주세요");
		board2.setMem_id("kkk");
		board2.setNotice_date("2019-09-10");
		noticeboardList.add(board2);

		NoticeboardVO board3 = new NoticeboardVO();
		board3.setNotice_title("잘 사고 갑니다");
		board3.setNotice_content("제목이 곧 내용");
		board3.setMem_id("jjj");
		board3.setNotice_date("2019-09-11");
		noticeboardList.add(board3);

		NoticeboardVO board4 = new NoticeboardVO();
		board4.setNotice_title("배송 문의합니다");
		board4.setNotice_content("제가 주문한거 언제 오나요.");
		board4.setMem_id("bbb");
		board4.setNotice_date("2019-09-07");
		noticeboardList.add(board4);

		NoticeboardVO board5 = new NoticeboardVO();
		board5.setNotice_title("교환되나요?");
		board5.setNotice_content("불량이 왔어요 교환해주세요");
		board5.setMem_id("uuu");
		board5.setNotice_date("2019-08-02");
		noticeboardList.add(board5);

		NoticeboardVO board6 = new NoticeboardVO();
		board6.setNotice_title("재고문의합니다.");
		board6.setNotice_content("빨강머리앤 책 재고있나요?");
		board6.setMem_id("gui");
		board6.setNotice_date("2019-08-02");
		noticeboardList.add(board6);

		NoticeboardVO board7 = new NoticeboardVO();
		board7.setNotice_title("반품합니다");
		board7.setNotice_content("파손되어서 왔어요 반품합니다");
		board7.setMem_id("www");
		board7.setNotice_date("2019-08-04");
		noticeboardList.add(board7);

		NoticeboardVO board8 = new NoticeboardVO();
		board8.setNotice_title("교환요청");
		board8.setNotice_content("교환하고싶습니다.");
		board8.setMem_id("sky");
		board8.setNotice_date("2019-07-11");
		noticeboardList.add(board8);

		NoticeboardVO board9 = new NoticeboardVO();
		board9.setNotice_title("배송문의");
		board9.setNotice_content("배송 언제되나요. 넘나 느리네요.");
		board9.setMem_id("lll");
		board9.setNotice_date("2019-07-05");
		noticeboardList.add(board9);

		NoticeboardVO board10 = new NoticeboardVO();
		board10.setNotice_title("주문취소되나요?");
		board10.setNotice_content("아직 배송전이면 주문취소 해주세요");
		board10.setMem_id("eun");
		board10.setNotice_date("2019-05-02");
		noticeboardList.add(board10);
	}

	{
		// UsedBook(중고책) 초기화
		UsedBookVO usedbook1 = new UsedBookVO();
		usedbook1.setUb_name("영만샘의 혼자공부하는 자바");
		usedbook1.setUb_writer("이영만샘");
		usedbook1.setPb_id(0); // 출판사랑 연결
		usedbook1.setStatus(1); // 중고판매 상태
		usedbook1.setCart_id(1); // 장바구니랑 연결
		usedbookList.add(usedbook1);

		UsedBookVO usedbook2 = new UsedBookVO();
		usedbook2.setUb_name("HTML5+CSS3 바이블");
		usedbook2.setUb_writer("배미숙샘");
		usedbook2.setPb_id(0);
		usedbook1.setStatus(2);
		usedbook2.setCart_id(1);
		usedbookList.add(usedbook2);

		UsedBookVO usedbook3 = new UsedBookVO();
		usedbook3.setUb_name("Life of pi");
		usedbook3.setUb_writer("얀 마텔");
		usedbook3.setPb_id(0);
		usedbook1.setStatus(4);
		usedbook3.setCart_id(1);
		usedbookList.add(usedbook3);

		UsedBookVO usedbook4 = new UsedBookVO();
		usedbook4.setUb_name("개떡같이 말하면 개떡같이 알아듣습니다");
		usedbook4.setUb_writer("김윤정");
		usedbook4.setPb_id(0);
		usedbook1.setStatus(1);
		usedbook4.setCart_id(4);
		usedbookList.add(usedbook4);

		UsedBookVO usedbook5 = new UsedBookVO();
		usedbook5.setUb_name("DEMIAN");
		usedbook5.setUb_writer("헤르만헤세");
		usedbook5.setPb_id(1);
		usedbook1.setStatus(3);
		usedbook5.setCart_id(8);
		usedbookList.add(usedbook5);

		UsedBookVO usedbook6 = new UsedBookVO();
		usedbook6.setUb_name("거절 잘해도 좋은 사람입니다");
		usedbook6.setUb_writer("양지아링");
		usedbook6.setPb_id(0);
		usedbook1.setStatus(2);
		usedbook6.setCart_id(6);
		usedbookList.add(usedbook6);

		UsedBookVO usedbook7 = new UsedBookVO();
		usedbook7.setUb_name("HTML5+CSS3 바이블");
		usedbook7.setUb_writer("배미숙샘");
		usedbook7.setPb_id(0);
		usedbook1.setStatus(2);
		usedbook7.setCart_id(2);
		usedbookList.add(usedbook7);

		UsedBookVO usedbook8 = new UsedBookVO();
		usedbook8.setUb_name("영만샘의 혼자공부하는 자바");
		usedbook8.setUb_writer("이영만샘");
		usedbook8.setPb_id(0);
		usedbook8.setCart_id(5);
		usedbookList.add(usedbook8);

		UsedBookVO usedbook9 = new UsedBookVO();
		usedbook9.setUb_name("관계도 반품이 됩니다");
		usedbook9.setUb_writer("박민근");
		usedbook9.setPb_id(0);
		usedbook1.setStatus(4);
		usedbook9.setCart_id(3);
		usedbookList.add(usedbook9);

		UsedBookVO usedbook10 = new UsedBookVO();
		usedbook10.setUb_name("거절 잘해도 좋은 사람입니다");
		usedbook10.setUb_writer("양지아링");
		usedbook10.setPb_id(0);
		usedbook1.setStatus(2);
		usedbook10.setCart_id(6);
		usedbookList.add(usedbook10);

	}

	/**
	 * 회원가입 - 아이디 중복검사 해주는 메서드
	 * 
	 * @param String 
	 *        아이디 중복검사할 회원의 아이디 
	 * @return boolean 중복검사 성공여부
	 * @author 현주
	 */
	public boolean dupleId(String mem_id) {
		boolean result = false;
		for (MemberVO member : memberList) {
			if (member.getMem_id().equals(mem_id)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 멤버를 추가하는 메서드(회원가입)
	 * @param MemberVO
	 * 		  추가할 멤버객체  
	 * @return boolean
	 *         추가 성공여부
	 * @author 현주
	 */
	public boolean addMv(MemberVO mv) {
		boolean result = false;
		try {
			memberList.add(mv);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	/**
	 * 로그인 메서드
	 * 
	 * @param Map <String, String> params
	 * 			   로그인에 입력한 회원의 아이디, 비밀번호
	 * @return MemberVO
	 * 		   db에 저장된 멤버객체 중 있으면 그 멤버객체를 돌려줌
	 * @author 현주 
	 */
	public MemberVO logIn(Map<String, String> params) {
		String mem_id = params.get("mem_id");
		String mem_pw = params.get("mem_pw");
		MemberVO logInMember = null;

		for (MemberVO member : memberList) {
			if (member.getMem_id().equals(mem_id)
					&& member.getMem_pw().equals(mem_pw)) {
				logInMember = member;
				break;
			}
		}
		return logInMember;
	}

	// 회원: 카테고리
	/**
	 * 전체 카테고리목록 조회
	 * @return List<CategoryVO>
	 *          전체 카테고리 목록을 보여줌
	 * @author 제윤
	 */
	public List<CategoryVO> showCv() {
		List<CategoryVO> categoryList2 = new ArrayList<CategoryVO>();
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).isActived()) {
				categoryList2.add(categoryList.get(i));
			}
		}
		return categoryList2;
	}


	/**
	 * 카테고리별 상품 조회 메서드
	 * 
	 * @param int
	 *        cate_id 카테고리 아이디
	 * 
	 * @return List<ProductVO> 카테고리별 상품 리스트
	 * @author 제윤
	 */
	public List<ProductVO> showProductByCategory(int cate_id) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		for (ProductVO dbProduct : productList) {
			if (dbProduct.isActived() && dbProduct.getCate_id() == cate_id) {
				list.add(dbProduct);
			}
		}
		return list;
	}
	
	/**
	 * 카테고리 검색 메서드
	 * @author 
	 * @param int
	 *         cate_id
	 * @return CategoryVO
	 *         해당 카테고리 id와 카테고리 리스트의 id가 동일시 해당 객체 반환
	 * @author 제윤
	 */
	public CategoryVO searchCv(int cate_id) {
		CategoryVO cvo = null;
		for (CategoryVO cvo2 : categoryList) {
			if (cvo2.isActived() && cvo2.getCate_id() == cate_id) {
				cvo = cvo2;
			}
		}
		return cvo;
	}


	// 회원: 장바구니
	
	/**
	 * 신규 회원 장바구니 추가 메서드
	 * @since 2019-09-24
	 * @param CartVO 
	 *        cart값을 입력받은 객체
	 * @return boolean
	 *         성공/실패 여부 리턴
	 * @author 제윤
	 */
	public boolean addCartv(CartVO cart) {
		boolean result = false;
		if (cart != null) {
			result = cartList.add(cart);
		}
		return result;
	}
	/**
	 * 멤버별 전체 장바구니 조회 메서드
	 * @param mem_id
	 *        멤버의 ID
	 * @return 멤버의 장바구니 리스트
	 * @author 제윤
	 */
	public List<CartVO> showCartv(String mem_id) { 
		List<CartVO> cList = new ArrayList<CartVO>();
		for (CartVO cart : cartList) { 
			if (cart.getMem_id().equals(mem_id)&&!cart.isPayed()) { 
				cList.add(cart); 
			} 
		} return cList; 
	}
	
	
	/**
	 * 장바구니 멤버별 cart_id 조회 메서드
	 * @param mem_id
	 *        멤버의 ID
	 * @return int
	 *         cart_id
	 * @author 제윤
	 */
	// private boolean isPayed = false;	// 물품에 대한 구매 여부 
	public int searchCartId(String mem_id) { 
		List<CartVO> cList = new ArrayList<CartVO>();
		int cart_id=0;
		for (CartVO cart : cartList) { 
			if (cart.getMem_id().equals(mem_id)&&!cart.isPayed()) { 
				cList.add(cart); 
				cart_id = cart.getCart_id();
				break;
			}else {
				cart_id = -1;
			}
		} return cart_id; 
	}
	
	
/*	public int serachCartId(String mem_id) { 
		List<CartVO> cList = new ArrayList<CartVO>();
		int cart_id = 0;
		for (CartVO cart : cartList) { 
			if (cart.getMem_id().equals(mem_id)&&!cart.isPayed()) { 
				cList.add(cart); 
				cart_id = cart.getCart_id();
			}
		} return cart_id; 
	}*/

	/**
	 * 장바구니를 검색하는 메서드
	 * 
	 * @param cart_id
	 *        장바구니의 ID
	 * @return CartVO
	 *         장바구니 객체
	 */
	public CartVO searchCartv(int cart_id) {
		CartVO cart = null;
		for (CartVO dbCart : cartList) {
			if (dbCart.getCart_id() == cart_id) {
				cart = dbCart;
			}
		}
		return cart;
	}
	
	/**
	 * 장바구니에 상품 추가 메서드
	 * 
	 * @param Map <String, Object> params 
	 *             상품 객체, 구입할 상품의 수량
	 *            (pv, pro_mount, 장바구니 id)
	 * @return boolean 성공 여부
	 * @author 제윤
	 */
	public boolean addCartProduct(Map<String, Object> params, int cart_id) {	
		ProductVO pv = (ProductVO) params.get("pv");   // 사용자로부터 입력받은 상품 객체
		int pro_mount = (int) params.get("pro_mount"); // 사용자로부터 입력받은 상품 수량
		CartProductVO cartProduct;						// 장바구니에 담을 장바구니상품 객체
	
		for (CartProductVO dbCartPro : cartProductList) { // db에 저장된 장바구니상품객체에 꺼내서
			if (dbCartPro.getPro_id() == pv.getPro_id() && dbCartPro.getCart_id() == cart_id) { 
				dbCartPro.setCartPro_mount(dbCartPro.getCartPro_mount()+ pro_mount);
				pv.setPro_mount(pv.getPro_mount() - pro_mount);
				return true;
			}
		}
		//System.out.println("=======일단 여기 없군========");
		// 회원의 아이디로 카트번호를 찾아 그곳에 연결해준다.
		try {
			cartProduct = new CartProductVO();
			cartProduct.setCart_id(cart_id);
			cartProduct.setPro_id(pv.getPro_id());
			cartProduct.setCartPro_mount(pro_mount);
			CartProductMount(pv, pro_mount);
			cartProductList.add(cartProduct);
		} catch (Exception e) {
			return false;
		}
		return true;
		
		
	}		
		

	
	/**
	 * 장바구니 상품 객체에 수량 감소
	 * 
	 * @param ProductVO pv, int pro_mount 
	 *        사용자가 선택한 상품, 사용자가 선택한 수량
	 * @return boolean
	 *         수량 감소 성공여부
	 * @author 제윤
	 */

	public boolean CartProductMount(ProductVO pv, int pro_mount){
		for (CartProductVO dbCartPro : cartProductList) { // db에 저장된 장바구니상품객체에 꺼내서
		// db에 저장된 상품 id와 사용자가 선택한 상품이 같을 경우  
			if (dbCartPro.getPro_id() == pv.getPro_id()) { 
				// db의 카트상품의 수량을 db에 저장된 수량과 사용자가 선택한 수량을 더해준다.
				dbCartPro.setCartPro_mount(dbCartPro.getCartPro_mount()+ pro_mount);
				// 상품객체가 가지고 있는 전체 수량에서 사용자가 선택한 수량을 빼준다.
				pv.setPro_mount(pv.getPro_mount() - pro_mount);
				return true;
			} 	
		}
		return false;
	}
	
	
	
	/**
	 * 장바구니 상품 객체가 cart_id랑 같은게 있는지 확인 메서드
	 * 
	 * @param int 
	 *        cart_id 장바구니의 아이디
	 * @return CartProductVO
	 *         
	 * @author 제윤
	 */
	
	
	public CartProductVO searchMemberCartProduct(int cart_id) {	
		CartProductVO cartProduct = null;
		for(CartProductVO dbCartPro : cartProductList) {
			if(dbCartPro.getCart_id() == cart_id) {
				cartProduct = dbCartPro;
			}
		}
		return cartProduct;
	}
	
	
	/**
	 * 장바구니 상품 조회
	 * 
	 * @param int 
	 *        cart_id 장바구니의 아이디
	 * @return List<CartProductVO> 
	 *         CartProductVO에서 cart_id를 가진 상품들을 조회하여 리턴
	 * @author 제윤
	 */
	
	// CartVO         => private boolean isPayed = false;	// 물품에 대한 구매 여부 
	// CartProductVO  => private boolean isActived = true;	// true : 장바구니 구매  false: 구매내역 
	public List<CartProductVO> showCartPv(int cart_id) {
		
		List<CartProductVO> cList = new ArrayList<CartProductVO>();
		for (CartProductVO cartPro : cartProductList) {
			if (cartPro.isActived() && cart_id == cartPro.getCart_id()) {
				cList.add(cartPro);
			}
		}
		return cList;
	}
	
	/**
	 * 장바구니 상품 주문 완료에 따라 CartProduct의 isActived를 false로 변경
	 * 
	 * @param int 
	 *        cart_id 장바구니의 아이디
	 * @return List<CartProductVO> 
	 *         CartProductVO에서 cart_id를 가진 상품들을 조회하여 리턴
	 * @author 제윤
	 */
/*	
	public List<CartProductVO> searchCartProduct(int cart_id) {
		List<CartProductVO> cList = new ArrayList<CartProductVO>();
		for (CartProductVO cartPro : cartProductList) {
			if (cartPro.getCart_id() == cart_id) {
				System.out.println(" db searchCartProduct() 호출");
				cList.add(cartPro);
				
			}
		}
		return cList;
	}
*/	
	
	/**
	 * 장바구니 물품들의 재고를 확인 메서드
	 * 
	 * @param int
	 *         cart_id
	 * @return boolean
	 *         재고가 있으면 true 없으면 false
	 */
	public boolean checkStock(int cart_id) {
		CartVO cart = searchCartv(cart_id);
		List<CartProductVO> dbCartProList = showCartPv(cart_id);
		ProductVO pro;
		boolean result = true;
		for (CartProductVO dbCartPro : dbCartProList) {
			pro = searchPv(dbCartPro.getPro_id());
			if (dbCartPro.getCartPro_mount() > pro.getPro_mount()) {
				result = false;
				break;
			}
		}
		return true;
	}
	
	/**
	 * 장바구니의 총합계 조회
	 * 
	 * @param int
	 *        cart_id 장바구니의 id
	 * @return int
	 *         장바구니의 총합계
	 * @author 제윤
	 */
	public int getCartPrice(int cart_id) {
		int price = 0;
		List<CartProductVO> cList = new ArrayList<CartProductVO>();
		for (CartProductVO cartPro : cartProductList) {
			if (cartPro.isActived() && cart_id == cartPro.getCart_id()) {
				price += searchPv(cartPro.getPro_id()).getPro_price()
						* cartPro.getCartPro_mount();
			}
		}

		return price;
	}

	
	// ** 관리자 모드
	// 관리자: 상품관리
	// 관리자: 상품관리
		/**
		 * 상품을 검색하는 메서드
		 * 
		 * @param int 
		 *        pro_id 상품의 ID
		 * @return ProductVO 
		 *         검색해서 찾은 상품 객체
		 * @author 현주 
		 */
		public ProductVO searchPv(int pro_id) {
			ProductVO product = null;
			for (ProductVO dbProduct : productList) {
				if (dbProduct.isActived() && dbProduct.getPro_id() == pro_id) {
					product = dbProduct;
				}
			}
			return product;
		}
		
		/**
		 * 상품 재고 조회
		 * 
		 * @author 
		 * @param pb_id 업체를 삭제하기 위하여 업체 id를 이용
		 * @return List<ProductVO>  list
		 */
		public List<ProductVO> showPv() {
			List<ProductVO> list = new ArrayList<ProductVO>();
			PublisherVO pb;
			CategoryVO cate;
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).isActived() && searchPb(productList.get(i).getPb_id()) != null
						&& searchCv(productList.get(i).getCate_id()) != null) {

					list.add(productList.get(i));
				}	
			}
			return list;
		}
		
		/**
		 * 상품 추가
		 * @param param
		 *        int pb_id, String pro_name, int pro_mount, int pro_price, String pro_writer, boolean value; String Cate_name, int Pb_id
		 * @return boolean
		 * 		   Map<String, Object>
		 * @author 현주
		 */
		public boolean addPv(Map<String, Object> param) {
			String name = (String) param.get("pro_name");
			boolean result = false;  // 리턴값이 boolean형이라 param.get()으로 작성하면 터짐. 그래서 return 받아주기 위해서 result추가하고 result를 리턴해줌
			if(name.equals(" ")){
				return result;
			}
			
			ProductVO pp = new ProductVO();
			pp.setPro_name((String)param.get("pro_name"));
			pp.setPro_mount((int) param.get("pro_mount"));
			pp.setPro_price((int) param.get("pro_price"));
			pp.setPro_writer((String) param.get("pro_writer"));
			pp.setPb_id((int) param.get("pb_id"));
			
			if ( productList.add(pp) ) {
				result = true;
			} 
			
//			for (int i = 0; i < productList.size(); i++) {
//				if (name.equals(productList.get(i).getPro_name())) {
//					productList.add(pp);
//				}
//			}
			return result;
		}

		/**
		 * 상품 삭제
		 * @param pro_id
		 * @return boolean
		 * 		   isActived ( true , false )
		 * @author 현주
		 */
		public boolean deletePv(int pro_id) {
			ProductVO pro = null;
			for (ProductVO pro2 : productList) {
				if (pro2.isActived() && pro2.getPro_id() == pro_id) {
					pro = pro2;
				}
			}
			pro.setIsActived(false);
			return true;
		}

		/**
		 * 상품 변경
		 * @param udp
		 * 		  pro_id, pro_name, pro_price, pro_mount
		 * @return boolean 
		 * @author 현주
		 */
		public boolean updateProduct(Map<String, Object> udp) {
			int pro_id = (int) udp.get("pro_id");
			String pro_name = (String) udp.get("pro_name");
			int pro_price = (int) udp.get("pro_price");
			int pro_mount = (int) udp.get("pro_mount");
			
			ProductVO pro = searchPv(pro_id);
			boolean result = false;

			if (pro != null) {
//				pro.setPro_id(pro_id); //sq 써서 얘 필요없음.
				pro.setPro_name(pro_name);
				pro.setPro_price(pro_price);
				pro.setPro_mount(pro_mount);
				result = true;
			}
			return result;
		}
	
	
	/**
	 * 주문 내역 추가
	 * 
	 * @param cart_id
	 *        주문하는 장바구니의 id
	 * @return boolean
	 *         추가 성공 여부
	 */
	/*public boolean addOrder(int cart_id) {
		int cart_price = getCartPrice(cart_id);
		OrderViewVO order = new OrderViewVO();
		CartVO cart = searchCartv(cart_id);

		order.setCart_price(cart_price);
		order.setCart_id(cart_id);
		order.setMem_id(cart.getMem_id());
		System.out.println("addOrder() 메서드 실행");
		System.out.println("order.getCart_id()= " + order.getCart_id());
		System.out.println("order.getCart_price()= " + order.getCart_price());
		System.out.println("order.getMem_id()= " + order.getMem_id());

		orderList.add(order);

		return true;
	}*/
	
	
	public boolean addOrder(int cart_id) {
		int cart_price = 0;
		OrderViewVO order = new OrderViewVO();
		CartVO cart = searchCartv(cart_id);
		for(CartProductVO dbCartProduct : cartProductList) {
			if(dbCartProduct.getCart_id() == cart_id) {
				order.setCart_price(cart_price);
				order.setCart_id(cart_id);
				
				order.setMem_id(cart.getMem_id());

			}
			
			
		}
		
		
		//CartVO cart = searchCartv(cart_id);

		order.setCart_price(cart_price);
		order.setCart_id(cart_id);
		order.setMem_id(cart.getMem_id());

		orderList.add(order);

		return true;
	}
	/**
	 * 캐시 충전
	 * 
	 * @param CashVO
	 *        cash 사용자가 충전한 캐시객체
	 * @return boolean
	 *         캐시 충전 성공 여부
	 * @author 은선
	 */
	
	public boolean addCash(CashVO cash) {
		cashList.add(cash);
	    return true;
	}
	
	/**
	 * 캐시 충전 내역 
	 * 
	 * @param String
	 *        mem_id 회원의 아이디
	 * @return List<CashVO>
	 *         캐시 충전 사용 내역 List로 반환
	 * @author 은선
	 */
	public List<CashVO> showCashList(String mem_id) {
		List<CashVO> cashviewList = new ArrayList<CashVO>();
		for (int i = 0; i < cashList.size(); i++) {
			if (cashList.get(i).isActived()
					&& cashList.get(i).getMem_id().equals(mem_id)) {
				cashviewList.add(cashList.get(i));
			}
		}
		return cashviewList;
	}
	
	
	// 관리자 : 업체관리
	/**
	 * 전체 업체 목록 조회
	 * 
	 * @return List<PublisherVO> 
     *          publisherList에 저장된 업체 목록을 모두 보여줌
	 * @author 현주
            
	 */
	public List<PublisherVO> getPbList() {
		List<PublisherVO> list = new ArrayList<PublisherVO>();
		for (PublisherVO pb : publisherList) {
			if (pb.isActived()) {
				list.add(pb);
			}
		}
		return list;
	}
	
	/**
	 * @author
	 * @param Map<String, String> pb_name
	 *        추가한 업체 이름
	 * @return boolean
	 *         이름이 중복되거나 빈칸 입력시 성공/실패 여부
	 * @author 현주 
	 */
	public boolean addPb(Map<String, String> pb) {
		String name = pb.get("pb_name");
		for (int i = 0; i < publisherList.size(); i++) {
			if (name.equals(publisherList.get(i).getPb_name())
					|| name.equals(" ")) {
				return false;
			}
		}
		PublisherVO pb2 = new PublisherVO();
		pb2.setPb_name(pb.get("pb_name"));
		
		publisherList.add(pb2);
		return true;
	}

	/**
	 * 업체선택 메서드
	 * 
	 * @return List<PublisherVO>
	 *         publisherListd에서 업체를 찾아 그 업체를 돌려줌
	 * @author 현주 
	 */
	public List<PublisherVO> getPbbList() {
		List<PublisherVO> list = new ArrayList<PublisherVO>();
		for (PublisherVO pb : publisherList) {
			if (pb.isActived()) {
				list.add(pb);
			}
		}
		return list;
	}


	/**
	 * 업체 삭제 메서드
	 * 
	 * @param int
	 *        pb_id 업체를 삭제하기 위하여 업체 id를 이용
	 * @return boolean
	 *         삭제를 위해 isActive true/false 반환
	 * @author 현주
	 */
	public boolean deletePb(int pb_id) {
		PublisherVO pb = null;
		for (PublisherVO pb2 : publisherList) {
			if (pb2.isActived() && pb2.getPb_id() == pb_id) {
				pb = pb2;
			}
		}
		pb.setIsActived(false);
		return true;
	}

	/**
	 * 업체 검색 메서드
	 * 
	 * @param int 
	 *        pb_id 출판사의 정보를 조회하기 위한 출판사 id이용
	 * @return PublisherVO 
	 *         출판사 id를 비교하여 같으면 해당 출판사의 정보(이름, 소개)를 반환
	 * @author 현주
	 */
	public PublisherVO searchPb(int pb_id) {
		PublisherVO pb = null;
		for (PublisherVO pb2 : publisherList) {
			if (pb2.isActived() && pb2.getPb_id() == pb_id) {
				pb = pb2;
			}
		}
		return pb;
	}
	// 관리자 : 회원관리
		/**
		 * 전체 회원 조회
		 * 
		 * @return
		 */
	public List<MemberVO> showMv() {
		List<MemberVO> mList = new ArrayList<MemberVO>();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).isActived()) {
				mList.add(memberList.get(i));
			}
		}
		return mList;
	}

	/**
	 * 회원 정보 수정
	 * 
	 * @param params Map<String, String>
	 * mem_id, mem_name, mem_password, mem_birth, mem_phone
	 * 입력한 회원 정보
	 * @return boolean
	 *         수정 성공 여부/ 수정된 회원 정보
	 * @author 은선
	 */
	public boolean updateMv(Map<String, String> params) {
		String mem_id = params.get("mem_id");
		List<MemberVO> mList = new ArrayList<MemberVO>();
		for (int i = 0; i < memberList.size(); i++) {
			if (mem_id.equals(memberList.get(i).getMem_id())) {
				memberList.get(i).setMem_name(params.get("mem_name"));
				memberList.get(i).setMem_pw(params.get("mem_pw"));
				memberList.get(i).setMem_bir(params.get("mem_birth"));
				memberList.get(i).setMem_phone(params.get("mem_phone"));
				return true;
			}
		}
		return false;
	}

	/**
	 * 회원 정보 삭제 
	 * 
	 * @param mem_id
	 *        삭제할 회원 id
	 * @return boolean
	 *         isActived = false로 변경 (활성화 false)
	 * @author 은선
	 */
	public boolean deleteMv(String mem_id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMem_id().equals(mem_id)
					&& memberList.get(i).isActived()) {
				memberList.get(i).setActived(false); // 활성화false
				return true;
			}
		}
		return false;
	}

	// 공통
	// 게시판
	/**
	 * 전체 게시글 조회
	 * @return List<NoticeboardVO>
	 *         db의 noticeboardList에 저장된 값을 List로 받아 반환
	 * @author 현주, 은선
	 */
	public List<NoticeboardVO> showNv() {
		List<NoticeboardVO> noticeList = new ArrayList<NoticeboardVO>();
		for (int i = 0; i < noticeboardList.size(); i++) {
			if (noticeboardList.get(i).isActived()) {
				noticeList.add(noticeboardList.get(i));
			}
		}
		return noticeList;
	}

	/**
	 * 공통 - 게시글 작성 메서드
	 * @param NoticeboardVO
	 *        사용자가 작성한 NoticeboardVO객체
	 * @return boolean
	 * @author 현주, 은선
	 * 
	 */
	public boolean addNv(NoticeboardVO nv) {
		if (!nv.equals("")) {
			noticeboardList.add(nv);
			return true;
		}
		return false;
	}

	/**
	 * 게시글 상세 검색
	 * 
	 * @param int 게시글 번호
	 * @return NoticeboardVO 게시글 객체
	 * @author 현주, 은선
	 */
	public NoticeboardVO searchNv(int notice_id) {
		for (int i = 0; i < noticeboardList.size(); i++) {
			if (notice_id == noticeboardList.get(i).getNotice_id()
					&& noticeboardList.get(i).isActived()) {
				return noticeboardList.get(i);
			}
		}
		return null;
	}


	/**
	 * 게시글 작성자 검색
	 * 
	 * @param String 
	 *        회원의 id(게시글 작성자)
	 * @return MemberVO 
	 *         게시글 작성자 객체
	 * @author 현주, 은선
	 */
	public MemberVO searchMv(String mem_id) {
		MemberVO mv = null;
		for (MemberVO member : memberList) {
			if (member.isActived() && member.getMem_id().equals(mem_id)) {
				mv = member;
			}
		}
		return mv;
	}

	/**
	 * 게시글 수정 및 삭제 권한 체크
	 * 
	 * @param Map<String, Object> 
	 *        notice_id, mem_autho, current_id
	 * @return boolean
	 *         관리자계정/자신의게시글의 권한: true
	 * @author 현주, 은선
	 */
	public boolean checkNoticeAutho(Map<String, Object> params) {
		MemberVO current_id = (MemberVO) params.get("current_id");
		MemberVO mem_id = (MemberVO) params.get("mem_autho");
		NoticeboardVO notice_id = (NoticeboardVO) params.get("notice_id");
			if (current_id.getMem_id().equals(notice_id.getMem_id())
					|| mem_id.getMem_autho()) {
				return true;
			}
		return false;
	}

	/**
	 * 게시글 수정
	 * 
	 * @param NoticeboardVO 
	 *        수정할 게시판객체
	 * @return boolean
	 *         수정 성공여부
	 * @author 현주, 은선
	 */
	public boolean updateNv(NoticeboardVO nv) {
		for (int i = 0; i < noticeboardList.size(); i++) {
			if (nv.getNotice_id() == noticeboardList.get(i).getNotice_id()) {
				noticeboardList.get(i).setNotice_content(nv.getNotice_content());
				noticeboardList.get(i).setNotice_title(nv.getNotice_title());
				return true;
			}
		}
		return false;
	}

	/**
	 * 게시글 삭제
	 * 
	 * @author
	 * @param int
	 * @return boolean
	 * @author 현주, 은선
	 */
	public boolean deleteNv(int notice_id) {
		for (int i = 0; i < noticeboardList.size(); i++) {
			if (noticeboardList.get(i).isActived()
					&& noticeboardList.get(i).getNotice_id() == notice_id) {
				noticeboardList.get(i).setActived(false);
				return true;
			}
		}
		return false;
	}


	/**
	 * 회원모드 - 전체주문내역
	 * 
	 * 
	 * @param String
	 *        mem_id 회원의 아이디를 입력받는다.
	 * @return List<OrderViewVO>
	 *         
	 */
	public List<OrderViewVO> showOrderList(String mem_id) {
		List<OrderViewVO> orderviewList = new ArrayList<OrderViewVO>();

		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).isActived()
					&& orderList.get(i).getMem_id().equals(mem_id)) {
				orderviewList.add(orderList.get(i));
			}
		}
		return orderviewList;
	}

}