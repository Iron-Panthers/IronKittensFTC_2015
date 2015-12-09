import java.util.*;

public class Callback extends TimerTask{	
	private Runnable func;

	public Callback(Runnable function){
		func = function;
	}

	public void run(){
		System.out.println("callbeckin'");
		func.run();
	}
}
