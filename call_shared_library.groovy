@Library('shared_library_example')

pipeline {
    agent {label 'jenkinsnodes'}
 
    stages {
         stage("Env Build User"){
            steps{
               // wrap step, call from steps
                wrap([$class: 'BuildUser']) {
                    libraryfunction(BUILD_USER, NODE_NAME)
                }
            }    
        }
    }
}
