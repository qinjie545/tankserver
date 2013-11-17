package com.james.tank.core;

import com.james.tank.model.ActionFrameProcessor;
import com.james.tank.show.ShowFrameHandler;
import com.james.tank.utils.Constants;
import com.james.tank.utils.Constants.FrameCategory;

public class TankGameEngine {

	private QueueThread<Frame> mActionFrameProcessThread = null;
	private QueueThread<Frame> mShowFrameThread = null;
	
	private IFrameProcessor mShowFrameProcessor;
	private IFrameProcessor mActionFrameProcessor;
	
	private int state = Constants.State.STOP;
	
	public void init(){
		mShowFrameProcessor = new ShowFrameHandler();
		mActionFrameProcessor = new ActionFrameProcessor();
		BrainCenter.getInstance().init(this);
	}

	public void start() {
		if (state == Constants.State.STOP) {
			// do start
			state = Constants.State.START;
			if (mActionFrameProcessThread == null) {
				mActionFrameProcessThread = new QueueThread<Frame>() {
					@Override
					protected void processFrame(Frame t) {
						mActionFrameProcessor.processFrame(t);
					}
				};
				mActionFrameProcessThread.start();
			}
			if (mShowFrameThread == null) {
				mShowFrameThread = new QueueThread<Frame>() {
					@Override
					protected void processFrame(Frame t) {
						mShowFrameProcessor.processFrame(t);
					}
				};
				mShowFrameThread.start();
			}
		}
	}
	
	public void putFrame(Frame t , int type){
		if (state == Constants.State.START) {
			if(type == FrameCategory.TYPE_ACTION){
				mActionFrameProcessThread.putFrame(t);
			}else if(type == FrameCategory.TYPE_SHOW){
				mShowFrameThread.putFrame(t);
			}
		}
	}
	
	public void stop() {
		state = Constants.State.STOP;
	}

	public void destory() {
		
	}

}
