package com.dominic.test;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

public class ConfigWatcher implements Watcher {
	
	private ActiveKeyValueStore store;
	
	public ConfigWatcher(String hosts) throws IOException, InterruptedException {
		store = new ActiveKeyValueStore();
		store.connect(hosts);
	}
	
	public void displayConfig() throws KeeperException, InterruptedException{
		String value = store.read(ConfigUpdater.PATH, this); 
		System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
	}
	
	@Override
	public void process(WatchedEvent event) {
		if(event.getType() == EventType.NodeDataChanged){
			try {
				displayConfig();
			} catch (InterruptedException e) {
				System.err.println("Interrupted. Existing.");
				Thread.currentThread().interrupt();
			} catch (KeeperException e) {
				System.err.printf("KeeperException: %s. Existing.\n", e);
			}
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		ConfigWatcher configWatcher = new ConfigWatcher("172.16.102.14:2181");
		configWatcher.displayConfig();
		Thread.sleep(Long.MAX_VALUE);
	}
}
