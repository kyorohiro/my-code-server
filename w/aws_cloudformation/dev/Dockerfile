FROM ubuntu:18.04

RUN apt-get update
RUN apt-get upgrade

RUN apt-get install -y wget curl git 
#
# CODE-SERVER
#
WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1
RUN /works/code-server --install-extension redhat.vscode-yaml

