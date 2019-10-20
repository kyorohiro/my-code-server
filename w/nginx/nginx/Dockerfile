FROM ubuntu:18.04
RUN apt-get update
RUN apt-get install nginx -y
RUN echo "\ndaemon off;" >> /etc/nginx/nginx.conf
RUN chown -R www-data:www-data /var/lib/nginx
WORKDIR /etc/nginx

# docker build -t xxx .
# docker run -p80:80 -p443:443 -p8443:8443 -v/Users/kyorohiro/w/w_nginx:/var/www/html -it xxx nginx

# mine 
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y
RUN apt-get install -y build-essential libssl-dev curl git-core
RUN apt-get install -y emacs

WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.1523-vsc1.38.1/code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz
RUN tar xzf code-server2.1523-vsc1.38.1-linux-x86_64.tar.gz -C ./ --strip-components 1

CMD /works/code-server --no-auth --allow-http --port 8443 --host 0.0.0.0 /etc/nginx


