/*
 * # ���θ� [��ٱ���]
 * 1. �α��� �� ���� �޴��� �����ϸ�, ������ ���� ��ǰ����� �����ش�.
 * 	1) ���
 *  2) �ٳ���
 *  3) ����
 * 2. ��ȣ�� ������ ��ǰ�� ��ٱ��Ͽ� ���� �� �ִ�.
 * 3. �α��� ȸ���� �ε��� ��ȣ�� �� ���� ù��° ���� �����Ѵ�.
 * 4. �ش� ȸ���� ������ ��ǰ�� �ε��� ��ȣ�� �� ���� �ι�° ���� �����Ѵ�.
 * ��)
 * {
 * 		{0, 1},				qwerȸ�� 			> �������
 * 		{1, 2},				javakingȸ�� 		> �ٳ�������
 * 		{2, 1},				abcdȸ��			> �������
 * 		{0, 3},				qwerȸ��			> ���ⱸ��
 * 		...
 * }
 */
//�̰� ���� �ȉ�


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
		
		String[] items = {"���", "�ٳ���", "����"};
		
		int log = -1;
		int check = -1;
		
		while(true) {
			
			System.out.println("[MEGA MART]");
			System.out.println("[1]�� �� ��");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]��     ��");
			System.out.println("[4]��ٱ���");
			System.out.println("[0]��     ��");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {			//�α���
				if(log != -1)
				{
					System.out.println(ids[check] + "���� �̹� �α������Դϴ�.");
					System.out.println("�α� �ƿ� �� ������ּ���");
				}
				else
				{
					System.out.println("���̵� �Է��ϼ���");
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
						System.out.println("���̵� Ȯ�����ּ���");
					}
					else
					{
						System.out.println("�н����带 �Է����ּ���");
						String pw = sc.next();
						
						for(int i=0;i<3;i++)
						{
							if(pw.equals(pws[i]))
							{
								System.out.println(ids[check]+"�� �α��� �Ǿ����ϴ�.");
								log = check;
							}
						}
					}
				}
			}
			else if(sel == 2) {				//�α� �ƿ�
				if(log == -1)
				{
					System.out.println("�α׾ƿ� �����Դϴ�.");
				}
				else if(log != -1)
				{
					System.out.println(ids[check] + "���� �α׾ƿ��Ǿ����ϴ�.");
					log = -1;
				}
			}
			else if(sel == 3) {				//����
				if(log == -1)
				{
					System.out.println("�α��� �� ��� �����մϴ�.");
				}
				while(true)
				{
					System.out.println("��ǰ ���");
						
					for(int i=0;i<items.length;i++)
					{
						System.out.println("["+(i+1)+"] "+items[i]);
					}
					
					System.out.println("��ǰ�� �����Ͽ���(��ȣ ����)");
					int num = sc.nextInt();
					System.out.println("[4]�ڷΰ���");
					
					if(num == 4)
					{
						break;
					}
					
					jang[count][0] = log;
					jang[count][1] = num;
					
					count++;
				}
				
			}
			else if(sel == 4) {				//��ٱ���
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
				System.out.println(items[0] + " : " + apple + "��");
				System.out.println(items[1] + " : " + banana + "��");
				System.out.println(items[2] + " : " + berry + "��");

			}
			else if(sel == 0) {
				System.out.println("���α׷� ����");
				break;
			}
			
		}

	}
}
