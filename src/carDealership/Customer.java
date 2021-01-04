package carDealership;

public class Customer extends Person{

    private int cash;
    private int creditRaiting;

    public Customer(String name, int cash, int creditRaiting) {
        super(name);
        this.cash = cash;
        this.creditRaiting = creditRaiting;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCreditRaiting() {
        return creditRaiting;
    }

    public void setCreditRaiting(int creditRaiting) {
        this.creditRaiting = creditRaiting;
    }

    public void purchaseCar(Vehicle vehicle, Employee employee, boolean finance) {
        if (finance) {
            System.out.println("Hey there! I'm looking to finance a " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("Hello. I am looking to buy a " + vehicle.getMake() + " " + vehicle.getModel() + " outright in ca$h.");
        }

        employee.handleCustomer(this, vehicle, finance);
    }

}
