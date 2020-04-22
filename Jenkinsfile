pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        withGradle() {
          build './gradlew build -x test'
        }

      }
    }

  }
}