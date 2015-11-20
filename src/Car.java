import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Daniel on 11/6/2015.
 */
public class Car {
    String name;
    int mileage, price, yearBuilt, cylinders, horsePower, fuelCapacity;
    int[] rankArray;
    int totalRank;
    Map<String, Integer> rankMap;

    public Car(String name, int mileage, int price, int yearBuilt, int cylinders, int horsePower, int fuelCapacity) {
        this.name = name;
        this.mileage = mileage;
        this.price = price;
        this.yearBuilt = yearBuilt;
        this.cylinders = cylinders;
        this.horsePower = horsePower;
        this.fuelCapacity = fuelCapacity;
        rankArray = new int[6];
        rankMap = new HashMap<String, Integer>();
        totalRank = 0;

    }

    public Car()
    {
        rankArray = new int[6];
        rankMap = new HashMap<String, Integer>();
        totalRank = 0;
    }

    public void setRank(String type, int rank)
    {
        rankMap.put(type, rank);
    }
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int calculateTotalRank()
    {
        /*
        for (int i = 0; i < rankMap.size(); i++)
        {

            if (rankArray[i] != 0)
                totalRank += rankArray[i];
        }

        return totalRank;

        */

        Iterator<Integer> i = rankMap.values().iterator();
        while (i.hasNext())
        {
            totalRank += i.next();
        }

        return totalRank;
    }

    public int getRank(String type)
    {
        return rankMap.get(type);
    }

    public int getTotalRank()
    {
        return totalRank;
    }
}

class myComparator implements Comparator<Car>
{
    String comparisonType;

    public myComparator(String comparisonType)
    {
        this.comparisonType = comparisonType;
    }

    @Override
    public int compare(Car o1, Car o2)
    {
        switch (comparisonType)
        {
            case "mileage":
                return o1.getMileage() - o2.getMileage();
            case "price":
                return o1.getPrice() - o2.getPrice();
            case "cylinders":
                return o2.getCylinders() - o1.getCylinders();
            case "yearBuilt":
                return o2.getYearBuilt() - o1.getYearBuilt();
            case "horsePower":
                return o2.getHorsePower() - o1.getHorsePower();
            case "fuelCapacity":
                return o2.getFuelCapacity() - o1.getFuelCapacity();
            default:
                System.out.println("Invalid comparison type");
                return 0;

        } // end switch

    }
}

