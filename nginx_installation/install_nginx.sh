
install_nginx(){
    sudo apt install nginx -y || echo "Installation failed && exit 1"
    echo "Nginx successfully installed"
}

#####Main#####
install_nginx
