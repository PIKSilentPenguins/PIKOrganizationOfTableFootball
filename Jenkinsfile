pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '''cd backend/
mvn clean install
chmod +x ./mvnw
mvn spring-boot:run'''
      }
    }
  }
}