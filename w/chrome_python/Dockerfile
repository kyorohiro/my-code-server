#FROM selenium/standalone-chrome
FROM selenium/standalone-chrome-debug
USER root
RUN apt-get update
RUN apt-get install -y python3-pip 


WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.1692-vsc1.39.2/code-server2.1692-vsc1.39.2-linux-x86_64.tar.gz
RUN tar xzf code-server2.1692-vsc1.39.2-linux-x86_64.tar.gz -C ./ --strip-components 1
RUN /works/code-server --install-extension ms-python.python

#
# docker run -p4444:4444 -p5900:5900 -p5443:5443 -it yy
# /works/code-server --auth none --host 0.0.0.0 --port 8443 /app
# 