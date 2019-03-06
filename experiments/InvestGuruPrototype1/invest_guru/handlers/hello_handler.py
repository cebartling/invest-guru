import os


def hello(event, context):
    name = event['name']

    alpha_vantage_api_key = os.environ['alphaVantageApiKey']

    result = {
        "content": "Hello {} from Lambda function. APIKey: {}".format(name, alpha_vantage_api_key),
        "event": event
    }
    return result
