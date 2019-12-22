FROM ubuntu:20.04

WORKDIR /works
# install dart
RUN apt-get update
RUN apt-get install -y wget gnupg1
RUN apt-get install apt-transport-https
RUN sh -c 'wget -qO- https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -'
RUN sh -c 'wget -qO- https://storage.googleapis.com/download.dartlang.org/linux/debian/dart_stable.list > /etc/apt/sources.list.d/dart_stable.list'
RUN apt-get update
RUN apt-get -y install dart

# install go
RUN apt-get install software-properties-common -y
#RUN add-apt-repository ppa:longsleep/golang-backports
RUN apt-get update
RUN apt-get install golang-go -y
RUN apt-get install git -y
RUN go get github.com/ramya-rao-a/go-outline
RUN go get github.com/mdempsky/gocode
RUN go get github.com/uudashr/gopkgs/cmd/gopkgs
RUN go get github.com/sqs/goreturns
RUN go get github.com/rogpeppe/godef

# install c
RUN apt-get install musl-dev -y

# code-server
RUN wget https://github.com/cdr/code-server/releases/download/2.1692-vsc1.39.2/code-server2.1692-vsc1.39.2-linux-x86_64.tar.gz
RUN tar -xzf code-server2.1692-vsc1.39.2-linux-x86_64.tar.gz -C ./ --strip-components 1


RUN /works/code-server --install-extension Dart-Code.dart-code
RUN /works/code-server --install-extension ms-vscode.go
RUN /works/code-server --install-extension ms-vscode.cpptools

WORKDIR /app
ENV PATH=${PATH}:/lib/dart/bin
ENV PATH="${PATH}:/root/.pub-cache/bin"
RUN pub global activate webdev
RUN pub global activate stagehand

CMD ["/works/code-server", "--auth","none", "--host","0.0.0.0","--port","8443", "/app"]
