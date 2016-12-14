package com.dominic.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class CreateGroup extends ConnectionWatcher {

	public void create(String groupName) throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		String createPath = zk.create(path, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println("Created " + createPath);
	}
}
