# Robot template

---
## Getting Started

Clone the repository
```shell
git clone --recurse-submodules https://github.com/kettlemorainerc/robot-template.git <target directory>
cd <target directory>
```

Modify the target repository 
```shell
git remote set-url origin https://github.com/kettlemorainerc/<Robot repository>
```


### OR In IntelliJ

`File > New > Project from Version Control...`

Set the URL to `https://github.com/kettlemorainerc/robot-template.git`

Click "Clone"

In the IntelliJ "Terminal" (try looking in the bottom left corner for a module you can open)
and execute

```shell
git submodule update --recursive --init
```

Then go to the option menu under `Git > Manage Remotes` and update "origin" to
the url of your target robot repository.
