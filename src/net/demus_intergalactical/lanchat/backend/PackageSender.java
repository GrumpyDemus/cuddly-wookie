package net.demus_intergalactical.lanchat.backend;

import java.io.IOException;
import java.net.*;

public class PackageSender {

	public final int PACKET_LENGTH = 4096;

	private DatagramSocket clientSocket;
	private InetAddress address;
	private int port;

	public PackageSender(int port)
			throws SocketException, UnknownHostException {
		this.port = port;
		clientSocket = new DatagramSocket();
		address = InetAddress.getByName("255.255.255.255");
	}

	public void sendRaw(byte[] b)
			throws PacketLengthException, IOException {
		if (b.length != PACKET_LENGTH) {
			throw new PacketLengthException(
				PACKET_LENGTH, b.length
			);
		}
		clientSocket.send(
			new DatagramPacket(b, PACKET_LENGTH, address, port)
		);
	}

}
