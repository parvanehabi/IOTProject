package services;

import beans.ParcelEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

@WebListener
public class SocketServerConfig implements ServletContextListener {

	private int listenPort;
	private ServerSocket serverSocket;
	private List<Socket> clientSockets;
	static long rowNumber = 1;
	private boolean stopping;
	private static PrintWriter out;

	// init() is a good place to read in parameters
	private void init()  {
		clientSockets = new ArrayList<Socket>();
		listenPort = 5555;
	}

	public static void print(String message){
		out.println(message);
	}
	
	public void contextInitialized(ServletContextEvent event) {
		
		try {
		ServletContext context = event.getServletContext();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("inside config");
		init();
		
		Runnable acceptorThread = new Runnable() {
			public void run() {
				try {
					serverSocket = new ServerSocket(listenPort);
				} catch (IOException e) {
					System.exit(-1);
				}
						
				while (true) {
					Socket clientSocket = null;
					try {
						clientSocket = serverSocket.accept();
						out =
								new PrintWriter(clientSocket.getOutputStream(), true);
						BufferedReader in =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					//	DeviceStreamingSourceSocketAdapter sourceAdapter = new DeviceStreamingSourceSocketAdapter(clientSocket);
					//	Thread clientThread = new Thread(sourceAdapter);
					//	clientThread.start();
						while(true){
							String inputString = in.readLine();
							System.out.println(inputString);
							if(inputString.startsWith("recieve parcel")){
								inputString = in.readLine();
								List<Object> parcels = DatabaseService.selectAll("ParcelEntity", "idparcel", "=", Integer.valueOf(inputString), "");
								if(parcels.size() >0) {
									ParcelEntity parcelEntity = (ParcelEntity)parcels.get(0);
									parcelEntity.setRecievedate(new Timestamp(System.currentTimeMillis()));
									DatabaseService.updateObject(parcelEntity);
								}else{
									System.out.println("parcel not found");
								}
							}

						}
					} catch (Exception e) {
						if (stopping)
							return;
						e.printStackTrace();
						continue;
					}

				}
			}
		};

		new Thread(acceptorThread).start();
    }

    public void contextDestroyed(ServletContextEvent event) {
		//utility.getAdapterLogger().info("SocketServerExample stopping");
		stopping = true;

		//utility.sendEnd(); // Flush out any unsent transactions/envelopes

		for (Socket clientSocket : clientSockets) {
			try {
				clientSocket.close();
			} catch (Exception exception) {
			//	utility.getAdapterLogger().error("Unable to close client connection: " + clientSocket);
			}
		}
		try {
			serverSocket.close();
		} catch (Exception exception) {
		//	utility.getAdapterLogger().error("Unable to shutdown server listener socket: " + serverSocket);
		}
    }
    
}