public class Faculty extends Employee {

    public static String LECTURER = "Lecturer";
    public static String ASSISTANT_PROFESSOR = "Assistant Professor";
    public static String ASSOCIATE_PROFESSOR = "Associate Professor";
    public static String PROFESSOR = "Professor";

    protected String officeHours;
    protected String rank;

	// value constructor for default values
    public Faculty(String name) {
        this(name, "9-5PM", "Employee");
    }

	// second value constructor for more data
    public Faculty(String name, String officeHours, String rank) {
        super(name);
        this.officeHours = officeHours;
        this.rank = rank;
    }

	// setters and getters
    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

	// printer
    @Override
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}
