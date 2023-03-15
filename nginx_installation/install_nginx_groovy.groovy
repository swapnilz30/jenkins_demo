def install_nginx(){
    echo "Installation started"
    sh "ssh sample@192.168.1.42 'sudo apt install nginx -y && exit 0'"
}
def start_service(){
   echo "Checking service status"
   sh "ssh sample@192.168.1.42 'sudo systemctl start nginx && sudo systemctl status nginx'"
}
pipeline{
    agent {label 'jenkinsnodes'}
    stages{
        stage("Install Jenkins"){
            agent {label 'node2'}
            steps{
                install_nginx()
            }
            steps{
               start_service()
            }
        }
       
    }
}
