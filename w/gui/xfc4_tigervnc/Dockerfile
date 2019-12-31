FROM ubuntu:18.04

ENV DEBIAN_FRONTEND="nonintractive"
#ENV LANG='en_US.UTF-8' 
#ENV LANGUAGE='en_US:en'
#ENV LC_ALL='en_US.UTF-8'
ENV X11VNC_PASSWORD="password"

RUN apt-get update
RUN apt-get install xfce4 -y
RUN apt-get install xfce4-goodies -y
RUN apt-get install xfce4-terminal -y
RUN apt-get install xterm -y
RUN apt-get install wget -y
RUN apt-get install ttf-ubuntu-font-family ttf-wqy-zenhei -y

RUN apt-get purge -y pm-utils xscreensaver*
EXPOSE 5901

RUN wget -qO- https://dl.bintray.com/tigervnc/stable/tigervnc-1.8.0.x86_64.tar.gz | tar xz --strip 1 -C /
RUN mkdir ~/.vnc
RUN echo "123456" | vncpasswd -f >> ~/.vnc/passwd
RUN chmod 600 ~/.vnc/passwd

ADD ./execute.sh /root/execute.sh
CMD ["/usr/bin/vncserver", "-fg"]


#
# CHROME
#RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
#RUN echo 'deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list
#RUN apt-get update
#RUN apt-get install -y google-chrome-stable
