pipeline {
  agent any
  stages {
    stage('Init') {
      steps {
        echo 'Log-in'
      }
    }

    stage('Manual Step') {
      steps {
        echo "choice: ${CHOICE}"
        echo "choice params.: "+params.CHOICE
        echo "choice env: "+env.CHOICE
      }
    }

    stage('Hello') {
      when {
        expression {
          env.CHOICE == 'Hello' || env.CHOICE == 'H'
        }

      }
      steps {
        echo 'Say Hello'
      }
    }

    stage('Bye') {
      when {
        expression {
          env.CHOICE == 'Bye'
        }

      }
      steps {
        echo 'Say Bye'
      }
    }

  }
  parameters {
    choice(choices: ['Hello','Bye','H'], description: 'Users Choice', name: 'CHOICE')
  }
}