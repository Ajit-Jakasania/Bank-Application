import java.util.Scanner;

public class BankFunc {

	public static void main(String[] args) {
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		Bank b[] = new Bank[10];
		int ch;
		while (true) {
			System.out.println("*************************************");
			System.out.println("1-------Create Account");
			System.out.println("2-------Deposit Money");
			System.out.println("3-------Withdraw Money");
			System.out.println("4-------Show all bank data");
			System.out.println("5-------Show particular bank data");
			System.out.println("6-------Transfer Money");
			System.out.println("7-------Account History");
			System.out.println("8-------Change PIN");
			System.out.println("9-------Exit");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				b[cnt] = new Bank();
				b[cnt].getData();
				cnt++;
				break;
			case 2:
				System.out.println("----------------");
				System.out.println("Deposite Money");
				System.out.println("Enter your account number:");
				int num2 = sc.nextInt();
				System.out.println("Enter your personal PIN:");
				int num3 = sc.nextInt();
				int num5 = 0, flag = 0;
				for (int i = 0; i < cnt; i++) {
					if (num2 == b[i].getAcc() && num3 == b[i].getPIN()) {
						num5 = i;
					} else {
						flag++;
					}
				}
				if (flag == cnt) {
					System.out.println("Error Wrong account number or PIN!");
					System.out.println("Check your account number or PIN again.");
				} else {
					b[num5].depositeMoney();
				}
				break;
			case 3:
				System.out.println("------------------");
				System.out.println("Withdraw Money");
				System.out.println("Enter your account number:");
				int num = sc.nextInt();
				System.out.println("Enter your personal PIN:");
				int num1 = sc.nextInt();
				int num6 = 0, flag1 = 0;
				for (int i = 0; i < cnt; i++) {
					if (num == b[i].getAcc() && num1 == b[i].getPIN()) {
						num6 = i;
					} else {
						flag1++;
					}
				}
				if (flag1 == cnt) {
					System.out.println("Error Wrong account number or PIN!");
					System.out.println("Check your account number or PIN again.");
				} else {
					b[num6].withdrawMoney();
				}

				break;
			case 4:
				System.out.println("---------------------");
				System.out.println("Name\tAcc No.\tAmount($)");
				for (int i = 0; i < cnt; i++) {
					b[i].showData();
				}
				break;
			case 5:
				System.out.println("------------------");
				System.out.println("Show Bank Data");
				System.out.println("Enter your account number:");
				int num7 = sc.nextInt();
				System.out.println("Enter your personal PIN:");
				int num8 = sc.nextInt();
				int num9 = 0, flag2 = 0;
				for (int i = 0; i < cnt; i++) {
					if (num7 == b[i].getAcc() && num8 == b[i].getPIN()) {
						num9 = i;
					} else {
						flag2++;
					}
				}
				if (flag2 == cnt) {
					System.out.println("Error Wrong account number or PIN!");
					System.out.println("Check your account number or PIN again.");
				} else {
					b[num9].searchData();
				}
				break;
			case 6:
				System.out.println("-------------");
				System.out.println("Transfer Money");
				System.out.println("Enter your account number:");
				int num10 = sc.nextInt();
				System.out.println("Enter your personal PIN:");
				int num11 = sc.nextInt();
				int num12 = 0, flag3 = 0;
				for (int i = 0; i < cnt; i++) {
					if (num10 == b[i].getAcc() && num11 == b[i].getPIN()) {
						num12 = i;
					} else {
						flag3++;
					}
				}
				if (flag3 == cnt) {
					System.out.println("Error Wrong account number or PIN!");
					System.out.println("Check your account number or PIN again.");
				} else {
					System.out.println("Enter the transfer Account Number:");
					int transacc = sc.nextInt();
					b[num12].transferMoney();
					int transamt = b[num12].getTransferAmt();
					int num13 = 0, flag4 = 0;
					for (int i = 0; i < cnt; i++) {
						if (transacc == b[i].getAcc()) {
							num13 = i;
						} else {
							flag4++;
						}
					}
					if (flag4 == cnt) {
						System.out.println("Error Wrong account number or PIN!");
						System.out.println("Check your account number or PIN again.");
					} else {
						b[num13].addTransfer(transamt);
					}
				}
				break;
				
			case 7: 
					
					break;
			
			case 8:
					System.out.println("-------------");
					System.out.println("Change PIN");
					System.out.println("Enter your old PIN:");
					int checkOldPin=sc.nextInt();
					int tempAcc=0, flagCheck=0;
					for(int i=0;i<cnt;i++)
					{
						if (checkOldPin == b[i].getPIN()) {
							tempAcc = i;
						} else {
							flagCheck++;
						}
					}
					if(flagCheck==cnt)
					{
						System.out.println("Error Wrong PIN Entered!");
						System.out.println("Check your PIN again.");
					}
					else
					{
						int newPin=0 , confirmPin=1;
						while(newPin != confirmPin)
						{
							System.out.println("Enter new 4 digit PIN: ");
							newPin = sc.nextInt();
							System.out.println("Confirm PIN :");
							confirmPin = sc.nextInt();
							if(newPin!=confirmPin)
							{
								System.out.println("------------------");
								System.out.println("PIN not matching!");
								System.out.println("Please Try Again");
								System.out.println("-----------------");
							}
						}
						b[tempAcc].changePin(newPin);
						System.out.println("------------");
						System.out.println("PIN Successfully changed!");
						System.out.println("New PIN : "+b[tempAcc].getPIN());
					}
					break;
					
			case 9:
				System.exit(0);
				break;
			}
		}
	}
}
