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
    //public DriveAuto driveAuto;

    public KittenRobot(){}

    @Override public void init()
    {
        climber = new Climber(hardwareMap);
        zipline = new Zipline(hardwareMap);
        //driveAuto = new DriveAuto(hardwareMap);

        zipline.resetServos();
        /*climber.lowerElevator();
        climber.elevatorUp = false;
        climber.resetPlatform();*/
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        backRightMotor = hardwareMap.dcMotor.get("backRight");
    }

    @Override public void loop()
    {
        frontLeftMotor.setPower(-gamepad1.left_stick_y * 0.457); //wheel ratio of rear wheel diameter to front wheel diameter
        backLeftMotor.setPower(-gamepad1.left_stick_y);

        frontRightMotor.setPower(gamepad1.right_stick_y * 0.457);
        backRightMotor.setPower(gamepad1.right_stick_y);

        if(gamepad1.left_bumper)
        {
            zipline.toggleLeft();
        }

        if(gamepad1.right_bumper)
        {
            zipline.toggleRight();
        }

        if(gamepad1.y)
        {
           climber.raiseElevator();
        }

        if(gamepad1.x)
        {
            climber.lowerElevator();
        }

        if(gamepad1.a)
        {
            climber.togglePlatform();
        }

        if(gamepad1.back) //just in case to reset all servos and elevator motor
        {
            climber.elevatorMotor.setPower(0);
        }

    }
}