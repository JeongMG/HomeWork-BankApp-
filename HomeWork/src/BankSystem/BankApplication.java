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
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.���� ");
			System.out.println("----------------------------------------");
			System.out.print("���� >> ");
			
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
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
			}
		}
	}
	
	private static void createAccount() {
		System.out.println("------");
		System.out.println("���� ����");
		System.out.println("------");
		
		String ano = readStr("���¹�ȣ : ");
		String owner = readStr("������ : ");
		int balance = readInt("�ʱ��Աݾ� : ");
		Account acnt = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = acnt;
				break;
			}
		}
		System.out.println("��� : ���°� �����Ǿ����ϴ�.");
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
		System.out.println("����");
		System.out.println("------");
	
		String searchAccountNo = readStr("���¹�ȣ : ");
		int credit = readInt("���ݾ� : ");
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null && searchAccountNo.equals(accountArray[i].getAno())) {
				int AmountToDeposit = accountArray[i].getBalance() + credit;
				accountArray[i].setBalance(AmountToDeposit);
				System.out.println("��� : ������ �����Ǿ����ϴ�.");
			}
		}
	}	
	
	private static void withdraw() {
		System.out.println("------");
		System.out.println("���");
		System.out.println("------");
		
		String searchAccountNo = readStr("���¹�ȣ : ");
		int credit = readInt("��ݾ� : ");
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null && searchAccountNo.equals(accountArray[i].getAno())) {
				if(accountArray[i].getBalance() >= credit) {
					int AmountToWithdrawal = accountArray[i].getBalance() - credit;
					accountArray[i].setBalance(AmountToWithdrawal);
					System.out.println("��� : ����� �����Ǿ����ϴ�.");
				} else if (accountArray[i].getBalance() < credit) {
					System.out.println("��� : ��� ���ɾ��� �ʰ��Ͽ����ϴ�.");
				} else {
					System.out.println("�߸��� �Է��� �Ͽ����ϴ�.");
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
				System.out.println("���ڸ� �Է����ֽʽÿ�.");
			}
		}		
		return result;
	}
}
