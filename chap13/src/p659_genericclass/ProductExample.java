package p659_genericclass;

public class ProductExample {

	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setkind(new Tv());
		product1.setModel("스마트Tv");
		Tv tv = product1.getkind();
		String tvModel = product1.getModel();
		
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setkind(new Car());
		product2.setModel("디젤");
		Car car = product2.getkind();
		String carModel = product2.getModel();
		

	}

}
