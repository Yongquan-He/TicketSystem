package ticketingsystem;

public class Seat{
	boolean[] available;
	int stationnum;

	public Seat(int stationnum){
		this.stationnum=stationnum;
		this.available=new boolean[stationnum+1];
		for(int i=1;i<=stationnum;i++){
			available[i]=true;
		}
	}
	public boolean checkSeat(int departure,int arrival,boolean status){
		for(int i=departure;i<arrival;i++){
			if(this.available[i]!=status){
				return false; //fail to get a ticket from departure to  arrival
			}
		}
		return true;
	}
	
	public  synchronized void  modifySeat(int departure,int arrival,boolean status){
		for(int i=departure;i<arrival;i++){
			this.available[i]=status;
			}
	}
	public  boolean buySeat(int departure,int arrival){
		if(this.checkSeat(departure, arrival,true)==true){
			this.modifySeat(departure, arrival, false); // 已被占 置为false
			return true;
		}else{
			return false;
		}
	}
	
	public boolean refundSeat(int departure,int arrival){
		if(this.checkSeat(departure, arrival, false)==true){
			this.modifySeat(departure, arrival, true);
			return true;
		}
		return false;
	}
	
}
