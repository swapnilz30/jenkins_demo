pipeline{
    agent {label 'jenkinsnodes'}
    stages{
        stage("Env Build Number"){
            steps{
                echo "Current build number \${BUILD_NUMBER} -> ${BUILD_NUMBER}"
            }
        }
        stage("Env Job Name"){
            steps{
                echo "Current job name \${JOB_NAME} -> ${JOB_NAME}"
            }
        }
        stage("Env Node Name"){
            steps{
                echo "Current job name \${NODE_NAME} -> ${NODE_NAME}"
            }    
        }
        stage("Env Build Display Name"){
            steps{
                echo "Current job name \${BUILD_DISPLAY_NAME} -> ${BUILD_DISPLAY_NAME}"
            }    
        }
        stage("Env Job URL"){
            steps{
                echo "Current job name \${JOB_URL} -> ${JOB_URL}"
            }    
        }
        stage("WORKSPACE"){
            steps{
                echo "Current job name \${WORKSPACE} -> ${WORKSPACE}"
            }    
        }
    }
}
