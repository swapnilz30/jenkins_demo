def diplay_build_user(name) {
    echo "Build username: ${name}"
}

def display_node_name(nodename){
    echo "Node name: ${nodename}"
}

pipeline {
    agent {label 'jenkinsnodes'}
 
    stages {
         stage("Env Build User"){
            steps{
                // wrap step, call from steps
                wrap([$class: 'BuildUser']) {
                    diplay_build_user(BUILD_USER)
                    display_node_name(NODE_NAME)
                }    
            }
        }
        stage("Env Node Name"){
            agent {label 'node1'}
            steps{
                 // wrap step, call from steps
                wrap([$class: 'BuildUser']) {
                    diplay_build_user(BUILD_USER)
                    display_node_name(NODE_NAME)
                }    
            }    
        }
    }
}
