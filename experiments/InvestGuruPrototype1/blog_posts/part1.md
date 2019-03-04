# GraphQL APIs with AWS AppSync, Lambda and DynamoDB: Part one

This blog post is the first of a series of posts describing my experimentation with AWS AppSync, Lambda, and 
DynamoDB. I really wanted to experiment with AWS AppSync and really dig into its support for Lambda-based 
resolvers. I also  wanted to ensure that everything I did was through an Infrastructure as Code (IaC) approach, 
so I utilized the [Serverless Framework](https://serverless.com/) for creating all of my resources on AWS. 

A [public GitHub repository](https://github.com/cebartling/invest-guru) exists with 
[this experiment](https://github.com/cebartling/invest-guru/tree/master/experiments/InvestGuruPrototype1) 
so others can learn from my efforts. Links to the other posts in this series are listed below:

- Part one (this article)
- [Part two]() 


## Introduction


## The technology stack

- Python 3.7 for the AWS Lambda runtime
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
include CloudFormation configuration that the Serverless Framework will use to create the associated AWS
resources.

### The Serverless Framework's configuration file

The centerpiece of a Serverless Framework-managed application is the `serverless.yml` file. Its declarations 
specify everything about the project: cloud provider, plugins, runtime and deployment configuration to name
just a few. A full listing of the options available through the `aws` provider within the `serverless.yml`
file can be found [here](https://serverless.com/framework/docs/providers/aws/guide/serverless.yml/). The 
user guide for the `aws` provider can be found [here](https://serverless.com/framework/docs/providers/aws/guide/intro/).  


### Using CloudFormation YAML
 
AWS CloudFormation supports 
[both JSON and YAML formats](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-formats.html). 
I chose YAML as it works well with the Serverless Framework's own `serverless.yml` configuration file.

#### CloudFormation intrinsic functions

You will see a fair amount of intrinsic functions usage (e.g. `Fn::GetAtt:`, `!GetAtt`) in my CloudFormation YAML. A 
full description of these functions can be found [here](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/intrinsic-function-reference.html).
A little odd to work with at first, but once you get the hang of them, they aren't too bad. I use the _short form_
syntax in my `serverless.yml` file.

#### Serverless variables

I also use some Serverless Framework variables in the `serverless.yml` file. A full description of those can be
found [here](https://serverless.com/framework/docs/providers/aws/guide/variables/). Again, super helpful for making
the configuration modular. I especially like having the GraphQL schema in its own file (`schema.graphql`) and 
being able to edit it with syntax highlighting.