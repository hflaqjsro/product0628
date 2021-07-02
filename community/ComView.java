package javaexp.z0625_project;

import java.util.Scanner;

public class ComView {
	public static void main(String[] args) {
		ComController ComCon = new ComController();
		do{
			System.out.println("# 커뮤니티 홈입니다 :) #");
			System.out.println("[0]게시글보기 [1]질문작성 [2]MY활동내역 [3]HOT키워드");
			Scanner sc = new Scanner(System.in);
			System.out.println("메뉴를 선택해주세요");
			String menuSelect = sc.nextLine();
			if(menuSelect.equals("0")||menuSelect.equals("게시글보기")){
				System.out.println("#게시글#");
				ComCon.loadPost();
			}else if(menuSelect.equals("1")||menuSelect.equals("질문작성")) {
				//String title, String text, String tag, boolean check01, boolean check02, boolean check03
				System.out.print("제목 입력 : ");
				String title = sc.nextLine();
				System.out.print("내용 입력 : ");
				String text = sc.nextLine();
				System.out.print("태그 입력 [ex) #취업준비 #면접준비]: ");
				String tag = sc.nextLine();
				ComCon.post(new Post(title, text, tag), new Model());
				
			}else if(menuSelect.equals("2")||menuSelect.equals("MY활동내역")) {
				System.out.println("[1]프로필수정 [2]내가쓴글보기");
				String menuSelect02 = sc.nextLine();
				if(menuSelect02.equals("1")||menuSelect02.equals("프로필수정")) {
					
				}else if(menuSelect02.equals("2")||menuSelect02.equals("내가쓴글보기")) {
					ComCon.loadPost();
				}else {
					System.out.println("해당메뉴가 없습니다.");
				}
			}else {
				System.out.println("해당 메뉴가 없습니다.");
			}
		}while(true);
		
		
	}
}
