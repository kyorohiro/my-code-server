FROM ubuntu:18.04

RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y

RUN mkdir /works
WORKDIR /works



#
# plugin
# https://marketplace.visualstudio.com/items?itemName=ms-python.python
#


#
# install python
# --no-cache
RUN apt-get install build-essential checkinstall -y
RUN apt-get install libreadline-gplv2-dev libncursesw5-dev libssl-dev libsqlite3-dev libgdbm-dev libc6-dev libbz2-dev  --fix-missing -y
RUN apt-get install zlib1g-dev libffi-dev -y  --fix-missing
RUN wget https://www.python.org/ftp/python/3.7.3/Python-3.7.3.tgz
RUN tar xf Python-3.7.3.tgz
WORKDIR /works/Python-3.7.3
RUN ./configure --enable-optimizations
RUN make altinstall
RUN pip3.7  install --upgrade pip
RUN ln /usr/local/bin/python3.7 /usr/local/bin/python  
WORKDIR /works/w


# docbuild -t python_django_vscode .
# docker run -p 8443:8443 -p8080:8080 -p8022:22  -it python_django_vscode 


WORKDIR /works
# CODE-SERVER
RUN wget https://github.com/cdr/code-server/releases/download/2.preview.11-vsc1.37.0/code-server2.preview.11-vsc1.37.0-linux-x86_64.tar.gz
RUN tar xzf code-server2.preview.11-vsc1.37.0-linux-x86_64.tar.gz -C ./ --strip-components 1

RUN /works/code-server --install-extension ms-python.python

#
#
# ENTRYPOINT /works/code-server  --allow-http --no-auth
# docker run -p8080:8080 -p8443:8443 -it vspython 
# bash

CMD [ "/works/code-server", "--allow-http", "--no-auth", "--port", "8443"]

