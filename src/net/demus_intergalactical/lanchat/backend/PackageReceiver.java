package net.demus_intergalactical.lanchat.backend;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PackageReceiver {

	private DatagramSocket receiveSocket;
	private int port;
	private Command<Byte[]> process;

	public PackageReceiver(int port, Command<Byte[]> process)
			throws IOException {
		this.port = port;
		this.process = process;
		receiveSocket = new DatagramSocket(1337);
	}

	public void run() {
		Thread receiveThread = new Thread(() -> {
			try {
				while (true) {
					System.out.println("Waiting for " +
						"someone to connect...");
					byte[] data = new byte[4096];
					DatagramPacket p = new DatagramPacket(
						data, data.length
					);
					receiveSocket.receive(p);
					new Thread(() ->
						process.apply(
							toByteArray(p.getData())
						)
					).run();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		receiveThread.start();
	}

	private Byte[] toByteArray(byte[] data) {
		Byte[] b = new Byte[data.length];
		for (int i = 0; i < data.length; i++) {
			b[i] = data[i];
		}
		return b;
	}

}
