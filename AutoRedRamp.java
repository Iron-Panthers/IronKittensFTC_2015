public class AutoRedRamp
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Moutain();

	public void execute()
	{
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(32.68. 0.5);
		mountain.climb();
	}
}
