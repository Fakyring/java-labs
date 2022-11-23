final class Customer {
    private String firstName, secondName;
    private int age;
    private Address address;
    public Customer MATURE_UNKNOWN_CUSTOMER, NOT_MATURE_UNKNOWN_CUSTOMER;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public Customer(Customer customer) {
        this.firstName = customer.firstName;
        this.secondName = customer.secondName;
        this.age = customer.age;
        this.address = customer.address;
    }

    public Customer() {
        firstName = "Ivan";
        secondName = "Ivanov";
        age = 25;
        address = new Address();
    }
}
