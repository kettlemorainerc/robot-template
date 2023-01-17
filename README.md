# Robot template

---
This is a basic template for team 2077 bots. There's a few important files to know about
as you star editing the code for a new robot. 

- [DriveStation](src/main/java/org/usfirst/frc/team2077/DriveStation.java)
  - It's the location where we setup the robot for user control.
    Typically, you set up controllers, their button bindings, and any default
    commands for subsystems.
- The [command](src/main/java/org/usfirst/frc/team2077/command) package
  - You will add new commands to this package that will then be used in
    autonomousInit/DriveStation
- [RobotHardware](src/main/java/org/usfirst/frc/team2077/RobotHardware.java)
  - This is the location where subsystem will be added and where you can see examples of
    various subsystem instances
- [Robot](src/main/java/org/usfirst/frc/team2077/Robot.java)
    - Normally you'll only need to really touch the autonomousInit method in order
      to set up and execute a command in autonomous mode.


## Getting Started

- Create a new, blank, uninitialized repository
  - The git URL for the new robot repository will be identified as `<target repo>`
    - It'll most likely resemble `https://github.com/kettlemorainerc/robot-template.git`, but with only `robot-template`
      changed to something else
  - The folder of the new robot repo name will be identified as `<target dir>`
- Clone the repository
  - Either using terminal/cmd commands
    - ```shell
      git clone --recurse-submodules https://github.com/kettlemorainerc/robot-template.git <target dir>
      cd <target dir> 
      ```
  - Or using IntelliJ's built-in repository cloning
    - `File > New > Project from Version Control...`
    - Set the URL to `https://github.com/kettlemorainerc/robot-template.git`
    - Click "Clone"
- Make sure submodules have been initialized
  - in a terminal do
    - ```shell
      git submodule update --recursive --init
      ```
    - you can find IntelliJ's built-in terminal near the lower-left corner by default
- Modify the remote URL of the local repository
  - In a terminal you can do
    - ```shell
      git remote set-url origin https://github.com/kettlemorainerc/<taget repo>
      ```
  - In IntelliJ 
    - go to `Git > Manage Remotes`
    - Update the "origin" option to `<target repo>`
