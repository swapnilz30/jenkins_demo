pipeline {
    agent {label 'master'}
    stages {
        stage("Parallel Jobs") {
            parallel {
                stage("node1 job") {
                    agent {label 'node1'}
                    steps{
                        echo "node1 job"
                        sleep 10
                    }
                }
                stage("node2 job") {
                    agent {label 'node2'}
                    steps{
                        echo "node2 job"
                        sleep 10
                    }    
                }
            }
        }
    }
}