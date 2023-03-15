#!/bin/bash

check_nginx_installed(){
     sudo apt list --installed | grep nginx
	 if [ $? -ne 0 ]; then
	     return
	 fi
	 echo "Nginx is already installed"
	 exit 1
}

install_nginx(){
    sudo apt install nginx -y
	if [ $? -ne 0 ]; then
	    echo "Failed to install nginx"
		exit 1
	fi
	echo "Nginx successfully installed"
}

#####Main#####
check_nginx_installed
install_nginx
