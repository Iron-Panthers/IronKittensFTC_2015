package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.ftccommon.DbgLog;

public class KittenRobot extends PushBotTelemetry
{
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;

    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public Climber climber;
    public Zipline zipline;
    public DriveAuto driveAuto;
    public Joystick joystick;

    public KittenRobot(){}

    @Override public void init()
    {
        climber = new Climber(hardwareMap);
        zipline = new Zipline(hardwareMap);
        driveAuto = new DriveAuto(hardwareMap);
        joystick = new Joystick(gamepad1);

        zipline.resetServos();
        climber.lowerElevator();
        climber.elevatorUp = false;
        climber.resetPlatform();
    }

    @Override public void loop()
    {
        frontLeftMotor.setPower(-joystick.leftStickY() * 0.457); //wheel ratio of rear wheel diameter to front wheel diameter
        backLeftMotor.setPower(-joystick.leftStickY());

        frontRightMotor.setPower(joystick.rightStickY() * 0.457);
        backRightMotor.setPower(joystick.rightStickY());

        if(joystick.leftBumper())
        {
            zipline.toggleLeft();
        }

        if(joystick.rightBumper())
        {
            zipline.toggleRight();
        }

        if(joystick.yButton())
        {
            climber.toggleElevator();
        }

        if(joystick.xButton())
        {
            climber.togglePlatform();
        }

        if(joystick.backButton()) //just in case to reset all servos and elevator motor
        {
            climber.lowerElevator();
            climber.resetPlatform();
        }

    }
}