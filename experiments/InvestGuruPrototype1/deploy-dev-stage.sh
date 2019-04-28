#!/usr/bin/env bash

set -ex


yarn deploy-dev

(cd invest-guru-prototype1-vue && yarn build)

yarn deploy-client
