package BankSystem;
import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int num = 0;
	
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
			System.out.println("----------------------------------------");
			System.out.print("선택 >> ");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			} else {
				System.out.println("잘못된 값을 입력하였습니다.");
			}
		}
	}
	
	private static void createAccount() {
		System.out.println("------");
		System.out.println("계좌 생성");
		System.out.println("------");
		
		String ano = readStr("계좌번호 : ");
		String owner = readStr("계좌주 : ");
		int balance = readInt("초기입금액 : ");
		Account acnt = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = acnt;
				break;
			}
		}
		System.out.println("결과 : 계좌가 생성되었습니다.");
	}	
	
	private static void accountList() {
		int cnt = 0;
		
		for(Account acnt : accountArray) {
			if(acnt != null) {
				System.out.printf("%s %s     %d\n", accountArray[cnt].getAno(), accountArray[cnt].getOwner(), accountArray[cnt].getBalance());
				cnt++;
			}
		}
	}	
	
	private static void deposit() {
		System.out.println("------");
		System.out.println("예금");
		System.out.println("------");
	
		String searchAccountNo = readStr("계좌번호 : ");
		int credit = readInt("예금액 : ");
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null && searchAccountNo.equals(accountArray[i].getAno())) {
				int AmountToDeposit = accountArray[i].getBalance() + credit;
				accountArray[i].setBalance(AmountToDeposit);
				System.out.println("결과 : 예금이 성공되었습니다.");
			}
		}
	}	
	
	private static void withdraw() {
		System.out.println("------");
		System.out.println("출금");
		System.out.println("------");
		
		String searchAccountNo = readStr("계좌번호 : ");
		int credit = readInt("출금액 : ");
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null && searchAccountNo.equals(accountArray[i].getAno())) {
				if(accountArray[i].getBalance() >= credit) {
					int AmountToWithdrawal = accountArray[i].getBalance() - credit;
					accountArray[i].setBalance(AmountToWithdrawal);
					System.out.println("결과 : 출금이 성공되었습니다.");
				} else if (accountArray[i].getBalance() < credit) {
					System.out.println("결과 : 출금 가능액을 초과하였습니다.");
				} else {
					System.out.println("잘못된 입력을 하였습니다.");
				}
			}
		}
	}	
	
	private static Account findAccount(String ano) {
		return null;
	}	
	
	static Scanner scn = new Scanner(System.in);
	private static String readStr(String msg) {
		System.out.print(msg);
		return scn.nextLine();
	}	
	
	private static int readInt(String msg) {
		System.out.print(msg);
		int result = 0;	
		
		while (true) {
			String val = scn.nextLine();
			try {
				result = Integer.parseInt(val);
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력해주십시오.");
			}
		}		
		return result;
	}
}
