#!/bin/bash
 #!/bin/bash
 ip=$2
 pw=$3
 name=$1
 command1="ssh-copy-id -i /home/gitlab-runner/.ssh/id_rsa.pub $name@$ip"
 expect -c "
       spawn $command1;
       expect {
                \"Password:\" {send \"$pw\r\"; exp_continue}
                \"connecting(yes/no)?\" {send \"yes\r\"; exp_continue}
                }
       "
 ~