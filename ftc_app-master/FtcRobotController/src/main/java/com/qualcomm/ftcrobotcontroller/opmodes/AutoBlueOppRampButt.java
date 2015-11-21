public class AutoBlueOppRampButt
{
	BluePush bluePush = new BluePush();
	DriveAuto driveAuto = new DriveAuto();
	Mountain mountain = new Mountain();

	public void execute()
	{
		bluePush.go();
		driveAuto.driveStraight(-31, 0.5);
		driveAuto.turnRight(131);
		driveAuto.driveStraight(40, 0.5);
		mountain.climb();
}
