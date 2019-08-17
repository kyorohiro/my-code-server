FROM ubuntu:18.04

RUN apt-get update --fix-missing
RUN apt-get upgrade -y
#RUN dpkg -i /var/cache/apt/archives/linux-libc-dev_4.15.0-55.60_amd64.deb
#RUN apt-get install linux-libc-dev -y
RUN apt-get install clang -y --fix-missing
RUN apt-get install curl wget -y
WORKDIR /works
RUN wget https://swift.org/builds/swift-5.0.2-release/ubuntu1804/swift-5.0.2-RELEASE/swift-5.0.2-RELEASE-ubuntu18.04.tar.gz
ENV PATH=/works/swift-5.0.2-RELEASE-ubuntu18.04/usr/bin:"${PATH}"
#
RUN wget https://github.com/cdr/code-server/releases/download/2.preview.5-vsc1.37.0/code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz
RUN tar --strip-components 1 -xzf code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz


