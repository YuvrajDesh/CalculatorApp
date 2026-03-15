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
                        sh '/opt/homebrew/bin/ansible-playbook -i inventory.ini deploy.yml'

                    }
                }

    }

    post {
            success {
                mail to: 'yuvrajdeshmukh8998@gmail.com',
                     subject: "Success: Build ${env.BUILD_NUMBER}",
                     body: "The pipeline ${env.JOB_NAME} completed successfully! Check the console output here: ${env.BUILD_URL}"
            }
            failure {
                mail to: 'yuvrajdeshmukh8998@gmail.com',
                     subject: "Failed: Build ${env.BUILD_NUMBER}",
                     body: "The pipeline ${env.JOB_NAME} failed. Check the console output here: ${env.BUILD_URL}"
            }
        }
}

