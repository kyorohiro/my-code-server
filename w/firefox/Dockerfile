FROM ubuntu:20.04

RUN apt-get update

RUN apt-get install -y x11vnc
RUN apt-get install -y xvfb
RUN apt-get install -y fluxbox
RUN apt-get install -y wget
RUN apt-get install -y wmctrl
RUN apt-get install -y gnupg
RUN apt-get install -y dbus-x11
RUN apt-get install -y firefox

RUN mkdir ~/.vnc
RUN touch ~/.vnc/passwd
RUN x11vnc -storepasswd "kyorohiro" ~/.vnc/passwd
RUN sh -c 'echo "firefox" >> ~/.bashrc'
CMD ["/usr/bin/x11vnc", "-forever", "-usepw", "-create"]
# 
# docker run -p 5900:5900 -it xx
#


#
# ref 
# https://hub.docker.com/r/devopsil/vnc-firefox/dockerfile/
# 