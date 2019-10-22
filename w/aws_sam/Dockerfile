FROM amazonlinux:2

RUN yum -y install python37 python37-pip 
RUN yum -y install git zip
RUN yum -y install wget curl tar
RUN yum clean all
RUN python3 -m pip install --upgrade pip
RUN python3 -m pip install boto3

#
# AWS
#
RUN pip3 install awscli --upgrade --user
ENV PATH="${PATH}:/root/.local/bin"

#
# OPENSSL
#
WORKDIR /works

RUN yum update -y
RUN yum install make gcc perl pcre-devel zlib-devel -y
RUN wget https://ftp.openssl.org/source/old/1.1.1/openssl-1.1.1.tar.gz
RUN tar xvf openssl-1.1.1.tar.gz

#
WORKDIR /works/openssl-1.1.1
RUN ./config --prefix=/usr --openssldir=/etc/ssl --libdir=lib no-shared zlib-dynamic
RUN make
# RUN make test
RUN make install


#
#
# CODE-SERVER
WORKDIR /works/code-server
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1

#
# https://docs.aws.amazon.com/ja_jp/serverless-application-model/latest/developerguide/serverless-sam-cli-install-linux.html
#
RUN yum install -y which
RUN amazon-linux-extras install docker -y
RUN git clone https://github.com/Homebrew/brew ~/.linuxbrew/Homebrew
#RUN mkdir ~/.linuxbrew/bin
#RUN ln ~/.linuxbrew/Homebrew/bin/brew  ~/.linuxbrew/bin
ENV PATH="${PATH}:~/.linuxbrew/Homebrew/bin"
RUN  brew tap aws/tap & brew install aws-sam-cli



