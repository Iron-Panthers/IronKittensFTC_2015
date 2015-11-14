package com.qualcomm.ftcrobotcontroller.IronKittensFTC_2015;

import com.qualcomm.robotcore.hardware.*;

public class Climber
{

	public static final String ELEVATOR_MOTOR = "elevatorMotor";

	public static final String DUMP_SERVO = "dumpServo";

	public static final double DUMP_POSITION = 100, UP_POSITION = 10;

	public static final double PLATFORM_DOWN = 100, PLATFORM_UP = 10;
	
	public DcMotor elevatorMotor;
	public Servo dumpServo;

	public Climber(HardwareMap hardwareMap)
	{
		elevatorMotor = hardwareMap.dcMotor.get(ELEVATOR_MOTOR);
		dumpServo = hardwareMap.servo.get(DUMP_SERVO);
	}
	
	public void lowerPlatform()
	{
		elevatorMotor.setDirection(DcMotor.Direction.FORWARD); // change directions if necessary
   		elevatorMotor.setMotorPower(0.75);
		while (elevatorMotor.getCurrentPosition() < PLATFORM_DOWN) // change boolean operator if necessary
		{

		}
		elevatorMotor.setMotorPower(0);
    } 
   	
   	public void raisePlatform()
   	{
   		elevatorMotor.setDirection(DcMotor.Direction.REVERSE); 
		elevatorMotor.setMotorPower(0.75)
		while (elevatorMotor.getCurrentPosition() > PLATFORM_UP)
		{

		}
		elevatorMotor.setMotorPower(0);
   	}
	    
    public void dumpPlatform()
    {
		dumpServo.setServoPosition(DUMP_POSITION);
	}

    public void resetPlatform()
    { 
        dumpServo.setServoPosition(UP_POSITION);
    }

}
 
 
                     
 
//      Motor(elevatorMotor)
//Servo(dumpServo)
//void dumpPlatform()
//      servo lower platform
//void resetPlatform()
//      puts platform parallel to floor
//void raisePlatform()
//      uses both motors
//void lowerPlatform()
//      uses both motors[]
// written by BigKobe and twamble
//classify servo
//outline steps of the methods