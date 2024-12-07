pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/mainPlayBook.yml',
                    inventory: '.ansible/inventory/stend/hosts',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/.ssh.id_rsa',
                    tags:'deploy',
                )
            }
        }
        stage('Start') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/mainPlayBook.yml',
                    inventory: '.ansible/inventory/stend/hosts',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/.ssh.id_rsa',
                    tags:'start',
                )
            }
        }
    }
}