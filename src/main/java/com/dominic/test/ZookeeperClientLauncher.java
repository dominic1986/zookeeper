package com.dominic.test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperClientLauncher {
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
//		CreateGroup createGroup = new CreateGroup();
//		createGroup.connect(args[0]);
//		createGroup.create(args[1]);
//		createGroup.close();
		
		
//		JoinGroup joinGroup = new JoinGroup();
//		joinGroup.connect(args[0]);
//		joinGroup.join(args[1], args[2]);
		
//		ListGroup listGroup = new ListGroup();
//		listGroup.connect(args[0]);
//		listGroup.list(args[1]);
//		listGroup.close();
		
		DeleteGroup deleteGroup = new DeleteGroup();
		deleteGroup.connect(args[0]);
		deleteGroup.delete(args[1]);
		deleteGroup.close();
	}
}
