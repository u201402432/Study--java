package Lab_1;
import java.util.* ;

public class zoo implements animal {
	
	private String name ;
	private int age ;
	private String color ;
	private Scanner sc ;
	
	public void run() {
		
		System.out.println("동물의 이름을 입력하세요 : ");
		sc = new Scanner(System.in) ;
		this.name = sc.next();
		
		try{
		if(this.name.length()>10)
			throw new Exception() ;
		}catch(Exception e){
			System.out.println("이름을 너무 길게 입력했습니다.");
		}

		System.out.println("동물의 나이를 입력하세요 : ");
		this.age = sc.nextInt();
		System.out.println("동물의 색을 입력하세요 : ");
		this.color = sc.next();
		
	}
	
	public void printAnimal(){
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		System.out.println("색 : "+this.color);
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
