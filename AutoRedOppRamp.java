public class AutoRedOppRamp
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Moutain();

	public void execute()
	{
		driveAuto.wait(10);
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(60, 0.5);
		moutain.climb();
	}
}
