pipeline {
    agent any
   
    parameters {
        choice(choices:['Hello':default,'Bye','H'], description: 'Users Choice', name: 'CHOICE')
    }
   
   stages {
        stage('Init') {
            steps('Log-in') {
                echo 'Log-in'
            }
        }
        
        stage('Manual Step') {
            steps('Input') {
                echo "choice: ${CHOICE}"
                echo "choice params.: " + params.CHOICE
                echo "choice env: " + env.CHOICE
            }
        }
        
        stage('Hello') {
            when { 
                expression { env.CHOICE == 'Hello' || env.CHOICE == 'H' }
            }   
            
            steps('Execute')    {
                echo 'Say Hello'
            } 
        }       
        
        stage('Bye') {
            when {
                expression {env.CHOICE == 'Bye'}
            }
            
            steps('Execute'){
                echo 'Say Bye'    
            }
        }
    }
}
