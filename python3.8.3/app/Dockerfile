FROM ubuntu:20.10

ENV DEBIAN_FRONTEND noninteractive

# install code-server
WORKDIR /works
RUN apt-get update
RUN apt-get install -y curl
RUN curl -sSOL https://github.com/cdr/code-server/releases/download/v3.3.1/code-server_3.3.1_amd64.deb
RUN dpkg -i code-server_3.3.1_amd64.deb


# install python
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y
RUN apt-get install build-essential checkinstall -y
RUN apt-get install libreadline-gplv2-dev libncursesw5-dev libssl-dev libsqlite3-dev libgdbm-dev libc6-dev libbz2-dev  --fix-missing -y
RUN apt-get install zlib1g-dev libffi-dev -y  --fix-missing
RUN wget https://www.python.org/ftp/python/3.8.3/Python-3.8.3.tgz
RUN tar xf Python-3.8.3.tgz
WORKDIR /works/Python-3.8.3
RUN ./configure --enable-optimizations
RUN make altinstall
RUN pip3.8 install --upgrade pip
RUN ln /usr/local/bin/python3.8 /usr/local/bin/python  
RUN pip install pylint

# install plugin
RUN code-server --install-extension ms-python.python


#
