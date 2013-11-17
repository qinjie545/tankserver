package com.james.tank.core;

import com.james.tank.core.Frame.Type;
import com.james.tank.utils.Constants;


public class BrainCenter {
	private static BrainCenter brainCenter = new BrainCenter();
	private TankGameEngine engine;
	public static BrainCenter getInstance(){
		return brainCenter;
	}
	public void init(TankGameEngine engine){
		this.engine = engine;
	}
	public void processFrame(Frame frame) {
		switch (frame.getType()) {
		case Type.TYPE_MOVE:
			engine.putFrame(frame, Constants.FrameCategory.TYPE_SHOW);
			break;
		default:
			break;
		}
	}
}
