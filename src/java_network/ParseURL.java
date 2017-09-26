package java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ParseURL {

	public static void main(String[] args) {
		URL opinion = null;
		URL homePage = null;
//		http://dgit.or.kr/SUB/?ctId=2
			try {
				homePage = new URL("http://www.dgit.or.kr");
				opinion = new URL(homePage, "SUB/?ctId=2");
				System.out.printf("protocal : %s%n",opinion.getProtocol());
				System.out.printf("host : %s%n",opinion.getHost());
				System.out.printf("port : %s%n",opinion.getPort());
				System.out.printf("path : %s%n",opinion.getPath());
				System.out.printf("filename : %s%n",opinion.getFile());
				
				BufferedReader br = new BufferedReader(
						new InputStreamReader(opinion.openStream()));
				String line = null;
				
				while((line = br.readLine()) !=null){
					System.out.println(line);
				}
				br.close();
			} catch (MalformedURLException e) {
				System.err.println("잘못된 URL주소입니다.");
				e.printStackTrace();			
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
