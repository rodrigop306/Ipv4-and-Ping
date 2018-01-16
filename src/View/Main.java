package View;
import Controller.RedesController;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		RedesController rede = new RedesController();
		String so = rede.osName();
		int opc=0;
		Scanner ler = new Scanner(System.in);
		while(opc!=3) {
			System.out.println("Digite 1 para consultar os adaptadores ethernet e o ipv4 \n"
					+ "Digite 2 para ver o tempo médio em ms do ping \n"
					+ "Digite 3 para sair");
			opc = ler.nextInt();
			switch(opc) {
			case 1:
				rede.ip(so);
				break;
			case 2:				
				rede.ping(so);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Digite uma opção valida");
				break;
			}
		}
	}
}
