public class AutoRedRampButt
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Moutain();

	public void execute()
	{
		redPush.go();
		driveAuto.driveStraight(-31, 0.5);
		driveAuto.turnLeft(50);
		driveAuto.driveStraight(40. 0.5);
		mountain.climb();
	}
}
