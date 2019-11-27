package package_Main;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import package_VO.*;

public class View {
	private Scanner in0 = new Scanner(System.in);
	private int input0; // 명령어를 받을 임시 변수
	private MemberVO currentMember = null; // 로그인한 멤버객체 session
	Service service = new ImService();

	/**
	 * 배너를 보여주는 메서드
	 * 
	 * @param str
	 */
	private void showBanner(String str) {
		System.out.println();
		System.out
				.println("────────────────── genie에 오신걸 환영합니다. ───────────────────");
		System.out.println("\t\t\t" + str);
		System.out
				.println("───────────────────────────────────────────────────────");
		System.out.println();
	}

	/**
	 * 첫 메인화면 메서드
	 * 
	 * @param str
	 */
	public void mainView() {
		while (true) {
			showBanner("메인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			System.out.print("무엇을 도와드릴까요? ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			switch (input) {
			case 1:
				com_signUp();
				break;
			case 2:
				com_logIn();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
	}

	/**
	 * 회원가입 메서드
	 * 
	 * @author
	 */

	// 회원가입
	private void com_signUp() {
		showBanner("****** 회원가입 ******");
		MemberVO mv = new MemberVO();

		String mem_id;
		String mem_pw;
		String mem_name;
		String mem_bir;
		String mem_phone;
		String mem_add;

		mem_id = inputId();
		mem_pw = inputPw();
		mem_name = inputName();
		mem_bir = inputBir();
		mem_phone = inputPhone();
		mem_add = inputAdd();

		mv.setMem_id(mem_id);
		mv.setMem_pw(mem_pw);
		mv.setMem_name(mem_name);
		mv.setMem_bir(mem_bir);
		mv.setMem_phone(mem_phone);
		mv.setMem_add(mem_add);

		// 새로 가입하는 회원에 대한 카트 자동 생성 (19-09-24)
		CartVO cart = new CartVO();
		cart.setMem_id(mv.getMem_id());

		// 가입한 회원의 멤버객체 및 카트를 db의 각 List에 추가 (19-09-24)
		if (service.addMv(mv) && service.addCartv(cart)) {
			System.out.println("genie 회원가입 완료!");
		} else {
			System.out.println("genie 회원가입 실패!");
		}
	}

	/**
	 * 회원의 id를 입력받는 메서드 (정규식 검사, 중복검사) //id는 중복되면 안되기때문에 중복검사도 돌려준다
	 * 
	 * @return
	 */
	private String inputId() { // id입력받는 메서드
		String mem_id = "";
		while (true) {
			System.out.print("ID : "); // 콘솔창에서 id입력.
			Scanner in = new Scanner(System.in);
			mem_id = in.nextLine(); // id를 스트링으로 입력받는다.
			if (RegEx.checkMemId(mem_id)) { // 입력받은 id를 정규식 돌려서 검사해줌.

				// 중복검사
				if (service.dupleId(mem_id)) { // 2차 완료 후 추후에 하는거임.
					System.out.println("이미 사용중인 ID입니다.");
					continue;
				}

				break; // 정규식검사까지 완료되면 while문 빠져나감.
			} else { // 정규식 검사에서 실패시에 다시 어떻게 입력하라고 출력해줌.
				System.out.println("아이디는 3글자 이상이여야 합니다!");
			}
		}
		return mem_id; // 정규식 검사가 완료되서 while문을 빠져나온 mem_id를 드디어 반환해줌.
	}

	/**
	 * 회원의 pw를 입력받는 메서드 (정규식 검사만)
	 * 
	 * @return
	 */
	private String inputPw() {
		String mem_pw = "";
		while (true) {
			System.out.print("PASSWORD : ");
			Scanner in = new Scanner(System.in);
			mem_pw = in.nextLine();
			if (RegEx.checkMemPw(mem_pw)) {
				break;
			} else {
				System.out.println("패스워드는 4글자 이상이고 공백이 없어야 합니다!");
			}
		}
		return mem_pw;
	}

	/**
	 * 회원의 name(이름)을 입력받는 메서드 (정규식 검사만)
	 * 
	 * @return
	 */
	private String inputName() {
		String mem_name = "";
		while (true) {
			System.out.print("이름 : ");
			Scanner in = new Scanner(System.in);
			mem_name = in.nextLine();
			if (RegEx.checkMemName(mem_name)) {
				break;
			} else {
				System.out.println("이름은 한글로 2~4문자여야 합니다!");
			}
		}
		return mem_name;
	}

	/**
	 * 회원의 bir(생년월일)을 입력받는 메서드 ( 정규식검사만 )
	 * 
	 * @return
	 */
	private String inputBir() {
		String mem_bir = "";
		while (true) {
			System.out.print("생년월일(YYYY-MM-DD) : ");
			Scanner in = new Scanner(System.in);
			mem_bir = in.nextLine();
			if (RegEx.checkMemBirth(mem_bir)) {
				break;
			} else {
				System.out.println("생년월일을 똑바로 입력해주세요!");
			}
		}
		return mem_bir;
	}

	/**
	 * 회원의 phone(핸드폰번호)를 입력받는 메서드 ( 정규식 검사만 )
	 * 
	 * @return
	 */
	private String inputPhone() {
		String mem_phone = "";
		while (true) {
			System.out.print("핸드폰번호(010-1234-5678) : ");
			Scanner in = new Scanner(System.in);
			mem_phone = in.nextLine();
			if (RegEx.checkMemPhone(mem_phone)) {
				break;
			} else {
				System.out.println("핸드폰번호를 똑바로 입력해주세요.");
			}
		}
		return mem_phone;
	}

	/**
	 * 회원의 add(주소)를 입력받는 메서드 (정규식 검사 안함)
	 * 
	 * @return
	 */
	private String inputAdd() {
		String mem_add = "";
		while (true) {
			System.out.print("주소 : ");
			Scanner in = new Scanner(System.in);
			mem_add = in.nextLine();
			if (mem_add.length() == 0 || mem_add == null) {
				System.out.println("주소를 올바르게 입력해주세요");
			} else {
				break;
			}
		}
		return mem_add;
	}

	/**
	 * 숫자를 입력받는 메서드 예외처리를 받으면 다시 입력받는다
	 * 
	 * @author
	 * @return
	 */
	private int inputInt() {
		Scanner in = new Scanner(System.in);
		int inputInt;
		while (true) {
			try {
				System.out.print("입력 : ");
				inputInt = in.nextInt();
				in.nextLine();
				if (inputInt < 0) {
					System.out.println("0 이상을 입력해주세요");
					continue;
				}
				return inputInt;
			} catch (InputMismatchException e) {
				inputInt = -1;
				in.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				in = new Scanner(System.in);
				continue;
			}
		}
		return inputInt;
	}

	/**
	 * 로그인 메서드
	 * 
	 * @author
	 */
	// 로그인
	private void com_logIn() {
		Scanner in = new Scanner(System.in);
		String mem_id = "";
		String mem_pw = "";
		Map<String, String> params = new HashMap<String, String>();

		while (true) {
			showBanner("****** 로그인 ******");
			System.out.print("ID : ");
			mem_id = in.nextLine();
			System.out.print("PASSWORD : ");
			mem_pw = in.nextLine();
			params.put("mem_id", mem_id);
			params.put("mem_pw", mem_pw);

			currentMember = service.logIn(params);

			if (currentMember == null) {
				System.out.println("잘못된 ID와 PW입니다.");
				continue;
			}

			if (currentMember.getMem_autho()) {
				adminService();
			} else {
				mem_memberService();
			}
		}
	}

	/**
	 * 회원모드 메서드
	 * 
	 * @author
	 */
	//
	private void mem_memberService() {
		while (true) {
			showBanner("회원 로그인");
			System.out.println("1. 카테고리");
			System.out.println("2. 중고도서");
			System.out.println("3. 장바구니");
			System.out.println("4. 마이페이지");
			System.out.println("5. 게시판");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 : ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();

			switch (input) {
			case 1:
				mem_showCategory();
				break;
			case 2:
			mem_UsedBook();
				break;
			case 3:
				mem_Cart();
				break;
			case 4:
				mem_MyPage();
				break;
			case 5:
				com_managementNotice();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	/**
	 * 회원모드 : 카테고리
	 */
	private void mem_showCategory() {
		CategoryVO category = null;
		while (true) {
			showBanner("카테고리 선택");
			category = selectCategory();
			if (category == null) {
				return;
			}
			mem_productByCategory(category);
		}
	}

	/**
	 * 카테고리 선택 메서드
	 * 
	 * @return 카테고리 객체
	 */
	CategoryVO selectCategory() {
		List<CategoryVO> list = null;
		list = service.showCv(); // 전체 카테고리 목록을 보여줌

		// cate_sq를 -1로 주는 이유는 사용자로부터 입력값이 0 이상이기 때문이다.
		int cate_sq = -1;

		System.out
				.println("=======================================================");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isActived() == true) {// 카테고리 i번째의 삭제여부가 true이면
				System.out.println("No." + (i + 1) + "\t\t"
						+ list.get(i).getCate_name()); // 카테고리를 출력
			}
			if (i < list.size() - 1) {
				System.out.println("-------------------------------------------------------");
			}
		}
		System.out.println("=======================================================");

		while (true) {
			System.out.print("뒤로나가기(Q/q)");
			System.out.print("\nNo. ");
			cate_sq = inputInt(); // 카테고리 No. 입력
			if ((cate_sq) == 0) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
				continue;
			}

			if ((cate_sq) == -1) { // cate_sq가 -1이라는 것은 사용자가 입력하지 않았다는 것
				return null;
			}
			if ((cate_sq - 1) < list.size()) {
				break;
			} else {// cate_sq를 벗어난 값을 입력
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				continue;
			}

		}
		return list.get((cate_sq - 1));
	}

	/**
	 * 카테고리별 상품 조회 및 선택
	 * 
	 * @param input
	 */
	private void mem_productByCategory(CategoryVO category) {
		int pro_sq; // 상품 시퀀스
		int pro_mount; // 상품 수량
		List<ProductVO> proList = service.showProductByCategory(category
				.getCate_id()); // 카테고리별 상품 조회
		ProductVO pv; // 사용자가 선택한 상품을 담을 객체

		showBanner("상품 조회 : " + category.getCate_name()); // 카테고리 이름을 가져온다.

		System.out
				.println("=======================================================");
		if (proList.isEmpty()) {
			System.out.println("상품이 없습니다.");
		}
		// 카테고리별 상품의 목록을 출력한다.
		for (int i = 0; i < proList.size(); i++) {
			pv = proList.get(i);
			// System.out.println("view service.searchPb(pv.getPro_id() = " +
			// service.searchPb(pv.getPro_id()));
			System.out.println("No." + (i + 1) + "\t도서명: "
					+ pv.getPro_name() + "\n저자: " + pv.getPro_writer()
					+ "\t 출판사 : "
					+ service.searchPb(pv.getPro_id()).getPb_name() + "\n 재고: "
					+ pv.getPro_mount() + "\t가격: " + pv.getPro_price());
			if (i < proList.size() - 1) {
				System.out
						.println("-------------------------------------------------------");
			}
		}
		System.out
				.println("=======================================================");
		// 사용자로부터 맘에 드는 상품의 No.를 입력 받도록 한다.
		while (true) {
			try {
				System.out.println("담을 상품이 있으시다면 상품 번호를 입력하세요");
				System.out.println("뒤로가기(0)");
				pro_sq = inputInt() - 1;
				if (pro_sq == -1) {
					return;
				}
				if (pro_sq >= proList.size()) {
					System.out.println("잘못된 상품 번호입니다. 다시 입력해주세요.");
					continue;
				}
				pv = proList.get(pro_sq); // 상품객체의 id를 가져온다.
				System.out.println("상품을 몇 개 담을까요?");
				pro_mount = inputInt();
				if (pro_mount == -1) {
					return;
				}
				if (pv.getPro_mount() < pro_mount) {
					System.out.println("너무 많은 양을 선택하였습니다.");
					continue;
				}
				break;
			} catch (Exception e) {
				continue;
			}

		}
		// HashMap에 상품 객체와 상품의 수량을 담아준다.
		Map<String, Object> params = new HashMap<String, Object>();
		String mem_id = currentMember.getMem_id();
		int cart_id = service.searchCartId(mem_id);

		// params.put("cart_id", cart_id);
		// 사용자가 선택한 상품의 객체와 수량을 장바구니에 상품으로 담는 메서드 호출
		params.put("pv", pv);
		params.put("pro_mount", pro_mount);
		if (service.addCartProduct(params, cart_id)) {
			System.out.println("상품이 성공적으로 담겼습니다.");
		} else {
			System.out.println("상품 담기에 실패하였습니다.");
		}

	}

	
	/** 중고도서 포기..
	 * 회원모드 : 중고도서 // 완료못함. 아직 구상중 컨펌필요
	 */
	private void mem_UsedBook() {

		while (true) {
			showBanner("중고도서");
			System.out.println("1. 보유도서 목록");
			System.out.println("2. 중고도서 지정");
			System.out.println("3. 중고도서 수량변경");
			System.out.println("4. 중고도서 삭제");
			System.out.println("5. 중고도서 판매");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 : ");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();

			switch (input) {
			case 1:
				// mem_CartProductList();
				break;
			case 2:
				mem_usedBookList();
				break;
			case 3:
				mem_ubuList();
				break;
			case 4:
				mem_ubdList();
				break;
			case 5:
				mem_salesUsedBookList();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	// 회원 로그인 .
	private void mem_usedBookList() {
		Scanner in = new Scanner(System.in);
		// mem_CartProductList();

		System.out.print("중고도서로 팔 책을 선택 : ");
		int input = in.nextInt();
		// 여기서 선택한 책들이 중고도서리스트에 담기는 거임.
	}

	private void mem_ubuList() { // 중고도서리스트에서 상품의 수량을 변경할 메서드 usedBookUpdate
									// 약자따서 ubu
		Scanner in = new Scanner(System.in);

		System.out.print("상품수량 : ");
		int input = in.nextInt();
		System.out.println("상품수량이 수정되었습니다.");
		// 상품수량 변경 후 다시 usedBookList에 변경된 정보를 담아줘야 함.
	}

	private void mem_ubdList() { // 중고도서리스트에서 상품을 삭제할 메서드 usedBookDelete 약자따서
									// ubd
		Scanner in = new Scanner(System.in);

		System.out.print("삭제할 상품 : ");
		int input = in.nextInt();
		System.out.println("상품이 삭제 되었습니다.");
		// 상품삭제 후 그 정보를 다시 usedBookList에 담아줘야 함.
	}

	// 관리자 로그인 (위에서 회원이 정의한 중고리스트들을 가져와서 관리자가 등급,가격 매김)
	private void ad_usedBookPriceList() {
		Scanner in = new Scanner(System.in);
		mem_usedBookList(); // 회원이 정의한 중고리스트 호출

		System.out.print("측정할 상품 : ");
		int input = in.nextInt();
		System.out.print("상품의 등급 : "); // 1~3등급. 1등급 : 10% 감액 2등급 : 20% 감액 3등급 :
										// 30%감액
		input = in.nextInt();
		System.out.print("상품의 가격 : "); // 매긴 등급에 의해 신품상태의 책가격 에서 %로 감액되어 가격이
										// 매겨짐.
		input = in.nextInt();

		System.out.println("해당 상품의 가격이 측정되었습니다.");
		// 위에서 관리자가 측정한 정보들이 해당 상품에 반영되고, 그 반영된 상품들이 ad_usedBookPriceList()에
		// 담겨야함.
	}

	// 회원 로그인( 관리자가 측정한 상품들의리스트( ad_usedBookPriceList() )를 가져와서 회원이 판단해서 팔지 말지
	// 결정.

	private void mem_salesUsedBookList() { // 중고책판매 리스트.
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();

		switch (input) {
		case 1:
			mem_salesUsedBook(); // 판매 결정했을때 사용할 메서드.
			break;
		case 2:
			mem_deleteUsedBookList(); // 판매안할때 사용할 메서드.
			return;
		default:
			System.out.println("다시 입력하세요.");
		}
	}

	private void mem_salesUsedBook() {
		Scanner in = new Scanner(System.in);
		System.out.println("판매상품 선택 : "); // 판매할 상품 선택
		int input = in.nextInt();
		System.out.println("판매가 완료되었습니다.");

		// 위에서 판매되면 그 금액 회원 캐시에 추가되고 관리자캐시에서는 차감됨.
	}

	private void mem_deleteUsedBookList() {
		// 이 메서드를 선택하게 되면 안판다는거니까 관리자가 건내준 리스트를 여기서 삭제시키도록 구현해줘야함.
	}
	
	/**
	 * 회원모드 : 장바구니
	 */
	private void mem_Cart() {
		while (true) {
			showBanner("장바구니");
			Scanner in = new Scanner(System.in);
			System.out.println("장바구니 관리");
			System.out.println("1. 장바구니 조회");
			System.out.println("2. 장바구니 주문");
			System.out.println("3. 상품 수량 변경");
			System.out.println("4. 장바구니 상품 삭제");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 : ");
			int input = in.nextInt();

			switch (input) {
			case 1:
				mem_showCart();
				break;
			case 2:
				mem_orderCart();
				break;
			case 3:
				mem_updateCartProduct();
				break;
			case 4:
				mem_deleteCartProduct();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");

			}
		}
	}

	/**
	 * 회원 모드 - 장바구니에 담긴 상품 조회 완료
	 */
	private void mem_showCart() {
		showBanner("******장바구니 조회******");
		// 현재 멤버의 id를 가져온다.
		String mem_id;
		int cart_id;
		List<CartProductVO> productList = null;
		ProductVO product = null;

		mem_id = currentMember.getMem_id();
		cart_id = service.searchCartId(mem_id);
		if (cart_id == -1) {
			System.out
					.println("=====================================================================================");
			System.out.println("\t담은 상품이 없습니다.");
			System.out
					.println("=====================================================================================");
			return;
		}

		productList = service.showCartPv(cart_id);
		if (productList == null) {
			return;
		}
		System.out
				.println("=====================================================================================");
		for (int i = 0; i < productList.size(); i++) {
			CartProductVO cartProduct = productList.get(i);
			product = service.searchPv(cartProduct.getPro_id());
			System.out.print("No. " + i);
			System.out.println("\t도서명 : " + product.getPro_name());
			System.out.print(" 저자: " + product.getPro_writer());
			System.out.println("\t출판사 : "
					+ service.searchPb(product.getPro_id()).getPb_name());
			System.out.print(" 수량: " + cartProduct.getCartPro_mount());
			System.out.println("\t가격 : " + product.getPro_price());
			System.out
					.println("------------------------------------------------------------------------------------------");
		}
		System.out.println("전체 상품 총 합계: " + service.getCartPrice(cart_id));
		if (product == null) {
			System.out.println("\t담은 상품이 없습니다.");
		}
		System.out
				.println("=====================================================================================");
	}

	/**
	 * 회원모드 : 장바구니 주문
	 */

	private void mem_orderCart() {
		// 장바구니 주문
		showBanner("*****장바구니 주문*****");
		Map<Integer, String> params = new HashMap<Integer, String>();
		CartVO cart;
		CartProductVO cartProduct;
		OrderViewVO order;
		int cart_id = -1;

		String mem_id = currentMember.getMem_id();
		cart_id = service.searchCartId(mem_id);
		if (cart_id == -1) {
			return;
		}

		// 회원별 카트의 번호를 알아와서 CartVO 인스턴스를 그 해당 cart_id와 연결
		cart = service.searchCartv(cart_id);

		// 회원별 장바구니상품의 번호를 알아와서 CartProduct 인스턴스를 그와 연결

		try {
			cartProduct = service.searchMemberCartProduct(cart_id);

			System.out.println("=======================================================");
			System.out.println("회원 ID : " + currentMember.getMem_id());
			System.out.println("총 금액 : " + service.getCartPrice(cart_id) + "원");
			System.out.println("회원님의 보유 캐시 : " + currentMember.getMem_cash()+ "원");
			if (service.getCartPrice(cart_id) > currentMember.getMem_cash()) {
				System.out.println("캐시가 부족합니다!+");
			} else if (!service.checkStock(cart_id)) {
				System.out.println("재고가 부족합니다. 주문 수량을 줄여주세요");
			} else {
				// 사용한 캐시 내역 추가
				mem_SubCash(service.getCartPrice(cart_id));
				//currentMember.subCash(service.getCartPrice(cart_id));
				//System.out.println("view mem_orderCart() orderPrice= " + orderPrice);
				cart.setPayed(true); // 구매했으니깐 true
				// 회원이 장바구니 주문을 하면 CartProduct의 isActived를 false로 변경
				cartProduct.setActived(false);
				if (service.addOrder(cart_id)) {
					System.out.println("성공적으로 구매하였습니다!");
					System.out.println("구매 후 회원님의 보유 캐시 : "+ currentMember.getMem_cash() + "원");
					System.out.println("=======================================================");
				} else {
					System.out.println("구매에 실패하였습니다.");
				}
			}
		} catch (Exception e) {
			System.out
					.println("=====================================================================================");
			System.out.println("\t담은 상품이 없습니다.");
			System.out
					.println("=====================================================================================");
		}

	}

	/**
	 * 회원모드 : 상품 수량 변경
	 */
	
	private void mem_updateCartProduct() {
		Scanner in = new Scanner(System.in);
		System.out.print("수량 변경할 상품 선택>> ");
		int input = in.nextInt();
		System.out.print("변경할 수량>> ");
		input = in.nextInt();
		System.out.println("상품 수량 변경 완료");
	}

	/**
	 * 회원모드 : 장바구니 상품 삭제
	 */
	private void mem_deleteCartProduct() {
		Scanner in = new Scanner(System.in);
		System.out.print("삭제할 상품 선택>> ");
		int input = in.nextInt();
		System.out.println("상품 삭제 완료");
	}

	/**
	 * 회원모드 : 4.마이페이지
	 */
	private void mem_MyPage() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("마이페이지");
			System.out.println("1. 캐시충전");
			System.out.println("2. 캐시사용내역");
			System.out.println("3. 주문조회");
			System.out.println("4. 주문취소");
			System.out.println("5. 정보수정");
			System.out.println("6. 정보조회");
			System.out.println("7. 회원탈퇴");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 : ");
			int input = in.nextInt();

			switch (input) {
			case 1:
				mem_addCash();
				break;
			case 2:
				mem_showCash();
				break;
			case 3:
				mem_showOrder();
				break;
			case 4:
				mem_orderCancle();
				break;
			case 5:
				mem_updateInfo();
				break;
			case 6:
				mem_showInfo();
				break;
			case 7:
				mem_memOut();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	/**
	 * 회원모드 : 마이페이지 : 주문목록메서드
	 */
	private void mem_orderList() {
		System.out.println("====주문 목록입니다=====");
		System.out.println("No.1");
		System.out.println("날짜 : ");
		System.out.println("상품명 : \t  상품 가격 : ");
		System.out.println("총 주문금액 : ");
		System.out.println("==========================");
	}

	/**
	 * 마이페이지 : 캐시충전
	 */
	private void mem_addCash() {
		Scanner in = new Scanner(System.in);
		int addCash;
		showBanner("******캐시충전******");
		System.out.println("보유 캐시 :" + currentMember.getMem_cash());
		System.out.print("충전할 캐시 ");
		addCash = inputInt();
		if (addCash == -1) {
			return;
		}
		currentMember.addCash(addCash);
		CashVO cash = new CashVO();
		cash.setAddCash(addCash);
		cash.setSubCash(0);
		cash.setMem_id(currentMember.getMem_id());

		service.addCash(cash);

		System.out.println(addCash + "원이 충전되었습니다.");
		System.out.println("보유 캐시 :" + currentMember.getMem_cash() + "원");
	}

	/**
	 * 마이페이지 : 캐시 사용
	 */
	private void mem_SubCash(long usedCash) {
		List<CashVO> cashList = null;
		Date today = new Date();
		long subCash;
		String mem_id = currentMember.getMem_id();
		
		
		// 회원의 사용 캐시 계산
		currentMember.subCash(usedCash);
		cashList = service.showCashList(mem_id);

		CashVO cash = new CashVO();
		cash.setSubCash(usedCash);
		cash.setAddCash(0);
		cash.setMem_id(mem_id);
		
		service.addCash(cash);

		//System.out.println(usedCash + "원이 사용되었습니다.");
		//System.out.println("보유 캐쉬 :" + currentMember.getMem_cash() + "원");
	}
	
	
	   /**
	    * 마이페이지 : 캐시사용내역
	    */
	   private void mem_showCash() {
	      List<CashVO> cashList = null;
	      Scanner in = new Scanner(System.in);
	      Date today = new Date();

	      CashVO cash = new CashVO();
	      showBanner("캐시사용내역");
	      System.out.println("회원님의 캐쉬사용내역 입니다.");
	      cashList = service.showCashList(currentMember.getMem_id());
	      

	      for (int i = 0; i < cashList.size(); i++) {
	         if (cashList.get(i).getAddCash() != 0) {
	            System.out.println("충전캐시 : " + cashList.get(i).getAddCash()
	                  + "원" + "\t 충전한 날짜 : " + cashList.get(i).getCash_date());
	            System.out.println("--------------------------------------------------");
	         }
	      }


	      for (int i = 0; i < cashList.size(); i++) {
	         System.out.println();
	         if (cashList.get(i).getSubCash() != 0) {
	            System.out.println("사용한 캐시 : " + cashList.get(i).getSubCash()
	                  + "원" + "\t 사용한 날짜 : " + cashList.get(i).getCash_date());
	            System.out.println("--------------------------------------------------");
	         }
	      }

	      System.out.println("\n현재 보유 캐시 : " + currentMember.getMem_cash() + "원");

	   }

	/**
	 * 마이페이지 : 주문조회
	 */
	private void mem_showOrder() {
		List<OrderViewVO> orderList = null;

		showBanner("주문조회");
		orderList = service.showOrderList(currentMember.getMem_id());

		for (int i = 0; i < orderList.size(); i++) {

			System.out.println("\t\t주문한 날짜 : "
					+ orderList.get(i).getOrder_date());
			System.out.println("\t\t상품명 : " + orderList.get(i).getPro_name());
			System.out.println("\t\t가격 : " + orderList.get(i).getCart_price());
		}
		if (orderList.isEmpty()) {
			System.out.println("\t주문 내역이 없습니다");
		}

	}

	/**
	 * 마이페이지 : 주문취소
	 */
	private void mem_orderCancle() {
		showBanner("주문취소");
		List<OrderViewVO> orderList = null;
		orderList = service.showOrderList(currentMember.getMem_id());

		Scanner in = new Scanner(System.in);
		System.out.print("취소할 주문번호 : ");
		int input = in.nextInt();
		System.out.println("주문취소가 완료되었습니다.");
	}

	/**
	 * 마이페이지 : 정보수정
	 */
	private void mem_updateInfo() {
		Scanner in = new Scanner(System.in);
		showBanner("정보수정");

		String mem_id;
		String mem_pw;
		String mem_name;
		String mem_birth;
		String mem_phone;
		String mem_add;

		mem_name = inputMemberName();
		mem_pw = inputPw();
		mem_phone = inputMemberPhone();
		mem_birth = inputMemberBirth();
		mem_add = inputMemberAddress();

		currentMember.setMem_pw(mem_pw);
		currentMember.setMem_name(mem_name);
		currentMember.setMem_bir(mem_birth);
		currentMember.setMem_phone(mem_phone);
		currentMember.setMem_add(mem_add);

		System.out.println("회원 정보 수정이 완료되었습니다.");

	}

	/**
	 * 마이페이지 : 정보조회
	 */
	private void mem_showInfo() {
		showBanner("정보조회");
		System.out.println("회원 ID : " + currentMember.getMem_id());
		System.out.println("비밀번호 : " + currentMember.getMem_pw());
		System.out.println("회원 이름 : " + currentMember.getMem_name());
		System.out.println("생년월일 : " + currentMember.getMem_bir());
		System.out.println("주소 : " + currentMember.getMem_add());
		System.out.println("핸드폰 번호 : " + currentMember.getMem_phone());
		System.out.println("보유 캐시 : " + currentMember.getMem_cash());

	}

	/**
	 * 마이페이지 : 회원탈퇴메서드
	 */
	private void mem_memOut() {
		showBanner("회원탈퇴");
		Scanner in = new Scanner(System.in);

		System.out.println("1.회원탈퇴  0.취소");
		while (true) {
			System.out.print("입력 : ");
			int input = in.nextInt();

			switch (input) {
			case 1:
				System.out
						.println("회원탈퇴가 완료되었습니다. \n그동안 저희 genie를 이용해 주셔서 감사합니다");
				System.exit(0);
			case 0:
				return;
			default:
				System.out.println("다시 입력해주세요.");
			}

		}
	}

	// 회원모드 : 게시판은 공통부분으로 따로 뺌

	/**
	 * 관리자모드 메서드
	 */

	private void adminService() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("관리 대상 선택");
			System.out.println("1. 상품관리");
			System.out.println("2. 업체관리");
			System.out.println("3. 회원관리");
			System.out.println("4. 게시판 관리");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 : ");
			int input = in.nextInt();
			switch (input) {
			case 1:
				ad_managementProduct();

				break;
			case 2:
				ad_managementPublisher();
				break;
			case 3:
				ad_managementMember();
				break;
			case 4:
				com_managementNotice();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}

		}

	}

	/**
	 * 관리자 - 상품관리
	 */
	private void ad_managementProduct() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("상품 관리");
			System.out.println("1. 상품 재고 조회");
			System.out.println("2. 상품 상세 조회");
			System.out.println("3. 매출 조회");
			System.out.println("4. 상품 추가");
			System.out.println("5. 상품 변경");
			System.out.println("6. 상품 삭제");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력: ");
			int input = in.nextInt();

			switch (input) {
			case 1:
				ad_showProduct();
				break;
			case 2:
				ad_detailShowProduct();
				break;
			case 3:
				ad_salesProduct();
				break;
			case 4:
				ad_addProduct();
				break;
			case 5:
				ad_updateProduct();
				break;
			case 6:
				ad_deleteProduct();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
				continue;
			}
		}
	}

	/**
	 * 상품 상세 조회
	 */
	private void ad_detailShowProduct() {
		Scanner in = new Scanner(System.in);
		ProductVO product = null;

		int pro_id;
		showBanner("상품 검색");
		try {
			product = selectProduct();
			if (product == null) {
				return;
			}
			String pb_name = service.searchPb(product.getPb_id()).getPb_name();
			System.out.println();
			System.out.println("물품명 : " + product.getPro_name());
			System.out.println("가격 : " + product.getPro_price());
			System.out.println("수량 : " + product.getPro_mount());
			System.out.println("저자 : " + product.getPro_writer());
			System.out.println("업체명 : " + pb_name);
			System.out.println("카테고리 : "
					+ service.searchCv(product.getCate_id()).getCate_name());
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			in.nextLine();
		}
	}

	/**
	 * 관리자모드 : 상품 재고 조회
	 */
	private void ad_showProduct() {
		List<ProductVO> list = null;
		list = service.showPv();
		showBanner("전체 상품 재고 조회");
		System.out
				.println("=======================================================");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isActived() == true) {
				System.out.print("No." + (i + 1));
				System.out.print("\t상품명 : " + list.get(i).getPro_name());
				System.out.print("\n\t수량 : " + list.get(i).getPro_mount());
			}
			if (i < list.size() - 1) {
				System.out
						.println("\n-------------------------------------------------------");
			}
		}
		if (list.isEmpty()) {
			System.out.println("상품이 없습니다!");
		}
		System.out.println();
		System.out
				.println("=======================================================");
	}

	/**
	 * 관리자모드 : 매출 조회
	 */
	private void ad_salesProduct() { // 고객이 구매한 상품들을 담을 메서드를 만들고 그 메서드를 여기서 다시
										// 불러오면 그게 매출목록.
		Scanner in = new Scanner(System.in);
		showBanner("****** 매출 조회 ******");

		System.out.println("일반도서 매출액 : \t 중고도서 매출액 : \n총 매출액 : ");
	}

	/**
	 * 관리자 - 상품 추가 메서드
	 */
	private void ad_addProduct() {
		Scanner in = new Scanner(System.in);
		Map<String, Object> param = new HashMap<String, Object>();

		int pb_id;
		String pro_name;
		int pro_mount;
		int pro_price;
		String pro_writer;
		PublisherVO pb = null;
		String cate;
		showBanner("상품 추가");
		while (true) {

			try {
				System.out.print("상품명 : ");
				pro_name = in.nextLine();

				if (pro_name.equals("")) {
					continue;
				}

				System.out.print("가격 ");
				pro_price = inputInt();
				if (pro_price == -1)
					return;

				System.out.print("수량 ");
				pro_mount = inputInt();
				if (pro_mount == -1) {
					return;
				}

				System.out.print("저자 : ");
				pro_writer = in.nextLine();
				if (pro_writer.equals("")) {
					continue;
				}

				// 업체 및 카테고리 (불러와서 띄워줌)
				System.out.println("업체ID");
				pb = ad_selectPb();
				System.out.println("카테고리");
				cate = selectCategory().getCate_name();

				if (pb == null) {
					System.out.println("입력 오류입니다. 다시 입력해 주세요");
					continue;
				}

				pb_id = pb.getPb_id();

				param.put("pro_name", pro_name);
				param.put("pro_mount", pro_mount);
				param.put("pro_price", pro_price);
				param.put("pb_id", pb_id);
				param.put("pro_writer", pro_writer);

				if (service.addPv(param)) {
					System.out.println("[상품명 : " + pro_name + ", 수량 : "
							+ pro_mount + ", 가격 : " + pro_price + "원, 저자 : "
							+ pro_writer + ", 업체 : " + pb.getPb_name()
							+ ", 카테고리 : " + cate + "] 추가완료");
					break;
				} else {
					System.out.println("중복되었거나 잘못 입력하셨습니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("다시 입력해주세요.");
				in = new Scanner(System.in);
				continue;
			}
		}
	}

	/**
	 * 관리자모드 : 상품 변경 // 연결 다 했는데 db못짰음ㅠㅠ 넘 어려움...
	 */
	private void ad_updateProduct() {
		Scanner in = new Scanner(System.in);
		int pro_id;
		String pro_name;
		int pro_price;
		int pro_mount;
		Map<String, Object> udp = new HashMap<String, Object>();
		showBanner("****** 상품 변경 ******");

		// 전체목록보여줘라

		// ProductVO pro_id2 = new ProductVO();
		// pro_id2 = selectProduct();
		// List<ProductVO> list2 = null;
		// list2 = service.showPv();

		ad_showProduct();

		System.out.println("***상품 ID***");
		pro_id = inputInt();
		if (pro_id == -1) {
			return;
		}
		System.out.print("***상품명***\n입력 : ");
		pro_name = in.nextLine();
		if (pro_name == null) {
			return;
		}

		System.out.println("***상품 가격***");
		pro_price = inputInt();
		if (pro_price == -1) {
			return;
		}

		System.out.println("***상품 수량***");
		pro_mount = inputInt();
		if (pro_mount == -1) {
			return;
		}

		udp.put("pro_id", pro_id - 1);
		udp.put("pro_name", pro_name);
		udp.put("pro_price", pro_price);
		udp.put("pro_mount", pro_mount);

		if (service.updateProduct(udp)) {
			System.out.println("상품변경이 완료되었습니다.");
		} else {
			System.out.println("상품변경에 실패하였습니다.");
		}

	}

	/**
	 * 관리자모드 : 상품 삭제
	 */
	private void ad_deleteProduct() {
		showBanner("상품 삭제");
		ProductVO product = selectProduct();
		if (product == null) {
			return;
		}
		if (service.deletePv(product.getPro_id())) {
			System.out.println("상품 삭제 완료 ");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

	/**
	 * 상품 삭제시에 상품을 선택해서 삭제해주기 위한 메서드
	 */
	private ProductVO selectProduct() {
		Scanner in = new Scanner(System.in);
		List<ProductVO> proList = service.showPv();
		int pro_sq;
		System.out
				.println("=======================================================");
		for (int i = 0; i < proList.size(); i++) {
			System.out.println("No." + (i + 1) + "\t상품 명 : "
					+ proList.get(i).getPro_name());
			if (i < proList.size() - 1) {
				System.out
						.println("------------------------------------------------------");
			}
		}
		if (proList.isEmpty()) {
			System.out.println("상품이 없습니다!");
			return null;
		}
		System.out
				.println("=======================================================");

		while (true) {
			try {
				System.out.print("상품 No. : ");
				pro_sq = in.nextInt();
				in.nextLine();

				for (int i = 0; i < proList.size(); i++) {
					if ((pro_sq - 1) == i) {
						return proList.get(pro_sq - 1);
					}
				}
				System.out.println("다시 입력해주세요.");
			} catch (InputMismatchException e) {
				in.nextLine();
				return null;
			} catch (Exception e) {
				in.nextLine();
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

	/**
	 * 관리자모드 : 2.업체관리
	 */
	private void ad_managementPublisher() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("업체 관리");
			System.out.println("1. 업체 조회");
			System.out.println("2. 업체 추가");
			System.out.println("3. 업체 삭제");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력: ");
			int input = in.nextInt();
			switch (input) {
			case 1:
				ad_showPublisher();
				break;
			case 2:
				ad_addPublisher();
				break;
			case 3:
				ad_deletePublisher();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	/**
	 * 관리자모드 : 업체 조회
	 */
	private void ad_showPublisher() {
		int pb_id;
		List<PublisherVO> pblist = null;
		showBanner("전체 업체 정보");
		pblist = service.getPbList();
		System.out
				.println("=======================================================");
		for (int i = 0; i < pblist.size(); i++) {
			if (pblist.get(i).isActived() == true) {
				System.out.print("업체 No." + (i + 1));
				System.out.println("\t업체 명 : " + pblist.get(i).getPb_name());
			}
			if (i < pblist.size() - 1) {
				System.out
						.println("-------------------------------------------------------");
			}
		}
		System.out
				.println("=======================================================");
	}

	/**
	 * 관리자모드 : 업체 추가
	 */
	private void ad_addPublisher() {
		Scanner in = new Scanner(System.in);
		String pb_name;
		Map<String, String> param = new HashMap<String, String>();
		boolean value;
		showBanner("업체 추가");
		while (true) {

			System.out.print("추가할 출판사 이름 : ");
			pb_name = in.nextLine();
			param.put("pb_name", pb_name);
			value = service.addPb(param);
			if (value == true) {
				System.out.println(param.get("pb_name") + "이 추가되었습니다.");
				break;
			} else {
				System.out.println("값이 중복되었거나 빈 칸을 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}

	/**
	 * 관리자-업체 삭제 메서드
	 */
	private void ad_deletePublisher() {
		showBanner("업체 삭제");
		PublisherVO pb;
		while (true) {
			System.out.println("삭제할 업체를 선택해주세요 ");
			try {
				pb = ad_selectPb();
				if (pb == null) {
					return;
				}
				service.deletePb(pb.getPb_id());
				break;
			} catch (Exception e) {
				System.out.println("똑바로 입력해 주세요.");
			}
		}
		System.out.println("업체 삭제 완료");
	}

	/**
	 * 업체선택 메서드
	 * 
	 * @author
	 * @return
	 */
	private PublisherVO ad_selectPb() {
		PublisherVO pb;
		int pb_sq;
		List<PublisherVO> pblist = null;
		pblist = service.getPbbList();
		System.out
				.println("=======================================================");
		for (int i = 0; i < pblist.size(); i++) {
			System.out.print("No." + (i + 1));
			System.out.println("\t\t업체 명 : " + pblist.get(i).getPb_name());
			if (i < pblist.size() - 1) {
				System.out
						.println("-------------------------------------------------------");
			}
		}
		System.out
				.println("=======================================================");
		while (true) {
			System.out.print("No. ");
			pb_sq = inputInt();
			if (pb_sq == -1) {
				return null;
			}
			if ((pb_sq - 1) > pblist.size()) {
				System.out.println("잘못된 번호입니다!");
				continue;
			}
			break;
		}
		return pblist.get((pb_sq - 1));
	}

	/**
	 * 관리자모드 : 3.회원관리
	 */
	private void ad_managementMember() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("회원관리");
			System.out.println("1. 회원 조회");
			System.out.println("2. 회원 정보 변경");
			System.out.println("3. 회원 퇴출");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력: ");
			int input = in.nextInt();
			switch (input) {
			case 1:
				ad_showMember();
				break;
			case 2:
				ad_updateMember();
				break;
			case 3:
				ad_MemberEject();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}

	}

	/**
	 * 관리자모드 : 회원 조회
	 * 
	 */
	private void ad_showMember() {
		showBanner("****** 회원조회 ******");
		List<MemberVO> mList = service.showMv();
		for (int i = 0; i < mList.size(); i++) {

			System.out.print("No." + (i + 1));
			System.out.println("\t회원명 : " + mList.get(i).getMem_name());
			System.out.print("\t회원 ID : " + mList.get(i).getMem_id());
			System.out.println("\t회원 생년월일 : " + mList.get(i).getMem_bir());
			System.out.print("\t회원 주소 : " + mList.get(i).getMem_add());
			System.out.println("\t회원 캐시 : " + mList.get(i).getMem_cash());
			System.out
					.println("------------------------------------------------------------");
		}
	}

	/**
	 * 관리자모드 : 회원 정보 변경
	 * 
	 * @param
	 * @return
	 */
	private void ad_updateMember() {
		Scanner in = new Scanner(System.in);
		String mem_id;
		String mem_name;
		String mem_password;
		String mem_birth;
		String mem_phone;
		showBanner("****** 회원정보 변경 ******");

		mem_id = selectMember();
		if (mem_id == null) {
			return;
		}
		mem_name = inputMemberName(); // 이름
		mem_password = inputPw(); // 비밀번호
		mem_phone = inputMemberPhone(); // 핸드폰
		mem_birth = inputMemberBirth(); // 생년월일
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		params.put("mem_name", mem_name);
		params.put("mem_password", mem_password);
		params.put("mem_birth", mem_birth);
		params.put("mem_phone", mem_phone);

		if (service.updateMv(params)) {
			System.out.println("ID : " + mem_id + " 회원 정보 수정 완료");
		} else {
			System.out.println("ID : " + mem_id + "가 없습니다.");
		}

	}

	/**
	 * 멤버 주소를 입력받는 메서드
	 * 
	 * @param
	 * @return
	 */
	private String inputMemberAddress() {
		Scanner in = new Scanner(System.in);
		String mem_add = "";
		while (true) {
			System.out.print("주소 : ");
			mem_add = in.nextLine();
			if (mem_add == null) {
				System.out.println("주소를 다시 입력해주세요");
			} else {
				return mem_add;
			}
		}
	}

	/**
	 * 멤버 생년월일을 입력받는 메서드
	 * 
	 * @param
	 * @return
	 */
	private String inputMemberBirth() {
		Scanner in = new Scanner(System.in);
		String mem_bir = "";
		while (true) {
			System.out.print("생년월일(YYYY-MM-DD) : ");
			mem_bir = in.nextLine();
			if (RegEx.checkMemBirth(mem_bir)) {
				break;
			} else {
				System.out.println("생년월일을 올바르게 입력해주세요");
			}
		}
		return mem_bir;
	}

	/**
	 * 회원정보 수정할 멤버 핸드폰번호을 입력받는 메서드
	 * 
	 * @param
	 * @return
	 */
	private String inputMemberPhone() {
		Scanner in = new Scanner(System.in);
		String mem_phone = "";
		while (true) {
			System.out.print("핸드폰번호 : ");
			mem_phone = in.nextLine();
			if (RegEx.checkMemPhone(mem_phone)) {
				break;
			} else {
				System.out.println("핸드폰번호를 올바르게 입력해주세요.");
			}
		}
		return mem_phone;
	}

	/**
	 * 회원정보 수정할 멤버 이름을 입력받는 메서드
	 * 
	 * @param
	 * @return
	 */
	private String inputMemberName() {
		Scanner in = new Scanner(System.in);
		String mem_name = "";
		while (true) {
			System.out.print("이름 : ");
			mem_name = in.nextLine();
			if (RegEx.checkMemName(mem_name)) {
				break;
			} else {
				System.out.println("이름은 한글 2~4글자로 입력해주세요");
			}
		}
		return mem_name;
	}

	/**
	 * 회원 찾는 메서드
	 * 
	 * @return 회원 no.
	 */
	String selectMember() {
		Scanner in = new Scanner(System.in);
		String mem_id = null;
		int sq;
		/*
		 * sql 회원 전체 조회 메서드 List<MemberVO> showMv();
		 */
		List<MemberVO> mList = service.showMv();
		for (int i = 0; i < mList.size(); i++) {
			System.out.print("No." + (i + 1));
			System.out.print("\t회원명 : " + mList.get(i).getMem_name());
			System.out.println("\t회원 ID : " + mList.get(i).getMem_id());
		}
		System.out
				.println("=======================================================");
		while (true) {
			System.out.print("회원 No. : ");
			try {
				sq = in.nextInt();
				in.nextLine();
				/*
				 * 입력한 값에 맞는 Id를 찾는 과정
				 */
				for (int i = 0; i < mList.size(); i++) {
					if (sq - 1 == i) {
						mem_id = mList.get(i).getMem_id();
						return mem_id;
					}
				}
				System.out.println("다시 입력해 주세요.");
			} catch (InputMismatchException e) {
				in.nextLine();
				return null;
			}
		}
	}

	/**
	 * 관리자모드 : 회원 퇴출
	 */
	private void ad_MemberEject() {
		showBanner("****** 회원 퇴출 ******");
		String mem_id;
		mem_id = selectMember();
		if (mem_id == null) {
			return;
		}
		if (mem_id.equals(currentMember.getMem_id())) {
			System.out.println("자기자신을 삭제할 수 없습니다.");
			return;
		}
		if (service.deleteMv(mem_id)) {
			System.out.println("회원 퇴출이 완료되었습니다.");
		} else {
			System.out.println("잘못된 아이디입니다.");
		}
	}

	/**
	 * 공통 : 게시판 관리
	 */

	private void com_managementNotice() {
		while (true) {
			Scanner in = new Scanner(System.in);
			showBanner("게시판");
			System.out.println("1. 게시글 조회");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("0. 뒤로가기");
			System.out.print("\n입력 :");
			int input = in.nextInt();
			switch (input) {
			case 1:
				com_showNotice();
				break;
			case 2:
				com_addNotice();
				break;
			case 3:
				com_updateNotice();
				break;
			case 4:
				com_deleteNotice();
				break;
			case 0:
				return;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
	}

	/**
	 * 공통 : 게시글 조회
	 */
	private void com_showNotice() {
		showBanner("게시글 조회");
		List<NoticeboardVO> noticeList = service.showNv();
		System.out
				.println("=======================================================");
		for (int i = 0; i < noticeList.size(); i++) {
			System.out.print("No." + (i + 1));
			System.out.print("\tID : " + noticeList.get(i).getMem_id());
			System.out.println("\t제목 : " + noticeList.get(i).getNotice_title());
			System.out.println("\t내용 : "
					+ noticeList.get(i).getNotice_content());
		}
		System.out
				.println("=======================================================");

	}

	/**
	 * 공통 - 게시글 작성 메서드
	 */
	private void com_addNotice() {
		Scanner in = new Scanner(System.in);
		String noticeTitle;
		String noticeContent;
		showBanner("게시글 작성");
		System.out.print("게시글 이름 : ");
		noticeTitle = in.nextLine();
		System.out.print("게시글 내용 : ");
		noticeContent = in.nextLine();

		if (noticeTitle.equals("") || noticeContent.equals("")) {
			System.out.println("공백을 입력했습니다.");
			return;
		}

		NoticeboardVO board = new NoticeboardVO();
		board.setNotice_title(noticeTitle);
		board.setNotice_content(noticeContent);
		board.setNotice_date("2019-04-21");
		board.setMem_id(currentMember.getMem_id());

		if (service.addNv(board)) {
			System.out.println("성공적으로 저장되었습니다!");
		} else {
			System.out.println("게시글 저장에 실패했습니다.");
		}

	}

	/**
	 * 공통 - 게시글 번호 찾기
	 * 
	 * @return 게시글 번호
	 */
	private int selectNotice() {
		Scanner in = new Scanner(System.in);
		int notice_id = 0;
		int sq = 0;

		// 게시글 전체 조회
		List<NoticeboardVO> noticeList = service.showNv();
		for (int i = 0; i < noticeList.size(); i++) {
			System.out.print("No." + (i + 1));
			System.out.print("\tID : " + noticeList.get(i).getMem_id());
			System.out.println("\t제목 : " + noticeList.get(i).getNotice_title());
		}
		System.out
				.println("=======================================================");
		while (true) {
			try {
				System.out.print("게시글 No. : ");

				sq = in.nextInt();
				/*
				 * 입력한 값에 맞는 Id를 찾는 과정
				 */
				for (int i = 0; i < noticeList.size(); i++) {
					if ((sq - 1) == i) {
						notice_id = noticeList.get(i).getNotice_id();
						return notice_id;
					}
				}
				System.out.println("다시 입력해주세요.");
			} catch (InputMismatchException e) {
				in.nextLine();
				return -1;
			}
		}
	}

	/**
	 * 공통 - 게시글 수정 메서드
	 */
	private void com_updateNotice() {
		Scanner in = new Scanner(System.in);
		showBanner("게시글 수정");
		String notice_title = "";
		String notice_content = "";
		int notice_id = 0;

		notice_id = selectNotice();
		if (notice_id == -1) {
			return;
		}

		try {
			NoticeboardVO nv = service.searchNv(notice_id);
			MemberVO mv = service.searchMv(currentMember.getMem_id());
			System.out.println(nv.getNotice_title());

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("notice_id", nv);
			params.put("mem_autho", mv);
			params.put("current_id", currentMember);

			/*
			 * sql 게시글 수정,삭제 권한 체크 checkNoticeAutho(Map<String, Object> params);
			 */
			if (service.checkNoticeAutho(params)) {
				System.out.print("제목 : ");
				notice_title = in.nextLine();
				System.out.print("내용 : ");
				notice_content = in.nextLine();

				if (notice_title.equals("") || notice_content.equals("")) {
					System.out.println("공백을 입력했습니다.");
					return;
				}

				nv.setNotice_id(notice_id);
				nv.setNotice_title(notice_title);
				nv.setNotice_content(notice_content);

				if (service.updateNv(nv)) {
					System.out.println("성공~!");
				} else {
					System.out.println("수정에 성공했습니다.");
				}
			} else {
				System.out.println("권한이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}

		/*
		 * sql 게시글 수정 메서드 boolean updateNv(NoticeboardVO nv);
		 */

	}

	/**
	 * 공통 - 게시글 삭제 메서드
	 */
	private void com_deleteNotice() {
		int notice_id;
		showBanner("게시글 삭제");
		notice_id = selectNotice();
		if (notice_id == -1) {
			return;
		}
		/*
		 * 게시글 검색 메서드
		 */
		NoticeboardVO nv = service.searchNv(notice_id);
		MemberVO mv = service.searchMv(currentMember.getMem_id());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("notice_id", nv);
		params.put("mem_autho", mv);
		params.put("current_id", currentMember);

		if (service.checkNoticeAutho(params)) {
			if (service.deleteNv(notice_id)) {
				System.out.println("삭제 완료.");
			} else {
				System.out.println("게시글 삭제에 실패했습니다.");
			}
		} else {
			System.out.println("권한이 없습니다.");
		}
	}

}
