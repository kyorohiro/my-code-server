FROM openjdk:11

#
# GRADLE
RUN mkdir /works
WORKDIR /works

RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y
RUN apt-get install -y build-essential libssl-dev curl git-core
RUN apt-get install -y emacs

RUN wget https://downloads.gradle.org/distributions/gradle-5.4.1-bin.zip
RUN unzip gradle-5.4.1-bin.zip
ENV PATH="/works/gradle-5.4.1/bin:${PATH}"

#
# nodejs for vscode plugin
RUN curl -sL https://raw.githubusercontent.com/creationix/nvm/v0.33.11/install.sh -o install_nvm.sh
RUN sh install_nvm.sh
ENV NVM_DIR="/root/.nvm"

RUN chmod o+x /root/.nvm/nvm.sh
RUN /bin/bash -c "source /root/.nvm/nvm.sh && nvm install v12.0.0"
ENV PATH="/root/.nvm/versions/node/v12.0.0/bin/:${PATH}"

#
# code-server
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1


#
# mysql client 
RUN apt-get -y install mysql-client

#
#  $ docker build -t java_spring_vscode .
#  $ docker run -p 8443:8443 -p 8080:8080 -it java_spring_vscode bash
#
#  $ git clone https://github.com/kyorohiro/tmporary.git ./w
#  $ /works/code-server /works/w --allow-http --no-auth
# 
#  open 127.0.0.1:8443 at broswer
# 
#  install plugin
#  https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency
#  $ gradle build
#  $ SERVER_PORT=8080 SERVER_HOST=0.0.0.0 gradle tasks bootRun
#
# open 127.0.0.1:8080 at browser
#



#
# PS
# https://code.visualstudio.com/docs/languages/java
#
# https://code.visualstudio.com/docs/java/java-spring-boot
#
# https://github.com/redhat-developer/vscode-java/issues/297
