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
RUN /works/code-server --install-extension naco-siren.gradle-language
RUN /works/code-server --install-extension redhat.java
#
# code-server
RUN wget https://github.com/cdr/code-server/releases/download/2.1523-vsc1.38.1/code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz
RUN tar xzf code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz -C ./ --strip-components 1

#
RUN apt-get install -y mysql-server
