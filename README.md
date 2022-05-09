# Robot template

---
## Getting Started

- Create a new, blank, uninitialized repository
  - The git URL will be identified as `<target repo>`
  - It's name will be identified as `<target dir>`
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
