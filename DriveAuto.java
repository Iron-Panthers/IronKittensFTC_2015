import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class DriveAuto
{
	public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    double FRONT_DIAMETER = 7; 
	double BACK_DIAMETER = 4;
	double ROBOT_WIDTH = 18;

	public void driveStraight(double distance, double speed)
	{
		double targetValue = distance/(BACK_DIAMETER * Math.PI);
		double start = backLeft.getCurrentPosition();

		targetValue = targetValue + start;

		while(backLeft.getCurrentPosition() && backRight.getCurrentPosition() < targetValue)
		{
			backLeft.setPower(speed);
			backRight.setPower(speed);
			frontLeft.setPower(speed);
			frontRight.setPower(speed);
		}
	}

	public void turnRight(double angle)
	{
		double start = backLeft.getCurrentPosition();
		backLeft.setPower(0);
		backRight.setPower(0);

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_DIAMETER * Math.PI;

		while(backRight.getCurrentPosition() && backLeft.getCurrentPosition() < targetValue)
		{
			backLeft.setPower(0.5);
			backRight.setPower(-0.5);
			frontLeft.setPower(0.5);
			frontRight.setPower(-0.5);
		}
	}

	public void turnLeft(double angle)
	{
		double start = backRight.getCurrentPosition();
		backLeft.setPower(0);
		backRight.setPower(0);

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_DIAMETER * Math.PI;

		while(backRight.getCurrentPosition() && backLeft.getCurrentPosition() < targetValue)
		{
			backLeft.setPower(-0.5);
			backRight.setPower(0.5);
			frontLeft.setPower(-0.5);
			frontRight.setPower(0.5);
		}
	}
}