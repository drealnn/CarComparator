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
    static String [] sortingOptions = {"mileage", "price", "cylinders", "yearBuilt", "horsePower", "fuelCapacity"};

    public static void main(String[] args)
    {
        try {
            initCarArray("INPUTs.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Input a new file name: ");

            Scanner input = new Scanner(System.in);

            String filename = input.next();



            try {
                initCarArray(filename);
            }catch (IOException f)
            {
                f.printStackTrace();
                return;
            }
        }

        sortedCarArrays = new Car[6][carArray.size()];

       // printCarArray();

        for (int i = 0; i < 6; i++)
        {
            Collections.sort(carArray, new myComparator(sortingOptions[i]));
            sortedCarArrays[i] = carArray.toArray(new Car[carArray.size()]);
        }

        Scanner in = new Scanner(System.in);
        String choice;




        do {

            printMenu(0);

            choice = in.next();

            switch (choice)
            {
                case "1":
                    //Collections.sort(carArray, new myComparator(choice));
                    printMenu(1);
                    choice = in.next();

                    if (choice.equals("1")) {
                        printCarArray(sortedCarArrays[0]);
                        break;
                    }
                    else if (choice.equals("2")) {
                        // call range function
                        int min = getMin(in);
                        int max = getMax(in);
                        printRange(min, max, sortedCarArrays[0], "mileage");
                        break;
                    }
                    else if (choice.equals("q"))
                        break;
                    else
                        System.out.println("Invalid Input");


                    break;

                case "2":
                    //Collections.sort(carArray, new myComparator(choice));
                    printMenu(1);
                    choice = in.next();

                    if (choice.equals("1")) {
                        printCarArray(sortedCarArrays[1]);
                        break;
                    }
                    else if (choice.equals("2")) {
                        // call range function
                        int min = getMin(in);
                        int max = getMax(in);
                        printRange(min, max, sortedCarArrays[1], "price");
                        break;
                    }
                    else if (choice.equals("q"))
                        break;
                    else
                        System.out.println("Invalid Input");
                    break;

                case "3":
                    //Collections.sort(carArray, new myComparator(choice));
                    printCarArray(sortedCarArrays[2]);
                    break;

                case "4":
                    //Collections.sort(carArray, new myComparator(choice));
                    printMenu(1);
                    choice = in.next();

                    if (choice.equals("1")) {
                        printCarArray(sortedCarArrays[3]);
                        break;
                    }
                    else if (choice.equals("2")) {
                        // call range function
                        int min = getMin(in);
                        int max = getMax(in);
                        printRange(min, max, sortedCarArrays[3], "year");
                        break;
                    }
                    else if (choice.equals("q"))
                        break;
                    else
                        System.out.println("Invalid Input");
                    break;

                case "5":
                    //Collections.sort(carArray, new myComparator(choice));
                    printCarArray(sortedCarArrays[4]);
                    break;

                case "6":
                    //Collections.sort(carArray, new myComparator(choice));
                    printCarArray(sortedCarArrays[5]);
                    break;

                case "q":
                    break;
                default:
                    System.out.println("Invalid input");

            }

            //printCarArray();

        }while (!choice.equals("q"));

        in.close();

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

        in.close();
    }

    static void printMenu(int type)
    {
        if (type == 0)
        {
            System.out.printf("Select one of the following options:\n1-Sort by Mileage\n2-Sort by Price\n3-Sort by Number of Cylinders\n4-Sort by Year Built\n5-Sort by Horse Power\n" +
                    "6-Sort by Fuel Capacity\nq-quit\n\n");
        }
        else if (type == 1)
            System.out.printf("1-Print entire list\n2-Specify range\nq-quit\n\n");
    }

    static void printCarArray()
    {
        System.out.println("Here's the car list: ");
        for  (Car mycar : carArray)
        {
            printCar(mycar);
        }
    }

    static void printCarArray(Car [] myCarArray)
    {
        System.out.println("Here's the car list: ");
        for  (Car mycar : myCarArray)
        {
            printCar(mycar);
        }
    }

    static void printCar(Car mycar)
    {
        System.out.printf("Name: %s\nMileage: %s\nPrice: %s\nYear Built: %s\nCylinders: %s\nFuel Capacity: %s\nHorse Power: %s\n\n",
                mycar.getName(), mycar.getMileage(), mycar.getPrice(), mycar.getYearBuilt(), mycar.getCylinders(), mycar.getFuelCapacity(), mycar.getHorsePower());
    }

    static int getMax(Scanner in)
    {

        System.out.println("Provide a max value: ");
        int max = in.nextInt();

        return max;
    }

    static int getMin(Scanner in)
    {

        System.out.println("Provide a min value: ");
        int max = in.nextInt();

        return max;
    }

    static void printRange(int min, int max, Car [] myCarArray, String type)
    {
        if (min > max)
        {
            System.out.println("Specified minimum is greater than the maximum");
            return;
        }

        switch (type)
        {
            case "year":
                for (Car mycar : myCarArray)
                {
                    if (mycar.getYearBuilt() >= min && mycar.getYearBuilt() <= max )
                        printCar(mycar);
                }
                break;
            case "mileage":
                for (Car mycar : myCarArray)
                {
                    if (mycar.getMileage() >= min && mycar.getMileage() <= max )
                        printCar(mycar);
                }
                break;
            case "price":
                for (Car mycar : myCarArray)
                {
                    if (mycar.getPrice() >= min && mycar.getPrice() <= max )
                        printCar(mycar);
                }
                break;
            default:
                System.out.println("Unspecified range type");
        }
    }

}
