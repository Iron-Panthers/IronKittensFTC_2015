import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorController;

public class Climber
{
	//DcMotor(DcMotorController controller, int portNumber)

	public DcMotor elevatorMotor;
	public Servo dumpServo;

	void setMotorPower(int Motor, double power)
	{
		
	}
	
	public void lowerPlatform()
	{
   		elevatorMotor.setMotorPower(0.75)
   		{
   			if (elevatormotor.getcurrentposition() < x;)
   			{
   				elevatorMotor.setMotorPower(0);
   			}
   		}
    } 
   	
   	public void raisePlatform()
   	{
		elevatormotor.setMotorPower(0.75)
		{
			if (elevatormotor.getcurrentposition() > x;)
			{
   				elevatorMotor.setMotorPower(0);
			}
		}
   	}
	
	void setServoPosition(int channel, double position)
	{

	}  
    
    public void dumpPlatform()
    {
		dumpServo.setServoPosition(0) //value needs to be confirmed
	}

    public void resetPlatform()
	{
		dumpServo.setServoPosition(100)
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

//classify servo
//outline steps of the methods