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

# Download GPG keys, signature and Swift package, then unpack, cleanup and execute permissions for foundation libs
RUN SWIFT_URL=https://swift.org/builds/$SWIFT_BRANCH/$(echo "$SWIFT_PLATFORM" | tr -d .)/$SWIFT_VERSION/$SWIFT_VERSION-$SWIFT_PLATFORM.tar.gz \
    && apt-get update \
    && apt-get install -y curl \
    && curl -fSsL $SWIFT_URL -o swift.tar.gz \
    && curl -fSsL $SWIFT_URL.sig -o swift.tar.gz.sig \
    && apt-get purge -y curl \
    && apt-get -y autoremove \
    && export GNUPGHOME="$(mktemp -d)"

  #
RUN wget https://swift.org/builds/swift-5.0.2-release/ubuntu1804/swift-5.0.2-RELEASE/swift-5.0.2-RELEASE-ubuntu18.04.tar.gz
RUN tar --strip-components 1  -xzf swift-5.0.2-RELEASE-ubuntu18.04.tar.gz --directory /
RUN chmod -R o+r /usr/lib/swift


WORKDIR /app
WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.preview.5-vsc1.37.0/code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz
RUN tar --strip-components 1 -xzf code-server2.preview.5-vsc1.37.0-linux-x86_64.tar.gz

CMD [ "/works/code-server", "--allow-http", "--no-auth","--port","8443", "/app" ]

