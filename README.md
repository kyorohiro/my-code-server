Build my development environment with vscode on docker by code-server



# BASIC 

(1) run a docker image.
 
```
git clone https://github.com/kyorohiro/my-code-server.git
cd my-code-server/xxxxx
docker build -t xxxxx_vscode .
docker run -p 8443:8443 -p 8080:8080 -it xxxxx_vscode bash
```

(2) run vscode at code-server

```
mkdir /works/w
/works/code-server /works/w --allow-http --no-auth
```

(3) and open 'http://127.0.0.1:8443/' at your browser 

![](root_page.jpg)


# Docker Command Memo

[a] restart a container

```
$ docker ps -a
check id and
$ docker exec -it < id > bash
```

[b] reset configure which like port and mount etc.

$ docker commit < id > clang_vscode_xxx
$ docker run -p 8443:8443 -p 8080:8080 -it clang_vscode_xxx bash

[c] mount volume

$ docker run -p 8443:8443 -p 8080:8080 -v /Users/kyorohiro/w/dart/xxx:/works/w -it clang_vscode bash

[d] delete all container 

```
$ docker ps -qa | grep docker rm 
```

[e] delete all image 
```
$ docker image ls -qa | docker image rm
```







PS 
move from 
https://github.com/kyorohiro/clang-code-server
https://github.com/kyorohiro/dart-code-server