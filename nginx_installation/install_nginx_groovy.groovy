def install_nginx(){
    echo "Installation started"
    sh "ssh sample@192.168.1.42 'sudo apt install nginx -y || echo failed to installed && exit 1'"
}

pipeline{
    agent {label 'jenkinsnodes'}
    stages{
        stage("Install Jenkins"){
            agent {label 'node2'}
            steps{
                install_nginx()
            }
        }
    }
}
