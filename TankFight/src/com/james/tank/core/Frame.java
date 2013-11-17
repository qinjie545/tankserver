package com.james.tank.core;

public class Frame {
	
	public interface Type{
		public final int TYPE_MOVE = 0;
		public final int TYPE_ATTACK = 1;
		public final int TYPE_ATTACTED = 2;
		public final int TYPE_DEAD = 3;
		
	}
	
	private int type;	
	private long time;
	private Object data;
	public Frame(int type, Object data) {
		super();
		this.type = type;
		this.time = System.currentTimeMillis();
		this.data = data;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getTime() {
		return time;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
