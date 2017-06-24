package ticketingsystem;

/*
 * ��Ϊ�淶�ļ������ܸĶ�������
 */
class Ticket {
	long tid; //��Ʊ���
	String passenger; //�˿�����
	int route;//�г�����
	int coach;//�����
	int seat;//��λ��
	int departure;//����վ���
	int arrival;//����վ���
};

public interface TicketingSystem {
	/*
	 * buyTicket�ǹ�Ʊ���������˿�passenger����route���δ�departureվ��arrivalվ�ĳ�Ʊһ�š�
	 * ����Ʊ�ɹ���������Ч��Ticket������ʧ�ܣ�������Ʊ����������Ч��Ticket���󣨼�null��
	 */
	Ticket buyTicket(String passenger,int route,int departure,int arrival);
	/*
	 * inquiry�ǲ�ѯ��Ʊ�ķ���������ѯroute���δ�departureվ��arrivalվ����Ʊ����
	 */
	int inquiry(int route,int departure,int arrival);
	/*
	 * refundTicket����Ʊ������������Ч��Ticket���󷵻�true������Ч��Ticket���󷵻�false��
	 */
	boolean refundTicket(Ticket ticket);
}
