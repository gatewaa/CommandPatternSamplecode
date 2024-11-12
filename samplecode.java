interface Command{ //command interface
  void execute();
}

class TurnOnCommand implements Command {//concrete command to turn a device on
  private Device device;

public TurnOnCommand(Device device){
  this.device = device;
}

@Override
  public void execute(){
    device.turnON();
  }
}

class TurnOffCommand implements Command {//concrete command to turn a device off
  private Device device;

public TurnOffCommand(Device device){
  this.device = device;
}

@Override
  public void execute(){
    device.turnOff();
  }
}

//Concrete command for adjusting stove heat level
class HeatLevelCommand implements Command{
private Stove stove;
  public HeatLevelCommand(Stove stove){
    this.stove=stove;
  }
  @Override
    public void execute(){
      stove.adjustHeatLevel();
    }
}
//Concrete command for blender's blade speed speed
class BlenderBladeSpeedCommand implements Command{
  private Blender blender;
  public BlenderBladeSpeed(Blender blender){
    this.blender =blender;
  }
  @Override
    public void execute(){
      blender.bladeSpeed();
    }
}
interface Device{//Receiver interface
  void turnOn();
  void turnOff();
}
class Stove implements Device { //concrete reciever for Stove
    @Override
    public void turnOn() {
        System.out.println("Stove is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stove is now off");
    }
  public void adjustHeatLevel() {
    System.out.println("Heat level adjusted);

}
//Concrete Receiver for blander
Class Blender implements Device{
  @Override
  public void turnOn(){
    System.out.println("Blender is now on");
  }
  @Override
  public void turnOff(){
    System.out.ln("Blender is now off");
  }
  public void bladeSpeed(){
    system.out.println("blade is now spinning");
  }
}
class RemoteControl { //the invoker
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// usage
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create devices
        Stove stove = new Stove();
        Blender blender = new Blender();
        // Create command objects
        Command turnOnStoveCommand = new TurnOnCommand(stove);
        Command turnOffStoveCommand = new TurnOffCommand(stove);
        Command heatLevelCommand = new HeatLevelCommand(stove);
        Command blenderBladeSpeedCommand = new BlenderBladeSpeedCommand(blendere);
        // Create remote control
        RemoteControl remote = new RemoteControl();

        // Set and execute commands
        remote.setCommand(turnOnStoveCommand);
        remote.pressButton(); // Outputs: Stove is now on
        
        remote.setCommand(heatLevelCommand);
        remote.pressButton();
      
        remote.setCommand(turnOffTVCommand);
        remote.pressButton(); // Outputs: Stove is now off
    }
}
