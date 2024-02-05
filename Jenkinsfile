pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    cleanWs()
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/arabindamcs/product-service-java.git']]])
                }
            }
        }
        
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install --batch-mode'
                }
            }
        }

        stage('Stop Existing Application') {
            steps {
                script {
                    sh 'pkill -f product-service-0.0.1-SNAPSHOT.jar || true'
                }
            }
        }

        stage('Start New Application') {
            steps {
                script {
                    sh 'nohup java -jar target/product-service-0.0.1-SNAPSHOT.jar > startserver.log &'
                                def exitCode = sh(script: 'echo $?', returnStatus: true)
            echo "Java process exited with code: ${exitCode}"
                    sleep 10  // Wait for 10 seconds
           
                }
            }
        }
    }
    post {
        success {
            echo 'Deployment successful.'
        }
        failure {
            echo 'Deployment failed.'
        }
    }


}
