import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {
	
	
	
	@SuppressWarnings("resource")
	private static CarPark inputreader(String[] args, List<Car> cars) throws FileNotFoundException {
		
		InputStreamReader isr;
		Scanner sc;
		if(args[0].contentEquals("inputs.txt")) {
			File f=new File(args[0]);
			sc=new Scanner(f);
			
		}
		else {
			isr=new InputStreamReader(System.in);
			sc=new Scanner(isr);
		}
		
		int park_h, park_w;
		String line=sc.nextLine();
		String [] pair=line.split("\t");
		park_h=Integer.parseInt(pair[0]);
		park_w=Integer.parseInt(pair[1]);
		
		int numofcars=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<numofcars;++i) {
			pair=sc.nextLine().split("\t");
			int car_h = Integer.parseInt(pair[0]);
			int car_w=Integer.parseInt(pair[1]);;
			
			if((park_h>park_w && car_w>car_h) || (park_w>park_h && car_h>car_w)) {
				int temp= car_h;
				car_h=car_w;
				car_w=temp;	
			}
			
			cars.add(new Car(car_h, car_w, i+1));
		}
		return new CarPark(park_h, park_w);
		
	}

	
	
	public static void main(String[] args) {
		try {
			
			List<Car> cars=new ArrayList<Car>();
		
			CarPark carpark=inputreader(args, cars);
			
			Collections.sort(cars, Collections.reverseOrder());
			
			carpark.park(cars.get(0), new Position(0,0), true, cars);
			
			carpark.print();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
