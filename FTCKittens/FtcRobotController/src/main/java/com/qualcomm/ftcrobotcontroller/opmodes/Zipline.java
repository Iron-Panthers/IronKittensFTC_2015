package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class Zipline
{
    public Servo leftClimberServo;
    public Servo rightClimberServo;

    public static final String LEFT_CLIMBER_SERVO = "leftClimberServo";
    public static final String RIGHT_CLIMBER_SERVO = "rightClimberServo";

    private static final double LEFT_OUT_POSITION = 1.0; //for leftClimberServo
    private static final double LEFT_IN_POSITION = 0.5; //for leftClimberServo

    private static final double RIGHT_OUT_POSITION = 0.0; //for rightClimberServo
    private static final double RIGHT_IN_POSITION = 0.5; //for rightClimberServo

    public boolean leftOut = false;
    public boolean rightOut = false;

    public Zipline(HardwareMap hardwareMap)
    {
       // leftClimberServo = hardwareMap.servo.get(LEFT_CLIMBER_SERVO);
        rightClimberServo = hardwareMap.servo.get(RIGHT_CLIMBER_SERVO);
    }

    public void setRightServoOut()
    {
        rightClimberServo.setPosition(RIGHT_OUT_POSITION);
    }

    public void setRightServoIn()
    {
        rightClimberServo.setPosition(RIGHT_IN_POSITION);
    }

    public void setLeftServoOut()
    {
        leftClimberServo.setPosition(LEFT_OUT_POSITION);
    }

    public void setLeftServoIn()
    {
        leftClimberServo.setPosition(LEFT_IN_POSITION);
    }

    public void resetServos()
    {
        setLeftServoIn();
        leftOut = false;
        setRightServoIn();
        rightOut= false;
    }

    public void toggleLeft(){
        if (leftOut)
        {
            setLeftServoIn();
            leftOut = false;
        }
        else
        {
            setLeftServoOut();
            leftOut = true;
        }
    }

    public void toggleRight(){
        if (rightOut)
        {
            setRightServoIn();
            rightOut = false;
        }
        else
        {
            setRightServoOut();
            rightOut = true;
        }
    }
}
