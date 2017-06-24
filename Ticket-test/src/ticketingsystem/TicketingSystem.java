package ticketingsystem;

/*
 * 此为规范文件，不能改动！！！
 */
class Ticket {
	long tid; //车票编号
	String passenger; //乘客名字
	int route;//列车车次
	int coach;//车厢号
	int seat;//座位号
	int departure;//出发站编号
	int arrival;//到达站编号
};

public interface TicketingSystem {
	/*
	 * buyTicket是购票方法，即乘客passenger购买route车次从departure站到arrival站的车票一张。
	 * 若购票成功，返回有效的Ticket对象；若失败（即无余票），返回无效的Ticket对象（即null）
	 */
	Ticket buyTicket(String passenger,int route,int departure,int arrival);
	/*
	 * inquiry是查询余票的方法，即查询route车次从departure站到arrival站的余票数。
	 */
	int inquiry(int route,int departure,int arrival);
	/*
	 * refundTicket是退票方法，即对有效的Ticket对象返回true，对无效的Ticket对象返回false。
	 */
	boolean refundTicket(Ticket ticket);
}
