public class AutoBlueRamp
{
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Mountain();

	public void execute()
	{
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(40, 0.5);
		mountain.climb();
	}
}
