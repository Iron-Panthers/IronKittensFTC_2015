public class AutoBlueOppRampButt
{
	BluePush bluePush;
	DriveAuto driveAuto;
	Mountain mountain;

	public void execute()
	{
		bluePush = new BluePush();
		driveAuto = new DriveAuto();
		mountain = new Mountain();
		bluePush.go();
		driveAuto.driveStraight(-31, 0.5);
		driveAuto.turnRight(131);
		driveAuto.driveStraight(40, 0.5);
		mountain.climb();
}
