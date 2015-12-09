public class Wait extends Routine{
    public Wait(long time){ //time in seconds
    	TIME = time * 1000;
    }

    public void executeAction(){
        System.out.println("lets git goin' time:" + TIME);
    }
    public void stopAction(){
        System.out.println("donzo kid");
    }
}
