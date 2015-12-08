package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Zipline
{
    public Servo leftClimberServo;
    public Servo rightClimberServo;

    public static final String LEFT_CLIMBER_SERVO = "leftClimberServo";
    public static final String RIGHT_CLIMBER_SERVO = "rightClimberServo";

    private static final double LEFT_OUT_POSITION = 0.4; //for leftClimberServo
    private static final double LEFT_IN_POSITION = 0.0; //for leftClimberServo

    private static final double RIGHT_OUT_POSITION = 0.5; //for rightClimberServo

    private static final double RIGHT_IN_POSITION = 1.0; //for rightClimberServo

    public boolean leftOut = false;
    public boolean rightOut = false;

    ElapsedTime timerRightServo;
    ElapsedTime timerLeftServo;

    public Zipline(HardwareMap hardwareMap)
    {
        leftClimberServo = hardwareMap.servo.get(LEFT_CLIMBER_SERVO);
        rightClimberServo = hardwareMap.servo.get(RIGHT_CLIMBER_SERVO);

        timerRightServo = new ElapsedTime();
        timerLeftServo = new ElapsedTime();
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

    public void toggleLeft()
    {
        if(timerLeftServo.time() > 0.5) {
            if (leftOut) {
                setLeftServoIn();
                leftOut = false;
                timerLeftServo.reset();
            } else {
                setLeftServoOut();
                leftOut = true;
                timerLeftServo.reset();
            }
        }
    }

    public void toggleRight(){
        if(timerRightServo.time() > 0.5) {
            if (rightOut) {
                setRightServoIn();
                rightOut = false;
                timerRightServo.reset();
            } else {
                setRightServoOut();
                rightOut = true;
                timerRightServo.reset();
            }
        }
    }
}
