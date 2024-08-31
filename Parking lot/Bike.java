
class Bike{
	private String vehicalNo;
	private double entryTime;
	
	Bike(String vehicalNo,double entryTime){
		this.vehicalNo = vehicalNo;
		this.entryTime = entryTime;
	}
	
	public String getVehicalNo(){
		return vehicalNo;
	}
	
	public void setVehicalNo(String vehicalNo){
		this.vehicalNo = vehicalNo;
	}
	
	public double getEntryTime(){
		return entryTime;
	}
	
	public void setVehicalNo(double entryTime){
		this.entryTime = entryTime;
	}
}