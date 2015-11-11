package net.demus_intergalactical.lanchat.backend;

/**
 * Created by thomas on 11.11.2015.
 */
public class PacketLengthException extends Throwable {

	private int packet_length;
	private int length;

	public PacketLengthException(int packet_length, int length) {

		this.packet_length = packet_length;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Tried to send packet with " + length + " bytes but " +
				"the nice protocol expects " + packet_length
				+ " bytes";
	}
}
