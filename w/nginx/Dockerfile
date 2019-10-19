FROM ubuntu:18.04
RUN apt-get update
RUN apt-get install nginx -y
RUN echo "\ndaemon off;" >> /etc/nginx/nginx.conf
RUN chown -R www-data:www-data /var/lib/nginx
WORKDIR /etc/nginx
# docker build -t xxx .
# docker run -p80:80 -p443:443 -v/Users/kyorohiro/w/w_nginx:/var/www/html -it xxx nginx