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
class TV implements Device { //concrete reciever
    @Override
    public void turnOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is now off");
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

// Example usage
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create devices
        TV tv = new TV();

        // Create command objects
        Command turnOnTVCommand = new TurnOnCommand(tv);
        Command turnOffTVCommand = new TurnOffCommand(tv);
    
        // Create remote control
        RemoteControl remote = new RemoteControl();

        // Set and execute commands
        remote.setCommand(turnOnTVCommand);
        remote.pressButton(); // Outputs: TV is now on

        remote.setCommand(turnOffTVCommand);
        remote.pressButton(); // Outputs: TV is now off
    }
}
