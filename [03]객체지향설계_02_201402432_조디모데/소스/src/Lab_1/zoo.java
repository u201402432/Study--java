package Lab_1;
import java.util.* ;

public class zoo implements animal {
	
	private String name ;
	private int age ;
	private String color ;
	private Scanner sc ;
	
	public void run() {
		
		System.out.println("������ �̸��� �Է��ϼ��� : ");
		sc = new Scanner(System.in) ;
		this.name = sc.next();
		
		try{
		if(this.name.length()>10)
			throw new Exception() ;
		}catch(Exception e){
			System.out.println("�̸��� �ʹ� ��� �Է��߽��ϴ�.");
		}

		System.out.println("������ ���̸� �Է��ϼ��� : ");
		this.age = sc.nextInt();
		System.out.println("������ ���� �Է��ϼ��� : ");
		this.color = sc.next();
		
	}
	
	public void printAnimal(){
		System.out.println("�̸� : "+this.name);
		System.out.println("���� : "+this.age);
		System.out.println("�� : "+this.color);
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public int age() {
		return this.age;
	}

	@Override
	public String color() {
		return this.color ;
	}

}
