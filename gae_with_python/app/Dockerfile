FROM ubuntu:20.10

ENV DEBIAN_FRONTEND noninteractive

# install code-server
WORKDIR /works
#RUN apt-get --allow-unauthenticated upgrade
RUN apt-get update 
RUN apt-get install -y curl
RUN curl -sSOL https://github.com/cdr/code-server/releases/download/v3.3.1/code-server_3.3.1_amd64.deb
RUN dpkg -i code-server_3.3.1_amd64.deb


# install python
RUN apt-get autoclean
RUN apt-get install curl wget gnupg less lsof net-tools git apt-utils -y
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


# gcloud
RUN apt-get install apt-transport-https ca-certificates gnupg -y
RUN echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" |  tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
RUN curl https://packages.cloud.google.com/apt/doc/apt-key.gpg |  apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -
RUN apt-get update &&  apt-get install google-cloud-sdk -y
RUN apt-get update &&  apt-get --only-upgrade install google-cloud-sdk-skaffold kubectl google-cloud-sdk-anthos-auth google-cloud-sdk-minikube google-cloud-sdk google-cloud-sdk-app-engine-grpc google-cloud-sdk-kind google-cloud-sdk-pubsub-emulator google-cloud-sdk-app-engine-go google-cloud-sdk-firestore-emulator google-cloud-sdk-cloud-build-local google-cloud-sdk-datastore-emulator google-cloud-sdk-kpt google-cloud-sdk-app-engine-python google-cloud-sdk-spanner-emulator google-cloud-sdk-cbt google-cloud-sdk-bigtable-emulator google-cloud-sdk-app-engine-python-extras google-cloud-sdk-datalab google-cloud-sdk-app-engine-java