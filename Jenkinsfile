pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withMaven(publisherStrategy: 'IMPLICIT', maven: '/opt/apache-maven-3.5.4/bin/mvn') {
          sh 'mvn clean package'
        }

      }
    }
    stage('Test') {
      steps {
        sh 'mvn verify -Pit'
      }
    }
    stage('Deploy') {
      steps {
        sh 'mvn spring-boot:run -Dvaadin.productionMode -Dserver.port=80 -Dspring.profiles.active=prod'
      }
    }
  }
}