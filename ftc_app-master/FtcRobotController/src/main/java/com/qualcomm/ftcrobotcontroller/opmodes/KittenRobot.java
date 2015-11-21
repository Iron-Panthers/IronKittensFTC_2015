package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.ftccommon.DbgLog;

public class KittenRobot extends PushBotTelemetry {

    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;

    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public Climber climber;
    public Zipline zipline;
    public DriveAuto driveAuto;
    //public Joystick gamepad1;

    @Override 
    public void init() {
        climber = new Climber(hardwareMap);
        zipline = new Zipline(hardwareMap);
        driveAuto = new DriveAuto(hardwareMap);
        //gamepad1 = new Joystick(gamepad1);

        zipline.resetServos();
        climber.lowerElevator();
        climber.elevatorUp = false;
        climber.resetPlatform();
    }

    @Override 
    public void loop() {
        frontLeftMotor.setPower(-gamepad1.left_stick_y * 0.457); //wheel ratio of rear wheel diameter to front wheel diameter
        backLeftMotor.setPower(-gamepad1.left_stick_y;

        frontRightMotor.setPower(gamepad1.right_stick_y * 0.457);
        backRightMotor.setPower(gamepad1.right_stick_y);

        if(gamepad1.left_bumper) {
            zipline.toggleLeft();
        }

        if(gamepad1.right_bumper) {
            zipline.toggleRight();
        }

        if(gamepad1.y) {
            climber.toggleElevator();
        }

        if(gamepad1.x) {
            climber.togglePlatform();
        }

        if(gamepad1.back) { //just in case to reset all servos and elevator motor
            climber.lowerElevator();
            climber.resetPlatform();
        }

    }
}