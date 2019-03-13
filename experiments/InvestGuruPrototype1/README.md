# InvestGuru Prototype 1

Demonstration of using AWS Lambda, AppSync, and DynamoDB for an algorithmic trading system demonstration. 

 

Using the Serverless Framework here to provision the solution in AWS.


## Tools needed

- nvm: [https://github.com/creationix/nvm]
- yarn: [https://yarnpkg.com/lang/en/docs/install/#debian-stable]
- pyenv: [https://github.com/pyenv/pyenv]

## Local development

### Node.js runtime

This project expects you to be using `nvm` for managing your Node.js runtimes. 

```bash
nvm use
# If the correct Node.js runtime is not setup...
nvm install $(cat .nvmrc)

yarn install
```


### Python 3.7

This project expects you to be using `pyenv` for managing your Python runtimes. 

```bash
pyenv install 3.7.2
pyenv local 3.7.2

pip install virtualenvwrapper

mkvirtualenv InvestGuruPrototype1

workon InvestGuruPrototype1
```


## Deploying to AWS

1. Create an **InvestGuruAdmin** IAM user with admin privileges. Copy the _Access Key ID_ and 
_Secret Access Key_ for the next step.
1. Create the `InvestGuruAdmin` named profile in your AWS credentials file (`~/.aws/credentials`) with the 
associated _Access Key ID_ and _Secret Access Key_.
1. Deploy solution to AWS...
    
    ```bash
    yarn deploy-dev
    ```
    
## Undeploying the solution from AWS

Once you have finished tinkering with the solution in our AWS environment, you can conveniently remove it
from your AWS environment:

    ```bash
    yarn undeploy-dev
    ```
    
    