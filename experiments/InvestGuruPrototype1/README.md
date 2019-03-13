# InvestGuru Prototype 1

Demonstration of using AWS Lambda, AppSync, and DynamoDB for an algorithmic trading system demonstration. Using the Serverless Framework here to provision the solution in AWS.

I wrote a blog series around this experiment:

- [Introduction]() 
- [First GraphQL query]() 


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

### Alpha Vantage integration

This solution uses the [Alpha Vantage APIs](https://www.alphavantage.co/) for investment data and analytics. 
A free API key can be obtained from Alpha Vantage by filling out 
[this form](https://www.alphavantage.co/support/#api-key). Copy the generated API key
and paste it into a text file named `.alphavantage` in the root directory of this experiment project 
(not the root of the git repository). I have added an entry to the `.gitignore` file to exclude this 
hidden file from being version controlled.


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
    
    