#!/usr/bin/env bash

set -ex


yarn deploy-dev

yarn serverless-info

yarn create-prod-env

(cd invest-guru-prototype1-vue && yarn build)

yarn deploy-client
