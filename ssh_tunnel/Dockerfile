FROM ubuntu:18.04

RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y

RUN mkdir /works
WORKDIR /works

#
# sshd 
# docker run ubuntu /usr/sbin/sshd -D
RUN apt-get install -y openssh-server openssh-client


# CODE-SERVER
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1


#

# docker build . -t ssh_tunnel_vscode
# docker run -p 8080:8080 -p 8022:22  -it ssh_tunnel_vscode  
# ssh root@127.0.0.1 -p 8022
# ssh -N -p 8022 root@127.0.0.1 -L 8081:127.0.0.1:8443 
#RUN echo "root:password" | chpasswd

RUN useradd -ms /bin/bash sshuser
RUN echo "sshuser:Password_Sshuser" | chpasswd
RUN echo "root:Password_Root" | chpasswd

RUN echo "PermitRootLogin yes" >> /etc/ssh/sshd_config 
ENTRYPOINT service ssh restart && /works/code-server  --allow-http --no-auth


