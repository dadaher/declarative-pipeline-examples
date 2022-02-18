pipeline {
    agent any
    stages {
        stage('Check System Usage') {
            steps {
                script {
                    bash'''#!/bin/bash 
                        CPUUSAGE=$(top -bn1 | grep load | awk '{printf "%.2f%%\t\t\n", $(NF-2)}')
                        MEMUSAGE=$(free -m | awk 'NR==2{printf "%.2f%%\t\t", $3*100/$2 }')
                        IOWAIT=$(iostat -c 3 3 |awk '/^ /{print $4}'|awk  '{ printf( "%s ", $1 ); } END { printf( "\n" ); }')
                        #echo("CPUUSAGE = ${CPUUSAGE}","MEMUSAGE = ${MEMUSAGE}","IOWAIT = {IOWAIT}")
                        echo "CPUUSAGE = $CPUUSAGE","MEMUSAGE = $MEMUSAGE","IOWAIT = $IOWAIT"
                    '''
                }
            }
        }
    }
}
