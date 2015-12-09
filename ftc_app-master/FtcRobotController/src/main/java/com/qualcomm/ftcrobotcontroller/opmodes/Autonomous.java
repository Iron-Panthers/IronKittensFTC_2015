package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Autonomous extends PushBotTelemetry {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;

    public DriveAuto driveAuto;


    public ElapsedTime timer;
    public Autonomous() {

    }

    @Override
    public void start() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
    }

    @Override
    public void loop() {
        //
        // WHERE THE LOOP WILL DO COOL STUFFS: DRIVES FOR 3 SEC
        //
        if (timer.time() > 0.0)
        {
            SetPower(-1);
        }

        if (timer.time() > 3.0)
        {
            Stop();
        }


    }
    public void SetPower(double power)
    {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }
    public void Stop()
    {
        // choose num 1 to 1000000000
        // if num is 3, give +1 attack
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

}