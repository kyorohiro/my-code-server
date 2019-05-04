FROM php:7
RUN apt-get update -y && apt-get install -y openssl zip unzip git
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils
RUN apt-get install -y emacs
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
RUN docker-php-ext-install pdo mbstring
WORKDIR /app
COPY . /app
#RUN composer install

#CMD php artisan serve --host=0.0.0.0 --port=8181

#
# CODE-SERVER
RUN wget https://github.com/cdr/code-server/releases/download/1.939-vsc1.33.1/code-server1.939-vsc1.33.1-linux-x64.tar.gz
RUN tar xzf code-server1.939-vsc1.33.1-linux-x64.tar.gz -C ./ --strip-components 1

