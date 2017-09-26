package java_network_tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.corba.se.spi.oa.OADefault;

public class ServerEx {
	
	public static void main(String[] args) {
		BufferedReader in = null;   //클라이언트로부터 보낸 메시지를 읽기위한 reader
		BufferedReader stin = null; //키보드로 부터 입력받기 위한 Reader
		BufferedWriter out = null;  //클라이언트로 보낼 Writer
		
		ServerSocket listener = null; //클라이언트의 요청을 대기하는 소켓
		Socket socket = null;		  //클라이언트의와 주고받을 소켓
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("Server Ready~~!!");
			socket = listener.accept(); // 클라이언트와 연결이 성공
			System.out.println("클라이언트와 연결되었습니다.");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stin = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String clientMsg;
			while(true){
				clientMsg = in.readLine();
				if(clientMsg.equalsIgnoreCase("bye")){
					break;
				}
				System.out.println(clientMsg);
				String outputMsg = stin.readLine();
				out.write("클라이언트>"+outputMsg);
				out.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				listener.close();
				out.close();
				in.close();
				stin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
