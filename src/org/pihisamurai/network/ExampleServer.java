package org.pihisamurai.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ExampleServer {
	DatagramSocket socket;
	public ExampleServer() throws SocketException {
	
		socket =new DatagramSocket(4242);
	}
		public void respond() throws IOException {
			//read the request to get the name
			byte[]buffer = new byte[512];
			DatagramPacket packet = new DatagramPacket(
					buffer, buffer.length);
			socket.receive(packet);
			//add "Hello" <name>!"
		
			String name = new String(packet.getData())
					.substring(0,packet.getLength());
			
			String greeting = "Hello " + name + "!";
			
			//send the greeting back
			packet.setData(greeting.getBytes());
			packet.setLength(greeting.getBytes().length);
			socket.send(packet);
			
}
}