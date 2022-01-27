pipeline {
  def code
  agent any
  stages {
    stage('test') {
      steps {
        code = load 'example.groovy'
      }
    }
    stage('Execute') {
      steps {
        script {
                code = load "example.groovy"
            }
      }
    }
  }
}
