package java_network_udp;

public class ChattingMain {

	public static void main(String[] args) {
		ChattingFrame cfA = new ChattingFrame("MessengerA", 5000, 6000, "127.0.0.1");
		ChattingFrame cfB = new ChattingFrame("MessengerB", 6000, 5000, "127.0.0.1");
	}

}
