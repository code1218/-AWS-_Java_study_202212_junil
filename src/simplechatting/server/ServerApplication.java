package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=====<<< 서버 실행 >>>=====");
			List<Socket> socketList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept();	// 클라이언트의 접속을 기다리는 녀석
				socketList.add(socket);
				
				Thread thread = new Thread(() -> {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						out.println("join");
						
						InputStream inputStream = socket.getInputStream();
						BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
						
						String username = in.readLine();
						System.out.println(username + "님이 접속하였습니다.");
						
						for(Socket s : socketList) {
							out.println("@welcome/" + username + "님이 접속하였습니다.");								
						}
						
						while(true) {
							String message = in.readLine();
							for(Socket s : socketList) {
								outputStream = s.getOutputStream();
								out = new PrintWriter(outputStream, true);
								out.println(message);								
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
				thread.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("=====<<< 서버 종료 >>>=====");
		}
		
	}
	
}








