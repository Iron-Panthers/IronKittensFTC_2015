package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

/**
	Alliance Button utilities by Maxim
*/
public class AllianceButton {

	/** the ultrasonic sensor id **/
	public static final String ULTRASONIC_SENSOR = "ultrasonic";

	/** the color sensor id **/
	public static final String COLOR_SENSOR = "color";

	/** the touch sensor id **/
	public static final String TOUCH_SENSOR = "touch";

	/** the motor id **/
	public static final String MOTOR_LEFT = "motor_left", MOTOR_RIGHT = "motor_right";

	/** drive speed **/
	public static final double SLOW = 0.25;

	/** distance it starts at (inches) **/
	public static final double START_DIST = 23;

	/** distance between buttons (inches) **/
	public static final double BUTTON_DIFFERENCE = 5.25;

	/** buffer distance for turning (inches) **/
	public static final double TURNING_BUFFER_DIST = 3;

	/** max distance for color inspection (inches) **/
	public static final double INSPECTION_DIST = 3;

	private DriveAuto drive;
	private Climber climber;
	private DcMotor motorL, motorR;
	private UltrasonicSensor ultrasonic;
	private TouchSensor touch;
	private ColorSensor color;
	private AllianceColor teamColor;

	/**
		@param drive The driving utilities
		@param hwm The HardwareMap object that the hardware is sourced from.
		@param team Which alliance the robot is on
	*/
	public AllianceButton(DriveAuto drive, Climber climber, HardwareMap hwm, AllianceColor team) {
		this.ultrasonic = hwm.ultrasonicSensor.get(ULTRASONIC_SENSOR);
		this.touch = hwm.touchSensor.get(TOUCH_SENSOR); //touchSensorMultiplexer if NXT sensor
		this.motorL = hwm.dcMotor.get(MOTOR_LEFT);
		this.motorR = hwm.dcMotor.get(MOTOR_RIGHT);
		this.color = hwm.colorSensor.get(COLOR_SENSOR);

		this.drive = drive;
		this.climber = climber;
		this.teamColor = team;
	}

	/**
		Run the color checking sequence. Make sure that the robot is at the proper
		position prior to calling this method!
	**/
	public void runAllianceButton() {
		moveToInspection();
		if (checkColor()) {
			hitButton();
		} else {
			swapLight();
			moveToInspection();
			if (checkColor()) {
				hitButton();
			}
			resetPositionFromRight();
		}
		moveUntilDistance(START_DIST, SLOW, DcMotor.Direction.REVERSE);
	}

	/**
		Checks the color.
		@return whether the detected color matches the alliance color
	*/
	public boolean checkColor() {
		/*
		PSEUDOCODE:
		detected color = null
		hue = color.argb()
		if hue in blue range then color = blue
		if hue in red range then color = red
		return color == teamcolor
		*/

		int hue = color.argb();

		/*
		if(hue  == range of alliance color)
        {
            return true;
        }
        else
        {
            return false;
        }
        */
		return false;
	}

	/**
		Moves to a good turning distance and changes from left button to right button. 
	*/
	public void swapLight() {
		moveUntilDistance(TURNING_BUFFER_DIST, SLOW, DcMotor.Direction.FORWARD);
		drive.turnRight(90);
		drive.driveStraight(BUTTON_DIFFERENCE, SLOW);
		drive.turnLeft(90);
	}

	/**
		Move to the robot's starting position from the right side.
	*/
	public void resetPositionFromRight() {
		moveUntilDistance(TURNING_BUFFER_DIST, SLOW, DcMotor.Direction.REVERSE);
		drive.turnLeft(90);
		drive.driveStraight(BUTTON_DIFFERENCE, SLOW);
		drive.turnRight(90);
	}

	/**
		Move to the checking distance.
	*/
	public void moveToInspection() {
		moveUntilDistance(INSPECTION_DIST, SLOW, DcMotor.Direction.FORWARD);
	}

	/**
		Drives forward to hit the button, then moves to turning buffer distance.
	*/
	public void hitButton() {

		setDirection(DcMotor.Direction.FORWARD);
		setPower(SLOW);
		while (!touch.isPressed()) {

		}
		setPower(0);

		moveUntilDistance(TURNING_BUFFER_DIST, SLOW, DcMotor.Direction.REVERSE);

	}

	/**
		Moves the robot until the sensor is at a certain distance.
		@param dist distance, in inches
		@param power the power of the motors
		@param direction the direction to move in
	*/
	public void moveUntilDistance(double dist, double power, DcMotor.Direction direction) {
		dist *= 2.54;
		boolean isForward = direction == DcMotor.Direction.FORWARD;
		setDirection(direction);
		setPower(power);
		while (isForward ? (checkDist() <= dist) : (checkDist() >= dist)) {

		}
		setPower(0);
	}

	/**
		I'm too lazy to type out that big method name
	*/
	public double checkDist() {
		return ultrasonic.getUltrasonicLevel();
	}

	private void setDirection(DcMotor.Direction direction) {
		motorL.setDirection(direction);
		motorR.setDirection(direction);
	}

	private void setPower(double power) {
		motorL.setPower(0);
		motorR.setPower(0);
	}

}
