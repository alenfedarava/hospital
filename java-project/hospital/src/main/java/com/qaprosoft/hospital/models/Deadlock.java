package com.qaprosoft.hospital.models;

public class Deadlock {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) {
		FirstThread T1 = new FirstThread();
		SecondThread T2 = new SecondThread();
		T1.start();
		T2.start();
	}

	private static class FirstThread extends Thread {
		public void run() {
			synchronized (Lock1) {
				System.out.println("lock 1 has been held by first thread");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("first thread is waiting for lock 2!");

				synchronized (Lock2) {
					System.out.println("locks 1 & 2 have been held by first thread");
				}
			}
		}
	}

	private static class SecondThread extends Thread {
		public void run() {
			synchronized (Lock2) {
				System.out.println("lock 2 has been held by second thread");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("second thread is waiting for lock 1!");

				synchronized (Lock1) {
					System.out.println("locks 1 & 2 have been held by second thread");
				}
			}
		}
	}
}
