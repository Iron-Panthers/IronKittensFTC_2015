package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class PullUpBar
{
	private DcMotor leftPullupMotor;
	private DcMotor rightPullupMotor;

	private Servo leftPullupServo;
	private Servo rightPullupServo;

	public static final String LEFT_PULLUP_SERVO = "leftPullupServo";
	public static final String RIGHT_PULLUP_SERVO = "rightPullupServo";

	public static final String LEFT_PULLUP_MOTOR = "leftPullupMotor";
	public static final String RIGHT_PULLUP_MOTOR = "rightPullupMotor";

	public static final double PULLUP_HEIGHT = 1337;

	public static final double SWING_UP = 1337;
	public static final double SWING_DOWN = 123; //need to test

	private boolean ArmsOut = false; //True if pullup arms are out

	public PullUpBar(HardwareMap hardwareMap)
	{
		leftPullupServo = hardwareMap.servo.get(LEFT_PULLUP_SERVO);
		rightPullupServo = hardwareMap.servo.get(RIGHT_PULLUP_SERVO);
		leftPullupMotor = hardwareMap.dcMotor.get(LEFT_PULLUP_MOTOR);
		rightPullupMotor = hardwareMap.dcMotor.get(RIGHT_PULLUP_MOTOR);
	}

	public void setExtend()
	{
		double leftFinalPosition = leftPullupMotor.getCurrentPosition() + PULLUP_HEIGHT;
		double rightFinalPosition = rightPullupMotor.getCurrentPosition() + PULLUP_HEIGHT;

		while(leftPullupMotor.getCurrentPosition() < leftFinalPosition && rightPullupMotor.getCurrentPosition() < rightFinalPosition)
		{
			leftPullupMotor.setPower(1.0);
			rightPullupMotor.setPower(1.0); //need to determine direction
		}
		leftPullupMotor.setPower(0);
		rightPullupMotor.setPower(0);
	}

	public void extendPullupMotor()
	{
		double leftFinalPosition = leftPullupMotor.getCurrentPosition() + PULLUP_HEIGHT;
		double rightFinalPosition = rightPullupMotor.getCurrentPosition() + PULLUP_HEIGHT;

		while(leftPullupMotor.getCurrentPosition() < leftFinalPosition || rightPullupMotor.getCurrentPosition() < rightFinalPosition)
		{

		}
	}

	public void setRetract()
	{
		double leftFinalPosition = leftPullupMotor.getCurrentPosition() - PULLUP_HEIGHT;
		double rightFinalPosition = rightPullupMotor.getCurrentPosition() - PULLUP_HEIGHT;

		while (leftPullupMotor.getCurrentPosition() > leftFinalPosition && rightPullupMotor.getCurrentPosition() > rightFinalPosition)
		{
			leftPullupMotor.setPower(-1.0);
			rightPullupMotor.setPower(-1.0); //need to determine direction
		}
		leftPullupMotor.setPower(0);
		rightPullupMotor.setPower(0);
	}

	public void SwingUp()
	{
		leftPullupServo.setPosition(SWING_UP);
		rightPullupServo.setPosition(SWING_UP);
	}

	public void SwingDown()
	{
		leftPullupServo.setPosition(SWING_DOWN);
		rightPullupServo.setPosition(SWING_DOWN);
	}

	public void toggleArms()
	{
		if(ArmsOut)
		{
			setRetract();
			ArmsOut = false;
		}
		else
		{
			setExtend();
			ArmsOut = true;
		}
	}
}