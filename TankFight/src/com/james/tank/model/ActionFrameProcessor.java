package com.james.tank.model;

import com.james.tank.core.BrainCenter;
import com.james.tank.core.Frame;
import com.james.tank.core.IFrameProcessor;

public class ActionFrameProcessor implements IFrameProcessor {

	@Override
	public void processFrame(Frame frame) {
		System.out.println("处理动作帪:"+frame.getType());
		BrainCenter.getInstance().processFrame(frame);
	}

}
