import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Daniel on 11/6/2015.
 */
public class CarComparator
{
    static ArrayList<Car> carArray = new ArrayList<Car>();
    static Car [][] sortedCarArrays;

    public static void main(String[] args)
    {
        try {
            initCarArray("input.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        sortedCarArrays = new Car[6][carArray.size()];

        Scanner in = new Scanner(System.in);
        String choice;


        printCarArray();

        do {
            choice = in.next();

            switch (choice)
            {
                case "mileage":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                case "price":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                case "cylinders":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                case "yearBuilt":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                case "horsePower":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                case "fuelCapacity":
                    Collections.sort(carArray, new myComparator(choice));
                    break;
                default:
                    System.out.println("Invalid input");

            }

            printCarArray();

        }while (!choice.equals("q"));

    }

    static void initCarArray(String input) throws IOException
    {
        String name;
        int horsePower, cylinders, yearBuilt, price, fuelCapacity, mileage;
        Scanner in = new Scanner(new File(input));

        int numOfCars = in.nextInt();

        for (int i = 0; i < numOfCars; i++)
        {
            in.nextLine();
            name = in.nextLine();
            mileage = in.nextInt();
            price = in.nextInt();
            yearBuilt = in.nextInt();
            cylinders = in.nextInt();
            fuelCapacity = in.nextInt();
            horsePower = in.nextInt();

            carArray.add(new Car(name, mileage, price, yearBuilt, cylinders, fuelCapacity, horsePower));

        }
    }

    static void printCarArray()
    {
        System.out.println("Here's the car list: ");
        for  (Car mycar : carArray)
        {
            System.out.println(mycar.getName());
        }
    }

}
