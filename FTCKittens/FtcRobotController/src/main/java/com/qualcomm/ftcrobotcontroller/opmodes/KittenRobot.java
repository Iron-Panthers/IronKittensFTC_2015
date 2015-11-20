package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.ftccommon.DbgLog;

public class KittenRobot extends PushBotTelemetry
{
    public final float yJoystickScale = (float)0.75;
    public final float minTrigger = (float)0.1;
    public final float pullupSpeed = (float)0.25;
    public final float trigThresh = (float)0.4;

    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public DcMotor leftMotor1;
    public DcMotor rightMotor1;

    public DcMotor pullUpMotor;

    public Climber climber;
    public Zipline zipline;
    public PullUpBar pullUp;
    public DriveAuto driveAuto;

    private boolean leftWasFlipped = false;
    private boolean aFlipped = false;
    private boolean rightWasFlipped = false;

    public Servo servo;

    public KittenRobot()
    {
        //climber = new Climber(hardwareMap);
        //zipline = new Zipline(hardwareMap);
        //pullUp = new PullUpBar(hardwareMap);
        //driveAuto = new DriveAuto(hardwareMap);
        servo = hardwareMap.servo.get("servo");
    }

    @Override public void init()
    {
        //leftMotor = hardwareMap.dcMotor.get("leftMotor");
        //leftMotor1 = hardwareMap.dcMotor.get("leftMotor1");
        //rightMotor = hardwareMap.dcMotor.get("rightMotor");
        //rightMotor1 = hardwareMap.dcMotor.get("rightMotor1");
        //zipline.resetServos();
        //servo.setPosition(0.0);
        //zipline.setRightServoIn();
        //driveAuto.driveStraight(10, 0.5);
        //zipline.setRightOut();
        //pullUpMotor = hardwareMap.dcMotor.get("pullup");
    }

    @Override public void loop()
    {
        servo.setPosition(.75);
        leftMotor.setPower(-leftStickY() * 0.457);
        leftMotor1.setPower(-leftStickY());

        rightMotor.setPower(rightStickY() * 0.475);
        rightMotor1.setPower(rightStickY());

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

    public float leftStickY(){
        return yJoystickScale*gamepad1.left_stick_y;
    }

    public float rightStickY(){
        return yJoystickScale*gamepad1.right_stick_y;
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