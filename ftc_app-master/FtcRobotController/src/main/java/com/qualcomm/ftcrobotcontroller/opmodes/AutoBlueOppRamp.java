public class AutoBlueOppRamp
{
	DriveAuto driveAuto;
	Mountain mountain;

	public void execute()
	{
		mountain = new Mountain();
		driveAuto = new DriveAuto();
		driveAuto.wait(10);
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(60, 0.5);
		mountain.climb();
	}
}
