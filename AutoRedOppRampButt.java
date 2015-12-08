public class AutoRedOppRampButt
{
	RedPush redPush = new RedPush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Moutain();

	public void execute()
	{
		redPush.go();
		driveAuto.driveStraight(-69.75, 0.5);
		driveAuto.turnRight(131);
		driveAuto.driveStraigt(32.68, 0.5);
		mountain.climb();
	}
}
