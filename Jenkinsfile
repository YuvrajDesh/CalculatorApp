pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    // This tells Jenkins to listen for GitHub Webhook signals
        triggers {
            githubPush()
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
        stage('Deploy with Ansible') {
                    steps {
                        // Now run the playbook that you just pushed to GitHub
                        sh 'ansible-playbook -i inventory.ini deploy.yml'
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

