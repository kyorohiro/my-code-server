Build clang's development environment with vscode on docker by code-server



(1) run a docker image.
 
```
docker build -t clang_vscode .
docker run -p 8443:8443 -p 8080:8080 -it clang_vscode bash
```

(2) run vscode at code-server

```
mkdir /works/w
/works/code-server /works/w --allow-http --no-auth
```

(3) and open 'http://127.0.0.1:8443/' at your browser 




## VSCode Setting 

https://code.visualstudio.com/docs/languages/cpp


add setting file in .vscode dirctory

```
# c_cpp_properties.json
{
    "configurations": [
        {
            "intelliSenseMode": "gcc-x64",
            "compilerPath": "/usr/bin/gcc",
            "cStandard": "c11",
            "cppStandard": "c++17",
            "includePath": [
                "/usr/include"
            ]
        }
    ],
    "version": 4
}
```
