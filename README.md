# TicketSystem
//给定Ticket类：
class Ticket{
  long tid;   /*车票编号*/
  String passenger;   /*乘客姓名*/
  int route;    /*列车车次*/
  int coach;    /*车厢号*/
  int seat;   /*座位号*/
  int departure;    /*出发站编号*/
  int arrival;    /*到达站编号*/
}

//给定TicketingSystem接口：
public interface TicketingSystem{
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

使用 Java语言设计并完成一个用于列车售票的可线性化并发数据结 构：TicketingDS类，
该类实现 TicketingSystem接口，同时提供 Ticketing DS ( routenum , coachnum , seatnum , stationnum ) ;
构造函数。其中，routenum 是车次总数（缺省为5个），coachnum是列车的车 厢数目（缺省为8个），
seatnum是每节车厢的座位数（缺省为100个）， stationnum 是每个车次经停站的数量（缺省为10个,含始发站和终点站）。

为简单起见，假设每个车次的coachnum、seatnum和stationnum都相同。
车票涉及的各项参数均从1开始计数，例如车厢从1到8编号，车站从1到10编号等。

需编写多线程测试程序，在main方法中用下述语句创建TicketingDS类的一个实例。
TicketingDS tds = new
TicketingDS (routenum , coachnum , seatnum , stationnum) ;
系统中同时存在若干个线程（缺省为16个），每个线程是一个票务代理，
按照60%查询余票，30%购票和10%退票的比率反复调用TicketingDS类的三种方法若干次（缺省为总共10000次）。
按照线程数为4，8，16，32，64个的情况 分别给出每种方法调用的平均执行时间，
同时计算系统的总吞吐率（单位时间 内完成的方法调用总数）。

正确性要求：
每张车票都有一个唯一的编号tid，不能重复。
每一个tid的车票只能出售一次。退票后，原车票的tid作废。
每个区段有余票时，系统必须满足该区段的购票请求。
车票不能超卖，系统不能卖无座车票。


评分标准分为两部分：基本分（50%）和性能分(50%)。
1. 首先保证并发数据结构功能正确。如果发现实现有错误，只能按照完成情况给基本分。
如果能够给出验证并发数据结构正确性的方法并实现验证程序，可以额外加分。
2. 对于所有正确实现的并发数据结构，用统一的多线程基准程序在同一测试环境下测试系统的延迟和吞吐率。 
