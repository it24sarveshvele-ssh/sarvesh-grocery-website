pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/it24sarveshvele-ssh/sarvesh-grocery-website.git'
            }
        }

        stage('Maven Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }
    }
}
