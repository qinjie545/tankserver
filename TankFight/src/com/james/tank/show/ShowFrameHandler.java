package com.james.tank.show;

import com.james.tank.core.Frame;
import com.james.tank.core.IFrameProcessor;

public class ShowFrameHandler implements IFrameProcessor {

	@Override
	public void processFrame(Frame frame) {
		System.out.println("处理显示真:"+frame.getType());
	}

}
