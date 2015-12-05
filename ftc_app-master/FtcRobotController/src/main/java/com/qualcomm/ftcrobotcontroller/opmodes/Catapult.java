package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Catapult {
    public Servo catapultServo;
    public DcMotor catapultMotor;

    public String CATAPULT_SERVO = "catapultServo";
    public String CATAPULT_MOTOR = "catapultMotor";

    public static final double CATAPULT_UP_POSITION = 1.0;
    public static final double CATAPULT_DOWN_POSITION = 0.5;

    public boolean catapultExtend;

    ElapsedTime catapultTimer;

    public Catapult(HardwareMap hardwareMap)
    {
        catapultServo = hardwareMap.servo.get(CATAPULT_SERVO);
        catapultTimer = new ElapsedTime();
        catapultMotor = hardwareMap.dcMotor.get(CATAPULT_MOTOR);
    }

    public void extendCatapult()
    {
        catapultServo.setPosition(CATAPULT_UP_POSITION);
        catapultExtend = true;
    }

    public void retractCatapult()
    {
        catapultServo.setPosition(CATAPULT_DOWN_POSITION);
        catapultExtend = false;
    }

    public void runCatapult()
    {
        catapultMotor.setPower(0.5);
    }

    public void stopCatapult()
    {
        catapultMotor.setPower(0.0);
    }

    public void toggleCatapult()
    {
        if(catapultTimer.time() > 0.3)
        {
            if(catapultExtend)
            {
                retractCatapult();
                catapultTimer.reset();
            }
            else {
                extendCatapult();
                catapultTimer.reset();
            }
        }
    }
}
