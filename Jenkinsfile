def code;
pipeline {
  agent any
  stages {
    
    stage('Execute') {
      steps {
        script {
          code = load ('example.groovy')      
          code.example1()
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
