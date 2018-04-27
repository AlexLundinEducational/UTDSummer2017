public class Staff extends Employee {

    protected String title;

	// value constructor for default values
    public Staff(String name) {
        this(name, "none");

    }

	// value constructor for determined values
    public Staff(String name, String title) {
        super(name);
        this.title = title;
    }

	// getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	// printer
    @Override
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}