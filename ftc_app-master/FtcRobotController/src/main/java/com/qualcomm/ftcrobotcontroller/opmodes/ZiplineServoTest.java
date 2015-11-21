package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensorMultiplexer;
//import com.qualcomm.ftccommon.DbgLog;

public class ZiplineServoTest extends PushBotTelemetry {

    Zipline zipline;
    long lastUpdate = 0;
    boolean zipstate = false;

    @Override
    public void init() {
        zipline = new Zipline(hardwareMap);
    }

    @Override
    public void loop() {
        if (System.currentTimeMillis() - lastUpdate >= 1000) {
            zipstate = !zipstate;
            lastUpdate = System.currentTimeMillis();
        }

        if (zipstate) {
            zipline.setLeftServoIn();
            zipline.setRightServoIn();
        } else {
            zipline.setLeftServoOut();
            zipline.setRightServoOut();
        }
    }
}