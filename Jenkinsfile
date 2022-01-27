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
  post {
            failure {
                     mail to: 'daher@dtp.ae',
                     subject: "Pipeline has failed: ${currentBuild.fullDisplayName}",
                     body: "Error in ${env.BUILD_URL}"
  }
}
}
