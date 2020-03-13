/*
 * # 쇼핑몰 [장바구니]
 * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
 * 	1) 사과
 *  2) 바나나
 *  3) 딸기
 * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
 * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
 * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
 * 예)
 * {
 * 		{0, 1},				qwer회원 			> 사과구매
 * 		{1, 2},				javaking회원 		> 바나나구매
 * 		{2, 1},				abcd회원			> 사과구매
 * 		{0, 3},				qwer회원			> 딸기구매
 * 		...
 * }
 */
//이거 이해 안됌


package day_19;

import java.util.Scanner;

public class ArrayEx45 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",     "2222", "3333"};
		
		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];
		
		int count = 0;
		
		String[] items = {"사과", "바나나", "딸기"};
		
		int log = -1;
		int check = -1;
		
		while(true) {
			
			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니");
			System.out.println("[0]종     료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {			//로그인
				if(log != -1)
				{
					System.out.println(ids[check] + "님이 이미 로그인중입니다.");
					System.out.println("로그 아웃 후 사용해주세요");
				}
				else
				{
					System.out.println("아이디를 입력하세요");
					String id = sc.next();
					
					for(int i=0;i<3;i++)
					{
						if(id.equals(ids[i]))
						{
							check = i;
						}
					}
					
					if(check ==-1)
					{
						System.out.println("아이디를 확인해주세요");
					}
					else
					{
						System.out.println("패스워드를 입력해주세요");
						String pw = sc.next();
						
						for(int i=0;i<3;i++)
						{
							if(pw.equals(pws[i]))
							{
								System.out.println(ids[check]+"님 로그인 되었습니다.");
								log = check;
							}
						}
					}
				}
			}
			else if(sel == 2) {				//로그 아웃
				if(log == -1)
				{
					System.out.println("로그아웃 상태입니다.");
				}
				else if(log != -1)
				{
					System.out.println(ids[check] + "님이 로그아웃되었습니다.");
					log = -1;
				}
			}
			else if(sel == 3) {				//쇼핑
				if(log == -1)
				{
					System.out.println("로그인 후 사용 가능합니다.");
				}
				while(true)
				{
					System.out.println("상품 목록");
						
					for(int i=0;i<items.length;i++)
					{
						System.out.println("["+(i+1)+"] "+items[i]);
					}
					
					System.out.println("상품을 선택하여라(번호 선택)");
					int num = sc.nextInt();
					System.out.println("[4]뒤로가기");
					
					if(num == 4)
					{
						break;
					}
					
					jang[count][0] = log;
					jang[count][1] = num;
					
					count++;
				}
				
			}
			else if(sel == 4) {				//장바구니
				int apple = 0;
				int banana = 0;
				int berry = 0;
				
				for(int i=0; i<count; i++)
				{
					if(jang[i][0] == log)
					{
						if(jang[i][1] == 1)
						{
							apple++;
						}
						else if(jang[i][1] == 2)
						{
							banana++;
						}
						else if(jang[i][1] == 3)
						{
							berry++;
						}
					}
				}
				System.out.println(items[0] + " : " + apple + "개");
				System.out.println(items[1] + " : " + banana + "개");
				System.out.println(items[2] + " : " + berry + "개");

			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}

	}
}
