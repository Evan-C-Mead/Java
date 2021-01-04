package carDealership;

public class Employee extends Person{

    public Employee(String name) {
        super(name);
    }

    private String runCreditHistory(Customer customer) {
        if (customer.getCreditRaiting() <= 500) {
            return "You have bad credit.";
        } else {
            return "You have good credit.";
        }
    }

    public void handleCustomer(Customer customer, Vehicle vehicle, boolean finance) {
        if (finance = true) {
            String credit = runCreditHistory(customer);
            if (credit.equals("You have good credit.")) {
                System.out.println("We ran your credit and it looks like you can finance a new vehicle!");
            } else {
                System.out.println("You don't have the credit score to purchase a new vehicle, but you do qualify for a used vehicle.");
            }
        }

        if (customer.getCash() >= vehicle.getPrice()) {
            System.out.println("No need for financing! Enjoy your " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("You must finance...");
        }
    }

}
