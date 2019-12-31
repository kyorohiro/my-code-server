#!/bin/sh

#Xvfb :99 -ac -listen tcp -screen 0 800x600x24 &
#sleep 3 
#
#/usr/bin/fluxbox -display :99 -screen 0 &
#sleep 3 
#
#x11vnc -display :99.0 -forever -passwd ${X11VNC_PASSWORD:-password}
#mkdir -p /var/run/sshd

#/usr/bin/supervisord -c /root/supervisord.conf
#mkdir -p "${HOME}"/.vnc
#PASSWD_PATH="${HOME}/.vnc/passwd"
#echo "${VNC_PW}" | vncpasswd -f >> "${PASSWD_PATH}"
#export PATH=${PATH}:/user/bin
#vncserver ${DISPLAY} -depth ${VNC_COL_DEPTH}

/usr/bin/vncserver :1
tail -f /dev/null
