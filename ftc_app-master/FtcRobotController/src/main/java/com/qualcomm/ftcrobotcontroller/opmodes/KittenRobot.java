package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.ftccommon.DbgLog;

public class KittenRobot extends PushBotTelemetry {

    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;

    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public Climber climber;
    public Zipline zipline;
    public Catapult catapult;
    //public DriveAuto driveAuto;

    public KittenRobot(){}

    public final static double CONST_WHEEL_DIST = 0.88;
    //public Joystick gamepad1;

    @Override 
    public void init() {
        climber = new Climber(hardwareMap);
        zipline = new Zipline(hardwareMap);
        catapult = new Catapult(hardwareMap);

        zipline.resetServos();
        catapult.retractCatapult();
        /*climber.lowerElevator();
        climber.elevatorUp = false;*/
        climber.resetPlatform();
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        backRightMotor = hardwareMap.dcMotor.get("backRight");
    }

    @Override public void loop()
    {
        frontLeftMotor.setPower(gamepad1.left_stick_y * 0.457 * CONST_WHEEL_DIST); //wheel ratio of rear wheel diameter to front wheel diameter
        backLeftMotor.setPower(gamepad1.left_stick_y * CONST_WHEEL_DIST);

        frontRightMotor.setPower(-gamepad1.right_stick_y * 0.457 * CONST_WHEEL_DIST);
        backRightMotor.setPower(-gamepad1.right_stick_y * CONST_WHEEL_DIST);

        if(gamepad1.left_bumper)
        {
            zipline.toggleLeft();
        }

        if(gamepad1.right_bumper)
        {
            zipline.toggleRight();
        }

        if(gamepad1.left_trigger > 0.1)
        {
           climber.raiseElevator();
        }

        if(gamepad1.right_trigger > 0.1)
        {
            climber.lowerElevator();
        }

        if(gamepad1.a)
        {
            climber.togglePlatform();
        }

        if(gamepad1.b)
        {
            catapult.reverseCatapult();
        }

        if(gamepad1.x)
        {
            catapult.toggleCatapult();
        }

        if(gamepad1.y)
        {
            catapult.runCatapult();
        }
        else
        {
            catapult.stopCatapult();
            climber.stopElevator();
        }

        /*if(gamepad1.back) //just in case to reset all servos and elevator motor
        {
            climber.elevatorController.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
            climber.elevatorMotor.setPower(0);
        }*/

    }
}
