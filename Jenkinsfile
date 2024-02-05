pipeline {
    agent any

    environment {
        CUSTOM_BUILD_ID = "dontKillMe"
    }

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
                    // Set custom BUILD_ID
                    env.BUILD_ID = CUSTOM_BUILD_ID
                    
                    sh 'nohup java -jar target/product-service-0.0.1-SNAPSHOT.jar > startserver.log 2>&1 & disown'
                    sleep 30  // Wait for 30 seconds (adjust as needed)
           
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
