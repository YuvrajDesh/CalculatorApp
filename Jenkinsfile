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
                sh '/usr/local/bin/docker build -t calculator-app:ci .'
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

