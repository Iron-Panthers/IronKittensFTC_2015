//package com.qualcomm.ftcrobotcontroller.opmodes;

//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.*;

public abstract class Routine{
	public Callback callback;

	private long TIME = 0;

	public void execute(){
		Timer timer = new Timer();

        timer.schedule(new Callback(new Runnable(){
            public void run() {
                stop();
           }
        }), TIME);

        executeAction();
	}

	public abstract void stopAction();
	public abstract void executeAction();

	private void stop(){
		stopAction();

		callback.run();
	}
}
