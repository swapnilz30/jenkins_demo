node('jenkinsnodes') {
    stage("Env Build Number") {
       echo "Current build number ${BUILD_NUMBER} -> ${env.BUILD_NUMBER}"
    }
    stage("Env Job Name") {
       echo "Current job name ${JOB_NAME} -> ${env.JOB_NAME}"
    }
    stage("Env Node Name") {
       echo "Current node name ${NODE_NAME} -> ${env.NODE_NAME}"
    }
    stage("Env Build Display Name") {
      echo "Current build display name ${BUILD_DISPLAY_NAME} -> ${env.BUILD_DISPLAY_NAME}"
    }
    stage("Env Job URL") {
      echo "Current job URL ${JOB_URL} -> ${env.JOB_URL}"
    }
    stage("WORKSPACE") {
      echo "Current workspace ${WORKSPACE} -> ${env.WORKSPACE}"
    }
}
