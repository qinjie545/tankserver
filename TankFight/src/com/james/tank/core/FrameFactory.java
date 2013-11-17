package com.james.tank.core;

import com.james.tank.core.Frame.Type;

public class FrameFactory {
	private static FrameFactory mInstance = new FrameFactory();
	public static FrameFactory getInstance(){
		return mInstance;
	}
	
	public Frame getFrame(int frameType){
		Frame targetFrame = null;
		switch (frameType) {
		case Frame.Type.TYPE_MOVE:
			targetFrame = new Frame(Type.TYPE_MOVE	, null);
			break;
		default:
			break;
		}
		return targetFrame;
	}
}
