
public class Test2 {

	public static void main(String[] args) {

		System.out.println("------- Taxi -> Car 업캐스팅 -------");
		// Taxi -> Car 타입으로 업캐스팅
		// 호출 가능한 메서드 : 2개
//		Car car = new Taxi(240);
//		// 업캐스팅 후에는 공통 메서드만 호출 가능
//		car.speedUp(50);
//		car.speedDown(100);
		
		// 형변환 가능 여부 확인 후 형변환 수행하기
		Taxi taxi = new Taxi(240);
		
		// Taxi -> Car 로 형변환 가능 여부 판별
		Car car = null; // 로컬변수 Car 타입 선언 => null 값으로 초기화
		
		if(taxi instanceof Car) {
			car = taxi;
			// 업캐스팅 후에는 공통 메서드만 호출 가능
			car.speedUp(50);
			car.speedDown(100);
		}
		
		
		System.out.println("------- Car -> Taxi 다운캐스팅 --------");
		// 업캐스팅 후 다시 다운캐스팅 시 호출 가능한 메서드 : ?개
//		Taxi taxi2 = car; // 오류 발생! 명시적 형변환 필수
//		Taxi taxi2 = (Taxi)car;
//		taxi2.speedUp(100);
//		taxi2.speedDown(100);
//		taxi2.lift();
//		taxi2.drop();
		
		// car -> Taxi 로 형변환 가능 여부 판별
		if(car instanceof Taxi) {
			Taxi taxi2 = (Taxi)car;
			taxi2.speedUp(100);
			taxi2.speedDown(100);
			taxi2.lift();
			taxi2.drop();
		}
		
		System.out.println("------- Truck -> Car 업캐스팅 -------");
		// Truck -> Car 타입으로 업캐스팅
		// 호출 가능한 메서드 : 2개
//		car = new Truck(240);
//		car.speedUp(50);
//		car.speedDown(100);
		
		
		Truck truck = new Truck(240);
		// truck -> Car 타입으로 업캐스팅 가능 여부 판별
		if(truck instanceof Car) {
			car = truck;
			car.speedUp(50);
			car.speedDown(100);
		}
		
		
		System.out.println("------- Car -> Truck 다운캐스팅 -------");
		
		if(car instanceof Truck) {
			truck = (Truck)car;
			truck.speedUp(100);
			truck.speedDown(100);
			truck.dump();
		}
		
		
	}

}

// 슈퍼클래스 타입 Car 클래스 정의
// 멤버변수 : 속력(speed, 정수), 최대속력(maxSpeed, 정수)
// 생성자 : 최대속력을 전달받아 초기화
// 메서드 : 1) speedUp() - 파라미터 있음(speed, 정수) => "Car 속력 증가!" 출력
//                       - 리턴값 없음
//          2) speedDown() - 파라미터 있음(speed, 정수) => "Car 속력 감소!" 출력
//					       - 리턴값 없음
class Car {
	int speed;
	int maxSpeed;
	
//	public Car() {}
	
	public Car(int maxSpeed) {
		super();
		this.maxSpeed = maxSpeed;
	}
	
	public void speedUp(int speed) {
		System.out.println("Car 속력 증가!");
	}
	
	public void speedDown(int speed) {
		System.out.println("Car 속력 감소!");
	}
	
}

// Taxi 클래스 정의 - Car 클래스 상속
// 메서드 오버라이딩
// 1) speedUp() : "Taxi 속력 증가!" 출력
// 2) speedDown() : "Taxi 속력 감소!" 출력
// 메서드 정의
// lift() : "손님 승차!" 출력 => 파라미터, 리턴값 없음
// drop() : "손님 하차!" 출력 => 파라미터, 리턴값 없음
class Taxi extends Car {
	
	public Taxi(int maxSpeed) {
		super(maxSpeed);
	}

	@Override
	public void speedUp(int speed) {
		System.out.println("Taxi 속력 증가!");
	}

	@Override
	public void speedDown(int speed) {
		System.out.println("Taxi 속력 감소!");
	}
	
	public void lift() {
		System.out.println("손님 승차!");
	}
	
	public void drop() {
		System.out.println("손님 하차!");
	}
	
}

// Truck 클래스 정의 - Car 클래스 상속
// 메서드 오버라이딩
// 1) speedUp() : "Truck 속력 증가!" 출력
// 2) speedDown() : "Truck 속력 감소!" 출력
// 메서드 정의
// dump() : "짐칸의 모든 내용물 쏟아붓기!" 출력
class Truck extends Car {

	public Truck(int maxSpeed) {
		super(maxSpeed);
	}

	@Override
	public void speedUp(int speed) {
		System.out.println("Truck 속력 증가!");
	}

	@Override
	public void speedDown(int speed) {
		System.out.println("Truck 속력 감소!");
	}
	
	public void dump() {
		System.out.println("짐칸의 모든 내용물 쏟아붓기!");
	}
	
}













