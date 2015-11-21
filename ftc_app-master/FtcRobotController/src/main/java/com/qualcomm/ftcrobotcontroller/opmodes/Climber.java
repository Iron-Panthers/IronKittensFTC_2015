package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class Climber
{
	public DcMotor elevatorMotor;
	public Servo dumpServo;

	public static final String ELEVATOR_MOTOR = "elevatorMotor";
	public static final String DUMP_SERVO = "dumpServo";

	public static final double DUMP_POSITION = 100; //for dumpServo
	public static final double UP_POSITION = 10; //for dumpServo

	public static final double PLATFORM_HEIGHT = 50; //for elevatorMotor

	public boolean elevatorUp = true;
	public boolean platformUp = true;

	public Climber(HardwareMap hardwareMap)
	{
		elevatorMotor = hardwareMap.dcMotor.get(ELEVATOR_MOTOR);
		//dumpServo = hardwareMap.servo.get(DUMP_SERVO);
	}
	
	public void lowerElevator()
	{
		double finalPosition = elevatorMotor.getCurrentPosition() - PLATFORM_HEIGHT;

		while (elevatorMotor.getCurrentPosition() > finalPosition)
		{
			elevatorMotor.setPower(1.0); //need to determine direction
		}
		elevatorMotor.setPower(0);
    } 
   	
   	public void raiseElevator()
	{
		double finalPosition = elevatorMotor.getCurrentPosition() + PLATFORM_HEIGHT;

		while (elevatorMotor.getCurrentPosition() < finalPosition)
		{
			elevatorMotor.setPower(-1.0); //need to determine direction
		}
		elevatorMotor.setPower(0);
	}

	public void toggleElevator() //initialize platform to up/down somewhere
	{
		if(elevatorUp)
		{
			lowerElevator();
			elevatorUp = false;
		}
		else
		{
			raiseElevator();
			elevatorUp = true;
		}
	}

	public void resetElevator() //elevator reset position up?
	{
		raiseElevator();
		elevatorUp = true;
	}

	public void togglePlatform() //needs platform position set during initialization
	{
		if(platformUp)
		{
			dumpServo.setPosition(DUMP_POSITION);
			platformUp = false;
		}
		else
		{
			dumpServo.setPosition(UP_POSITION);
			platformUp = true;
		}
	}

	public void resetPlatform()
	{
		dumpServo.setPosition((UP_POSITION));
		platformUp = true;
	}
}