class User {
    static int id = 100;
    private String name;
    private double time;
    int userId;

    User(String name, double time) {
        id++; 
		userId = id;
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
