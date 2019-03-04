# GraphQL APIs with AWS AppSync, Lambda and DynamoDB: Part one

This blog post is the first of a series of posts describing my experimentation with AWS AppSync, Lambda, and 
DynamoDB. I really wanted to experiment with AWS AppSync and really dig into it's support for Lambda-based 
resolvers. I also  wanted to ensure that everything I did was through an Infrastructure as Code (IaC) approach, 
so I utilized the [Serverless Framework](https://serverless.com/) for creating all of my resources on AWS. 

A [public GitHub repository](https://github.com/cebartling/invest-guru) exists with 
[this experiment](https://github.com/cebartling/invest-guru/tree/master/experiments/InvestGuruPrototype1) 
so others can learn from my efforts.

## Introduction


## The technology stack

- Python 3.7
- Serverless Framework
- AWS AppSync for the hosted GraphQL engine
- AWS DynamoDB for the data store
- AWS Lambda for resolvers


## Create a AWS named profile 

AWS IAM best practices advises that you _do not_ use your AWS account root user credentials to access AWS. 
Instead, create an individual IAM user with administrative permissions for the work you will be performing
on AWS. The AWS CLI allows you to maintain a named profile for each IAM user.   

1. Create an **InvestGuruAdmin** IAM user with administrative privileges. Copy the _Access Key ID_ and 
_Secret Access Key_ for the next step.
1. Create the `InvestGuruAdmin` named profile in your AWS credentials file (`~/.aws/credentials`) with the 
associated _Access Key ID_ and _Secret Access Key_.


## Creating the AWS resources

I used the Serverless Framework to scaffold out the AWS Lambda project, but the Serverless Framework can 
do a lot more than just help facilitate the configuration and deployment of Lambda functions. One can
include CloudFormation configuration that the Serverless Framework will use to create associated AWS
resources.

### CloudFormation YAML
