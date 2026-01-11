pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/YuvrajDesh/CalculatorApp.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test package'
            }
        }
         stage('Docker Build') {
            steps {
                 sh 'docker build -t calculator-app:local .'
                  // This forces the running container to update to the new image
                 sh 'docker-compose up -d --no-deps calculator-app'
                    }
                }
    }

    post {
        success {
            echo 'CI Pipeline executed successfully!'
        }
        failure {
            echo 'CI Pipeline failed!'
        }
    }
}

