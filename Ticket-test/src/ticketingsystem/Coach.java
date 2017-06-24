package ticketingsystem;

public class Coach {
	int seatnum;
	Seat[] seat;
	int stationum;

	Coach(int stationnum,int seatnum){
		this.stationum=stationnum;
		this.seatnum=seatnum;
		seat=new Seat[seatnum+1];
		for(int i=1;i<=seatnum;i++){
			seat[i]=new Seat(stationnum);
		}
	}
	public int buyCoach(int departure,int arrival){
		for(int i=1;i<=this.seatnum;i++){
			if(this.seat[i].buySeat(departure, arrival)==true){
				return i; //×ùÎ»±àºÅ
			}
		}
		return 0;
	}
	
	public boolean refundCoach(int seatnum,int departure,int arrival){
		if(this.seat[seatnum].refundSeat(departure, arrival)==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int inquiryCoach(int departure,int arrival){
		int sum=0;
		for(int i=1;i<=this.seatnum;i++){
			if(this.seat[i].checkSeat(departure, arrival, true)==true)
				sum+=1;
		}
		return sum;
	}
}
