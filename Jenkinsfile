pipeline {
    agent any;
    stages {
        stage('build') {
            when { branch 'master' }
            stages {
                stage('compile') {
                    steps {
                        echo 'compile'
                    }
                }
                stage('test') {
                    steps {
                        echo 'test'
                    }
                }
                stage('package') {
                    steps {
                        echo 'package'
                    }
                }
            }
        }
    }
}
