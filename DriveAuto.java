import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class DriveAuto
{
	public DcMotor leftMotor;
    public DcMotor rightMotor;

	public void driveStraight(double distance, double speed)
	{
		while()
		{
			leftMotor.setPower(speed);
			rightMotor.setPower(speed);
		}
	}

	public void turn(double angle)
	{
		leftMotor.setPower(0);
		rightMotor.setPower(0);

		//turns left
		leftMotor.setPower(1);
		rightMotor.setPower(-1);

		//turns right
		leftMotor.setPower(-1);
		rightMotor.setPower(1);
	}
}