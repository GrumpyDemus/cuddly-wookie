package net.demus_intergalactical.lanchat.frontend;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Nikodemus on 12.11.2015.
 */
public class ChatPool {
	private static volatile HashMap<String, ChatInstance> pool;

	public synchronized static void init() {
		pool = new HashMap<>();
	}

	public synchronized static void set(String instanceID, ChatInstance chatInstance) {
		pool.put(instanceID, chatInstance);
	}

	public synchronized static ChatInstance get(String instanceID) {
		return pool.get(instanceID);
	}

	public synchronized static void remove(String instanceID) {
		pool.remove(instanceID);
	}

	public synchronized static Set<String> getAllInstanceIDs() {
		return pool.keySet();
	}
}
