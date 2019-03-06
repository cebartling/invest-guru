# InvestGuru Prototype 1

Demonstration of using AWS Lambda, AppSync, and DynamoDB for an algorithmic trading system demonstration. 

 

Using the Serverless Framework here to provision the solution in AWS.


## Tools needed

- nvm:
- yarn:
- pyenv:

## Local development

### Node.js runtime

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

### Running the solution offline

```bash
serverless offline
```

## Deploying to AWS

1. Create an **InvestGuruAdmin** IAM user with admin privileges. Copy the _Access Key ID_ and 
_Secret Access Key_ for the next step.
1. Create the `InvestGuruAdmin` named profile in your AWS credentials file (`~/.aws/credentials`) with the 
associated _Access Key ID_ and _Secret Access Key_.
1. Deploy solution to AWS...
    
    ```bash
    yarn deploy
    ```
    
    