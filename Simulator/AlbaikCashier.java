package application;

public class AlbaikCashier
{
    // instance variable
    private double speed; //Ranges from 0.5 to 6
    //constructor
    public AlbaikCashier()
    {
        speed = 0.5;
    }
    //setters
    public void setSpeed(double speed)
    {
        this.speed=speed;
    }
    public double getSpeed()
    {
        return speed;
    }
    public void increase()
    {
    	speed+=0.2;
    	if(getSpeed()>10)
    	{
    		speed=10;
    	}
    }
}