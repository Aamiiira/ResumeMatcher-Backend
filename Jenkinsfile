pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                     echo "Connected to github successfully"
                }
            }
        }
    
        stage("build war") {
            steps {
                script {
                    echo "building war artifact..."
                    sh 'mvn clean package'

                }
            }
        }
        stage("build image") {
            steps {
                script {
                   echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'DockerHub-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                      sh 'docker build -t amirazaghab/resumematcherbackend:2.0 .'
                      sh 'echo $PASS | docker login -u $USER --password-stdin'
                      sh 'docker push amirazaghab/resumematcherbackend:2.0' }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }   
}