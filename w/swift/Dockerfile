#
# docker build -t swift.streamini .
# docker run --privileged  -p8080:8080 -p8443:8443 -it swift.streamini 
#
FROM ubuntu:18.04

RUN apt-get update --fix-missing
RUN apt-get upgrade -y
#RUN dpkg -i /var/cache/apt/archives/linux-libc-dev_4.15.0-55.60_amd64.deb
#RUN apt-get install linux-libc-dev -y
RUN apt-get install clang -y --fix-missing
RUN apt-get install curl wget -y
WORKDIR /works
WORKDIR /app
WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.preview.5-vsc1.37.0/code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz
RUN tar --strip-components 1 -xzf code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz

#
# swift
#
# copy from  https://github.com/apple/swift-docker/blob/master/5.0/ubuntu/18.04/Dockerfile
#
RUN export DEBIAN_FRONTEND=noninteractive DEBCONF_NONINTERACTIVE_SEEN=true && \
    apt-get -q install -y \
    libatomic1 \
    libbsd0 \
    libcurl4 \
    libxml2 \
    libedit2 \
    libsqlite3-0 \
    libc6-dev \
    binutils \
    libgcc-5-dev \
    libstdc++-5-dev \
    libpython2.7 \
    tzdata \
    git \
    pkg-config \
    && rm -r /var/lib/apt/lists/*

# Everything up to here should cache nicely between Swift versions, assuming dev dependencies change little
ARG SWIFT_PLATFORM=ubuntu18.04
ARG SWIFT_BRANCH=swift-5.0.2-release
ARG SWIFT_VERSION=swift-5.0.2-RELEASE

ENV SWIFT_PLATFORM=$SWIFT_PLATFORM \
    SWIFT_BRANCH=$SWIFT_BRANCH \
    SWIFT_VERSION=$SWIFT_VERSION

RUN wget https://swift.org/builds/swift-5.1-branch/ubuntu1804/swift-5.1-DEVELOPMENT-SNAPSHOT-2019-08-16-a/swift-5.1-DEVELOPMENT-SNAPSHOT-2019-08-16-a-ubuntu18.04.tar.gz
#https://swift.org/builds/swift-5.0.2-release/ubuntu1804/swift-5.0.2-RELEASE/swift-5.0.2-RELEASE-ubuntu18.04.tar.gz
RUN tar --strip-components 1  -xzf swift-5.1-DEVELOPMENT-SNAPSHOT-2019-08-16-a-ubuntu18.04.tar.gz --directory /
RUN chmod -R o+r /usr/lib/swift



WORKDIR /works
RUN git clone https://github.com/apple/sourcekit-lsp.git
WORKDIR /works/sourcekit-lsp
#RUN git checkout tags/swift-5.1-DEVELOPMENT-SNAPSHOT-2019-06-26-a
RUN apt-get update 
RUN apt-get install libsqlite3-dev -y
RUN apt-get install libdispatch-dev -y
#RUN swift build -Xcxx -I/usr/lib/swift 
RUN apt-get install libncurses5-dev -y
RUN apt-get install libncurses5 -y
RUN swift build -Xcxx -I/usr/lib/swift 
RUN swift package update
RUN apt-get install nodejs -y
RUN apt-get install npm -y
ENV PATH="/works/sourcekit-lsp/.build/debug:${PATH}"
WORKDIR /works/sourcekit-lsp/Editors/vscode
RUN npm run createDevPackage
RUN /works/code-server --install-extension out/sourcekit-lsp-vscode-dev.vsix
CMD [ "/works/code-server", "--allow-http", "--no-auth","--port","8443", "/works" ]
