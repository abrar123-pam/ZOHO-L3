class User {
    private String vehicleNumber;
    private String vehicleType;
    private String vipUser;
    private int userId;
    private String start;
    private String end;
    
    public User(String vehicleNumber, String vehicleType, String vipUser, String start, String end) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vipUser = vipUser;
        this.start = start;
        this.end = end;
    }
    
   
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public String getVipUser() {
        return vipUser;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getStart() {
        return start;
    }
    
    public String getEnd() {
        return end;
    }
   
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public void setVipUser(String vipUser) {
        this.vipUser = vipUser;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setStart(String start) {
        this.start = start;
    }
    
    public void setEnd(String end) {
        this.end = end;
    }
}
