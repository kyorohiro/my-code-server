FROM ubuntu:20.04

WORKDIR /works
RUN apt-get update
RUN apt-get install -y wget gnupg1
RUN apt-get install apt-transport-https
RUN sh -c 'wget -qO- https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -'
RUN sh -c 'wget -qO- https://storage.googleapis.com/download.dartlang.org/linux/debian/dart_stable.list > /etc/apt/sources.list.d/dart_stable.list'
RUN apt-get update
RUN apt-get -y install dart

RUN wget https://github.com/cdr/code-server/releases/download/2.1665-vsc1.39.2/code-server2.1665-vsc1.39.2-linux-x86_64.tar.gz
RUN tar -xzf code-server2.1665-vsc1.39.2-linux-x86_64.tar.gz -C ./ --strip-components 1

RUN /works/code-server --install-extension Dart-Code.dart-code

WORKDIR /app
ENV PATH=${PATH}:/lib/dart/bin
ENV PATH="${PATH}:/root/.pub-cache/bin"
RUN pub global activate webdev
RUN pub global activate stagehand

CMD ["/works/code-server", "--auth","none", "--host","0.0.0.0","--port","8443", "/app"]
