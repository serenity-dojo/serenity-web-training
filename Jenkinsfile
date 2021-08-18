pipeline {
    agent any
    tools {
        maven 'MAVEN_3.6.3'
        jdk 'JDK_1.8.0_251'
    }
    stages {
        stage('Run Tests') {
//             environment {
//                PROJECT_DIR_1 = "C:\\Users\\Lenovo\\IdeaProjects\\Maven_Jenkins"
//                PROJECT_DIR_2 = "C:\\Users\\Lenovo\\IdeaProjects\\Maven_Jenkins_2"
//             }
            parallel {
                stage('Test Scenario 1') {
			 agent {
                        label "Slave_1"
                    }
                    steps {
                        echo 'maven clean'
                        bat ' mvn -f %PROJECT_DIR_1%\\pom.xml clean install'
                    }
                    post {
                        success {
                        publishHTML ([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            includes: '**/*',
                            keepAll: true,
                            reportDir: 'C:\\Users\\Lenovo\\IdeaProjects\\Maven_Jenkins\\target\\surefire-reports',
                            reportFiles: 'index.html',
                            reportName: 'Test Scenario 1 Report'
                          ])
                        }
                    }
                }
       stage('Test Scenario 2') {
			 agent {
                        label "Slave_2"
                    }
                    steps {
                        echo 'maven clean'
                        bat ' mvn -f %PROJECT_DIR_2%\\pom.xml clean install'
                    }
                    post {
                        success {
                        publishHTML ([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            includes: '**/*',
                            keepAll: true,
                            reportDir: 'C:\\Users\\Lenovo\\IdeaProjects\\Maven_Jenkins_2\\target\\surefire-reports',
                            reportFiles: 'index.html',
                            reportName: 'Test Scenario 2 Report'
                          ])
                        }
                    }
                }
            }
        }
    }
}