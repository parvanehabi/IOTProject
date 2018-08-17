package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.json.JSONObject;

public class DeviceStreamingSourceSocketAdapter implements Runnable{
	private Socket _socket = null;
	private BufferedReader _in = null;
	//private BlockingQueue<String> _queue;
	//final static Logger logger = Logger.getLogger(StreamingSourceSocketAdapter.class);

	public DeviceStreamingSourceSocketAdapter(Socket socket) {
		_socket = socket;
	}

	public void run() {
	//	logger.info("Client connected to socket: " + _socket.toString());
		System.out.println("inside con");
		try {
			_in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			String inputLine;
			//Read from socket and send it to the transportQueue in the main thread.
			try {
				while ((inputLine = _in.readLine()) != null) {
					try {
						 JSONObject inputJson = new JSONObject(inputLine);
					} catch (NullPointerException e ) {
						//logger.error("Unable to add data read from client to queue = " + inputLine);
						e.printStackTrace();
					}
				}
			} catch( java.net.SocketException e) {
				String error = e.getMessage();
				if (!error.contentEquals("socket closed")) {
				//	logger.error("Error on client socket: " + _socket);
				//	logger.error("Error message: " + error);
				}
			}
			_in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //In case anything goes wrong we need to close our I/O streams and sockets.
			try {
				_in.close();
				//logger.info("Client disconnected from socket: " + _socket.toString());
				_socket.close();
			} catch(Exception e) { 
				//logger.info("Couldn't close I/O streams");
			}
		}
	}
}
