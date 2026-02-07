package src.poo.metodos.classes;

public class Carro {

    private String name;
    private double MaxSpeed;
    private static double SpeedLimit = 250;

    public Carro(String name, double maxSpeed){
        this.name = name;
        this.MaxSpeed = maxSpeed;
    }

    public static double getSpeedLimit() {
        return Carro.SpeedLimit;
    }

    public double getMaxSpeed() {
        return MaxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setMaxSpeed(double maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setSpeedLimit(double speedLimit) {
        Carro.SpeedLimit = speedLimit;
    }

    public void imprimirInfo(){
        System.out.println("-------------------------");
        System.out.println("Nome: "+this.name);
        System.out.println("Speed Max: "+this.MaxSpeed);
        System.out.println("Speed Limit: "+Carro.SpeedLimit);
        System.out.println("-------------------------");
    }
}
