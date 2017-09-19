package com.qaprosoft.hospital.models.connectionpool;

public class Runner {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + ": RunnableTest");

		Runnable task1 = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		Runnable task2 = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		Runnable task3 = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		Runnable task4 = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};
		Runnable task5 = () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		};

		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
		new Thread(task4).start();
		new Thread(task5).start();
	}

}
