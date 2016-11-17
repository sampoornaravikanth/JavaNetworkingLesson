package org.pihisamurai.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Example {
	DatagramSocket socket;

	public Example() throws SocketException {
		socket = new DatagramSocket();
	}

	public void request(String name) throws IOException {
		InetAddress address = InetAddress.getByName("localhost");
		byte[] buffer = name.getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4242);
		socket.send(packet);
		// send the name to the server
	}

	public String getResponse() throws IOException {
		// read the response

		byte[] buffer = new byte[512];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		socket.receive(packet);
		// return it
		return new String(packet.getData()).substring(0, packet.getLength());

	}
}
