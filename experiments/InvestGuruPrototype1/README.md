# InvestGuru Prototype 1

## Local development

```bash
nvm use
# If Node.js runtime not setup...
nvm install $(cat .nvmrc)

npm install -g serverless
npm install
```

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
1. Create the `InvestGuruAdmin` profile in your AWS credentials file (`~/.aws/credentials`) with the 
associated _Access Key ID_ and _Secret Access Key_.
1. Deploy to AWS Lambda...
    
    ```bash
    serverless deploy --aws-profile InvestGuruAdmin --stage dev
    ```
    
    