FROM ubuntu:18.04

RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y

RUN mkdir /works
WORKDIR /works



# CODE-SERVER
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1


#
#
ENTRYPOINT /works/code-server  --allow-http --no-auth


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
WORKDIR /works/w

# docbuild -t python_django_vscode .
# docker run -p 8443:8443 -p8080:8080 -p8022:22  -it python_django_vscode 
