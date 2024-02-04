pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Check out the source code
                    git 'https://github.com/arabindamcs/product-service-java.git'
                }
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Build the Maven project
                    sh 'mvn clean install'
                }
            }
        }

        stage('Stop Existing Application') {
            steps {
                script {
                    // Replace 'your-app-name' with the actual name of your Spring Boot application JAR
                    sh 'pkill -f product-service-0.0.1-SNAPSHOT.jar || true'
                }
            }
        }

        stage('Start New Application') {
            steps {
                script {
                    // Replace 'your-app-name' with the actual name of your Spring Boot application JAR
                    sh 'nohup java -jar target/product-service-0.0.1-SNAPSHOT.jar &'
                }
            }
        }
    }
}
