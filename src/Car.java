import java.util.Comparator;

/**
 * Created by Daniel on 11/6/2015.
 */
public class Car {
    String name;
    int mileage, price, yearBuilt, cylinders, horsePower, fuelCapacity;

    public Car(String name, int mileage, int price, int yearBuilt, int cylinders, int horsePower, int fuelCapacity) {
        this.name = name;
        this.mileage = mileage;
        this.price = price;
        this.yearBuilt = yearBuilt;
        this.cylinders = cylinders;
        this.horsePower = horsePower;
        this.fuelCapacity = fuelCapacity;
    }

    public Car()
    {
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
                return o1.getCylinders() - o2.getCylinders();
            case "yearBuilt":
                return o1.getYearBuilt() - o2.getYearBuilt();
            case "horsePower":
                return o1.getHorsePower() - o2.getHorsePower();
            case "fuelCapacity":
                return o1.getFuelCapacity() - o2.getFuelCapacity();
            default:
                System.out.println("Invalid comparison type");
                return 0;

        } // end switch

    }
}

