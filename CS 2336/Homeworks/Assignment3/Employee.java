public class Employee extends Person {

    protected double salary;
    protected String office;
    protected MyDate dateHired;

	
	// value constructor, calls the one below
    public Employee(String name) {
        this(name, 0, "none", new MyDate());
    }

	// second value contructor for more data
    public Employee(String name, double salary, String office, MyDate dateHired) {
        super(name);
        this.salary = salary;
        this.office = office;
        this.dateHired = dateHired;
    }

	// setters and getters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

	// overriden toString for printing
    @Override
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}
