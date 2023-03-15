node{
    stage("Env Build Number") {
        node("node1"){
           echo "Current build number ${BUILD_NUMBER} -> ${env.BUILD_NUMBER}"
        }   
    }
    stage("Env Job Name") {
        node("node2"){
            echo "Current job name ${JOB_NAME} -> ${env.JOB_NAME}"
        }
    }
}
