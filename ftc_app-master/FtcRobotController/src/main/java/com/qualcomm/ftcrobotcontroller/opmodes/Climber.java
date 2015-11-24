package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.hardware.HiTechnicNxtDcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorController.DeviceMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Climber
{
	public DcMotor elevatorMotor;
	public Servo dumpServo;

	public static final String ELEVATOR_MOTOR = "elevatorMotor";
	public static final String DUMP_SERVO = "dumpServo";

	public static final double DUMP_POSITION = 0.0; //for dumpServo
	public static final double UP_POSITION = 0.50; //for dumpServo

	public static final double PLATFORM_HEIGHT = 50; //for elevatorMotor

	public boolean elevatorUp = true;
	public boolean platformUp = true;

    ElapsedTime timer;

	public Climber(HardwareMap hardwareMap)
	{
		elevatorMotor = hardwareMap.dcMotor.get(ELEVATOR_MOTOR);

		dumpServo = hardwareMap.servo.get(DUMP_SERVO);

        timer = new ElapsedTime();

       /* DcMotorController elevatorController;
        elevatorController = hardwareMap.dcMotorController.get("elevatorController");
        elevatorController.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY); */
	}
	
	public void lowerElevator()
    {
        //STUFF GETS CHANGED BELOW HERE
        /*
		double finalPosition = elevatorMotor.getCurrentPosition() - PL      ATFORM_HEIGHT;
		while (elevatorMotor.getCurrentPosition() > finalPosition)
		{
			elevatorMotor.setPower(1.0); //need to determine direction
		}
		elevatorMotor.setPower(0);
        elevatorUp = false;
        //STUFF GOT CHANGED ABOVE HERE
        */
        elevatorMotor.setPower(1);
    } 
   	
   	public void raiseElevator()
	{
		/*double finalPosition = elevatorMotor.getCurrentPosition() + PLATFORM_HEIGHT;

		while (elevatorMotor.getCurrentPosition() < finalPosition)
		{
			elevatorMotor.setPower(-1.0); //need to determine direction
		}
		elevatorMotor.setPower(0);
        elevatorUp = true;*/
        elevatorMotor.setPower(-1);
	}

	public void toggleElevator() //initialize platform to up/down somewhere
	{
		if(elevatorUp)
		{
			lowerElevator();
		}
		else
		{
			raiseElevator();
		}
	}

	public void togglePlatform() //needs platform position set during initialization
	{
        if(timer.time() > 0.5) {
            if (platformUp) {
                dumpServo.setPosition(DUMP_POSITION);
                platformUp = false;
                timer.reset();
            } else {
                dumpServo.setPosition(UP_POSITION);
                platformUp = true;
                timer.reset();
            }
        }
	}

	public void resetPlatform()
	{
		dumpServo.setPosition((UP_POSITION));
		platformUp = true;
	}
}