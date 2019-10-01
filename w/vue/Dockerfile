FROM ubuntu:18.04

RUN apt-get update -y
# mine 
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y
RUN apt-get install -y build-essential libssl-dev curl git-core
RUN apt-get install -y emacs

RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -
RUN apt-get update
RUN apt-get install -y nodejs



WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.1523-vsc1.38.1/code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz
RUN tar xzf code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz -C ./ --strip-components 1

RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update && apt-get install -y yarn
RUN npm install -g @vue/cli
RUN yarn global add @vue/cli
#
RUN npm install --registry=https://registry.npmjs.org/ 
RUN npm install --registry=https://custom.npm.registry.com/ 

WORKDIR /works/app

CMD /works/code-server --no-auth --allow-http --port 8443 --host 0.0.0.0 /works/app



#
# docker build -t xxx .
# docker run -p 8080:8080 -p 8443:8443 -it xxx bash

#
# vue create my-project
# OR
# vue ui
