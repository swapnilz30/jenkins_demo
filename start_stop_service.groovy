def service_start_stop(serviceaction, servicename, servername){
    echo "ssh sample@${servername} sudo systemctl start ${servicename}"
    sh "ssh sample@${servername} sudo systemctl ${env.service_action} $servicename"
	sh "ssh sample@${servername} 'sudo systemctl status $servicename ; exit 0 '"
}

def serviceaction = env.service_action
def servicename = env.service_name
def servername = env.server_name

if (servername == 'sample') {
    servername = env.sample
}

pipeline{
    agent {label 'jenkinsnodes'}
    stages{
        stage("Service"){
            steps{
                service_start_stop(serviceaction, servicename, servername)
            }
        }
    }
}