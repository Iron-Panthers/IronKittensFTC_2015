import com.qualcomm.robotcore.hardware.*;

public class PullUpBar
{

	public static final String SERVO_L = "pullupservol", SERVO_R = "pullupservor";

	public static final String MOTOR_L = "pullupmotorl", MOTOR_R = "pullupmotorr";

	public static final int EXTEND_POS = 1337, RETRACT_POS = 123;

	public static final double SWING_UP = 1337, SWING_DOWN = 123;

	private Servo servoL, servoR;
	private Motor motorL, motorR;

	public PullUpBar(HardwareMap hwm) {
		servoL = hwm.servo.get(SERVO_L);
		servoR = hwm.servo.get(SERVO_R);
		motorL = hwm.servo.get(MOTOR_L);
		motorR = hwm.servo.get(MOTOR_R);
	}

	public void setExtend()
	{
		motorL.setTargetPosition(EXTEND_POS);
		motorR.setTargetPosition(EXTEND_POS);
	}

	public void setRetract()
	{
		motorL.setTargetPosition(RETRACT_POS);
		motorR.setTargetPosition(RETRACT_POS);
	}

	public void SwingUp()
	{
		servoL.setPosition(SWING_UP);
		servoR.setPosition(SWING_UP);
	}

	public void SwingDown()
	{
		servoL.setPosition(SWING_DOWN);
		servoR.setPosition(SWING_DOWN);
	}

}