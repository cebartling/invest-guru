def hello(event, context):
    name = event['name']

    result = {
        "content": "Hello {} from Lambda function".format(name),
        "event": event
    }
    return result
