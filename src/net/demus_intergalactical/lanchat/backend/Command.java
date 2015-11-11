package net.demus_intergalactical.lanchat.backend;

public interface Command<T> {

	public void apply(T a);

}
