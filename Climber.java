package com.qualcomm.ftcrobotcontroller.IronKittensFTC_2015;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorController;


public class Climber
{
	public DcMotor elevatorMotor;
	public Servo dumpServo;

		
	public static final double DUMP_POSITION = 100;
	public static final double UP_POSITION = 10;
	public static final double PLATFORM_DOWN = 100;
	public static final double PLATFORM_UP = 10;

	public Climber(HardwareMap hardwareMap)
	{
		elevatorMotor = hardwareMap.dcMotor.get("elevatorMotor");
		dumpServo = hardwareMap.Servo.get("dumpServo");
	}
	void setMotorPower(int Motor, double power)
	{
		
	}
	
	public void lowerPlatform()
	{
   		elevatorMotor.setMotorPower(0.75);
		if (elevatormotor.getcurrentposition() < PLATFORM_DOWN)
		{
			elevatorMotor.setMotorPower(0);
		}
    } 
   	
   	public void raisePlatform()
   	{
		elevatorMotor.setMotorPower(0.75);
		if (elevatorMotor.getcurrentposition() > PLATFORM_UP)
		{
			elevatorMotor.setMotorPower(0);
		}
   	}
	
	void setServoPosition(int channel, double position)
	{

	}  
    
    public void dumpPlatform()
    {
		dumpServo.setServoPosition(DUMP_POSITION); //value needs to be confirmed
	}

    public void resetPlatform()
	{
		dumpServo.setServoPosition(UP_POSITION);
    }
	   
//elevatormotor.getcurrentposition
	

}


                     

//	Motor(elevatorMotor)
//Servo(dumpServo)
//void dumpPlatform()
//	servo lower platform
//void resetPlatform()
//	puts platform parallel to floor
//void raisePlatform()
//	uses both motors
//void lowerPlatform()
//	uses both motors[]
// written by BigKobe and twamble
//classify servo
//outline steps of the methods