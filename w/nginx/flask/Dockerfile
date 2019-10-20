FROM python:3.7-stretch



# mine 
RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y
RUN apt-get install -y build-essential libssl-dev curl git-core
RUN apt-get install -y emacs

WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.1523-vsc1.38.1/code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz
RUN tar xzf code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz -C ./ --strip-components 1

#
#
RUN /works/code-server --install-extension ms-python.python

#
#
WORKDIR /works/app
COPY ./requirements.txt /works/app/requirements.txt
RUN pip install -r requirements.txt
CMD /works/code-server --no-auth --allow-http --port 8443 --host 0.0.0.0 /works/app



