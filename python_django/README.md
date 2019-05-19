Build php x laravel's development environment with vscode on docker by code-server



# BASIC 

(1) run a docker image.
 
```
git clone https://github.com/kyorohiro/my-code-server.git
cd my-code-server/python_django
docker build -t python_django_vscode .
docker run -p 8443:8443 -p 8080:8080 -it python_django_vscode 
```

(3) and open 'http://127.0.0.1:8443/' at your browser 

![](../root_page.jpg)


## VSCode setting 

https://marketplace.visualstudio.com/items?itemName=ms-python.python


## Create Project


(1) Terminal -> New Terminal on VSCODE

(2) on Terminal

```
root@8e5699b9caa4:/works/w# django-admin startproject mysite
root@8e5699b9caa4:/works/w# cd mtsite
root@8e5699b9caa4:/works/w# python manage.py runserver 0.0.0.0:8080
```

(3) and, open 'http://127.0.0.1:8080/' at your browser

![](welcome.jpg)



## REF

### Tutorial

https://tutorial.djangogirls.org/
