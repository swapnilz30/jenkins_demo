def copy_installation_file(WORKSPACE){
    echo "Copy file"
    sh 'scp ${WORKSPACE}/nginx_installation/install_nginx.sh sample@192.168.1.42:~/.'
}
def change_permission(){
    sh 'ssh sample@192.168.1.42 chmod +x install_nginx.sh'
}
def install_nginx(){
    echo "Installation started"
    sh 'ssh sample@192.168.1.42 /home/sample/install_nginx.sh'
}

pipeline{
    agent {label 'jenkinsnodes'}
    stages{
        stage("Copy Nginx Installation File"){
            steps{
                copy_installation_file(WORKSPACE)
            }    
        }
        stage("Change Persmission"){
            steps{
                change_permission()
            }
        }
        stage("Install Jenkins"){
            agent {label 'node2'}
            steps{
                install_nginx()
            }
        }
    }
}
