package ticketingsystem;

public class Train {
	int stationnum;
	int seatnum;
	int coachnum;
	Coach[] coach;
	int[] seat_coach_train=new int[4]; //记录1座位号、2车厢号、3车次号
	
	Train(int stationnum,int seatnum,int coachnum){
		this.stationnum=stationnum;
		this.seatnum=seatnum;
		this.coachnum=coachnum;
		this.coach=new Coach[coachnum+1];
		for(int i=1;i<=coachnum;i++){
			this.coach[i]=new Coach(stationnum,seatnum);
		}
	}
	
	public boolean buyTrain(int departure,int arrival){
		for(int i=1;i<=this.coachnum;i++){
			if((seat_coach_train[1]=this.coach[i].buyCoach(departure, arrival))!=0){
				seat_coach_train[2]=i;
				return true;
			}
		}
		return false;
	}
	
	public int inquiryTrain(int departure,int arrival){
		int sum=0;
		for(int i=1;i<=this.coachnum;i++){
			sum+=this.coach[i].inquiryCoach(departure, arrival);
		}
		return sum;
	}
	
	public boolean refundTrain(int departure,int arrival,int coachnum,int seatnum){
		if(this.coach[coachnum].refundCoach(seatnum, departure, arrival)==true){
			return true;
		}else{
			return false;
		}
	}
	
}
