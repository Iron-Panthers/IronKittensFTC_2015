
public class PullUpBar

{

	private Servo thePullServo;
	private Motor thePullMotor;
	//Motor(leftPullUpMotor, RightPullUpMotor)
	//Servo(leftSwing, rightSwing

	public PullUpBar(){
		thePullServo = new Servo(needsServoController, 5); //whichever port the servo is at
		thePullMotor = new Motor(needsMOTORFUCKINGCONROLLERSTUPID, 6);//again, port #
	}

	public void setExtend()
	{
		int wantedExtendPosition = 200000;

		thePullMotor.setTargetPosition(wantedExtendPosition);

		//Put int position to where you want it to be to extend.

	}
	//This Extends it
	public void setRetract()
	{
		int wantedRetractPosition = 200000;

		thePullMotor.setTargetPosition(wantedRetractPosition);

		//Put int position to where you want it to be to retract.
	}
	// This Retracts the thing.

	public void SwingUp()
	{
		thePullServo.setPosition(int fuck you);

	}
	public void SwingDown()
	{
		thePullServo.setPosition(int ya);

	}
			//0.0 to 1.0 - set it what you please