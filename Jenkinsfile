pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                // Your build steps here
                echo 'Building...'
                sh 'printenv'
                sh '''
                
                #echo $env.BRANCH_NAME  
                #echo $env.TAG_NAME
                '''
                // Example build command
                // sh 'make build'
            }
        }

        stage('Tag Release') {
            when {
                expression {
                    // Conditionally run the tagging step based on your criteria
                    // For example, only tag on the master branch
                    return (env.GIT_BRANCH == 'origin/master')
                }
            }
            steps {
                script {
                    // Create a tag using Git
                    // Replace 'v1.0.0' with your desired tag name
                    sh 'git reset --hard'
                    sh 'git clean -dfx'
                    sh 'git config remote.origin.url git@github.com:dadaher/declarative-pipeline-examples.git'
                    sh 'git branch -l'
                    sh 'git fetch'
                   // sh 'git tag -a ex-v1.3.0 -m "ex Release v1.3.0"'
                    // Push the tag to the remote repository
                   // sh 'git push origin ex-v1.3.0'
                    githubNotify description: 'This is a shorted example',  status: 'SUCCESS', repo: 'declarative-pipeline-examples', credentialsId: 'New_Daher_token_full_2024', account: 'dadaher', sha: "${env.COMMIT_ID}"
                                        // Use the GitHub Checks Plugin step to post a check to GitHub
                    // The exact syntax depends on the plugin's API
                    // Example:
                    // githubChecks(
                    //     status: 'SUCCESS', // Or 'FAILURE', 'ERROR', 'PENDING'
                    //     description: 'Build completed successfully',
                    //     sha: env.COMMIT_ID,
                    //     repo: 'owner/repo-name',
                    //     account: 'owner-account',
                    //     gitApiUrl: 'https://api.github.com',
                    //     targetUrl: 'http://example.com/build-status'
                }
            }
        }

        stage('Deploy') {
            when {
                expression {
                    // Check if the current branch is master and if there is a tag available
                    return (env.GIT_BRANCH == 'origin/master' && env.TAG_NAME!= null)
                }
            }
            steps {
                script {
                    // Example deployment command, replace with your actual deployment commands
                    sh 'echo Deploying version ${env.TAG_NAME}'
                    // sh 'your-deployment-command-here'
                }
            }
        }
    }
}
