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
    code.example1()
    }

  }
}
