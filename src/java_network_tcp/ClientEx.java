package java_network_tcp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		BufferedReader in = null;   //클라이언트로부터 보낸 메시지를 읽기위한 reader
		BufferedReader stin = null; //키보드로 부터 입력받기 위한 Reader
		BufferedWriter out = null;  //클라이언트로 보낼 Writer
		Socket socket = null;		  //클라이언트의와 주고받을 소켓
		
		try {
			socket = new Socket("localhost", 9999);

			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stin = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String outputMsg;
			while(true){
				outputMsg = in.readLine();
				if(outputMsg.equalsIgnoreCase("bye")){
					break;
				}
				System.out.println(outputMsg);
				String outputMsg1 = stin.readLine();
				out.write("서버>"+outputMsg1);
				out.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				socket.close();

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
