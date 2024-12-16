class Student {
    private String id;
    private String name;
    private double marks;
    private String rank;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = determineRank(marks);
    }

    private String determineRank(double marks) {
        if (marks >= 0 && marks <= 5) return "Fail";
        else if (marks <= 6.5) return "Average";
        else if (marks <= 7.5) return "Good";
        else if (marks <= 8.5) return "Very Good";
        else return "Excellent";
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String getRank() { return rank; }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}