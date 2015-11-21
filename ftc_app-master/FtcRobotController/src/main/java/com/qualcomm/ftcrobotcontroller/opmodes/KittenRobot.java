package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.ftccommon.DbgLog;

public class KittenRobot extends PushBotTelemetry
{
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;

    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public Climber climber;
    public Zipline zipline;
    public DriveAuto driveAuto;

    private boolean leftWasFlipped = false;
    private boolean aFlipped = false;
    private boolean rightWasFlipped = false;

    public KittenRobot()
    {
        //don't do anything here because it is very dangerous
    }

    @Override public void init()
    {
        climber = new Climber(hardwareMap);
        zipline = new Zipline(hardwareMap);
        driveAuto = new DriveAuto(hardwareMap);

    }

    @Override public void loop()
    {
/*
        frontLeftMotor.setPower(-leftStickY() * 0.457);
        backLeftMotor.setPower(-leftStickY());

        frontRightMotor.setPower(rightStickY() * 0.475);
        backRightMotor.setPower(rightStickY());

        if (leftTrigger() > trigThresh && !leftWasFlipped){
            zipline.toggleLeft();
            leftWasFlipped = true;
        }
        if (leftTrigger() < trigThresh){
            leftWasFlipped = false;
        }

        if (rightTrigger() > trigThresh && !rightWasFlipped){
            zipline.toggleRight();
            rightWasFlipped = true;
        }
        if (leftTrigger() < trigThresh){
            rightWasFlipped = false;
        }

        if (aButton() && !aFlipped){
            pullUp.toggleArms();
            aFlipped = true;
        }
        if (!aButton()){
            aFlipped = false;
        }

        //leftMotor.setPower(-0.3);
        //leftMotor1.setPower(-0.3);

        //rightMotor.setPower(0.3);
        //rightMotor.setPower(0.3);

        /*DbgLog.msg("Left:"+leftMotor.getCurrentPosition() + ", Rights:"+rightMotor.getCurrentPosition());

        if (leftButton()){
            ziplineServo.setPosition(ziplineRetracted);
        }
        else if (rightButton()){
            ziplineServo.setPosition(ziplineExtended);
        }

        if (leftTrigger() > minTrigger){
            pullUpMotor.setPower(pullupSpeed);
        }
        else if (rightTrigger() > minTrigger){
            pullUpMotor.setPower(pullupSpeed);
        }*/
    } // loop

    //Joystick Wrapper stuff

    public float leftStickX(){
        return gamepad1.left_stick_x;
    }

    public float rightStickX(){
        return gamepad1.right_stick_x;
    }

    public float leftTrigger(){
        return gamepad1.left_trigger;
    }

    public float rightTrigger(){
        return gamepad1.right_trigger;
    }

    public boolean leftButton(){
        return  gamepad1.left_bumper;
    }

    public boolean rightButton() {return  gamepad1.right_bumper; }

    public boolean aButton() {
        return gamepad1.a;
    }

} // PushBotManual