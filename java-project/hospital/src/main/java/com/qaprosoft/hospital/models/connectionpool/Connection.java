package com.qaprosoft.hospital.models.connectionpool;

public class Connection {
	static int availableConn;

	public void close() {
		System.out.println("All connections have been closed!");
	}

}
