import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class DriveAuto
{
	public DcMotor leftMotor;
    public DcMotor rightMotor;

	double RADIUS = 7;
	double ROBOTWIDTH = 18;

	public void driveStraight(double distance, double speed)
	{
		double targetValue = distance/(7 * Math.PI);
		double start = leftMotor.getCurrentPosition();

		while(leftMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(speed);
			rightMotor.setPower(speed);
		}
	}

	public void turnRight(double angle)
	{
		double start = leftMotor.getCurrentPosition();
		leftMotor.setPower(0);
		rightMotor.setPower(0);

		double targetValue = ((18 * Math.PI) * (angle / 360)) / 7 * Math.PI;

		while(rightMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(0.5);
			rightMotor.setPower(-0.5);
		}
	}

	public void turnLeft(double angle)
	{
		double start = rightMotor.getCurrentPosition();
		leftMotor.setPower(0);
		rightMotor.setPower(0);

		double targetValue = ((18 * Math.PI) * (angle / 360)) / 7 * Math.PI;

		while(rightMotor.getCurrentPosition() < targetValue)
		{
			rightMotor.setPower(0.5);
			leftMotor.setPower(-0.5);
		}
	}
}