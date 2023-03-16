def diplay_build_user(name) {
    echo "Build username: ${name}"
}

pipeline {
    agent {label 'jenkinsnodes'}
 
    stages {
         stage("Env Build User"){
            steps{
               // wrap step, call from steps
                wrap([$class: 'BuildUser']) {
                    diplay_build_user(BUILD_USER)
                }
            }    
        }
    }
}
