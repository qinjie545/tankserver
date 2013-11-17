package com.james.tank.core;

import java.util.LinkedList;

public abstract class QueueThread<T> extends Thread {
	private LinkedList<T> mQueues = new LinkedList<T>();
	private boolean isStopped = false;
	@Override
	public void run() {
		super.run();
		while(!isStopped){
			synchronized (mQueues) {
				T t;
				while ((t = mQueues.poll()) != null) {
					System.out.println("Thread"+Thread.currentThread().getName()+" is processing!!!");
					processFrame(t);
				}
				try {
					System.out.println("Thread"+Thread.currentThread().getName()+" is waiting!!!");
					mQueues.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void exit(){
		isStopped = true;
	}
	protected abstract void processFrame(T t);
	
	public void putFrame(T t){
		synchronized (mQueues) {
			mQueues.addLast(t);
			mQueues.notify();
		}
	}
}
