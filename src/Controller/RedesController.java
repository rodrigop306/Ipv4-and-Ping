package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public String osName() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void ip( String so){		
		try {
			Process p;
			if(so.contains("Windows")) {			
				p = Runtime.getRuntime().exec("ipconfig");
			}else{
				p = Runtime.getRuntime().exec("ifconfig");
			}
			InputStream fluxo = p.getInputStream();
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while(linha!=null){
				if(linha.contains("Ethernet") || linha.contains("IPv4") || linha.contains("inet ")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void ping(String so){		
		try {
			Process p;
			if(so.contains("Windows")) {			
				p = Runtime.getRuntime().exec("ping -n 10 www.google.com");
			}else{
				p = Runtime.getRuntime().exec("ping -c 10 www.google.com");
			}
			InputStream fluxo = p.getInputStream();
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			
			while(linha!=null){		
				if(so.contains("Windows")) {
					if(linha.contains("ia = ")) {
						//System.out.println(linha);
						System.out.println("Tempo médio do ping: " +linha.substring(linha.indexOf("ia = ")+4,linha.indexOf("s", linha.indexOf("ia = ")))+"s");
						
					}
				}else if(so.contains("Linux")) {
					if(linha.contains("min/avg")){
						//System.out.println(linha);
						//30
						String media = linha.substring(30,36);			
						System.out.println("Tempo médio do ping: "+media+"ms");
					}
				}
				
				linha = buffer.readLine();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
