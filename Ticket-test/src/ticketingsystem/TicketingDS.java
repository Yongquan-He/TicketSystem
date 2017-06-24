package ticketingsystem;

public class TicketingDS implements TicketingSystem{
	//非抽象类实现接口时必须实现该接口中的全部方法。
	/*
	 * 以下为TicketingDS的构造函数。routenum为车次总数（缺省为5个），
	 * coachnum为列车的车厢数目（缺省为8个），seatnum为每节车厢的座位数（缺省为100个），
	 * stationnum为每个车次经停站的数量（缺省为10个，含始发站和终点站）。
	 * ！！！为简单起见，假设每个车次的coachnum、seatnum和stationnum都相同。车票涉及的各项参数
	 * 均从1开始计数，例如车厢从1到8编号，车站从1到10编号等。
	 */
	
	/*
	 * buyTicket是购票方法，即乘客passenger购买route车次从departure站到arrival站的车票一张。
	 * 若购票成功，返回有效的Ticket对象；若失败（即无余票），返回无效的Ticket对象（即null）
	 */
	int routenum;
	
	int coachnum;
	int seatnum;
	int stationnum;
	
	Train[] train;
	long tid=10000;
	
	TicketingDS(int routenum,int coachnum,int seatnum,int stationnum){
		this.routenum=routenum;
		
		this.coachnum=coachnum;
		this.seatnum=seatnum;
		this.stationnum=stationnum;
		
		this.train=new Train[routenum+1];
		
		for(int i=1;i<=routenum;i++){
			this.train[i]=new Train(stationnum,seatnum,coachnum);
		}
	}

	public Ticket buyTicket(String passenger,int route,int departure,int arrival){
		Ticket ticket=new Ticket();
		if(this.train[route].buyTrain(departure, arrival)==true){
			ticket.tid=this.tid++;
			ticket.passenger=passenger;
			ticket.route=route;
			ticket.coach=this.train[route].seat_coach_train[2];
			ticket.seat= this.train[route].seat_coach_train[1];
			ticket.departure=departure;
			ticket.arrival=arrival;
/*			System.out.println("BuyingTicket"+" "+
					"ID:"+ticket.tid+" "+
					"Passenger:"+ticket.passenger+" "+
					"Route:"+ticket.route+" "+
					"Coach:"+ticket.coach+" "+
					"Departure:"+ticket.departure+" "+
					"Arrival:"+ticket.arrival);*/
			
			return ticket;
		}
		/*System.out.println("BuyTicket error!");*/
		return null;
	}
	/*
	 * inquiry是查询余票的方法，即查询route车次从departure站到arrival站的余票数。
	 */
	public int inquiry(int route,int departure,int arrvial){
		int remains;
		remains=this.train[route].inquiryTrain(departure, arrvial);
/*		System.out.println("InquiryTicket:"+" "+
				"remains:"+remains+" "+
				"route:"+route+" "+
				"departure:"+departure+" "+
				"arrvial:"+arrvial);*/
		return remains;
	}
	/*
	 * refundTicket是退票方法，即对有效的Ticket对象返回true，对无效的Ticket对象返回false。
	 */

	
	public boolean refundTicket(Ticket ticket){
		
		try{
			if(this.train[ticket.route].refundTrain(ticket.departure, ticket.arrival,
					ticket.coach,ticket.seat)==true){
/*				System.out.println("RefundTicket succeed!"+" "+
						//"ID:"+ticket.tid+" "+
						//"Passenger:"+ticket.passenger+" "+
						"Route:"+ticket.route+" "+
						"Coach:"+ticket.coach+" "+
						"Departure:"+ticket.departure+" "+
						"Arrival:"+ticket.arrival);*/
				return true;
			}else{
				/*System.out.println("RufundTicket error!");*/
				return false;
			}
		}catch(NullPointerException e){
			return false;
		}
	}
}
