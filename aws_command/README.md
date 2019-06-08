

(1) run a docker image.
 
```
docker build -t aws_command  .
docker run -p 8443:8443 -p 8080:8080 -it aws_command bash
```

(2) run vscode at code-server

```
mkdir /works/w
/works/code-server /works/w --allow-http --no-auth
```

(3) and open 'http://127.0.0.1:8443/' at your browser 

# SAMPLE CREATE EC2 INSTANCE

### configure

```
$ aws configure

```

### create subnet

```
$ aws ec2 create-vpc --cidr-block 10.0.0.0/16
$ aws ec2 create-subnet --vpc-id vpc-0befd3b5f92a525e7 --cidr-block 10.0.0.0/24
# subnet-0a1f811c3b3c82ec9
```

```
$ aws ec2 create-internet-gateway
# "igw-07ade5c4989cd1291",
$ aws ec2 attach-internet-gateway --internet-gateway-id igw-07ade5c4989cd1291 --vpc-id vpc-0befd3b5f92a525e7
$ aws ec2 create-route-table --vpc-id vpc-0befd3b5f92a525e7
# rtb-063f946ab72d7db43
$ aws ec2 create-route --route-table-id rtb-063f946ab72d7db43 --destination-cidr-block 0.0.0.0/0 --gateway-id igw-07ade5c4989cd1291
$ aws ec2 associate-route-table --route-table-id rtb-063f946ab72d7db43 --subnet-id subnet-0a1f811c3b3c82ec9
```

### create security group

```

$ aws ec2 create-security-group --group-name HelloSecurityGroup --vpc-id vpc-0befd3b5f92a525e7 --description "Hello Security Group"
# sg-08721f64dc26436e0
$ aws ec2 describe-security-groups
$ aws ec2 authorize-security-group-ingress --group-id sg-08721f64dc26436e0 --protocol tcp --port 22 --cidr 0.0.0.0/0
$ aws ec2 authorize-security-group-ingress --group-id sg-08721f64dc26436e0 --protocol tcp --port 8080 --cidr 0.0.0.0/0

```

### create key pair

```
$ aws ec2 create-key-pair --key-name HelloKeyPair --output text > HelloKeyPair.pem
# modify format
$ chmod 600 HelloKeyPair.pem
```



### create ec2 instance


```
# https://cloud-images.ubuntu.com/locator/ec2/
# --region ap-northeast-1

$ aws ec2 run-instances --image-id ami-0b5a5c971fc30e5d1 --key-name HelloKeyPair --security-group-ids sg-08721f64dc26436e0 --instance-type t2.micro --tag-specifications 'ResourceType=instance,Tags=[{Key=Name,Value=HelloEc2}]' --count 1 --subnet-id subnet-0a1f811c3b3c82ec9 --associate-public-ip-address 
```



##


## end

```
aws ec2 terminate-instances --instance-id i-02b2204f615739d66 
```
