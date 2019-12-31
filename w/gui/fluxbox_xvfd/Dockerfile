FROM ubuntu:20.04

ENV DEBIAN_FRONTEND="nonintractive"
ENV X11VNC_PASSWORD="password"
RUN apt-get update
RUN apt-get install -y build-essential
RUN apt-get install -y git wget
RUN apt-get install -y xvfb x11vnc fluxbox

#
# CHROME
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo 'deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list
RUN apt-get update
RUN apt-get install -y google-chrome-stable
ENV DISPLAY :0

RUN apt-get install -y ttf-ubuntu-font-family ttf-wqy-zenhei 
ADD ./execute.sh /opt/execute.sh
CMD [ "/opt/execute.sh"]
# '--headless', '--disable-gpu', '--no-sandbox'