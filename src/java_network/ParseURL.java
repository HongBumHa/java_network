package java_network;

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
				System.out.printf("path : %s%n",opinion.getPort());
				System.out.printf("filename : %s%n",opinion.getFile());
				
			} catch (MalformedURLException e) {
				System.err.println("잘못된 URL주소입니다.");
				e.printStackTrace();
			}


	}

}
