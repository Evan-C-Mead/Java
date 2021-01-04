package carDealership;

public class CarDealership {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Dude", 8000, 735);
        Customer customer2 = new Customer("Guy", 1000, 498);

        Employee employee1 = new Employee("Sales Guy");

        Vehicle vehicle1 = new Vehicle(14000, "Honda", "Fit", "Hatchback");
        Vehicle vehicle2 = new Vehicle(8000, "Volkswagen", "Passat", "Sedan");
        Vehicle vehicle3 = new Vehicle(700, "Ford", "Mustang", "Sports Car");

        customer1.purchaseCar(vehicle1, employee1, false);
        customer2.purchaseCar(vehicle2, employee1, true);
        customer2.purchaseCar(vehicle3, employee1, true);
    }

}
