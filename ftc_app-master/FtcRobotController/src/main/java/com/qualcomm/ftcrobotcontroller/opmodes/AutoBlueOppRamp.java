public class AutoBlueOppRamp
{
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Mountain();

	public void execute()
	{
		driveAuto.wait(10);
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(60, 0.5);
		mountain.climb();
	}
}
