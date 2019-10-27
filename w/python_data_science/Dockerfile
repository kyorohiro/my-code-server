FROM python:3.8


#
# mine
RUN apt-get update
RUN apt-get install -y curl wget gnupg less lsof net-tools git apt-utils -y



WORKDIR /app
COPY ./requirements_pre.txt /app/requirements_pre.txt
COPY ./requirements.txt /app/requirements.txt
RUN apt-get install -y libpng-dev freetype* libblas-dev liblapack-dev libatlas-base-dev gfortran
RUN /usr/local/bin/python -m pip install -U pylint --user
RUN /usr/local/bin/python -m pip install -r requirements_pre.txt
RUN /usr/local/bin/python -m pip install -r requirements.txt


WORKDIR /works
RUN wget https://github.com/cdr/code-server/releases/download/2.1650-vsc1.39.2/code-server2.1650-vsc1.39.2-linux-x86_64.tar.gz
RUN tar xzf code-server2.1650-vsc1.39.2-linux-x86_64.tar.gz -C ./ --strip-components 1
RUN /works/code-server --install-extension ms-python.python

WORKDIR /app
CMD ["/works/code-server", "--auth","none", "--host","0.0.0.0","--port","8443"]

#
# docker build -t xxx .
# docker run -it xxx 

