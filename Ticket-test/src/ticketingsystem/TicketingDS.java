package ticketingsystem;

public class TicketingDS implements TicketingSystem{
	//�ǳ�����ʵ�ֽӿ�ʱ����ʵ�ָýӿ��е�ȫ��������
	/*
	 * ����ΪTicketingDS�Ĺ��캯����routenumΪ����������ȱʡΪ5������
	 * coachnumΪ�г��ĳ�����Ŀ��ȱʡΪ8������seatnumΪÿ�ڳ������λ����ȱʡΪ100������
	 * stationnumΪÿ�����ξ�ͣվ��������ȱʡΪ10������ʼ��վ���յ�վ����
	 * ������Ϊ�����������ÿ�����ε�coachnum��seatnum��stationnum����ͬ����Ʊ�漰�ĸ������
	 * ����1��ʼ���������糵���1��8��ţ���վ��1��10��ŵȡ�
	 */
	
	/*
	 * buyTicket�ǹ�Ʊ���������˿�passenger����route���δ�departureվ��arrivalվ�ĳ�Ʊһ�š�
	 * ����Ʊ�ɹ���������Ч��Ticket������ʧ�ܣ�������Ʊ����������Ч��Ticket���󣨼�null��
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
	 * inquiry�ǲ�ѯ��Ʊ�ķ���������ѯroute���δ�departureվ��arrivalվ����Ʊ����
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
	 * refundTicket����Ʊ������������Ч��Ticket���󷵻�true������Ч��Ticket���󷵻�false��
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
