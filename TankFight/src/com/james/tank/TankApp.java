package com.james.tank;

import com.james.tank.core.Frame;
import com.james.tank.core.FrameFactory;
import com.james.tank.core.TankGameEngine;
import com.james.tank.utils.Constants.FrameCategory;

public class TankApp {
	
	private TankGameEngine engine ;
	
	public static void main(String args[]){
		TankApp app = new TankApp();
		app.init();
		app.start();
	}

	//Start the app
	private void start() {
		engine.start();
		Frame frame = FrameFactory.getInstance().getFrame(Frame.Type.TYPE_MOVE);
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			engine.putFrame(frame, FrameCategory.TYPE_ACTION);
		}
	}

	//Init
	private void init() {
		engine = new TankGameEngine();
		engine.init();
	}
}
