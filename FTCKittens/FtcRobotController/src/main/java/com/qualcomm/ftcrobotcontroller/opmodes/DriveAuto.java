package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class DriveAuto
{
	public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public static final double FRONT_WHEEL_DIAMETER = 7; 
	public static final double BACK_WHEEL_DIAMETER = 4;
	public static final double ROBOT_WIDTH = 18;
	public static final double FRONT_WHEEL_RATIO = 0.457;

	public DriveAuto(HardwareMap hardwareMap)
	{
		frontLeft = hardwareMap.dcMotor.get("frontLeft");
	    frontRight = hardwareMap.dcMotor.get("frontRight");
	    backLeft = hardwareMap.dcMotor.get("backLeft");
	    backRight = hardwareMap.dcMotor.get("backRight");
	}

	public void driveStraight(double distance, double speed) //distance is in inches
	{
		double targetValue = distance/(BACK_WHEEL_DIAMETER * Math.PI);
		double leftStart = backLeft.getCurrentPosition();
		double rightStart = backRight.getCurrentPosition();

		double leftTargetValue = targetValue + leftStart;
		double rightTargetValue = targetValue + rightStart;

		while((backLeft.getCurrentPosition() < leftTargetValue) && (backRight.getCurrentPosition() < rightTargetValue))
		{
			backLeft.setPower(speed);
			backRight.setPower(speed);
			frontLeft.setPower(speed * FRONT_WHEEL_RATIO);
			frontRight.setPower(speed * FRONT_WHEEL_RATIO);
		}

		backLeft.setPower(0);
		backRight.setPower(0);
		frontLeft.setPower(0);
		frontRight.setPower(0);

	}

	public void turnRight(double angle)
	{
		double leftStart = backLeft.getCurrentPosition();
		double rightStart = backRight.getCurrentPosition();

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

		double leftTargetValue = leftStart + targetValue;
		double rightTargetValue = rightStart - targetValue;

		while((backRight.getCurrentPosition() > rightTargetValue) && (backLeft.getCurrentPosition() < leftTargetValue))
		{
			backLeft.setPower(0.5);
			backRight.setPower(-0.5);
			frontLeft.setPower(0.5 * FRONT_WHEEL_RATIO);
			frontRight.setPower(-0.5 * FRONT_WHEEL_RATIO);
		}

		backLeft.setPower(0);
		backRight.setPower(0);
		frontLeft.setPower(0);
		frontRight.setPower(0);
	}

	public void turnLeft(double angle)
	{
		double leftStart = backLeft.getCurrentPosition();
		double rightStart = backRight.getCurrentPosition();

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

		double leftTargetValue = leftStart - targetValue;
		double rightTargetValue = rightStart + targetValue;

		while((backRight.getCurrentPosition() < rightTargetValue) && (backLeft.getCurrentPosition() > leftTargetValue))
		{
			backLeft.setPower(-0.5);
			backRight.setPower(0.5);
			frontLeft.setPower(-0.5 * FRONT_WHEEL_RATIO);
			frontRight.setPower(0.5 * FRONT_WHEEL_RATIO);
		}

		backLeft.setPower(0);
		backRight.setPower(0);
		frontLeft.setPower(0);
		frontRight.setPower(0);
	}
}