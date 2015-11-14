import com.qualcomm.robotcore.hardware.*;

public class DriveAuto
{
	public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public static final double FRONT_WHEEL_DIAMETER = 7; 
	public static final double BACK_WHEEL_DIAMETER = 4;
	public static final double ROBOT_WIDTH = 18;

	public DriveAuto(HardwareMap hardwareMap)
	{
		frontLeft = hardwareMap.dcMotor.get("frontLeft");
	    frontRight = hardwareMap.dcMotor.get("frontRight");
	    backLeft = hardwareMap.dcMotor.get("backLeft");
	    backRight = hardwareMap.dcMotor.get("backRight");
	}

	public void driveStraight(double distance, double speed) //distance is in inches
	{
		double targetValue = distance/(BACK_WHEEL_DIAMETER * Math.PI);
		double start = backLeft.getCurrentPosition();

		targetValue += start;

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

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

		targetValue += start;

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

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

		targetValue += start;

		while(backRight.getCurrentPosition() && backLeft.getCurrentPosition() < targetValue)
		{
			backLeft.setPower(-0.5);
			backRight.setPower(0.5);
			frontLeft.setPower(-0.5);
			frontRight.setPower(0.5);
		}
	}
}