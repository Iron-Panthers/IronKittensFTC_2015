import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorController;

public class Climber
{
	//DcMotor(DcMotorController controller, int portNumber)

	DcMotor elevatorMotor = new DcMotor(DcMotorController controller, int portNumber)

	DcMotor dumpServo = new DcMotor(DcMotorController controller, int portNumber)
	

	void setMotorPower(int Motor, double power)
	{
	}
	public void lowerPlatform()
	{
   		elevatorMotor.setMotorPower()
    } 
   	public void raisePlatform()
   	{
		elevatorMotor.setMotorPower()
   	}
	
	void setServoPosition(int channel, double position)
	{

	}  
    public void dumpPlatform()
    {
		dumpServo.setServoPosition()
	}

    public void resetPlatform()
	{
		dumpServo.setServoPosition()
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